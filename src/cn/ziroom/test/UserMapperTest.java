package cn.ziroom.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ziroom.mybatis.mapper.UserMapper;
import cn.ziroom.mybatis.pojo.User;
import cn.ziroom.mybatis.pojo.UserVO;

/**   
 * @Title UserMapperTest.java 
 * @Package cn.ziroom.mybatis.test 
 * @Description: 通过mapper方式测试User
 * @author dfx  
 * @date 2015-11-9 下午2:30:10 
 * @version V1.0   
 */
public class UserMapperTest {

	private SqlSessionFactory factory ;
	
	ApplicationContext applicationContext ;
	@Before
	public void before() throws IOException{
		applicationContext = new ClassPathXmlApplicationContext("beans1.xml");
	}
	/**
	 * @desc id查询用户
	 * @throws Exception
	 */
	@Test
	public void getUserById() throws Exception {
		UserMapper mapper = applicationContext.getBean(UserMapper.class);
		User user = mapper.getUserById("1");
		System.out.println(user);
	}
	
	@Test
	public void insertUser() throws Exception{
		SqlSession session = factory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setName("张三");
		user.setSex("1");
		user.setAge(23);
		user.setBirthday(new Date());
		user.setAddr("陕西大同");
		mapper.insertUser(user);
		session.close();
	}
	
	@Test
	public void updateUser() throws Exception{
		SqlSession session = factory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.getUserById("a3677f6c-86c2-11e5-9518-40f02fef381a");
		user.setName("李四");
		user.setSex("2");
		user.setAge(24);
		user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1992-09-08"));
		user.setAddr("甘肃酒泉瓜州");
		mapper.updateUser(user);
		session.close();
	}
	
	@Test
	public void deleteUserById() throws Exception{
		SqlSession session = factory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		String userId = "35b61b47-86c4-11e5-9518-40f02fef381a";
		mapper.deleteUserById(userId);
		session.close();
	}
	
	@Test
	public void getUserByfields() throws Exception{
		SqlSession session = factory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		UserVO userVO = new UserVO();
		User user = new User();
		user.setName("%张%");
		//user.setSex("1");
		userVO.setUser(user);
		List<User> list = mapper.getUserByfields(userVO);
		System.out.println(list.size());
		session.close();
	}
	
	@Test
	public void getUserByName() throws Exception{
		SqlSession session = factory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<String> names = new ArrayList<String>();
		names.add("张三");
		names.add("张小三");
		names.add("张大三");
		List<User> list = mapper.getUserByName(names);
		System.out.println(list);
		session.close();
	}

}
