package com.study.spring.basic;

import com.study.spring.proxy.staticProxy.User;
import com.study.spring.proxy.staticProxy.UserService;
import com.study.spring.proxy.staticProxy.UserServiceProxy;
import org.junit.Test;

/**
 * @Author milindeyu
 * @Date 2021/12/30 10:40 下午
 * @Version 1.0
 */
public class TestProxy {

    /**
     * 测试静态代理
     */
    @Test
    public void test1() {
        UserService userService = new UserServiceProxy();
        userService.register(new User());
        userService.login("zhangsan", "123456");
    }
}
