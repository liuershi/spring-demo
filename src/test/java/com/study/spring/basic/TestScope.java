package com.study.spring.basic;

import com.study.spring.scope.Account;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhangwei151
 * @date 2021/12/26 18:30
 */
public class TestScope {

    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    /**
     * 测试singleton
     */
    @Test
    public void test1() {
        Account account = (Account) applicationContext.getBean("accountOne");
        Account account1 = (Account) applicationContext.getBean("accountOne");
        System.out.println("account = account1 ==> " + (account == account1));
    }

    /**
     * prototype对象的创建在获取时才创建，而singleton是在容器初始化时就创建
     */
    @Test
    public void test2() {
        Account account = (Account) applicationContext.getBean("accountTwo");
        Account account1 = (Account) applicationContext.getBean("accountTwo");
        System.out.println("account = account1 ==> " + (account == account1));
    }

    /**
     * 实现接口和配置init-method时，都会生效，接口优先级高于配置的方法。
     * 当配置了初始化和依赖注入式，注入优先级高于初始化。
     */
    @Test
    public void test3() {
        Account account = (Account) applicationContext.getBean("accountOne");
    }
}
