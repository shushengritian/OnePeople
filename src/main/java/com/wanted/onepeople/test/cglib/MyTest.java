package com.wanted.onepeople.test.cglib;

/**
 * @Description:
 * @Author fdc
 * @Date 2022-03-19
 */
public class MyTest {

    public String updateName(String name){
        System.out.println("修改"+name);
        return "*"+name+"*";
    }
}
