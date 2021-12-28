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

    /**
     * 测试工厂销毁调用自定义销毁方法
     *      注意：销毁方法只有在bean的scope属性未singleton时才生效
     */
    @Test
    public void test4() {
        // 测试bean销毁时，调用工厂的close方法
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        // 使用ApplicationContext接口时未提供close方法，而具体接口提供在子类中
        context.close();
    }
}
