package com.zola.study.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zola.study.entity.UserEntity;

public class SpringTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        UserEntity p = ctx.getBean("user",UserEntity.class);//创建bean的引用对象
        UserEntity u = new UserEntity();
        System.out.println(u.toString());
        System.out.println(p.toString());
	}
	
}
