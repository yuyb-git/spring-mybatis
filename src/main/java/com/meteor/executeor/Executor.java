package com.meteor.executeor;

import com.meteor.mapping.MappedStatement;

import java.util.List;

/**
 * @ClassName Executor
 * @Description: TODO
 * @Author meteor
 * @Date 2021/4/24
 * @Version V1.0
 **/
public interface Executor {

    <E> List<E> query(MappedStatement ms, Object parameter);

    void update(MappedStatement ms, Object parameter);

}
