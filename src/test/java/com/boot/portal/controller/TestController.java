package com.boot.portal.controller;/**
 * @description
 * @autor xbwu on 2017/8/9.
 */

import com.alibaba.fastjson.JSON;
import com.boot.portal.PortalApplicationTests;

import com.boot.portal.common.base.JdbcQueryBuilder;
import com.boot.portal.common.base.Pages;
import com.boot.portal.common.base.ResultWapper;
import com.boot.portal.common.util.JaxbXMLUtil;
import com.boot.portal.common.util.MD5Util;
import com.boot.portal.common.util.UUIDGeneratorUtil;
import com.boot.portal.dao.user.UserMapper;
import com.boot.portal.entity.portal.user.User;
import com.boot.portal.entity.portal.user.UserInfo;
import com.boot.portal.service.user.UserInfoService;
import com.boot.portal.service.user.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    UserMapper userMapper;
    @Autowired
    UserInfoService userInfoService;

    @Autowired
    @Qualifier("mysqlJQB")
    private JdbcQueryBuilder mysqlJQB;

    @Autowired
    @Qualifier("bpmJQB")
    private JdbcQueryBuilder bpmJQB;

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
        System.out.println(JSON.toJSONString(ResultWapper.success("").addResult("list",list)));
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
        us.setAccount("chixinzei");
        us.setPassword(MD5Util.getMD5("1234qwer"));
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
        Pages page=new Pages();
        List<Map<String, Object>> list=mysqlJQB.queryPage("select *from t_user order by id",page);
        System.out.println(Arrays.asList(list).toString()+" ,总条数："+page.getTotalCount()+",总页数："+page.getTotalPages()+
            ",是否存在下一页："+page.isHasNext()+",是否存在上一页："+page.isHasPre());

        Pages page1=new Pages(1,2);
        //返回map
        List<Map<String, Object>> list1=bpmJQB.queryPage("select *from users order by id",page1);
        System.out.println(Arrays.asList(list1).toString()+" ,总条数："+page1.getTotalCount()+",总页数："+page1.getTotalPages()+
                ",是否存在下一页："+page1.isHasNext()+",是否存在上一页："+page1.isHasPre());
        //返回单个对象
        User ue=mysqlJQB.queryOneByObject("select *from t_user where id=?",new Object[]{"53"},User.class);
        Map map=mysqlJQB.queryOneByMap("select *from t_user where id=?",new Object[]{"53"});
        System.out.println("ue:"+ue);
        System.out.println("ue map:"+map);

        //返回对象list
        List<User> users=mysqlJQB.queryPage("select *from t_user order by id",page1,User.class);
        System.out.println("users:"+users);
    }

    /**
     * jpa测试相关
     * @throws Exception
     */
    @Test
    //禁止回滚
    @Rollback(value = false)
    public void testJPAUpdate() throws Exception {
        //完整对象查询测试，修改关联对象值
        User u= userService.getOne(46L);
        System.out.println("旧email:"+u.getUserInfo().getEmail());
        u.getUserInfo().setEmail("dd:"+u.getUserInfo().getEmail());
        //userInfo的值成功被更新！
        userService.saveOrUpdate(u);
    }
    /**
     * jpa分页测试相关
     * 参考文档：http://www.codeweblog.com/%E5%85%A5%E9%97%A8%E5%B8%96-%E4%BD%BF%E7%94%A8-spring-data-jpa-%E7%AE%80%E5%8C%96-jpa-%E5%BC%80%E5%8F%91/
     * @throws Exception
     */
    @Test
    public void testJPAPageQuery() throws Exception {
        int pageNum=1;
        int pageSize=1;
        //jpa对象分页查询,page从0开始第一页
        PageRequest pr=PageRequest.of(pageNum-1,pageSize,null);
        Page<User> page= userMapper.findPageByUserAccount("254050372",pr);
        System.out.println(page.getContent());
    }
}