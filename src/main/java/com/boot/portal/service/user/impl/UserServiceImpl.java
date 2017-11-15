package com.boot.portal.service.user.impl;/**
 * @description
 * @autor xbwu on 2017/8/12.
 */


import com.boot.portal.dao.base.BaseRepository;
import com.boot.portal.dao.user.UserMapper;
import com.boot.portal.entity.portal.user.User;
import com.boot.portal.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现
 * @author xbwu
 * @create 2017-08-12 
 **/
@Service(value="userServiceImpl")
public class UserServiceImpl extends BaseJPAServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper baseRepository;

    @Override
    public BaseRepository<User, Long> getRepository() {
        return baseRepository;
    }
}
