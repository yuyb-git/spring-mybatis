package com.meteor;

import com.meteor.configuration.Configuration;
import com.meteor.dao.SysUserMapper;
import com.meteor.domain.SysUser;
import com.meteor.session.SqlSession;
import com.meteor.session.SqlSessionFactory;
import com.meteor.session.SqlSessionFactoryBuilder;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build("db.properties");
        SqlSession sqlSession = factory.openSession();
        //SysUser sysUser = sqlSession.selectOne("com.demo.dao.SysUserMapper.getUser", 1L);
        //System.out.println("sysUser:"+sysUser);
        //List<SysUser> sysUserList = sqlSession.selectList("com.demo.dao.SysUserMapper.getList");
        //System.out.println("sysUserList:"+sysUserList);

        SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
        SysUser sysUser = sysUserMapper.getUser(1L);
        System.out.println("sysUser:"+sysUser);
        List<SysUser> sysUserList = sysUserMapper.getList();
        System.out.println("sysUserList:"+sysUserList);

        //sysUserMapper.updateUser(1L);
    }
}
