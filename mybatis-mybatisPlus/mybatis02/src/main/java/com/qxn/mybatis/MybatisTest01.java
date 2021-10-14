package com.qxn.mybatis;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.qxn.dao.EmpMapper;
import com.qxn.pojo.Emp;

public class MybatisTest01 {
	private static SqlSession session;	
	static {
		try {
			//1.读取配置文件
			InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
			//2.通过配置信息获取SqlSessionFactory工厂对象
			SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(in);
			//3.通过工厂获取SqlSession对象
			session = fac.openSession();
			//更新需要session.commit();没法把empMapper提出来
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//查询所有员工信息
	@Test
	public void findAllEmp() {
		EmpMapper empMapper = session.getMapper(EmpMapper.class);
		List<Emp> list = empMapper.findAllEmp();
		for (Emp emp : list) {
			System.out.println(emp);
		}		
	}
	//根据id查询员工信息
	@Test
	public void findEmpById() {
		EmpMapper empMapper = session.getMapper(EmpMapper.class);
		Emp emp = empMapper.findEmpById(1);
		System.out.println(emp);		
	}
	//新增员工信息
	@Test
	public void insertEmp() {
		EmpMapper empMapper = session.getMapper(EmpMapper.class);
		Emp emp = new Emp(null,"王姐","收银员",4000d);
		int rows = empMapper.insertEmp(emp);
		session.commit();
		System.out.println(rows);
	}
	//修改指定id的员工信息 10 小王总 兼职 2900
	@Test
	public void updateEmp() {
		EmpMapper empMapper = session.getMapper(EmpMapper.class);
		Emp emp = new Emp(10,"小王总","兼职",2900d);
		int rows = empMapper.updateEmp(emp);
		session.commit();
		System.out.println(rows);
	}
	//根据id删除员工信息
	@Test
	public void deleteEmpById() {
		EmpMapper empMapper = session.getMapper(EmpMapper.class);
		int rows = empMapper.deleteEmpById(14);
		session.commit();
		System.out.println(rows);
	}
}

