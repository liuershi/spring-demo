package com.study.spring.scope;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author zhangwei151
 * @date 2021/12/26 18:29
 */
public class Account implements InitializingBean, DisposableBean {
    private String name;
    private Integer age;

    public Account() {
        System.out.println("account init ");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 对象创建的初始化方法
     */
    public void testInit() {
        System.out.println("test init");
    }

    /**
     * 自定义销毁方法：销毁方法只有在工厂关闭时才触发，例如调用close()方法。或者强制关闭容器
     */
    public void customizeDestroy() {
        System.out.println("destroy method...");
    }

    /**
     * 可以实现InitializingBean接口初始化，和init-method="testInit"效果相同
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("name = " + name);
        System.out.println("afterPropertiesSet");
    }

    /**
     * 同初始化一样，可实现接口实现销毁调用.
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("interface destroy");
    }
}
