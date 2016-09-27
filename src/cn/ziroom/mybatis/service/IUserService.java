package cn.ziroom.mybatis.service;

import cn.ziroom.mybatis.pojo.User;

/**
 * 
* @ClassName IUserService 
* @Description User接口Service
* @author dfx
* @date 2015年12月14日 上午10:05:13 
*
 */
public interface IUserService {

	/**
	 * 通过userId查询用户
	 */
	public User getUserById(String id);
	
	/**
	 * 添加用户
	 */
	public void insertUser(User user);
	
	/**
	 * 修改用户
	 */
	public void updateUser(User user);
	
	/**
	 * 删除用户
	 */
	public void deleteUserById(String id);
}
