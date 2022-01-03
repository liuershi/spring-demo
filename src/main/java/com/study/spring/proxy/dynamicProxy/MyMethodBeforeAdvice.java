package com.study.spring.proxy.dynamicProxy;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 自定义额外功能
 *      缺点：MethodBeforeAdvice只允许在方法执行前调用
 *
 * @author zhangwei151
 * @date 2022/1/1 14:00
 */
public class MyMethodBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("----------------dynamic log--------------------");
    }
}
