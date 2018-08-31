package com.mdx.common;

abstract class SimpleResp {
    private int code;

    private Boolean success = false;

    private String message;

    private String traceId;

    public SimpleResp() {

    }

    public SimpleResp(int code) {
        this.code = code;
    }

    public SimpleResp(IErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.success = errorCode.getCode() == 200 ? true : false;
    }

    public SimpleResp(int code, String message) {
        this.code = code;
        this.message = message;
        this.success = code == 200 ? true : false;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
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

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
