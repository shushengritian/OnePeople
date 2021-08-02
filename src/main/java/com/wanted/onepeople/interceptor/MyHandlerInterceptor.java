package com.wanted.onepeople.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @Description:
 * @Author fdc
 * @Date 2021-07-02
 */
@Component
public class MyHandlerInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        //接口地址
        String uri = request.getServletPath();

    }

}
