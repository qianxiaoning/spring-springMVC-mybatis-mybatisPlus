package com.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.qxn.pj.companys.dao.GameCompanysDao;

//数据层测试
public class TestRepositoryConfig extends TestBase{
	//测试数据库连接
	@Test
	public void testDataSource() throws Exception {
		DataSource ds = ctx.getBean("druid",DataSource.class);
		System.out.println(ds.getConnection());
	}
	//测试sqlSession连接
	@Test
	public void testSqlSessionFactory() {
		SqlSessionFactory ssf = ctx.getBean("sqlSessionFactory",SqlSessionFactory.class);
		System.out.println(ssf);
		Connection conn = ssf.openSession().getConnection();
		System.out.println(conn);
	}
	//测试dao
	@Test
	public void testGoodsDao() {
		GameCompanysDao dao = ctx.getBean("gameCompanysDao",GameCompanysDao.class);
		System.out.println(dao);
		System.out.println(dao.getClass());
	}
}
