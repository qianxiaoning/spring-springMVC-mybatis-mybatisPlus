package com.test;

import java.util.List;

import org.junit.Test;

import com.qxn.pj.companys.pojo.GameCompanys;
import com.qxn.pj.companys.service.GameCompanysService;

public class TestCompanysService extends TestBase {
	//测试service方法
	@Test
	public void testFindCompanys() {
		//在TestBase添加SpringServiceConfig.class
		GameCompanysService companysService = ctx.getBean("gameCompanysServiceImpl",GameCompanysService.class);
		List<GameCompanys> list = companysService.findCompanys();
		System.out.println(list.size());
	}
	
}
