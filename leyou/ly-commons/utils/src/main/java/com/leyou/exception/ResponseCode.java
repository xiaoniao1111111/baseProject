package com.leyou.exception;

/**
 * 自定义异常信息
 * @Author: WangXinWei
 * @Date: 2019/12/10 17:01
 * @Version 1.0
 */
public enum ResponseCode {
    ERROR("999999", "操作失败"),
    SUCCESS("000000", "操作成功");
    private String code;
    private String msg;

    ResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }}
