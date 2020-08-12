package com.wanted.onepeople.exception;

import com.wanted.onepeople.constant.Status;

/**
 * 描述：JSON异常
 *
 * @author xiyouquedongxing
 * @Date 2020-08-12
 */
public class JsonException extends BaseException{

    public JsonException(Status status){
        super(status);
    }

    public JsonException(Integer code, String message){
        super(code, message);
    }

}
