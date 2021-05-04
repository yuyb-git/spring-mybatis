package com.meteor.session;

import com.meteor.configuration.Configuration;
import com.meteor.session.defaults.DefaultSqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName SqlSessionFactoryBuilder
 * @Description: TODO
 * @Author meteor
 * @Date 2021/4/24
 * @Version V1.0
 **/
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(String fileName){
        InputStream inputStream = SqlSessionFactoryBuilder.class.getClassLoader().getResourceAsStream(fileName);
        return build(inputStream);
    }

    public SqlSessionFactory build(InputStream inputStream){
        try {
            Configuration.PROPS.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new DefaultSqlSessionFactory(new Configuration());
    }

}
