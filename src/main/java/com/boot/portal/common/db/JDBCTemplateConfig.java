package com.boot.portal.common.db;/**
 * @description
 * @autor xbwu on 2017/8/9.
 */

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * jdbcTamplate配置
 * @author xbwu
 * @create 2017-08-09 
 **/
@Configuration
public class JDBCTemplateConfig {

    /**
     * portal本地连接
     * @param dataSource
     * @return
     */
    @Bean(name = "localJdbcTemplate")
    public JdbcTemplate localJdbcTemplate(@Qualifier("portalDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    /**
     * bpm连接
     * @param dataSource
     * @return
     */
    @Bean(name = "bpmJdbcTemplate")
    public JdbcTemplate bpmJdbcTemplate(@Qualifier("bpmDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    /**
     * hr连接
     * @param dataSource
     * @return
     */
    @Bean(name = "hrJdbcTemplate")
    public JdbcTemplate hrJdbcTemplate(@Qualifier("hrDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
