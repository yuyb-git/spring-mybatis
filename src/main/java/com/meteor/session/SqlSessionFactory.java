package com.meteor.session;

/**
 * @ClassName SqlSessionFactory
 * @Description: TODO
 * @Author meteor
 * @Date 2021/4/24
 * @Version V1.0
 **/
public interface SqlSessionFactory {

    SqlSession openSession();

}
