package com.boot.portal.controller.user;/**
 * @description
 * @autor xbwu on 2017/8/9.
 */

import com.boot.portal.common.util.JaxbXMLUtil;
import com.boot.portal.entity.portal.user.User;
import com.boot.portal.entity.portal.user.UserInfo;
import com.boot.portal.service.user.UserInfoService;
import com.boot.portal.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 测试入口
 * @author xbwu
 * @create 2017-08-09 
 **/
@RestController
public class UserController {

    @Autowired
    @Qualifier("localJdbcTemplate")
    JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("bpmJdbcTemplate")
    JdbcTemplate jdbcTemplate2;
    @Autowired
    UserService userService;
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/test1")
    public String test1(){
        List<Map<String,Object>> list = jdbcTemplate1.queryForList("select * from t_user");
        return Arrays.asList(list).toString();
    }

    @RequestMapping("/test2")
    public String test2(){
        List<Map<String,Object>> list = jdbcTemplate2.queryForList("SELECT * from users where rownum<2");
        return Arrays.asList(list).toString();
    }


    @RequestMapping("/index")
    public ModelAndView index(Model model,HttpServletRequest request) throws  Exception{
        User ue=userService.getOne(25019377879351296L);
        ModelAndView mv = new ModelAndView("user/index"); //返回的view就是templetes下面文件的名称
        model.addAttribute("ue",ue);
        if(1==1)
        throw new Exception("手动异常");
        return mv;
    }

    @RequestMapping("/testExceptionCatch")
    public ModelAndView testExceptionCatch(Model model,HttpServletRequest request) throws  Exception{
        if(1==1)
            throw new Exception("手动异常");
            //throw new ParamException("手动异常");
        return null;
    }
    @RequestMapping("/testAJAXXML")
    public void testAJAXXML() throws Exception{
//        Pageable pageable = PageRequest.of(0, 10, new Sort(Sort.Direction.ASC, "id"));
        User us=new User();
        UserInfo ui=new UserInfo();
        ui.setEmail("254050372@163.com");
        ui.setSex(1);
        us.setUserInfo(ui);
        us.setAccount("254050372");
        us.setPassword("123");
        us.setValid(true);
        userInfoService.saveOrUpdate(ui);
        userService.saveOrUpdate(us);
        System.out.println(us.getAccount()+","+us.getValid());
        System.out.println(JaxbXMLUtil.beanToXml(us, User.class));
    }

}