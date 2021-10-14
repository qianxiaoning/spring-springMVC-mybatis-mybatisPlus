package com.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.Bean;

public class TestDataSource extends ReadBeans {
	@Test
	public void testDruid() throws Exception {
		//ctx.getBean()指定名字更快，默认名字方法名
//		DataSource ds = ctx.getBean("newDruid",DataSource.class);
		//@Bean(value="druid")指定名字
		DataSource ds = ctx.getBean("druid",DataSource.class);
		System.out.println(ds.getConnection());
	}
	@Test
	public void testHikariCP() throws Exception {
		DataSource ds = ctx.getBean("hikari",DataSource.class);
		System.out.println(ds.getConnection());
	}
}
