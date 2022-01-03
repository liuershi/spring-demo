package com.study.spring.proxy;

import com.study.spring.proxy.staticProxy.User;
import com.study.spring.proxy.UserService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @author zhangwei151
 * @date 2022/1/2 19:16
 */
public class TestCglibProxy {
    public static void main(String[] args) {
        // 使用cglib进行动态代理，spring中已经集成

        Enhancer enhancer = new Enhancer();
        // 1.使用cglib进行动态代理实际上是对目标类的继承，同jdk一样是运行期动态创建class字节码在jvm
        // 中，所有要需要设置类加载器
        enhancer.setClassLoader(TestCglibProxy.class.getClassLoader());
        // 2.由于是继承，所以要指定父类类型
        UserService userService = new UserService();
        enhancer.setSuperclass(userService.getClass());
        // 3.同样，还需设置额外功能
        enhancer.setCallback((MethodInterceptor) (proxy, method, objects, methodProxy) -> {
            System.out.println("------------------cglib proxy start------------------");
            Object result = method.invoke(userService, objects);
            System.out.println("------------------cglib proxy end------------------");
            return result;
        });
        // 4.创建代理类
        UserService userServiceProxy = (UserService) enhancer.create();
        userServiceProxy.cglibUser();
        userServiceProxy.cglibLogin();
    }
}
