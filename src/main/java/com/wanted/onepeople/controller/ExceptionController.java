package com.wanted.onepeople.controller;

import com.wanted.onepeople.constant.Status;
import com.wanted.onepeople.exception.JsonException;
import com.wanted.onepeople.exception.PageException;
import com.wanted.onepeople.common.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 描述：统一异常处理测试
 *
 * @author xiyouquedongxing
 * @Date 2020-08-12
 */
@RestController
public class ExceptionController {

    @GetMapping("/page")
    public ModelAndView pageException(){
        throw new PageException(Status.UNKNOWN_ERROR);
    }

    @GetMapping("/json")
    @ResponseBody
    public ApiResponse jsonException(){
        throw new JsonException(460, "网络异常");
    }

}
