package com.study.spring.proxy.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 通过实现BeanPostProcess来完成对代理对象的创建
 *
 * @author zhangwei151
 * @date 2022/1/2 19:51
 */
public class UserServiceFactory implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof UserService) {
            UserService userServiceProxy = (UserService) Proxy.newProxyInstance(UserServiceFactory.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("------------------factory log start------------------");
                    Object result = method.invoke(bean, args);
                    System.out.println("------------------factory log end------------------");
                    return result;
                }
            });
            // 返回创建的代理对象
            return userServiceProxy;
        }
        return bean;
    }
}
