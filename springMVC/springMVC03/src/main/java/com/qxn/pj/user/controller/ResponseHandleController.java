package com.qxn.pj.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

//响应controller
@Controller
@RequestMapping("/resp/")
public class ResponseHandleController {
	@RequestMapping("doResponseUI")
	public String doResponseUI() {
		return "response";
	}
	@RequestMapping("type")
	public String doResponseType() {
		//转发（请求一次）
		return "forward:doResponseUI";
		//重定向（请求两次）
//		return "redirect:doResponseUI";
	}
	@RequestMapping("doDataConvert")
	@ResponseBody
	private String doDataConvert() throws Exception {
		//手动转换
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id",11);
		map.put("msg","hello jackson");
		//借助jackson中的API将对象转换json格式的字符串
		ObjectMapper om = new ObjectMapper();
		return om.writeValueAsString(map);
	}
}
