package com.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.qxn.pj.company.dao.CompanyDao;
import com.qxn.pj.company.pojo.Company;
//xml配置SqlSessionFactory，接口方式访问数据库
public class TestCompanyDao02 extends TestBaseWithXml{
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
	@Test
	public void testDeleteObjects02() {
		//1.获取session对象
		SqlSession session = sqlSessionFactory.openSession();		
		//2.将对象持久化
		try {
			CompanyDao dao = session.getMapper(CompanyDao.class);
			int rows = dao.deleteObjects(11,12);
			System.out.println("delete rows="+rows);
			//3.提交事务
			session.commit();
		} finally {
			//4.释放资源
			session.close();
		}
	}
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
