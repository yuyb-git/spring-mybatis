package com.meteor.executeor;

import com.meteor.configuration.Configuration;
import com.meteor.mapping.MappedStatement;
import com.meteor.utils.CommonUtil;
import com.mysql.jdbc.JDBC4PreparedStatement;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SimpleExecutor
 * @Description: TODO
 * @Author meteor
 * @Date 2021/4/24
 * @Version V1.0
 **/
public class SimpleExecutor implements Executor{



    /** 数据库连接 */
    private static Connection connection;

    private Configuration conf;

    static {
        initConnect();
    }

    public SimpleExecutor(Configuration conf) {
        this.conf = conf;
    }

    @Override
    public <E> List<E> query(MappedStatement ms, Object parameter) {
        List<E> ret = new ArrayList<>();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            Connection connection = getConnect();
            preparedStatement= connection.prepareStatement(ms.getSql());
            parameterize(preparedStatement, parameter);
            System.out.println("执行sql：" + ((JDBC4PreparedStatement)preparedStatement).asSql());
            // 执行sql语句
            resultSet = preparedStatement.executeQuery();
            // 处理结果
            handlerResultSet(resultSet, ret, ms.getResultType());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public void update(MappedStatement ms, Object parameter) {
        PreparedStatement preparedStatement;
        Connection connection;
        try {
            connection = getConnect();
            preparedStatement= connection.prepareStatement(ms.getSql());
            parameterize(preparedStatement, parameter);
            System.out.println("执行sql：" + ((JDBC4PreparedStatement)preparedStatement).asSql());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnect() throws SQLException
    {
        if (null != connection)
        {
            return connection;
        }
        else
        {
            throw new SQLException("无法连接数据库，请检查配置");
        }
    }

    /**
     * 静态初始化数据库连接
     *
     * @return
     */
    private static void initConnect()
    {

        String driver = Configuration.getProperty("jdbc.driver");
        String url = Configuration.getProperty("jdbc.url");
        String username = Configuration.getProperty("jdbc.username");
        String password = Configuration.getProperty("jdbc.password");

        try
        {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("数据库连接成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void parameterize(PreparedStatement preparedStatement, Object parameter) throws SQLException {
        if (parameter instanceof String) {
            preparedStatement.setString(1, (String) parameter);
        } else if (parameter instanceof Long) {
            preparedStatement.setLong(1, (Long) parameter);
        } else if (parameter instanceof Integer) {
            preparedStatement.setInt(1, (Integer) parameter);
        }
    }



    private <E> void handlerResultSet(ResultSet resultSet, List<E> ret, String className){
        Class<E> clazz = null;
        try {
            clazz = (Class<E>)Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while (resultSet.next()){
                Object entity = clazz.newInstance();
                Field[] fields = clazz.getDeclaredFields();
                for(Field field : fields){
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    String underField = CommonUtil.camelCaseToUnderscore(fieldName);
                    Type type = field.getGenericType();
                    if (String.class.equals(type))
                    {
                        field.set(entity, resultSet.getString(underField));
                    }
                    else if (int.class.equals(type) || Integer.class.equals(type))
                    {
                        field.set(entity, resultSet.getInt(underField));
                    }
                    else if (long.class.equals(type) || Long.class.equals(type)) {
                        Long column = resultSet.getLong(underField);
                        field.set(entity, column);
                    }
                    else
                    {
                        // 其他类型自己转换，这里就直接设置了
                        field.set(entity, resultSet.getObject(underField));
                    }
                }
                ret.add((E)entity);
            }
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

}
