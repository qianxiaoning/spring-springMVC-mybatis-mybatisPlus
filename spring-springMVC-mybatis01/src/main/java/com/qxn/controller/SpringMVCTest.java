package com.qxn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringMVCTest {
	@RequestMapping("/testmvc")
	public String testmvc() {
		System.out.println("testmvc");
		return "springMVCTest";
	}

}
