package com.study.spring.basic;

import com.study.spring.converter.Person;
import com.study.spring.postprocess.Consumer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author milindeyu
 * @Date 2021/12/28 11:24 下午
 * @Version 1.0
 */
public class TestPostProcess {
    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("spring-config2.xml");
    }

    /**
     * 测试bean整个创建过程
     */
    @Test
    public void test1() {
        Consumer consumer = (Consumer) applicationContext.getBean("consumer");
        System.out.println(consumer);
    }
}
