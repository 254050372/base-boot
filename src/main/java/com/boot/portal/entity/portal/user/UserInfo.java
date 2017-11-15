package com.boot.portal.entity.portal.user;/**
 * @description
 * @autor xbwu on 2017/9/28.
 */

import com.boot.portal.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户信息
 * @author xbwu
 * @create 2017-09-28 
 **/
@Entity
//指定表名
@Table(name = "user_info")
public class UserInfo extends BaseEntity {

    private String email;

    private Integer sex;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

}
