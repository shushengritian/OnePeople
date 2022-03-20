package com.wanted.onepeople.test.jdk;

import com.wanted.onepeople.test.jdk.MyInterface;

/**
 * @Description:
 * @Author fdc
 * @Date 2022-03-19
 */
public class MyInterfaceImpl implements MyInterface {

    @Override
    public String updateName(String name) {
        System.out.println("修改"+name);
        return "*"+name+"*";
    }
}
