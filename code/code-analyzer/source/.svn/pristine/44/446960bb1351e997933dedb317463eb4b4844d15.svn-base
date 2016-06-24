package com.autostreets.biz.auction.web.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.PushPayload.Builder;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

import com.autostreets.biz.cms.model.AppModel;
import com.autostreets.biz.cms.model.AppMsgPushTrigger;
import com.autostreets.biz.cms.model.DrawDictionary;
import com.autostreets.biz.cms.service.AppModelService;
import com.autostreets.biz.cms.service.DrawDictionaryService;
import com.autostreets.biz.common.utils.PlaceholderUtils;

/**
 * 消息推送工具类
 * 
 * @Copyright (C), 2014-2015, 上海澍勋电子商务有限公司
 * @Date: 2015年12月24日 下午3:33:45
 * @author zhenxing.li
 * @since [1.0.0]
 */
@Controller
public class MsgPhshUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MsgPhshUtils.class);

    public static final String PUSH_SHOW_TYPE_ALTER = "1"; // 弹框提示
    public static final String PUSH_SHOW_TYPE_WEBVIEW = "2"; // webview展示
    public static final String PUSH_SHOW_TYPE_NATIVE = "3"; // native

    /**
     * 消息推送
     * 
     * @param drawDictionaryService
     * @param appModelService
     * @param showType
     *            显示方式
     * @param modelUrl
     *            推送地址
     * @param content
     *            推送内容
     * @param receiver
     *            接收者(用户标识)【注：若为空，则默认为所有用户】
     */
    public static void Jpush(DrawDictionaryService drawDictionaryService, AppModelService appModelService,
            AppMsgPushTrigger appMsgPushTrigger, String receiver, Map<String, String> params) {
        boolean apnsProduction = true;
        String appKey = drawDictionaryService.getByCategoryValue("jpush_param", "app_key").getValue();
        String masterSecret = drawDictionaryService.getByCategoryValue("jpush_param", "master_secret").getValue();
        DrawDictionary drawDictionary = drawDictionaryService.getByCategoryValue("jpush_param", "apns_production");
        if ("production".equals(drawDictionary.getValue())) {
            apnsProduction = true;
        } else {
            apnsProduction = false;
        }
        if (null != appMsgPushTrigger) {
            JPushClient jpushClient = new JPushClient(masterSecret, appKey);
            String modelUrl = appMsgPushTrigger.getModelUrl();
            if (PUSH_SHOW_TYPE_NATIVE.equals(appMsgPushTrigger.getShowType().toString())) {
                AppModel appModel = appModelService
                        .selectByPrimaryKey(Integer.valueOf(appMsgPushTrigger.getModelUrl()));
                modelUrl = appModel.getIos();
            }
            String content = PlaceholderUtils.resolvePlaceholders(appMsgPushTrigger.getContent(), params);

            // 推送平台
            Builder builder = allPush(modelUrl, content, appMsgPushTrigger.getShowType().toString());
            if (StringUtils.isNotEmpty(receiver)) {
                // 推送个指定用户
                builder.setAudience(Audience.alias(receiver));
            } else {
                // 推送所有用户
                builder.setAudience(Audience.all());
            }

            // 推送环境
            builder.setOptions(Options.newBuilder().setApnsProduction(apnsProduction).build());
            try {
                jpushClient.sendPush(builder.build());
            } catch (APIConnectionException | APIRequestException e) {
                LOGGER.error("消息推送异常", e);
            }
        }
    }

    /**
     * 推送给用户的所在平台
     * 
     * @param modelUrl
     *            推送链接
     * @param content
     *            推送内容
     * @author zhenxing.li
     * @Date: 2015年12月24日 下午4:00:05
     */
    private static Builder allPush(String modelUrl, String content, String showType) {
        Builder builder = PushPayload.newBuilder();
        builder.setPlatform(Platform.all());

        isoPush(builder, modelUrl, content, showType); // ios

        AndroidPush(builder, modelUrl, content, showType); // android
        return builder;
    }

    private static void isoPush(Builder builder, String modelUrl, String content, String showType) {
        Map<String, String> extras = new HashMap<>();
        extras.put("showType", showType);
        extras.put("modelUrl", modelUrl);
        builder.setNotification(Notification.ios(content, extras));
    }

    private static void AndroidPush(Builder builder, String modelUrl, String content, String showType) {
        builder.setMessage(Message.newBuilder().setMsgContent(content).addExtra("modelUrl", modelUrl)
                .addExtra("showType", showType).build());
    }

}
