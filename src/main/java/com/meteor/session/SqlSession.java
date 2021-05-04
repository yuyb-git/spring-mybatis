package com.meteor.session;

import com.meteor.configuration.Configuration;

import java.util.List;

/**
 * @ClassName SqlSession
 * @Description: TODO
 * @Author meteor
 * @Date 2021/4/24
 * @Version V1.0
 **/
public interface SqlSession {

    /**
     * @Description
     * @Author meteor
     * @Date 10:45 2021/4/24
     * @param statementId
     * @param parameter
     * @return T
     **/
    <T> T selectOne(String statementId, Object parameter);

    <E> List<E> selectList(String statementId);

    <E> List<E> selectList(String statementId, Object parameter);

    void update(String statementId, Object parameter);

    <T> T getMapper(Class<T> tClass);

    Configuration getConfiguration();

}
