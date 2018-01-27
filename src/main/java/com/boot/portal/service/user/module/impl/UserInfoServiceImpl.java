package com.boot.portal.service.user.module.impl;/**
 * @description
 * @autor xbwu on 2017/8/12.
 */


import com.boot.portal.dao.module.user.UserInfoRepo;
import com.boot.portal.entity.module.user.UserInfo;
import com.boot.portal.service.user.module.UserInfoService;
import com.boot.portal.service.user.base.impl.BaseJPAServiceImpl;
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
    private UserInfoRepo userInfoRepo;

}
