package com.qxn.pj.user.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qxn.pj.user.vo.User;
//springmvc中请求和传参
@Controller
@RequestMapping("/request/")
public class RequestHandleController {
	//请求url
	//普通方式url处理
//	@RequestMapping("doHandleUrl")
	//多个url对应
	@RequestMapping({"doHandleUrl","doWelcomeUI"})
	public String doHandleUrl() {
		return "welcome";
	}
	//Rest风格的url,其格式为{a}/{b}/{c}
	//假如希望方法参数获取url中{}值，用@PathVariable修饰 
	@RequestMapping("{module}/{page}")
	public String doModuleUI(
			@PathVariable String module,
			@PathVariable String page) {
		return module+"/"+page;
	}
	
	//请求方式
//	@RequestMapping(value="type",method=RequestMethod.POST)
//	@GetMapping("type")
	@PostMapping("type")
	@ResponseBody
	public String doRequestType() {
		return "request type GET";
	}
	
	//请求参数处理，直接量、pojo对象、map对象
	//直接量，接收8种基本数据类型+封装类+字符串+日期
	@GetMapping("param0")
	@ResponseBody
	public String doRequestParam0(
			@RequestParam(required=true) String msg,
			@DateTimeFormat(pattern="yyyy-MM-dd") Date begin) {
		return "request param handle msg="+msg+",begin="+begin;
	}
	
	//pojo对象，通过pojo的set方法赋值
	@GetMapping("param")
	@ResponseBody
	public String doRequestParam(
			User user) {
		return "user="+user.toString();
	}
	
	//map对象不常用，map参数前面得加@RequestParam
}




