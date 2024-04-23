package com.leyou.common;

import com.leyou.enumeration.BaseRespEnum;

import java.io.Serializable;

/**
 * @Author: WangXinWei
 * @Date: 2019/5/30 17:50
 * @Version 1.0
 */
public class BaseResponse<T> implements Serializable {
    private String code;
    private String message;
    private T result;

    public static <T> BaseResponse success(T result) {
        return new BaseResponse(BaseRespEnum.SUCCESS, result);
    }

    private BaseResponse(BaseRespEnum baseRespEnum, T result) {
        this.code = baseRespEnum.getCode();
        this.message = baseRespEnum.getMessage();
        this.result = result;
    }

    public BaseResponse(String code, String message, T result) {
        this.code = code;
        this.message = message;
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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public static BaseResponse success(String msg) {
        return new BaseResponse(BaseRespEnum.SUCCESS.getCode(), msg, (Object) null);
    }

    public static BaseResponse invalidParam(String msg) {
        return new BaseResponse(BaseRespEnum.ARGUMENT_INVALID.getCode(), msg, (Object) null);
    }

    public static BaseResponse fail(String msg) {
        return new BaseResponse(BaseRespEnum.ERROR.getCode(), msg, (Object) null);
    }
}
