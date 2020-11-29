package com.demo.model;

public class Response {

    /**
     * 状态码
     */
    private String code;

    /**
     * 状态码描述
     */
    private String message;

    /**
     * 接口异常信息
     */
    private String error;

    /**
     * 结果信息
     */
    private Object result;

    public Response(String code, String message, String error, Object result) {
        this.code = code;
        this.message = message;
        this.error = error;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
