package com.meteor.proxy;

import com.meteor.mapping.MappedStatement;
import com.meteor.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * @ClassName MapperProxy
 * @Description: TODO
 * @Author meteor
 * @Date 2021/4/24
 * @Version V1.0
 **/
public class MapperProxy implements InvocationHandler {

    private final SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String statementId = method.getDeclaringClass().getName()+"."+method.getName();
        MappedStatement ms = this.sqlSession.getConfiguration().getMappedStatement(statementId);
        Object result = null;
        switch (ms.getSqlCommandType()){
            case "select":
                Class<?> returnType = method.getReturnType();
                if(Collection.class.isAssignableFrom(returnType)){
                    result = sqlSession.selectList(statementId, args==null?null:args[0]);
                }else {
                    result = sqlSession.selectOne(statementId, args==null?null:args[0]);
                }
                break;
            case "update":
                sqlSession.update(statementId, args[0]);
                break;
            default:
                break;
        }
        return result;
    }

}
