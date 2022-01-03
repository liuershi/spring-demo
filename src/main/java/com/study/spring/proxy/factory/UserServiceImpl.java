package com.study.spring.proxy.factory;

import com.study.spring.proxy.staticProxy.User;

/**
 * @author zhangwei151
 * @date 2022/1/2 19:50
 */
public class UserServiceImpl implements UserService {
    @Override
    public void login(String username, String password) {
        System.out.println("username = " + username + " password = " + password);
    }

    @Override
    public void register(User user) {
        System.out.println("user = " + user.toString());
    }
}
