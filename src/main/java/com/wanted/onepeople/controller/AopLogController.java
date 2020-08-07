package com.wanted.onepeople.controller;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import com.wanted.onepeople.annotation.DoneTime;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 功能描述：测试aop切片日志
 *
 * @author xiyouquedongxing
 * @Date 2020-08-07
 */
@RestController
public class AopLogController {

    Logger myLog = LoggerFactory.getLogger("MY_LOG");

    /**
     * 测试aop日志打印
     *
     * */
    @GetMapping("/testAopLog")
    public Dict testAopLog(@Param("who") String who){
        Date date = new Date();
        myLog.info(date.toString()+":"+Dict.create().set("who", StrUtil.isBlank(who) ? "me" : who).toString());
        return Dict.create().set("who", StrUtil.isBlank(who) ? "me" : who);
    }

    /**
     * 测试testAnnotationAopLog
     *
     * */
    @GetMapping("/testAnnotationAopLog")
    @DoneTime(param = "testAnnotationAopLog")
    public Dict testAnnotationAopLog(@Param("who") String who) throws InterruptedException {
        Thread.sleep(1000);
        return Dict.create().set("who", StrUtil.isBlank(who) ? "me" : who);
    }

}
