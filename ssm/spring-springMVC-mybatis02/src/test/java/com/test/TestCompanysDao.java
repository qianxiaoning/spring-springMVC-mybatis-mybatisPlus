package com.test;

import java.util.List;

import org.junit.Test;

import com.qxn.pj.companys.dao.GameCompanysDao;
import com.qxn.pj.companys.pojo.GameCompanys;

public class TestCompanysDao extends TestBase {
	//测试dao方法
	@Test
	public void testFindCompanys() {
		GameCompanysDao companysDao = ctx.getBean(GameCompanysDao.class);
		List<GameCompanys> list = companysDao.findCompanys();
		System.out.println(list.size());
	}
}
