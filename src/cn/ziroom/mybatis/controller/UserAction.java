package cn.ziroom.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ziroom.mybatis.pojo.User;
import cn.ziroom.mybatis.service.IUserService;

@Controller
@RequestMapping(value="/UserAction")
public class UserAction {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/getUser",method=RequestMethod.GET)
	@ResponseBody
	public String getUser(@RequestParam("id") String id){
		System.out.println("id="+id);
		User user = userService.getUserById(id);
		user.setName("1234567890");
		userService.updateUser(user);
		user.setId(null);
		userService.insertUser(user);
		System.out.println(user);
		return "test";
	}
	
}
