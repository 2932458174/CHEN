package com.demo.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            //获取SqlSessionFactory对象
            String resource = "mybatis-config.xml";//指定核心配置文件路径
            InputStream inputStream = Resources.getResourceAsStream(resource);//把文件转化成java里的i/o流，input输入流
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//实例化factory
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);//连接数据库并设置为自动提交,返回创建的连接
    }
}
