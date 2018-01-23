package com.boot.portal.controller.base;/**
 * @description
 * @autor xbwu on 2018/1/22.
 */

import com.boot.portal.common.config.WebSecurityConfig;
import com.boot.portal.common.base.ResultWapper;
import com.boot.portal.common.util.MD5Util;
import com.boot.portal.entity.portal.user.User;
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

/**
 * 登录
 * @author xbwu
 * @create 2018-01-22 
 **/
@RestController
@RequestMapping
public class LoginController extends BaseController{
    @Autowired
    @Qualifier("localJdbcTemplate")
    JdbcTemplate jdbcTemplate1;

    @Autowired
    UserService userService;

    @GetMapping(value = "/login")
    public ModelAndView login() throws Exception {
        ModelAndView mv = getMV("login");
        return mv;
    }
    @PostMapping(value = "/login")
    public ResultWapper login(Model model,
                              @RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpServletRequest request) throws Exception {
        User ue = userService.findByUserAccount(username.trim());
        ResultWapper rw = null;
        do {
            if (ue == null) {
                rw = ResultWapper.error("用户或密码错误");
                break;
            }
            if (!ue.getValid()) {
                rw = ResultWapper.error("该用户被禁用");
                break;
            }
            String dbpd = ue.getPassword();
            String nowpd = MD5Util.getMD5(password.trim());
            if (!dbpd.equals(nowpd)) {
                rw = ResultWapper.error("用户或密码错误");
                break;
            }
            rw=ResultWapper.success("登录成功");
            rw.addResult("ue",ue);
            WebUtils.setSessionAttribute(request,WebSecurityConfig.SESSION_KEY,ue);
        } while (false);
        return rw;
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }
}
