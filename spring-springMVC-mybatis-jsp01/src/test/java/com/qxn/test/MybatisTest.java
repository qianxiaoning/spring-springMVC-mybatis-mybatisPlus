package com.qxn.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.qxn.dao.DoorMapper;
import com.qxn.pojo.Door;

public class MybatisTest {	
	//单独测试mybatis配置
	@Test
	public void testMybatis() throws IOException {
		// 1.读取mybatis-config.xml配置文件
		InputStream in = Resources.getResourceAsStream("mybatis/mybatis-config1.xml");
		// 2.获取SqlSessionFactory工厂对象
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(in);
		// 3.获取SqlSession对象
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
