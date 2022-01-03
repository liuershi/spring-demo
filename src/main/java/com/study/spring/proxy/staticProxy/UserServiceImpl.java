package com.study.spring.proxy.staticProxy;

import com.study.spring.proxy.dynamicProxy.Log;

/**
 * 原始类默认实现
 *
 * @Author milindeyu
 * @Date 2021/12/30 10:35 下午
 * @Version 1.0
 */
public class UserServiceImpl implements UserService{
    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register");
    }

    @Override
    @Log
    public boolean login(String username, String password) {
        System.out.println("UserServiceImpl.login");
        return false;
    }
}
