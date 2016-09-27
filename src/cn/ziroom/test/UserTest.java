package cn.ziroom.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.ziroom.mybatis.pojo.User;
import cn.ziroom.mybatis.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})

public class UserTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private IUserService userService;
	
	@Test
	public void getgetUserById(){
		User user = userService.getUserById("3bc7be81-9340-11e5-a56c-40f02fef381a");
		System.out.println("结果为:"+user);
	}
	
	@Test
	@Rollback(false) 
	public void insertUser(){
		User user = new User();
		user.setName("金毛狮王--谢逊");
		user.setAge(45);
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddr("冰火岛!");
		userService.insertUser(user);
	}
	
	@Test
	@Rollback(false) 
	public void updateUser(){
		User user = userService.getUserById("3bc7be81-9340-11e5-a56c-40f02fef381a");
		user.setName("九阴白骨爪--周芷若");
		userService.updateUser(user);
	}
	
	@Test
	@Rollback(false)
	public void deleteUserById(){
		userService.deleteUserById("3");
	}
	
}
