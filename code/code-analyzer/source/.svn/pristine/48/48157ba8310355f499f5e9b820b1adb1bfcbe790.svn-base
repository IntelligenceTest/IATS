package com.autostreets.biz.auction.enums;

/**
 * 校验返回信息枚举类
 * @author meng.zhao
 *
 */
public enum ValidationMsgEnum {
	SUCCESS(0, "操作成功"),
	INVALID_MOBILE(1, "手机号输入错误"),
	REPEAT_VALIDCODE(2, "请稍后再试"),
	INVALID_VALIDCODE(3, "验证码错误"),
	VALIDCODE_EXPIRE(4, "验证码过期"),
	MOBILE_NOT_EXISTS(5, "该手机号不存在"),
	MOBILE_EXISTS(6, "该手机号已存在"),
	PASSWORD_CONFLICT(7, "不能跟原密码一致"),
	PARAM_NOT_EXISTS(8, "参数不存在"),
	PASSWORD_ERROR(9, "密码输入错误"),
	ACCOUNT_EXISTS(10, "该账号已注册"),
	ACCOUNT_VIOLATION(11, "该账号无效，请联系客服"),
	SYSTEM_ERROR(99, "系统错误"),
	IMG_CODE_ERROR(88, "图片验证码错误");
    private int code = 0;
    private String name = null;
    
    private ValidationMsgEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }
    
    public String getName() {
        return name;
    }
    
}
