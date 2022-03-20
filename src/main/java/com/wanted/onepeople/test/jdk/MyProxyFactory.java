package com.wanted.onepeople.test.jdk;

import com.wanted.onepeople.test.jdk.MyInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author fdc
 * @Date 2022-03-19
 */
public class MyProxyFactory {

    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new MyInvocationHandler(target));
    }
}
