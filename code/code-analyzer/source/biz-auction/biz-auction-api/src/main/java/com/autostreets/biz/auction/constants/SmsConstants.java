/**
 * @Title: SmsConstants.java
 * @Package com.autostreets.constant
 * @Description:
 * @author yanqing.luo （roceys#gmail.com）
 * @date 2014-12-4 13:55:35
 * @version V1.0
 * @Copyright: 2014 www.autostreets.com Inc. All rights reserved.
 * 本内容仅限于汽车街(AUTOSTREETS)内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.autostreets.biz.auction.constants;

/**
 * <pre>
 * 短信商云信接口帮助文档：http://www.topencrm.com/xzzx
 * </pre>
* @ClassName: SmsConstants
* @Description: 短信常量
* @author yanqing.luo （roceys#gmail.com）
* @date 2014年12月4日 下午1:55:33
* @version V1.0
*/
public final class SmsConstants {
    private SmsConstants() {}

    // 1、 成功:返回本次提交的批次号(如:1362120689344),(或叫序列号、流水号 等,提交一次返回一个)。该批次号将用于查询状态报告。
    public static final String FAIL_INTERFACE_ERROR = "-1"; // 提交接口错误
    public static final String FAIL_INTERFACE_ERROR_TEXT = "提交接口错误";
    public static final String FAIL_USERNAMEORPWD_ERROR = "-3";// 用户名或密码错误
    public static final String FAIL_USERNAMEORPWD_ERROR_TEXT = "用户名或密码错误";
    public static final String FAIL_TEMPLATE_DIFF_FILING = "-4"; // 短信内容和备案的模板不一样
    public static final String FAIL_TEMPLATE_DIFF_FILING_TEXT = "短信内容和备案的模板不一样"; 
    public static final String FAIL_SIGNATURE_ERROR = "-5"; // 签名不正确（格式为： 短信内容……【签名内容】）签名一定要放在短信最后
    public static final String FAIL_SIGNATURE_ERROR_TEXT = "签名不正确";
    public static final String FAIL_BALANCE_ERROR = "-7";// 余额不足
    public static final String FAIL_BALANCE_ERROR_TEXT = "余额不足";
    public static final String FAIL_CHANNEL_ERROR = "-8";// 通道错误
    public static final String FAIL_CHANNEL_ERROR_TEXT = "通道错误";
    public static final String FAIL_INVALID_PHONE = "-9";// 无效号码
    public static final String FAIL_INVALID_PHONE_TEXT = "无效号码";
    public static final String FAIL_LENGTH_SIGNATURE_ERROR = "-10";// 签名内容不符合长度
    public static final String FAIL_LENGTH_SIGNATURE_ERROR_TEXT = "签名内容不符合长度";
    public static final String FAIL_SMSUSER_INVALIDDATE = "-11";// 用户有效期过期
    public static final String FAIL_SMSUSER_INVALIDDATE_TEXT = "用户有效期过期";
    public static final String FAIL_BLACKLIST = "-12";// 黑名单
    public static final String FAIL_BLACKLIST_TEXT = "黑名单";
    public static final String FAIL_ERRORS[] = { FAIL_INTERFACE_ERROR, FAIL_USERNAMEORPWD_ERROR, FAIL_TEMPLATE_DIFF_FILING, FAIL_SIGNATURE_ERROR, FAIL_BALANCE_ERROR, FAIL_CHANNEL_ERROR, FAIL_INVALID_PHONE, FAIL_LENGTH_SIGNATURE_ERROR, FAIL_SMSUSER_INVALIDDATE, FAIL_BLACKLIST };
}
