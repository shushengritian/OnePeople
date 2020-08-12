package com.wanted.onepeople.exception;

import com.wanted.onepeople.constant.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：异常处理基类
 *
 * @author xiyouquedongxing
 * @Date 2020-08-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException{

    private Integer code;
    private String message;

    public BaseException(Status status){
        super(status.getMessage());
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public BaseException(Integer code, String message){
        super(message);
        this.code = code;
        this.message = message;
    }

}
