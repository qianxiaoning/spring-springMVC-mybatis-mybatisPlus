package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
//xml配置SqlSessionFactory
public class TestBaseWithXml {
	//借助SqlSession实现与数据库之间的会话
	protected SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws IOException {
		InputStream in = 
		Resources.getResourceAsStream("mybatis-configs.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}
	@Test
	public void testSSF() {
		System.out.println(sqlSessionFactory);
	}
	@Test
	public void testConnection() {
		SqlSession session = sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		System.out.println(conn);
	}
	
}
