package com.boot.portal.common.db;/**
 * @description
 * @autor xbwu on 2017/9/28.
 */

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 多数据源配置
 * @author xbwu
 * @create 2017-09-28 
 **/
//Spring 配置文件注解
@Configuration
public class DataSourceConifg {

    //主要数据源注解，必须指定一个
    @Primary
    //数据源名称
    @Bean(name="portalDataSource")
    //松耦合属性分层注解，注意，跟druid整合时，需要忽略无效注入属性ignoreInvalidFields = true，避免注入报错
    @ConfigurationProperties(value = "spring.datasource.druid.local",ignoreInvalidFields = true)
    public DataSource dataSourcePortal(){
        return DruidDataSourceBuilder.create().build();
    }
    @Bean(name="bpmDataSource")
    @ConfigurationProperties(value="spring.datasource.druid.bpm",ignoreInvalidFields = true)
    public DataSource dataSourceBPM(){
        return DruidDataSourceBuilder.create().build();
    }
    @Bean(name="hrDataSource")
    @ConfigurationProperties(value="spring.datasource.druid.hr",ignoreInvalidFields = true)
    public DataSource dataSourceHR(){
        return DruidDataSourceBuilder.create().build();
    }

}
