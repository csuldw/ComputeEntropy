package com.zola.study.dao;

import org.apache.ibatis.annotations.Param;

public interface IUserMapper {
	
    String findAge(@Param("id") int id);
}
