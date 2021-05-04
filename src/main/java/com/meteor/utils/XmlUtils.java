package com.meteor.utils;

import com.meteor.configuration.Configuration;
import com.meteor.mapping.MappedStatement;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName XmlUtils
 * @Description: TODO
 * @Author meteor
 * @Date 2021/4/24
 * @Version V1.0
 **/
public class XmlUtils {

    public static void readMapperXml(File fileName, Configuration configuration){
        SAXReader saxReader = new SAXReader();
        saxReader.setEncoding("utf-8");
        try {
            Document document = saxReader.read(fileName);
            Element rootElement = document.getRootElement();
            if (!"mapper".equals(rootElement.getName()))
            {
                System.err.println("mapper xml文件根元素不是mapper");
                return;
            }
            String namespace = rootElement.attributeValue("namespace");

            List<MappedStatement> statements = new ArrayList<>();
            for (Iterator iterator = rootElement.elementIterator(); iterator.hasNext();)
            {
                Element element = (Element)iterator.next();
                String eleName = element.getName();

                MappedStatement statement = new MappedStatement();

                if ("select".equals(eleName))
                {
                    String resultType = element.attributeValue("resultType");
                    statement.setResultType(resultType);
                    statement.setSqlCommandType("select");
                }
                else if ("update".equals(eleName))
                {
                    statement.setSqlCommandType("update");
                }
                else
                {
                    // 其他标签自己实现
                    System.err.println("不支持此xml标签解析:" + eleName);
                    statement.setSqlCommandType("select");
                }

                //设置SQL的唯一ID
                String sqlId = namespace + "." + element.attributeValue("id");

                statement.setSqlId(sqlId);
                statement.setNamespace(namespace);
                statement.setSql(element.getStringValue());
                statements.add(statement);

                System.out.println(statement);
                configuration.addMappedStatement(sqlId, statement);

                //这里其实是在MapperRegistry中生产一个mapper对应的代理工厂
                //configuration.addMapper(Class.forName(namespace));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
