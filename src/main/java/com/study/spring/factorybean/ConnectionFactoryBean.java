package com.study.spring.factorybean;

import java.sql.Connection;
import org.springframework.beans.factory.FactoryBean;

import java.sql.DriverManager;

/**
 * FactoryBean接口实现
 *
 * @author zhangwei151
 * @date 2021/12/26 14:14
 */
public class ConnectionFactoryBean implements FactoryBean<Connection> {

    /**
     * 实现FactoryBean接口后，我们通过将ConnectionFactoryBean定义在spring-config.xml转之后
     * ，再获取ConnectionFactoryBean实例时，会得到getObject()方法的返回值而不是ConnectionFactoryBean实例
     * 本身，这是spring帮我们实现的，而想要获取ConnectionFactoryBean实例时可以通过加&前缀实现。
     * @return
     * @throws Exception
     */
    @Override
    public Connection getObject() throws Exception {
        Class.forName("com.mysql.jdbc.Connection");
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.13.13:3306", "root", "123456");
        return connection;
    }

    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
