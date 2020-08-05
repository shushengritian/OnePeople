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
@SpringBootApplication
/**mapper接口类扫描包*/
/*@MapperScan("com.wanted.onepeople.dao")*/
public class OnePeopleApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnePeopleApplication.class, args);
    }
}
