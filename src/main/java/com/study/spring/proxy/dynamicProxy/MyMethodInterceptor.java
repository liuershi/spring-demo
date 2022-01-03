package com.study.spring.proxy.dynamicProxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 自定义额外功能，实现MethodInterceptor可以在方法执行前后做扩展，功能相较于MethodBeforeAdvice更加强大
 *
 * @author zhangwei151
 * @date 2022/1/1 18:00
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("--------------------before-------------------");
        // MethodInvocation是对Method的封装，invocation.proceed()等同于Method.invoke()
        Object result = null;
        try {
            result = invocation.proceed();
//            int i = 1/0;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("原始方法抛出异常， 异常信息为：" + throwable.getMessage());
        }
        System.out.println("--------------------after-------------------");
        return result;
    }
}
