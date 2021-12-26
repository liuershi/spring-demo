package com.study.spring.construct;

/**
 * @Author milindeyu
 * @Date 2021/12/24 11:31 下午
 * @Version 1.0
 */
public class Consumer {
    private String name;
    private Integer age;

    public Consumer(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Consumer(String name) {
        this.name = name;
    }

    public Consumer(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
