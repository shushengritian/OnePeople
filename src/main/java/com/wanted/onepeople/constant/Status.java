package com.wanted.onepeople.constant;

import lombok.Getter;

/**
 * <p>
 * 状态码封装
 * </p>
 *
 * @author xiyouquedongxing
 * @Date 2020-08-12
 */
@Getter
public enum Status {

    /**
     * 成功
     */
    OK(200, "操作成功"),

    /**
     * 未知异常
     */
    UNKNOWN_ERROR(500, "服务器出错啦");

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 内容
     */
    private String message;

    Status(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
