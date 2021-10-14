package com.qxn.spring.beans;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.alibaba.druid.pool.DruidDataSource;
import com.zaxxer.hikari.HikariDataSource;
//整合第三方资源给spring管理
@Configuration
public class DataSourceConfig {
	//@Bean里可以指定开始和销毁的方法
	@Bean(value="druid",initMethod="init",destroyMethod="close")
	//加了@Bean，方法返回值也会交给spring管理生命周期，用于第三方资源
	public DataSource newDruid() {
		DruidDataSource ds = new DruidDataSource();
		ds.setUrl("jdbc:mysql:///mytest?serverTimezone=GMT");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	@Bean(value="hikari",destroyMethod="close")
	public DataSource newHikariCP() {
		HikariDataSource hds = new HikariDataSource();
		hds.setJdbcUrl("jdbc:mysql:///mytest?serverTimezone=GMT");
		hds.setUsername("root");
		hds.setPassword("root");
		return hds;
	}
}
