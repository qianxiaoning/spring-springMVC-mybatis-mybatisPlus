package com.qxn.pj.common.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

//数据层对象
@MapperScan("com.qxn.pj.companys.dao")
@Configuration
public class SpringRepositoryConfig {
	@Bean(value = "druid", initMethod = "init", destroyMethod = "close")
	public DruidDataSource dataSource() {
		DruidDataSource ds = new DruidDataSource();
		ds.setUrl("jdbc:mysql:///mybatis03_test?serverTimezone=GMT%2B8");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	@Bean("sqlSessionFactory")
	public SqlSessionFactory newSqlSessionFactory(DataSource dataSource) throws Exception {
		// 构建SqlSessionFactoryBean对象
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		// 调用FactoryBean的getObject方法创建SqlSessionFactory
		// 底层会使用SqlSessionFactoryBuilder创建
		return factoryBean.getObject();
	}
}
