package com.wanted.onepeople.enumerate;

/**
 * @Description:
 * @Author fdc
 * @Date 2022-03-13
 */
public enum DesensitizationFieldType {

    /**
     * 姓名
     */
    NAME("name","用户姓名"),
    /**
     * 手机号
     */
    MOBILE("phone", "11位手机号"),
    /**
     * 身份证
     */
    IDENTITY_NO("identityNo", "16或者18身份证号"),

    /**
     * 银行卡
     */
    BANKCARD_NO("bankCardNo", "银行卡号")
    ;

    String type;

    String describe;


    DesensitizationFieldType(String type, String describe) {
        this.type = type;
        this.describe = describe;
    }

    public String getType() {
        return type;
    }

    public String getDescribe() {
        return describe;
    }
}
