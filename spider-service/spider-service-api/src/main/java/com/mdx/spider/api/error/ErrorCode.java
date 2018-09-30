package com.mdx.spider.api.error;

import com.mdx.common.IErrorCode;

import java.util.HashMap;

public enum ErrorCode implements IErrorCode {

    SUCCESS(200, "成功"),
    NO_LOGIN(401, "未经授权，请重新登录！"),

    EMPTY_USER(1000, "用户信息不存在！请检查账号是否正确！"),
    EMPTY_USER_ID(1001, "用户ID为空！"),
    PASSWORD_ERROR(1002, "用户名或者密码错误！"),
    CAPTCHA_ERROR(1005, "验证码不能为空！"),
    DATA_INFO_EXIST(1004, "数据库已存在该数据，请勿重复插入！"),
    DATA_INFO_NOT_EXIST(1005, "数据库不已存在该数据，请检查！"),
    DATA_INFO_DELETE_ERROR(1006, "删除失败，请检查！"),
    DATA_INFO_UPDATE_ERROR(1007, "更新失败，请检查！"),
    DATA_INFO_CREATE_ERROR(1008, "插入失败，请检查！"),
    DATA_INFO_SELECT_ERROR(1009, "查询失败，请检查！"),
    ;

    private static HashMap<Integer, ErrorCode> codeHash;

    static {
        codeHash = new HashMap<Integer, ErrorCode>();
        for (ErrorCode item : ErrorCode.values()) {
            codeHash.put(item.getCode(), item);
        }
    }

    public static ErrorCode getRespCodeByCode(int code) {
        return codeHash.get(code);
    }

    public static final int SUCCESS_CODE = 200;
    private int code;
    private String message;

    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }

}
