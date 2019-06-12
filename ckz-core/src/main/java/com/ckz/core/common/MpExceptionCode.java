package com.ckz.core.common;

/**
 * @author: caikaizhen
 * @date: 2019/2/18 14:23
 * @Description:
 */
public enum MpExceptionCode {

    SUCCESS("SUCCESS", 1000, "success", "成功"),
    FAILED("FAILED", 1001, "failed", "失败"),
    NO_LOGIN("FAILED", 1002, "no login", "登陆异常"),
    TOKEN_IS_NULL("TOKEN_IS_NULL", 2000, "token_is_null", "token已过期请重新登录"),
    SYSTEM_ERROR("SYSTEM_ERROR", 9999, "system error", "流量过大系统开小差啦，请尝试重新发起"),
    NO_HANDLER_FOUND("NO_HANDLER_FOUND", 404, "no handler found", "没有找到对应的请求接口，请检查请求路径"),
    PARAM_ERROR("PARAM_ERROR",1005,"param error","传入参数异常"),
    USER_ID_IS_NULL("USER_ID_IS_NULL",2000,"userId is null error","用户id为空"),
    USER_ID_IS_EXCEPTION("USER_ID_IS_EXCEPTION",2001,"userId is exception","用户异常"),
    USER_NICK_IS_NULL("USER_NICK_IS_NULL",2003,"userNick is null","用户昵称为空"),
    USER_AVATAR_IS_NULL("USER_AVATAR_IS_NULL",2004,"userAvatar is null","用户头像为空"),
    USER_PHONE_IS_EXCEPTION("USER_PHONE_IS_EXCEPTION",2002,"user phone is exception","您的手机号存在问题"),
    LOGIN_ERROR_REGISTER("LOGIN_ERROR_REGISTER",10014,"not register","该用户未注册"),
    LOGIN_ERROR_PASSWORD("LOGIN_ERROR_PASSWORD",10015,"password error","密码错误"),
    REGISTER_ERROR_REGISTER("REGISTER_ERROR_REGISTER",10016,"is register","该用户已注册"),
    PASSWORD_REPASSWORD_IS_NOT_EQUALS("PASSWORD_REPASSWORD_IS_NOT_EQUALS",10016,"password is not equals","密码输入不一致"),
    ADVERTISEMENT_NULL("ADVERTISEMENT_NULL",10020,"advertisement null","广告或banner图为空"),
    BOMB_URL_NULL("BOMB_URL_NULL",10021,"bomb_url null","用户无弹弹封面照片，请上传"),

    ASYNC_EXCEPTION("ASYNC_EXCEPTION",999,"ASYNC_EXCEPTION","异步异常"),

    N0_USER("N0_USER",10022,"用户不存在","用户不存在"),
    IS_BINDING("IS_BINDING",10023,"用户已绑定过","用户已绑定过"),
    LOGIN_ERROR_ISBAN("LOGIN_ERROR_ISBAN",10025,"You have been banned","账号异常"),
    PASSWORDISNOTSFAE("NOTSAFE",1088,"密码长度不够","密码长度不够"),
    PASSWORDISNOTSFAE3("NOTSAFE",1090,"密码格式不正确,必须为6-12位英文加数字","密码格式不正确,必须为6-12位英文加数字");



    /**
     * 错误码
     */
    private String code;

    /**
     * 错误编号
     */
    private int errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 错误描述
     */
    private String desc;

    private MpExceptionCode(String code, int errorCode, String errorMsg, String desc) {
        this.code = code;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.desc = desc;
    }

    public static MpExceptionCode getByCode(String code) {
        if (code == null || "".equalsIgnoreCase(code)) {
            return null;
        }
        MpExceptionCode[] errorCodes = values();

        for (MpExceptionCode acsErrorCode : errorCodes) {
            if (acsErrorCode.getCode().equals(code)) {
                return acsErrorCode;
            }
        }

        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}

