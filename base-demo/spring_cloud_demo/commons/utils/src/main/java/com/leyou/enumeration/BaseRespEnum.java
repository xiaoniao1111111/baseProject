package com.leyou.enumeration;

/**
 * 反参状态码及状态信息
 *
 * @Author: WangXinWei
 * @Date: 2020/1/6 15:51
 * @Version 1.0
 */
public enum BaseRespEnum {

    ERROR("999999", "操作失败"),
    SUCCESS("200", "操作成功"),
    EXCEPTION("000999", "操作异常"),
    NOACTION("000111", "无动作"),
    ARGUMENT_INVALID("010000", "请求参数错误"),
    USER_NOT_EXIST("000101", "用户不存在"),
    PASSWORF_ERROR("000102", "密码错误"),
    INVALID_USER("000103", "无效的用户"),
    NO_TOKEN("000104", "用户未登录"),
    EXP_TOKEN("000105", "过期的token"),
    VISITE_DEL("000106", "数据为空"),
    NO_AUTHORITY("000107", "无本系统权限"),
    NO_AUTHORITY_PAGE("000108", "无该页面访问权限"),
    NEED_VALID_CODE("000106", "需要验证码"),
    REFERER_INVALID("00110","当前请求不合法,系统已拦截");
    private String code;
    private String message;

    BaseRespEnum(String code, String message) {
        this.code = code;
        this.message = message;
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
    }}
