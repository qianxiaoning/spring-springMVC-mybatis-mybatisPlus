package com.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.qxn.pj.company.dao.CompanyDao;
import com.qxn.pj.company.pojo.Company;

public class TestCahce01 extends TestBaseWithJava{
	// 测一级缓存，同一SqlSession间
	@Test
	public void testGetRowCount() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			CompanyDao dao = session.getMapper(CompanyDao.class);
			int rowCount = dao.getRowCount();
			rowCount = dao.getRowCount();//走的cache
			System.out.println(rowCount);
			session.commit();
		} finally {
			session.close();
		}
	}
	// 测一级缓存，同一SqlSession间
	@Test
	public void testFindPageObjects01() {
		//1.获取session对象
		SqlSession session1 = sqlSessionFactory.openSession();		
		//2.将对象持久化
		try {
			CompanyDao dao1 = session1.getMapper(CompanyDao.class);
			List<Company> list1 = dao1.findPageObjects(0,3);
			List<Company> list2 = dao1.findPageObjects(0,3);
			System.out.println(list1==list2);
			session1.commit();			
			//3.提交事务
		} finally {
			//4.释放资源
			session1.close();
		}
	}
	// 测二级缓存，不同SqlSession间
	@Test
	public void testFindPageObjects02() {
		//1.获取session对象
		SqlSession session1 = sqlSessionFactory.openSession();		
		SqlSession session2 = sqlSessionFactory.openSession();		
		//2.将对象持久化
		try {
			CompanyDao dao1 = session1.getMapper(CompanyDao.class);
			CompanyDao dao2 = session2.getMapper(CompanyDao.class);
			List<Company> list1 = dao1.findPageObjects(0,3);
			session1.commit();
			List<Company> list2 = dao2.findPageObjects(0,3);
			System.out.println(list1==list2);
			//默认是序列化所以false
			//<cache readOnly="true"/>不序列化是true
			session2.commit();
			//3.提交事务
		} finally {
			//4.释放资源
			session1.close();
			session2.close();
		}
	}
}
