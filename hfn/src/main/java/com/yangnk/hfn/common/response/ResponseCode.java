package com.yangnk.hfn.common.response;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-09 16:58
 **/
public enum ResponseCode {
    SUCCESS(0, "success"), ERROR(1, "error");

    private final int code;
    private final String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
