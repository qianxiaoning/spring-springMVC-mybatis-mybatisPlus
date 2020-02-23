package com.qxn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	//通用页面跳转方法
	@RequestMapping("/{pageName}")
	public String page(
			@PathVariable String pageName) {
		return pageName;
	}
}
