package com.wanted.onepeople.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 功能描述：完成时间注解
 *
 * @author xiyouquedongxing
 * @Date 2020-08-07
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface DoneTime {
    String param() default "";
}
