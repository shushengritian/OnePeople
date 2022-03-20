package com.wanted.onepeople.test.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Description:
 * @Author fdc
 * @Date 2022-03-19
 */
public class MyCglibFactory {

    public static Object getProxy(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new MyMethodInterceptor());
        return enhancer.create();
    }
}
