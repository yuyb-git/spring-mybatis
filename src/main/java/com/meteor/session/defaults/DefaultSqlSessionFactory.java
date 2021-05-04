package com.meteor.session.defaults;

import com.meteor.configuration.Configuration;
import com.meteor.session.SqlSession;
import com.meteor.session.SqlSessionFactory;
import com.meteor.utils.XmlUtils;

import java.io.File;
import java.net.URL;

/**
 * @ClassName DefaultSqlSessionFactory
 * @Description: TODO
 * @Author meteor
 * @Date 2021/4/24
 * @Version V1.0
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
        loadMappersInfo("com/meteor/dao/mapper/");
    }


    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }

    private void loadMappersInfo(String dirName){
        URL resources = DefaultSqlSessionFactory.class.getClassLoader().getResource(dirName);
        File mapperDir = new File(resources.getFile());
        if(mapperDir.isDirectory()){
            File[] mappers = mapperDir.listFiles();
            for(File file : mappers){
                // 只对XML文件解析
                XmlUtils.readMapperXml(file, this.configuration);
            }
        }
    }

}
