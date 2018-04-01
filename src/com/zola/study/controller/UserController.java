package com.zola.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zola.study.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
	@Qualifier(value="UserService")
	IUserService userService; //为什么得到的实体是userService
	
	@RequestMapping(value = "/user/findAge.do")
	@ResponseBody
	public String findAge(int id){
		String age = userService.findAge(id);
		return age;
	}	
	
}
