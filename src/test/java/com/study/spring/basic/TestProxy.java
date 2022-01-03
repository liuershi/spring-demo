package com.study.spring.basic;

import com.study.spring.proxy.staticProxy.User;
import com.study.spring.proxy.staticProxy.UserService;
import com.study.spring.proxy.staticProxy.UserServiceProxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author milindeyu
 * @Date 2021/12/30 10:40 下午
 * @Version 1.0
 */
public class TestProxy {

    /**
     * 测试静态代理
     */
    @Test
    public void test1() {
        UserService userService = new UserServiceProxy();
        userService.register(new User());
        userService.login("zhangsan", "123456");
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-proxy.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.login("lisi", "123456");
        userService.register(new User());
    }

    /**
     * 测试通过工厂方式创建代理对象
     */
    @Test
    public void testProxyFactory() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-proxy.xml");
        com.study.spring.proxy.factory.UserService userService = (com.study.spring.proxy.factory.UserService) context.getBean("userServiceTwo");
        userService.login("lisi", "123456");
        userService.register(new User());
    }

    /**
     * 测试使用注解实现aop
     */
    @Test
    public void testAnnotationAop() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-proxy.xml");
        com.study.spring.proxy.aspect.UserService userService = (com.study.spring.proxy.aspect.UserService) context.getBean("aspectUserService");
        userService.login("lisi", "123456");
//        userService.register(new User());
    }
}
