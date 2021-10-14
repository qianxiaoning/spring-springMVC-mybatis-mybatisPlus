package com.qxn.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qxn.pojo.User;
import com.qxn.pojo.UserInfo;

public class SpringTest {
	//IOC控制反转：通过spring容器创建对象
	@Test
	public void testIOC() {
		//读取配置文件
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取user容器
		UserInfo userInfo = (UserInfo)ac.getBean("userInfo");
		//获取对象
		System.out.println(userInfo);
	}
	//DI依赖注入
	//创建对象的同时或之后，通过set或构造，已经为对象属性赋值
	//setName("马云")或new User("马云")
	@Test
	public void testDI() {
		//读取配置文件
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取user容器
		User user = (User)ac.getBean("user");
		//对象属性已赋值
		System.out.println(user);
	}
}
