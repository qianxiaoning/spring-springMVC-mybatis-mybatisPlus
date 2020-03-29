package com.test;

import org.junit.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qxn.pj.common.config.SpringRepositoryConfig;
import com.qxn.pj.common.config.SpringServiceConfig;
//TestBase数据层、业务层扫描，暴露ctx对象
public class TestBase {
	protected AnnotationConfigApplicationContext ctx;
	@Before
	public void init() {
		ctx = new AnnotationConfigApplicationContext(SpringRepositoryConfig.class,SpringServiceConfig.class);
	}
	public void close() {
		ctx.close();
	}
}
