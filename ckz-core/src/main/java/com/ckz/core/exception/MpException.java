package com.ckz.core.exception;


import com.ckz.core.common.MpExceptionCode;

/**
 * @author hantao
 * @version V1.0
 * @Title: works
 * @Package com.ald.bubble.exception
 * @Description: 通用异常处理
 * @date 2017/12/8 17:58
 */
public class MpException extends Exception{
    private static final long serialVersionUID = 5540484171361000892L;

    private MpExceptionCode errorCode;

    public MpException() {
        super();
        errorCode = MpExceptionCode.SYSTEM_ERROR;
    }

    public MpException(String message) {
        super(message);
        errorCode = MpExceptionCode.SYSTEM_ERROR;
    }

    public MpException(String message, Throwable e) {
        super(message, e);
        errorCode = MpExceptionCode.SYSTEM_ERROR;
    }

    public MpException(Throwable e) {
        super(e);
        errorCode = MpExceptionCode.SYSTEM_ERROR;
    }

    public MpException(MpExceptionCode CommonErrorCode) {
        super();
        errorCode = CommonErrorCode;
    }

    public MpException(MpExceptionCode CommonErrorCode, Throwable e) {
        super(e);
        errorCode = CommonErrorCode;
    }

    public MpException(String message, MpExceptionCode CommonErrorCode) {
        super(message);
        errorCode = CommonErrorCode;
    }

    public MpException(String message, MpExceptionCode CommonErrorCode, Throwable e) {
        super(message, e);
        errorCode = CommonErrorCode;
    }

    public MpExceptionCode getErrorCode() {
        return errorCode;
    }
}
