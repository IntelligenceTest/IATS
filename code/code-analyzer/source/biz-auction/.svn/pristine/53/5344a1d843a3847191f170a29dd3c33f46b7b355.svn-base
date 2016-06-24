package com.autostreets.biz.auction.web.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autostreets.web.constant.Constants;
import com.autostreets.web.vo.UserIdentity;
import com.google.common.base.Throwables;

public final class UserIdentityUtils {

    private static final String DATE_PATTERN = "yyyyMMdd HH:mm:ss";
    private static final Logger LOGGER = LoggerFactory.getLogger(UserIdentityUtils.class);

    public static String serialize(UserIdentity userIdentity) {
        StringBuilder sb = new StringBuilder();
        sb.append(userIdentity.getId()).append(",");
        sb.append(userIdentity.getUsername()).append(",");
        sb.append(formatDate(userIdentity.getLastVisitTime()));

        return BlowfishUtils.encrypt(sb.toString(), Constants.SECRET_KEY);
    }

    public static UserIdentity unserialize(String value) {
        String text = BlowfishUtils.decrypt(value, Constants.SECRET_KEY);
        String[] ss = text.split(",");
        UserIdentity userIdentity = new UserIdentity();
        userIdentity.setId(ss[0]);
        userIdentity.setUsername(ss[1]);
        userIdentity.setLastVisitTime(parseDate(ss[2]));
        return userIdentity;
    }

    public static UserIdentity getUserIdentity(HttpServletRequest request) {
        return (UserIdentity) request.getAttribute(Constants.USER_IDENTITY_KEY);
    }

    private static String formatDate(Date date) {
        DateFormat df = new SimpleDateFormat(DATE_PATTERN);
        return df.format(date);
    }

    private static Date parseDate(String dateStr) {
        DateFormat df = new SimpleDateFormat(DATE_PATTERN);
        try {
            return df.parse(dateStr);
        } catch (ParseException e) {
            LOGGER.error(e.getMessage(), e);
            throw Throwables.propagate(e);
        }
    }

    private UserIdentityUtils() {
    }
}
