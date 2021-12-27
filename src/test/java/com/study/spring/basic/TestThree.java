package com.study.spring.basic;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

/**
 *
 * 测试通过FactoryBean接口创建复杂对象
 *
 * @author zhangwei151
 * @date 2021/12/26 14:22
 */
public class TestThree {

    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    /**
     * 获取FactoryBean#getObject方法的对象
     */
    @Test
    public void test1() {
        Connection conn = (Connection) applicationContext.getBean("conn");
        System.out.println("conn = " + conn);
    }

    /**
     * 通过&符号获取FactoryBean对象本身
     */
    @Test
    public void test2() {
        Object conn = applicationContext.getBean("&conn");
        System.out.println("conn = " + conn);
    }

    /**
     * 测试实例工程
     *  好处：
     *      1.与spring解耦合，不需要实现FactoryBean接口
     *      2.解决遗留系统问题
     */
    @Test
    public void test3() {
        Object conn = applicationContext.getBean("conn1");
        System.out.println("conn1 = " + conn);
    }

    /**
     * 静态工厂方式
     */
    @Test
    public void test4() {
        Object conn = applicationContext.getBean("staticFactory");
        System.out.println("conn = " + conn);
    }
}
