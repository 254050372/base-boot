package com.boot.portal.common.config;/**
 * @description
 * @autor xbwu on 2018/3/30.
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 基础配置
 * @author xbwu
 * @create 2018-03-30 
 **/
@Component
@ConfigurationProperties("boot.base")
public class BaseConstants {

    public static String templatesPrefix;

    public void setTemplatesPrefix(String templatesPrefix) {
        this.templatesPrefix = templatesPrefix;
    }
}
