package com.boot.portal.web.dao;/**
 * @description
 * @autor xbwu on 2017/8/12.
 */

import com.boot.portal.core.dao.BaseRepository;
import com.boot.portal.web.entity.UserInfo;
import org.springframework.stereotype.Repository;


/**
 * 用户信息
 * @author xbwu
 * @create 2017-08-12 
 **/
@Repository
public interface UserInfoRepo extends BaseRepository<UserInfo,Long> {

}
