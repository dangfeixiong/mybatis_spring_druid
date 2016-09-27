package cn.ziroom.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ziroom.mybatis.mapper.UserMSMapper;
import cn.ziroom.mybatis.pojo.User;
import cn.ziroom.mybatis.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	@Autowired
	//private UserMapper userMapper;
	private UserMSMapper userMSMapper;
	
	/**
	 * 通过userId查询用户
	 */
	public User getUserById(String id) {
		User user = null;
		try {
			//user = userMapper.getUserById(id);
			user = userMSMapper.getUserById(id);
		} catch (Exception e) {
			System.out.println("通过userId查询用户失败!");
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 添加用户
	 */
	public void insertUser(User user) {
		try {
			//userMapper.insertUser(user);
			userMSMapper.insertUser(user);
		} catch (Exception e) {
			System.out.println("添加用户失败!");
			e.printStackTrace();
		}
		
	}

	/**
	 * 修改用户
	 */
	public void updateUser(User user) {
		try {
			//userMapper.updateUser(user);
			userMSMapper.updateUser(user);
		} catch (Exception e) {
			System.out.println("修改用户失败!");
			e.printStackTrace();
		}
		
	}

	/**
	 * 删除用户
	 */
	public void deleteUserById(String id) {
		try {
		//	userMapper.deleteUserById(id);
			userMSMapper.deleteUserById(id);
		} catch (Exception e) {
			System.out.println(" 删除用户失败!");
			e.printStackTrace();
		}
		
	}

}
