package com.meteor;

import static org.junit.Assert.assertTrue;

import com.meteor.configuration.Configuration;
import com.meteor.domain.SysUser;
import com.meteor.session.SqlSession;
import com.meteor.session.SqlSessionFactory;
import com.meteor.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    public static void main(String[] args){
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build("db.properties");
        SqlSession sqlSession = factory.openSession();
        String url = Configuration.getProperty("jdbc.url");
        System.out.println("jdbcUrl:"+url);
        System.out.println("jdbcDriver:"+Configuration.getProperty("jdbc.driver"));
        SysUser sysUser = sqlSession.selectOne("com.demo.dao.SysUserMapper.getUser", 1L);
        System.out.println("sysUser:"+sysUser);
    }

}
