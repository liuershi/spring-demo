package com.study.spring.basic;

import com.study.spring.converter.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author milindeyu
 * @Date 2021/12/28 10:09 下午
 * @Version 1.0
 */
public class TestConverter {

    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("spring-config2.xml");
    }

    /**
     * 测试类型转换器
     */
    @Test
    public void test1() {
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
}
