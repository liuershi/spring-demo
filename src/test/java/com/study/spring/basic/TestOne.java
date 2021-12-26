package com.study.spring.basic;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author milindeyu
 * @Date 2021/12/23 10:27 下午
 * @Version 1.0
 */
public class TestOne {

    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    /**
     * 简单测试获取bean
     */
    @Test
    public void test1() {
        Person person = (Person) applicationContext.getBean("person");
        System.out.println("person=" + person);
    }

    /**
     * 使用其重载方法直接获取bean
     */
    @Test
    public void test2() {
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println("person=" + person);
    }

    /**
     * 使用类型获取bean时需要工厂中只存在该一个类型bean定义，否则抛出NoUniqueBeanDefinitionException异常
     */
    @Test
    public void test3() {
        Person person = applicationContext.getBean(Person.class);
        System.out.println("person=" + person);
    }

    /**
     * 该方法是获取当前工厂中所有bean的ID
     */
    @Test
    public void test4() {
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println("beanDefinitionName=" + beanDefinitionName);
        }

        // 判断工厂中是否包含指定ID的bean
        System.out.println(applicationContext.containsBeanDefinition("person"));
        System.out.println(applicationContext.containsBeanDefinition("test"));
    }

    /**
     * 默认的，不指定bean对象的id时，其id默认为：类的全限定名#下标
     */
    @Test
    public void test5() {
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
    }

    /**
     * 测试通过别名获取bean
     */
    @Test
    public void test6() {
        Person p = (Person) applicationContext.getBean("p");
        Person person = (Person) applicationContext.getBean("person");
        Person personTest = (Person) applicationContext.getBean("personTest");
        System.out.println("p==person : " + (p==person));
        System.out.println("p==personTest : " + (p==personTest));
    }
}
