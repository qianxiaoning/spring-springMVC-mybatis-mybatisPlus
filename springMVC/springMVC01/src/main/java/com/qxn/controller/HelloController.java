package com.qxn.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qxn.pojo.User;

@Controller
public class HelloController {
	//展现jsp页面
	@RequestMapping("/showJsp")
	public String testJsp() {
		System.out.println("hello");
		return "hello";
	}
	//简单参数
	@RequestMapping("/testSimpleParam")
	public String testSimpleParam(StringBuilder name,Integer age,String sex) {
		System.out.println(name+","+age+","+sex);
		return "hello";
	}
	//对象参数
	@RequestMapping("/testPojoParam")
	public String testPojoParam(User user) {
		System.out.println(user);
		return "hello";
	}
	//日期参数，默认/间隔
	@RequestMapping("/testDateParam")
	public String testDateParam(Date date) {
		System.out.println(date.toLocaleString());
		return "hello";
	}
	//自定义日期格式，-间隔
	@InitBinder
	public void InitBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
	//转发
	@RequestMapping("/testForward")
	public String testForward() {
		System.out.println("testForward");
		return "forward:/showJsp";
	}
	//重定向
	@RequestMapping("/testRedirect")
	public String testRedirect() {
		System.out.println("testRedirect");
		return "redirect:/showJsp";
	}
	//测试post请求乱码问题
	@RequestMapping("/testPost")
	public String testPost(String name) {
		System.out.println("name="+name);
		return "hello";
	}
	//测试Model使用
	@RequestMapping("/testModel")
	public String testModel(Model model) {
		List<User> list = new ArrayList<User>();
		User user01 = new User("小明",22,"男");
		User user02 = new User("小红",18,"女");
		User user03 = new User("小康",23,"男");
		list.add(user01);
		list.add(user02);
		list.add(user03);
		model.addAttribute("list",list);
		return "hello";
	}
	//测试返回json
	@RequestMapping("/testJson")
	@ResponseBody
	public List<User> testJson() {
		List<User> list = new ArrayList<User>();
		User user01 = new User("小明",22,"男");
		User user02 = new User("小红",18,"女");
		User user03 = new User("小康",23,"男");
		list.add(user01);
		list.add(user02);
		list.add(user03);
		return list;
	}
}
