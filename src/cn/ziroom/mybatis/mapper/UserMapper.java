package cn.ziroom.mybatis.mapper;


import java.util.List;

import org.springframework.stereotype.Repository;

import cn.ziroom.mybatis.pojo.User;
import cn.ziroom.mybatis.pojo.UserVO;

/**   
 * @Title UserMapper.java 
 * @Package cn.ziroom.mybatis.mapper 
 * @Description: UserDao实体 
 * @author dfx  
 * @date 2015-11-9 下午2:32:01 
 * @version V1.0   
 */

@Repository
public interface UserMapper {

	/**
	 * 通过userId查询用户
	 */
	public User getUserById(String id) throws Exception ;
	
	/**
	 * 添加用户
	 */
	public void insertUser(User user) throws Exception ;
	
	/**
	 * 修改用户
	 */
	public void updateUser(User user) throws Exception ;
	
	/**
	 * 删除用户
	 */
	public void deleteUserById(String id) throws Exception ;
	
	/**
	 * 多条件查询
	 */
	public List<User> getUserByfields(UserVO userVO) throws Exception ;
	
	/**
	 * foreach查询
	 */
	public List<User> getUserByName(List<String> names) throws Exception ;
}
