package com.wanted.onepeople.annotation;

import com.wanted.onepeople.enumerate.DesensitizationFieldType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 数据脱敏
 * @Author fdc
 * @Date 2022-03-11
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Desensitization {
    DesensitizationFieldType type();//注解中的定义值，可以理解为为这个注解添加的属性值
}
