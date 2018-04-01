package com.zola.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zola.study.dao.IUserMapper;
import com.zola.study.service.IUserService;

@Service("UserService")
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserMapper userMapper;
	
	@Override
	public String findAge(int id) {
		return userMapper.findAge(id);
	}

}
