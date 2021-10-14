package com.qxn.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.qxn.pojo.Emp;

public class MybatisTest {
	/**
	 * 查询emp表中的所有员工List<Emp>
	 */
	@Test
	public void findAllEmp() throws IOException {
		//1.读取配置文件
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		//2.通过配置信息获取SqlSessionFactory工厂对象
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(in);
		//3.通过工厂获取SqlSession对象
		SqlSession session = fac.openSession();
		//4.通过mapper.xml中namespace+id对应的sql
		List<Emp> list = session.selectList("EmpMapper.findAllEmp");
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
}
