package com.study.spring.postprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 测试bean初始化过程中各个方法的执行顺序
 *
 * @Author milindeyu
 * @Date 2021/12/28 11:20 下午
 * @Version 1.0
 */
public class Consumer implements InitializingBean {
    private String name;
    private Integer age;

    public Consumer() {
        System.out.println("invoke construct method");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("start set name value");
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * set注入后初始化之前调用
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("start process afterPropertiesSet method");
    }

    public void customizeInit() {
        System.out.println("start process init method");
    }
}
