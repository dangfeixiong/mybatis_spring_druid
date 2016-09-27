package cn.ziroom.mybatis.mapper;


import java.util.List;

import org.springframework.stereotype.Repository;

import cn.ziroom.mybatis.ms.DataSource;
import cn.ziroom.mybatis.pojo.User;
import cn.ziroom.mybatis.pojo.UserVO;

/**
 * 
* @ClassName UserMSMapper 
* @Description 读写分离实体
* @author dfx
* @date 2015年12月16日 下午1:37:05 
*
 */

@Repository
public interface UserMSMapper {

	/**
	 * 通过userId查询用户
	 */
	//@DataSource("slave")
	public User getUserById(String id) throws Exception ;
	
	/**
	 * 添加用户
	 */
	@DataSource("master")
	public void insertUser(User user) throws Exception ;
	
	/**
	 * 修改用户
	 */
	@DataSource("master")
	public void updateUser(User user) throws Exception ;
	
	/**
	 * 删除用户
	 */
	@DataSource("master")
	public void deleteUserById(String id) throws Exception ;
	
	/**
	 * 多条件查询
	 */
	@DataSource("slave1")
	public List<User> getUserByfields(UserVO userVO) throws Exception ;
	
	/**
	 * foreach查询
	 */
	@DataSource("slave1")
	public List<User> getUserByName(List<String> names) throws Exception ;
}
