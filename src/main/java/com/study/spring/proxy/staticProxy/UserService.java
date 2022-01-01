package com.study.spring.proxy.staticProxy;

/**
 * 静态代理的原始接口
 *
 * @Author milindeyu
 * @Date 2021/12/30 10:34 下午
 * @Version 1.0
 */
public interface UserService {

    void register(User user);

    boolean login(String username, String password);
}
