package com.qxn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qxn.dao.DoorMapper;
import com.qxn.pojo.Door;

@Controller
public class SpringMVCTest {
	//测试springmvc配置
	@RequestMapping("/testSpringmvc")
	public String testmvc() {
		System.out.println("testSpringmvc");
		return "springMVCTest";
	}
	//测试ssm配置
	//依赖注入
	//@Autowired（自动装配）注解将当前对象的创建交给spring容器，
	//由spring容器为DoorMapper接口提供实现类，并通过实现类创建对象，
	//再将对象赋值给doorMapper变量
	@Autowired
	private DoorMapper doorMapper;
	@RequestMapping("/testssm")
	public String testssm() {
		List<Door> list = doorMapper.findAll();
		for (Door door : list) {
			System.out.println(door);
		}
		System.out.println("ssm整合成功");
		return "springMVCTest";
	}

}
