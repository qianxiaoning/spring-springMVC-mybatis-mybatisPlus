package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.qxn.pj.company.dao.CompanyDao;
import com.qxn.pj.company.pojo.Company;
//xml配置SqlSessionFactory，命名空间方式访问数据库
public class TestCompanyDao01 extends TestBaseWithXml{
	@Test
	public void testDeleteObjects() {
		//1.获取session对象
		SqlSession session = sqlSessionFactory.openSession();
		//2.将对象持久化
		String statement = "com.qxn.pj.company.dao.CompanyDao.deleteObjects";
		try {
			int rows = session.delete(statement,new Object[] {10,11});
			System.out.println("delete.rows="+rows);
			//3.提交事务
			session.commit();
		} finally {
			//4.释放资源
			session.close();
		}
	}
	@Test
	public void testFindPageObjects01() {
		//1.获取session对象
		SqlSession session = sqlSessionFactory.openSession();
		//2.将对象持久化
		String statement = "com.qxn.pj.company.dao.CompanyDao.findPageObjects";
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startIndex",0);
			map.put("pageSize",3);
			List<Company> list = session.selectList(statement,map);
//			List<Company> list = session.selectList(statement,new Object[] {0,3});
			//对应xml #{array[0]},#{array[1]}
			System.out.println(list);
			//3.提交事务
			session.commit();
		} finally {
			//4.释放资源
			session.close();
		}
	}
	@Test
	public void testSelectObject() {
		//1.获取session对象
		SqlSession session = sqlSessionFactory.openSession();
		//2.将对象持久化
		String statement = "com.qxn.pj.company.dao.CompanyDao.selectById";
		try {
			Company g = session.selectOne(statement,10);
			System.out.println(g);
			//3.提交事务
			session.commit();
		} finally {
			//4.释放资源
			session.close();
		}
	}
	@Test
	public void testDeleteById() {
		//1.获取session对象
		SqlSession session = sqlSessionFactory.openSession();
		//2.将对象持久化
		String statement = "com.qxn.pj.company.dao.CompanyDao.deleteById";
		try {
			int rows = session.delete(statement,10);
			System.out.println("delete.rows="+rows);
			//3.提交事务
			session.commit();
		} finally {
			//4.释放资源
			session.close();
		}
	}
	@Test
	public void testInsertObject() {
		//1.创建Company对象
		Company g = new Company();
		g.setId(11L);
		g.setName("a");
		g.setRemark("a");
		//2.将Company对象写入到数据库
		//2.1获取SqlSession对象
		SqlSession session = sqlSessionFactory.openSession();
		//2.2将对象持久化
		String statement = "com.qxn.pj.company.dao.CompanyDao.insertObject";
		int rows = session.insert(statement,g);
		System.out.println("insert.rows="+rows);
		//2.3提交事务
		session.commit();
		//2.4释放资源
		session.close();
	}
	@Test
	public void testUpdateObject() {
		//1.创建Company对象
		Company g = new Company();
		g.setId(11L);
		g.setName("a");
		g.setRemark("a.");
		//2.将Company对象写入到数据库
		//2.1获取SqlSession对象
		SqlSession session = sqlSessionFactory.openSession();
		//2.2将对象持久化
		String statement = "com.qxn.pj.company.dao.CompanyDao.updateObject";
		int rows = session.update(statement,g);
		System.out.println("update.rows="+rows);
		//2.3提交事务
		session.commit();
		//2.4释放资源
		session.close();
	}
	
}
