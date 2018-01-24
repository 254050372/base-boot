package com.boot.portal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
/*
 * @ActiveProfiles，可以指定一个或者多个 profile，
 * 这样我们的测试类就仅仅加载这些名字的 profile 中定义的 bean 实例。
 */
@ActiveProfiles("test")
public class PortalApplicationTests {

	@Test
	public void contextLoads() {
	}

}
