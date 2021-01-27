package com.wanted.onepeople;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 项目启动类
 *
 * @author xiyouquedongxing
 * @date 2018/08/08
 */
@MapperScan(basePackages = {"com.wanted.onepeople.mapper"})
@SpringBootApplication
public class OnePeopleApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnePeopleApplication.class, args);
    }

}
