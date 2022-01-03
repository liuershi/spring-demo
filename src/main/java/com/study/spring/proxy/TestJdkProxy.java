package com.study.spring.proxy;

import com.study.spring.proxy.staticProxy.User;
import com.study.spring.proxy.staticProxy.UserService;
import com.study.spring.proxy.staticProxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangwei151
 * @date 2022/1/2 18:58
 */
public class TestJdkProxy {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        // 1.测试JDK的动态代理
        // 说明：由于动态代码并不会创建class类文件，只会在运行期动态创建class并加载到JVM中，而我们创建通过反射
        // ，而反射首先需要Class对象，而创建Class必须由类加载器来完成，对于java文件而已，jvm默认会为其提供类加载器，
        // 而动态字节码技术并不存在java源文件和class字节码文件，因此需要自己提供类加载器，而这个类加载器则没有限制
        // 任何类的类加载器都行
        // 缺点：jdk的动态代理实际上是对目标类实现的jdk进行实现，在目标类方法调用前后自定义处理，而本质上是对接口的继承,
        // 存在需要代理的类并未实现接口，此时JDK的代理并不能很好的工作。
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("---------------------jdk proxy start---------------------");
                Object invoke = method.invoke(userService, args);
                System.out.println("---------------------jdk proxy end---------------------");
                return invoke;
            }
        });

        userServiceProxy.register(new User());
        userServiceProxy.login("张三", "123");
    }
}
