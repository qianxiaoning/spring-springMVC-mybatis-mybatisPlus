package com.qxn.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qxn.dao.DoorMapper;
import com.qxn.pojo.Door;

public class SpringTest {	
	//测试spring和mybatis结合
	//手动启动spring，测试spring控制反转
	@Test
	public void testSpringMybatis() throws IOException {
		//启动spring new ClassPathXmlApplicationContext()
		//mybatis交给spring容器后，得启动spring取SqlSessionFactory容器
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		SqlSessionFactory fac = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");		
		SqlSession session = fac.openSession();
		// 4.获取mapper接口的实现类的实例
		DoorMapper dao = session.getMapper(DoorMapper.class);
		// 5.执行查询所有门店的方法
		List<Door> list = dao.findAll();
		// 6.输出结果
		for (Door door : list) {
			System.out.println(door);
		}
	}
}
