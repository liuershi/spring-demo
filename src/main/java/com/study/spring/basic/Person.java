package com.study.spring.basic;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2021/12/23 10:23 下午
 * @Version 1.0
 */
public class Person {
    private String name;
    private Integer age;

    /**
     * 别名：非基本类型或string也可以set注入
     */
    private List<String> alias;

    private Set<String> phones;

    private Map<String, Object> attr;

    /**
     * 也允许注入properties类型属性
     */
    private Properties properties;

    public Person() {
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAlias(List<String> alias) {
        this.alias = alias;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public void setAttr(Map<String, Object> attr) {
        this.attr = attr;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", alias=" + alias +
                ", phones=" + phones +
                ", attr=" + attr +
                ", properties=" + properties +
                '}';
    }
}
