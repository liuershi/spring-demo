package com.study.spring.proxy.staticProxy;

/**
 * 原始类的代理实现
 *      说明：静态代理的特点是，对于代理实现，必须实现原始类接口，即为原始类提供一个对应的代理类
 *      缺点：
 *          1. 静态代理对应代理文件过多，每个原始类都需要有一个对应的代理类，类数量过多导致项目管理难度大
 *          2. 后期维护中，代理类的维护性差（麻烦）
 *
 * @Author milindeyu
 * @Date 2021/12/30 10:36 下午
 * @Version 1.0
 */
public class UserServiceProxy implements UserService {

    private final UserService userService = new UserServiceImpl();

    @Override
    public void register(User user) {
        System.out.println("------log------");
        userService.register(user);
    }

    @Override
    public boolean login(String username, String password) {
        System.out.println("------log------");
        userService.login(username, password);
        return false;
    }
}
