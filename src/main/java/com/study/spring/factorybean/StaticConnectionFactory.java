package com.study.spring.factorybean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 静态工厂
 *
 * @author zhangwei151
 * @date 2021/12/26 15:28
 */
public class StaticConnectionFactory {
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Connection");
        return DriverManager.getConnection("jdbc:mysql://192.168.13.13:3306", "root", "123456");
    }
}
