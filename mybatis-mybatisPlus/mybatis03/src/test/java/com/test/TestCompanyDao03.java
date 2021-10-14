package com.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.qxn.pj.company.dao.CompanyDao;
import com.qxn.pj.company.pojo.Company;

public class TestCompanyDao03 extends TestBaseWithJava{
	//java配置SqlSessionFactory，注解方式访问数据库
	@Test
	public void testGetRowCount() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			CompanyDao dao = session.getMapper(CompanyDao.class);
			int rowCount = dao.getRowCount();
			System.out.println(rowCount);
			session.commit();
		} finally {
			session.close();
		}
	}	
	//java配置SqlSessionFactory，接口方式访问数据库
	@Test
	public void testFindPageObjects02() {
		//1.获取session对象
		SqlSession session = sqlSessionFactory.openSession();		
		//2.将对象持久化
		try {
			CompanyDao dao = session.getMapper(CompanyDao.class);
			List<Company> list = dao.findPageObjects(0,3);
			System.out.println(list);
			//3.提交事务
			session.commit();
		} finally {
			//4.释放资源
			session.close();
		}
	}
}
