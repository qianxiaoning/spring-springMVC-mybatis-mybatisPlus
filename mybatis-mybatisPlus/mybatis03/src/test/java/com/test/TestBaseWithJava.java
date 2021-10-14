package com.test;

import java.io.InputStream;
import java.sql.Connection;

import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Before;
import org.junit.Test;

import com.qxn.pj.company.dao.CompanyDao;
//java配置SqlSessionFactory
public class TestBaseWithJava {
	protected SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws Exception {
		//1.构建数据源对象
		PooledDataSource dataSource = new PooledDataSource();
		dataSource.setDriver("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///mybatis03_test?serverTimezone=GMT&characterEncoding=utf8");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		//2.创建事务管理工厂
		JdbcTransactionFactory transactionFactory = new JdbcTransactionFactory();
		//3.创建一个环境对象
		Environment env = new Environment("development", transactionFactory, dataSource);
		//4.创建配置对象
		Configuration config = new Configuration(env);
		config.addMapper(CompanyDao.class);//映射接口
		String resource = "mapper/CompanyMapper.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
        XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, config, resource, config.getSqlFragments());
        mapperParser.parse();//解析并注册映射文件
		//5.创建sqlSessionFactory对象
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
	}
	@Test
	public void testConnection() {
		Connection conn = sqlSessionFactory.openSession().getConnection();
		System.out.println(conn);
	}
}
