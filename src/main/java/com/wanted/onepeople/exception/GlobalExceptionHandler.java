package com.wanted.onepeople.exception;

import com.wanted.onepeople.dto.ErrorInfo;
import com.wanted.onepeople.common.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiyouquedongxing
 * @date 2018/7/26 21:17
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 统一JSON异常处理
     * @param exception PageException
     * @return 统一返回 json 格式
     */
    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public ApiResponse jsonErrorHandler(JsonException exception){
        log.error("【JsonException】:{}", exception.getMessage());
        return ApiResponse.ofException(exception);
    }

    /**
     * 统一页面异常处理
     * @param exception PageException
     * @return 跳转到异常页面
     */
    @ExceptionHandler(value = PageException.class)
    public ModelAndView pageErrorHandler(PageException exception){
        log.error("【PageException】:{}", exception.getMessage());
        ModelAndView mav = new ModelAndView();
        mav.addObject("code", exception.getCode());
        mav.addObject("message", exception.getMessage());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception exception){
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", exception.getMessage());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException exception){
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(exception.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
}
