package com.wanted.onepeople.controller;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import com.wanted.onepeople.annotation.Desensitization;
import com.wanted.onepeople.annotation.DoneTime;
import com.wanted.onepeople.model.User;
import com.wanted.onepeople.service.DesensitizationService;
import com.wanted.onepeople.service.MybatisDemoService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 功能描述：测试aop切片日志
 *
 * @author xiyouquedongxing
 * @Date 2020-08-07
 */
@RestController
public class AopLogController {

    Logger myLog = LoggerFactory.getLogger("MY_LOG");

    private final DesensitizationService desensitizationService;

    @Autowired
    public AopLogController(DesensitizationService desensitizationService) {
        this.desensitizationService = desensitizationService;
    }

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

    /**
     * 测试Desensitization
     *
     * */
    @GetMapping("/testDesensitization")
    public void testDesensitization() {
        User user1 = new User();
        user1.setName("张三丰");
        user1.setAge(23);
        User user2 = new User();
        user2.setName("李四");
        user2.setAge(18);
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        desensitizationService.roleDesensitization(list);
        for (User user: list) {
            System.out.println(user.getName());
        }
    }

}
