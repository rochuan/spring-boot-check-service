package com.mdx.common;

import java.util.HashMap;

public enum ErrorCode implements IErrorCode {

    SUCCESS             (200, "成功"),;


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
