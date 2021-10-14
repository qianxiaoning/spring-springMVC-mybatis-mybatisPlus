package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qxn.spring.config.SpringConfig;

public class ReadBeans {
	//ctx-所读容器
	protected AnnotationConfigApplicationContext ctx;
	@Before
	public void init() {
		//读取配置类
		ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
	}
	@Test
	public void testCtx() {
		System.out.println(ctx);
	}
	@After
	public void close() {
		ctx.close();
	}
}
