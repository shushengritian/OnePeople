package com.wanted.onepeople.exception;

import com.wanted.onepeople.constant.Status;
import lombok.Getter;

/**
 * 描述：页面异常
 *
 * @author xiyouquedongxing
 * @Date 2020-08-12
 */
@Getter
public class PageException extends BaseException{

    public PageException(Status status){
        super(status);
    }

    public PageException(Integer code, String message){
        super(code, message);
    }


}
