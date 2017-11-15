package com.boot.portal.dao.user;/**
 * @description
 * @autor xbwu on 2017/8/12.
 */

import com.boot.portal.dao.base.BaseRepository;
import com.boot.portal.entity.portal.user.UserInfo;
import org.springframework.stereotype.Repository;


/**
 * 用户信息
 * @author xbwu
 * @create 2017-08-12 
 **/
@Repository
public interface UserInfoMapper extends BaseRepository<UserInfo,Long> {

}
