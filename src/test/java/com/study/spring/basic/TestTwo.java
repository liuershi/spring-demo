package com.study.spring.basic;

import com.study.spring.construct.Consumer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author milindeyu
 * @Date 2021/12/23 11:59 下午
 * @Version 1.0
 */
public class TestTwo {

    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    @Test
    public void test1() {
        Person person = applicationContext.getBean(Person.class);
        System.out.println("person=" + person);
    }

    /**
     * 测试构造注入
     */
    @Test
    public void test2() {
        Consumer bean = applicationContext.getBean(Consumer.class);
        System.out.println(bean);
    }

    @Test
    public void test3() {
        Consumer bean = (Consumer) applicationContext.getBean("constructName");
        System.out.println(bean);
    }

    @Test
    public void test4() {
        Consumer bean = (Consumer) applicationContext.getBean("constructAge");
        System.out.println(bean);
    }
}
