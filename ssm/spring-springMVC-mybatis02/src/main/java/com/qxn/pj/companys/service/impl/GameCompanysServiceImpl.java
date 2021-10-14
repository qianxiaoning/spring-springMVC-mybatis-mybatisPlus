package com.qxn.pj.companys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qxn.pj.companys.dao.GameCompanysDao;
import com.qxn.pj.companys.pojo.GameCompanys;
import com.qxn.pj.companys.service.GameCompanysService;
/*
 * 业务层对象
 * 1.核心业务
 * 2.扩产业务（日志，权限，事务，缓存）
 * */
@Service
public class GameCompanysServiceImpl implements GameCompanysService{
	@Autowired
	private GameCompanysDao gameCompanysDao; 
	@Override
	public List<GameCompanys> findCompanys() {
		System.out.println("start:"+System.currentTimeMillis());
		List<GameCompanys> list = gameCompanysDao.findCompanys();
		System.out.println("end:"+System.currentTimeMillis());
		return list;
	}

}
