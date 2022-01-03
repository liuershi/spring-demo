package com.study.spring.proxy.aspect;

import com.study.spring.proxy.staticProxy.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author zhangwei151
 * @date 2022/1/2 19:50
 */
public class UserServiceImpl implements UserService, ApplicationContextAware {

    /**
     * 声明工厂成员变量
     */
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void login(String username, String password) {
        System.out.println("login");
        // 直接使用this调用方法时代表的是当前原始对象调用register方法，此时不会执行代理加的额外功能
        // 此时想让register方法也达到同login相同相关，需要使用代理类来调用register
//        this.register(new User());
        UserService aspectUserService = (UserService) applicationContext.getBean("aspectUserService");
        aspectUserService.register(new User());
    }

    @Override
    public void register(User user) {
        System.out.println("register");
    }
}
