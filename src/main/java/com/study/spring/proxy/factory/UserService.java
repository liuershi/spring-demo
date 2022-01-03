package com.study.spring.proxy.factory;

import com.study.spring.proxy.staticProxy.User;

/**
 * @author zhangwei151
 * @date 2022/1/2 19:49
 */
public interface UserService {
    void login(String username, String password);

    void register(User user);
}
