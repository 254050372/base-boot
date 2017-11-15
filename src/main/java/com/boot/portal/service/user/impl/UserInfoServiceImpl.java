package com.boot.portal.service.user.impl;/**
 * @description
 * @autor xbwu on 2017/8/12.
 */


import com.boot.portal.dao.base.BaseRepository;
import com.boot.portal.dao.user.UserInfoMapper;
import com.boot.portal.entity.portal.user.UserInfo;
import com.boot.portal.service.user.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现
 * @author xbwu
 * @create 2017-08-12 
 **/
@Service
public class UserInfoServiceImpl extends BaseJPAServiceImpl<UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public BaseRepository<UserInfo, Long> getRepository() {
        return userInfoMapper;
    }
}
