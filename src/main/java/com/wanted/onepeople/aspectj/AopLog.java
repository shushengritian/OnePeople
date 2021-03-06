package com.wanted.onepeople.aspectj;

import cn.hutool.json.JSONUtil;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * 功能描述：aop切面log日志
 *
 * @author xiyouquedongxing
 * @Date 2020-08-07
 */
@Aspect
@Component
@Slf4j
public class AopLog {

    private static final String START_TIME = "request-start";

    /**
     * 切入点
     * */
    @Pointcut("execution(public * com.wanted.onepeople.controller.AopLogController.*(..))")
    public void log(){

    }

    /**
     * 前置操作
     *
     * @param point 切入点
     * */
    @Before("log()")
    public void beforeLof(JoinPoint point){

        //获取request
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        log.info("【请求 URL】：{}", request.getRequestURL());
        log.info("【请求 IP】：{}", request.getRemoteAddr());
        log.info("【请求类名】：{}，【请求方法名】：{}", point.getSignature().getDeclaringTypeName(), point.getSignature().getName());

        Map<String, String[]> parameterMap = request.getParameterMap();
        log.info("【请求参数】：{}", JSONUtil.toJsonStr(parameterMap));
        Long start = System.currentTimeMillis();
        request.setAttribute(START_TIME,start);

    }

    /**
     * 环绕操作
     *
     * @param point 切入点
     * @throws Throwable 异常信息
     * @return Object 原方法返回值
     *
     * */
    @Around("log()")
    public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
        Object res = point.proceed();
        log.info("【返回值】：{}", JSONUtil.toJsonStr(res));
        return res;
    }

    /**
     * 后置操作
     *
     * */
    @AfterReturning("log()")
    public void afterReturning(){

        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        Long start = (Long)request.getAttribute(START_TIME);
        Long end = System.currentTimeMillis();
        log.info("【请求耗时】：{}毫秒",end - start);

        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        log.info("【浏览器类型】：{}，【操作系统】：{}，【原始User-Agent】：{}", userAgent.getBrowser().toString(),
                userAgent.getOperatingSystem().toString(), header);

    }

}
