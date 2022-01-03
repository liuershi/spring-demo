package com.study.spring.proxy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 基于注解的aop编程
 *
 * @author zhangwei151
 * @date 2022/1/2 21:47
 */
@Aspect// 声明这是一个切面
public class MyAspect {

    /**
     * 声明切入点
     *  例：下面声明的切入点只在名称为login的方法执行
     */
    @Pointcut(value = "execution(* login(..))")
    public void pointCut(){}

    /**
     * 声明切点为在类为UserServiceImpl的所有方法
     */
    @Pointcut(value = "execution(* *..UserServiceImpl..*(..))")
    public void customizePointCut(){}

    /**
     * ProceedingJoinPoint等同于实现MethodInterceptor接口中的MethodInvocation对象，用于调用原始方法
     * @param joinPoint
     */
    @Around(value = "customizePointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("--------------aspect log start--------------");
        // 原始方法调用
        Object result = joinPoint.proceed();
        System.out.println("--------------aspect log end--------------");
        return result;
    }
}
