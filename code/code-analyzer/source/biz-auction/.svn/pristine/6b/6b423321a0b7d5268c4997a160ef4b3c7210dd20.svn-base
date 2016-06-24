package com.autostreets.biz.auction.utils;

import java.util.List;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;

public final class ImgUtils {
    public static String choiceImgUrl(String spec, String urlColValue) {
        if (Strings.isNullOrEmpty(urlColValue)) {
            return "";
        }
        if (urlColValue.indexOf(",") == -1) {
            if (urlColValue.startsWith("SRC_")) {
                urlColValue = urlColValue.replace("SRC_", "");
            }
            urlColValue = urlColValue.substring(0, urlColValue.lastIndexOf(".")) + "*" + spec.replace("X", "*") + urlColValue.substring(urlColValue.lastIndexOf("."));
            return urlColValue;
        }

        List<String> list = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(urlColValue);
        String srcUrl = null;
        for (String url : list) {
            if (url.startsWith("SRC_")) {
                srcUrl = url.replace("SRC_", "");
                break;
            }
        }

        if (Strings.isNullOrEmpty(srcUrl)) {
            return "";
        }

        srcUrl = srcUrl.substring(0, srcUrl.lastIndexOf(".")) + "*" + spec.replace("X", "*") + srcUrl.substring(srcUrl.lastIndexOf("."));
        return srcUrl;
    }
}
