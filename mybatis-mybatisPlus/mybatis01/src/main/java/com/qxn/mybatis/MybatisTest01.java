package com.qxn.mybatis;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//新增员工 王董 董事长 9999
	@Test
	public void insertEmp() {
		int rows = session.update("EmpMapper.insertEmp");
		session.commit();
		System.out.println("影响行数："+rows);
	}
	//修改员工信息，将王董的job改为区域董事长，salary改为99999
	@Test
	public void updateEmp() {
		int rows = session.update("EmpMapper.updateEmp");
		session.commit();
		System.out.println("影响行数："+rows);
	}
	//删除name为'王董'的记录
	@Test
	public void deleteEmp() {
		int rows = session.update("EmpMapper.deleteEmp");
		session.commit();
		System.out.println("影响行数："+rows);
	}
	//传值---------------------
	//查询emp表中指定id的员工信息
	@Test
	public void selectEmpById() {
		Emp emp = session.selectOne("EmpMapper.selectEmpById",1);
		System.out.println(emp);
	}
	//新增员工信息：小王总 兼职 2800
	@Test
	public void insertEmp2() {
		Emp emp = new Emp(null, "小王总", "兼职", 2800d);
		int rows = session.update("EmpMapper.insertEmp2",emp);
		session.commit();
		System.out.println("影响行数："+rows);
	}
	//修改员工信息：小王总 全职 2900
	@Test
	public void updateEmp2() {
		Emp emp = new Emp(null, "小王总", "全职", 2900d);
		int rows = session.update("EmpMapper.updateEmp2",emp);
		session.commit();
		System.out.println("影响行数："+rows);
	}
	//删除id为4的员工信息
	@Test
	public void deleteEmp2() {
		int rows = session.update("EmpMapper.deleteEmp2",4);
		session.commit();
		System.out.println("影响行数："+rows);
	}
	//不定项查询---------------------
	/**
	 * 练习9：动态显示要查询的列，如：
	 * select * from emp;
	 * select id,name from emp;
	 */
	@Test
	public void findEmpByColumn() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("cols", "name,salary");
		List<Emp> list = session.selectList("EmpMapper.findEmpByColumn",map);
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
	//模糊查询---------------------
	//根据name模糊查询emp表，#{}可以直接传入，xml可以任意key获取。${}必须放入map
	@Test
	public void findEmpByFuzzyName() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", "小");
		List<Emp> list = session.selectList("EmpMapper.findEmpByFuzzyName",map);
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
	//动态sql---------------------	
	/**
	 * 根据薪资查询员工信息
	 * 如果参数有minSal,maxSal,则where salary>minSal and salary<maxSal
	 * 如果参数中只有minSal，则where salary > minSal
	 * 如果参数中只有maxSal，则where salary < maxSal
	 * 如果没有参数，则查询所有员工
	 */
	//where,if标签
	@Test
	public void findEmpBySalParam() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("minSal", 1000);
		map.put("maxSal", 4000);
		List<Emp> list = session.selectList("EmpMapper.findEmpBySalParam",map);
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
	/*根据参数传输与否，修改表中列
	 * 如果传输了name,job,salary则修改对应的列，否则就不修改
	 * */
	//set,if标签	
	@Test
	public void updateEmpByCols() {
		Emp emp = new Emp();
		emp.setId(10);
		emp.setSalary(2901d);
		int rows = session.update("EmpMapper.updateEmpByCols",emp);
		session.commit();
		System.out.println("影响行数："+rows);
	}
	//根据员工的id批量删除员工信息
	//foreach标签
	@Test
	public void deleteEmpByIds() {
		Integer[] ids = {11,12};
		int rows = session.update("EmpMapper.deleteEmpByIds",ids);
		session.commit();
		System.out.println("影响行数："+rows);
	}	
	/**
	 *根据员工的id批量查询员工信息
	 *Integer[] ids=[1,2,3];
	 */
	//foreach标签
	@Test
	public void findEmpByIds() {
		Integer[] ids = {1,2,3};
		List<Emp> list = session.selectList("EmpMapper.findEmpByIds",ids);
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
}

