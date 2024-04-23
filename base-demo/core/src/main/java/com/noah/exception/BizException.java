package com.noah.exception;

import java.math.BigDecimal;

/**
 * 自定义业务异常类
 *
 * @Author: WangXinWei
 * @Date: 2019/12/10 16:16
 * @Version 1.0
 */
public class BizException extends RuntimeException {
    private static final long seriaVersionUID = 1L;
    private String errorCode;
    private String errorMsg;

    public BizException(String errorMsg) {
        super(errorMsg);
        this.errorCode = ResponseCode.ERROR.getCode();
        this.errorMsg = errorMsg;
    }

    public BizException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(String errorMsg, Throwable throwable) {
        super(errorMsg,throwable);
        this.errorCode = ResponseCode.ERROR.getCode();
        this.errorMsg = errorMsg;
    }

    public BizException(ResponseCode responseCode) {
        super(responseCode.getMsg());
        this.errorCode = responseCode.getCode();
        this.errorCode = responseCode.getMsg();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
