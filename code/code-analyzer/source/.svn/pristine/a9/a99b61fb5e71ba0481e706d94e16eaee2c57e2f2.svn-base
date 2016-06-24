package com.autostreets.biz.auction.constants;

import java.util.Date;

import com.autostreets.framework.common.utils.Config;
import com.autostreets.framework.common.utils.DateUtils;

public final class Constants {

    public static final String BASE_DOMAIN = "autostreets.com";
    public static final String STATIC_DOMAIN = "img.autostreetscdn.com";
    public static final String NEW_DOMAIN = "new.autostreets.com";
    public static final String YDOMAIN = "y.autostreets.com";
    public static final String HOME_DOMAIN = "auction.autostreets.com";
    public static final String PARENT_HOME_DOMAIN = "www.autostreets.com";
    public static final String IMAGE_DOMAIN = "images.autostreets.com";
    public static final String STATIC_TIME = DateUtils.formatDate(new Date(), DateUtils.DATE_FORMAT_LONG);

    public static final String COOKIE_NAME = Config.getConfig().get("cookie.name");
    public static final String COOKIE_DOMAIN = Config.getConfig().get("cookie.domain");
    public static final String COOKIE_PATH = Config.getConfig().get("cookie.path");
    public static final String COOKIE_VERIFICATION = Config.getConfig().get("cookie.verification");

    public static final String SECRET_KEY = Config.getConfig().get("secret.key");

    public static final String USER_IDENTITY_KEY = Config.getConfig().get("user.identity.key");

    public static final int SESSION_TIMEOUT = Integer.parseInt(Config.getConfig().get("session.timeout"));

    public static final String LOGIN_DOMAIN = Config.getConfig().get("login.url");

    public static final String SESSION_CAS_ISLOGIN = "sessionCasIsLogin";

    // 支付网关
    public static final String PAYMENT_GATEWAY = Config.getConfig().get("payment.gateway");

    // 支付同步回调地址前部
    public static final String SYN_CALLBACK_URL = Config.getConfig().get("payment.syncallbackUrl");

    // 支付异步回调地址前部
    public static final String ASYN_CALLBACK_URL = Config.getConfig().get("payment.asyncallbackUrl");

    // 支付异步回调地址前部
    public static final String RESULT_CALLBACK_URL = Config.getConfig().get("payment.resultcallbackUrl");

    // 订单的推广渠道COOKIE
    public static final String ORDER_COOKIE = "ce2af7d6b8f748bebf9f8c2a187bdf8d";

    private Constants() {
    }
}
