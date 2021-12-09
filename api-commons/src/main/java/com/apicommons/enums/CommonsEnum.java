package com.apicommons.enums;

import lombok.Data;

/**
 * @Description
 * @Auther lym
 * @Date 2021-10-12 11:16
 * @Version 1.0
 */
public enum CommonsEnum {

    SUCCESS("200001","成功"),
    FAIL("200002","失败"),
    SERVICE_FAILURE("200003","服务故障"),
    NO_AUTHORITY("200004","用户未被授予访问权限");
    private String code;
    private String massage;

    CommonsEnum(String code, String massage) {
        this.code = code;
        this.massage = massage;
    }

    public String getCode() {
        return this.code;
    }

    public String getMassage() {
        return this.massage;
    }
}
