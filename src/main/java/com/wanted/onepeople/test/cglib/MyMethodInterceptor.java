package com.wanted.onepeople.test.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Description:
 * @Author fdc
 * @Date 2022-03-19
 */
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib修改前"+new Date());
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("cglib修改后"+new Date());
        return result;
    }
}
