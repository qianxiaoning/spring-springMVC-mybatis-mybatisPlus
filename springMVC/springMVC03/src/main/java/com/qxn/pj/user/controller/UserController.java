package com.qxn.pj.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user/")
public class UserController {
	@RequestMapping("userInfo")
	@ResponseBody
	public Object selectUserByName(String key) {
		//自动转换，配置类有@EnableWebMvc
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("age", 11);
		map.put("message","hello");
		return map;//{"age":11,"message":"hello"}
	}
	@RequestMapping("userInfoUI")
	public String userInfoUI() {
		return "user";
	}
}
