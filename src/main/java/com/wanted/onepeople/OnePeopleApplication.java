package com.wanted.onepeople;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 项目启动类
 *
 * @author xiyouquedongxing
 * @date 2018/08/08
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.wanted.onepeople.mapper"})
public class OnePeopleApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnePeopleApplication.class, args);
    }

}
