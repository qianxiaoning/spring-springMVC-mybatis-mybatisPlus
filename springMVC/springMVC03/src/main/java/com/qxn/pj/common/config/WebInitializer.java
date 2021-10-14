package com.qxn.pj.common.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//tomcat启动时会加载此类
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		// TODO Auto-generated method stub
//		super.onStartup(servletContext);
//	}//注册DispatcherServlet
	//加载service,dao配置
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("getRootConfigClasses()");
		return null;
	}
	//加载springMVC配置
	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("getServletConfigClasses()");
		return new Class[] {SpringWebConfig.class};
	}
	//指定DispatcherServlet对象的请求映射路径
	@Override
	protected String[] getServletMappings() {
		System.out.println("getServletMappings()");
		return new String[] {"/"};
	}

}
