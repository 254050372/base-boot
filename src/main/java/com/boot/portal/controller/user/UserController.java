package com.boot.portal.controller.user;/**
 * @description
 * @autor xbwu on 2017/8/9.
 */

import com.boot.portal.common.base.ResultWapper;
import com.boot.portal.common.util.MD5Util;
import com.boot.portal.controller.base.BaseController;
import com.boot.portal.entity.portal.user.User;
import com.boot.portal.service.user.UserInfoService;
import com.boot.portal.service.user.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 用户入口
 *
 * @author xbwu
 * @create 2017-08-09
 **/
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {


}