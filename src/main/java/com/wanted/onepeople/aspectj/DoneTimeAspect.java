package com.wanted.onepeople.aspectj;

import com.wanted.onepeople.annotation.DoneTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 功能描述：完成时间切面
 *
 * @author xiyouquedongxing
 * @Date 2020-08-07
 */
@Component
@Aspect
@Slf4j
public class DoneTimeAspect {

    @Around("@annotation(doneTime)")
    public Object around(ProceedingJoinPoint point, DoneTime doneTime) throws Throwable {
        log.info(doneTime.param() + ":" + new Date());
        Object object = point.proceed();
        log.info(doneTime.param() + ":" + new Date());
        return object;
    }

}
