package com.autostreets.biz.auction.web.security;

import java.io.IOException;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.autostreets.biz.auction.web.security.tag.ShiroTags;

import freemarker.template.TemplateException;

/**
 * 
 * 〈FreeMarker Shiro Tag 使用配置〉<br>
 * 〈功能详细描述〉
 *
 * @author jingzhou.zhao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ShiroTagFreeMarkerConfigurer extends FreeMarkerConfigurer {

    @Override
    public void afterPropertiesSet() throws IOException, TemplateException {
        super.afterPropertiesSet();
        this.getConfiguration().setSharedVariable("shiro", new ShiroTags());
    }

}
