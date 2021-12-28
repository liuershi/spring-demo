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

    private String driverClassName;
    private String url;
    private String userName;
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 实现FactoryBean接口后，我们通过将ConnectionFactoryBean定义在spring-config.xml转之后
     * ，再获取ConnectionFactoryBean实例时，会得到getObject()方法的返回值而不是ConnectionFactoryBean实例
     * 本身，这是spring帮我们实现的，而想要获取ConnectionFactoryBean实例时可以通过加&前缀实现。
     * @return
     * @throws Exception
     */
    @Override
    public Connection getObject() throws Exception {
        Class.forName(driverClassName);
        Connection connection = DriverManager.getConnection(url, userName, password);
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
