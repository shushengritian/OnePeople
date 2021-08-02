package com.wanted.onepeople.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:
 * @Author fdc
 * @Date 2021-07-02
 */
@Configuration
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {

    @Bean
    MyHandlerInterceptor getMyHandlerInterceptor(){
        return new MyHandlerInterceptor();
    }

    public void addInterceptors(){

    }


}
