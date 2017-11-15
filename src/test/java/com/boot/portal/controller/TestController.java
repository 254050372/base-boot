package com.boot.portal.controller;/**
 * @description
 * @autor xbwu on 2017/8/9.
 */

import com.alibaba.fastjson.JSON;
import com.boot.portal.PortalApplicationTests;
import com.boot.portal.common.base.JdbcQueryBuilder;
import com.boot.portal.common.base.Page;
import com.boot.portal.common.base.ResultWapper;
import com.boot.portal.common.util.JaxbXMLUtil;
import com.boot.portal.common.util.MD5Util;
import com.boot.portal.common.util.UUIDGeneratorUtil;
import com.boot.portal.entity.portal.user.User;
import com.boot.portal.entity.portal.user.UserInfo;
import com.boot.portal.service.user.UserInfoService;
import com.boot.portal.service.user.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 测试入口
 * @author xbwu
 * @create 2017-08-09 
 **/
@Transactional
public class TestController extends PortalApplicationTests {

    @Autowired
    @Qualifier("localJdbcTemplate")
    JdbcTemplate localJDBC;

    @Autowired
    @Qualifier("bpmJdbcTemplate")
    JdbcTemplate bpmJDBC;

    @Autowired
    @Qualifier("hrJdbcTemplate")
    JdbcTemplate hrJDBC;
    @Autowired
    UserService userService;
    @Autowired
    UserInfoService userInfoService;
    @Test
    public void testLocal(){
        List<Map<String,Object>> list = localJDBC.queryForList("select * from t_user");
        System.out.println(Arrays.asList(list).toString());
    }
    @Test
    //禁止回滚
    //@Rollback(value = false)
    public void testHRImportSSO(){
        localJDBC.execute("truncate table sso_user");
        List<Map<String,Object>> list = hrJDBC.queryForList("select rtrim(u.emp_id) emp_id from h_emp_mstr u  where u.emp_state=1");
        for(Map<String,Object> userMap:list){
            String id=UUIDGeneratorUtil.getUUID();
            String userid=(String) userMap.get("emp_id");
            String password= MD5Util.getMD5(userid);
            localJDBC.execute("insert into sso_user (id,account,password,valid) values('"+id+"','"+userid+"','"+password+"',1) ");
        }
        System.out.println(Arrays.asList(list).toString());
    }
    @Test
    //禁止回滚
    //@Rollback(value = false)
    public void testNewUserImportSSO(){
        String id=UUIDGeneratorUtil.getUUID();
        String userid="adminBPM";
        String password= MD5Util.getMD5(userid);
        localJDBC.execute("insert into sso_user (id,account,password,valid) values('"+id+"','"+userid+"','"+password+"',1) ");
    }
    @Test
    public void testBPM(){
        List<Map<String,Object>> list = bpmJDBC.queryForList("SELECT * from users where rownum<2");
        System.out.println(Arrays.asList(list).toString());
    }
    @Test
    public void testAJAXJSON(){
        List<Map<String,Object>> list = localJDBC.queryForList("select * from t_user");
        System.out.println(JSON.toJSONString(ResultWapper.success(list)));
    }
    @Test
    //禁止回滚
    @Rollback(value = false)
    public void testAJAXXML() throws Exception{
        //Pageable pageable = PageRequest.of(0, 10, new Sort(Sort.Direction.ASC, "id"));
        User us=new User();
        UserInfo ui=new UserInfo();
        ui.setEmail("254050372@qq.com");
        ui.setSex(1);
        us.setUserInfo(ui);
        us.setAccount("wuxb");
        us.setPassword("123");
        us.setValid(true);
        userInfoService.saveOrUpdate(ui);
        userService.saveOrUpdate(us);
        System.out.println(us.getAccount()+","+us.getValid());
        System.out.println(JaxbXMLUtil.beanToXml(us, User.class));
    }

    /**
     * jdbcTemplate分页查询，目前支持mysql和oracle，适用于复杂字段查询返回或者快速编写查询
     * 可直接返回对象类型，或者List<Map>类型
     * @throws Exception
     */
    @Test
    public void testJDBCPage() throws Exception {
        JdbcQueryBuilder pb=new JdbcQueryBuilder(localJDBC);
        Page page=new Page();
        List<Map<String, Object>> list=pb.queryPage("select *from user order by id",page);
        System.out.println(Arrays.asList(list).toString()+" ,总条数："+page.getTotalCount()+",总页数："+page.getTotalPages()+
            ",是否存在下一页："+page.isHasNext()+",是否存在上一页："+page.isHasPre());

        JdbcQueryBuilder pb1=new JdbcQueryBuilder(localJDBC);
        Page page1=new Page(1,2);
        List<Map<String, Object>> list1=pb1.queryPage("select *from user order by id",page1);
        System.out.println(Arrays.asList(list1).toString()+" ,总条数："+page1.getTotalCount()+",总页数："+page1.getTotalPages()+
                ",是否存在下一页："+page1.isHasNext()+",是否存在上一页："+page1.isHasPre());
        //返回单个对象
        User ue=pb.queryOneByObject("select *from user where id=?",new Object[]{"21029377879351397"},User.class);
        System.out.println("ue:"+ue);
        //返回对象list
        List<User> users=pb.queryPage("select *from user order by id",page1,User.class);
        System.out.println("users:"+users);
    }

    /**
     * jpa测试相关
     * @throws Exception
     */
    @Test
    //禁止回滚
    @Rollback(value = false)
    public void testJPA() throws Exception {
        //完整对象查询测试，修改关联对象值
        User u= userService.getOne(46L);
        System.out.println("旧email:"+u.getUserInfo().getEmail());
        u.getUserInfo().setEmail("aaaa:"+u.getUserInfo().getEmail());
        userService.saveOrUpdate(u);//userInfo的值成功被更新！
    }
}