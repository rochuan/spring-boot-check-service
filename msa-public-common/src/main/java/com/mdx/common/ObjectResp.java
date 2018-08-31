package com.mdx.common;

public class ObjectResp<T> extends SimpleResp {
    private T data;
    public ObjectResp(int code) {
        super(code);
    }

    public ObjectResp() {

    }
    public ObjectResp(IErrorCode errorCode) {
        super(errorCode);
    }

    public ObjectResp(int code, String message) {
        super(code, message);
    }

    public ObjectResp(T data, IErrorCode errorCode){
        super(errorCode);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ObjectResp(T data){
        this.setCode(ErrorCode.SUCCESS.getCode());
        this.setSuccess(true);
        this.setMessage(ErrorCode.SUCCESS.getMessage());
        this.data = data;
    }
}
