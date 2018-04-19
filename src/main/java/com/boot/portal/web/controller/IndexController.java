package com.boot.portal.web.controller;/**
 * @description
 * @autor xbwu on 2017/11/28.
 */

import com.boot.portal.core.common.config.WebSecurityConfig;
import com.boot.portal.core.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * 首页
 * @author xbwu
 * @create 2017-11-28 
 **/
@RestController
public class IndexController extends BaseController {

    @RequestMapping("/")
    public ModelAndView login(HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        if (session.getAttribute(WebSecurityConfig.USER) != null)
            return redirectController("index");
        ModelAndView mv = getMV("login");
        return mv;
    }

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) throws Exception{
        ModelAndView mv = getMV("index");
        return mv;
    }

}
