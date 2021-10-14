package com.qxn.pj.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//扫描指定的包
@ComponentScan("com.qxn.pj.user.controller")
//注册springmvc中的bean对象
@EnableWebMvc//<mvc:annotation-driven/>
public class SpringWebConfig implements WebMvcConfigurer{
	//配置静态资源处理
	//等价于xml中<mvc:default-servlet-handler/>
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	//bean视图解析器
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/pages/", ".html");
	}
}
