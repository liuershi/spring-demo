package com.study.spring.postprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author milindeyu
 * @Date 2021/12/28 11:49 下午
 * @Version 1.0
 */
public class ConsumerBeanPostProcess implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("consumer")) System.out.println("start execution before init");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("consumer")) System.out.println("start execution after init");
        return bean;
    }
}
