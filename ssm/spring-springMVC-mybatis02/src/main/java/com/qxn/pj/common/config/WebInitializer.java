package com.qxn.pj.common.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//-->web.xml
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	// Service,dao配置
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("getRootConfigClasses()");
		return new Class[] { SpringRepositoryConfig.class, SpringServiceConfig.class };
	}

	// View,Controller
	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("getServletConfigClasses()");
		return new Class[] { SpringWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("getServletMappings()");
		return new String[] { "/" };
	}

}