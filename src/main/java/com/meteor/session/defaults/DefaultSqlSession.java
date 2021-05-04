package com.meteor.session.defaults;

import com.meteor.proxy.MapperProxy;
import com.meteor.configuration.Configuration;
import com.meteor.mapping.MappedStatement;
import com.meteor.executeor.Executor;
import com.meteor.executeor.SimpleExecutor;
import com.meteor.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @ClassName DefaultSqlSession
 * @Description: TODO
 * @Author meteor
 * @Date 2021/4/24
 * @Version V1.0
 **/
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    private final Executor executor;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
        this.executor = new SimpleExecutor(configuration);
    }

    @Override
    public <T> T selectOne(String statementId, Object parameter) {
        List<T> list = selectList(statementId, parameter);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public <E> List<E> selectList(String statementId) {
        return selectList(statementId, null);
    }

    @Override
    public <E> List<E> selectList(String statementId, Object parameter) {
        MappedStatement mappedStatement = this.configuration.getMappedStatement(statementId);
        return this.executor.query(mappedStatement, parameter);
    }

    @Override
    public void update(String statementId, Object parameter) {
        MappedStatement mappedStatement = this.configuration.getMappedStatement(statementId);
        this.executor.update(mappedStatement, parameter);
    }

    @Override
    public <T> T getMapper(Class<T> tClass) {
        MapperProxy mapperProxy = new MapperProxy(this);
        return (T)Proxy.newProxyInstance(tClass.getClassLoader(), new Class[]{tClass}, mapperProxy);
    }

    @Override
    public Configuration getConfiguration() {
        return this.configuration;
    }
}
