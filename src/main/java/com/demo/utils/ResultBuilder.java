package com.demo.utils;

import com.demo.model.ApiCode;
import com.demo.model.Response;

/**
 * 接口回参构筑类
 */
public class ResultBuilder {

    /**
     * 调用成功，无返回信息
     */
    public static Response success() {
        return new Response(ApiCode.SUCCESS.getCode(), ApiCode.SUCCESS.getMessage(), "", "");
    }

    /**
     * 调用成功，返回结果信息
     *
     * @param result
     */
    public static Response success(Object result) {
        return new Response(ApiCode.SUCCESS.getCode(), ApiCode.SUCCESS.getMessage(), "", result);
    }

    /**
     * 调用失败，返回异常状态码及描述
     *
     * @param apiCode
     */
    public static Response failure(ApiCode apiCode, String error) {
        return new Response(apiCode.getCode(), apiCode.getMessage(), error, "");
    }

}
