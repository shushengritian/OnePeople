package com.wanted.onepeople.test.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Description:
 * @Author fdc
 * @Date 2022-03-19
 */
public class MyInvocationHandler implements InvocationHandler {

    private final Object target;

    public MyInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("修改前"+new Date());
        Object result = method.invoke(target, args);
        System.out.println("修改后"+new Date());
        return result;
    }
}
