package com.meteor.configuration;

import com.meteor.mapping.MappedStatement;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName Configuration
 * @Description: TODO
 * @Author meteor
 * @Date 2021/4/24
 * @Version V1.0
 **/
public class Configuration {

    public static Properties PROPS = new Properties();

    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    public void addMappedStatement(String key, MappedStatement mappedStatement){
        this.mappedStatements.put(key, mappedStatement);
    }

    public MappedStatement getMappedStatement(String key){
        return this.mappedStatements.get(key);
    }

    public static String getProperty(String key, String defaultValue){
        return PROPS.containsKey(key)?PROPS.getProperty(key):defaultValue;
    }

    public static String getProperty(String key){
        return getProperty(key, "");
    }

}
