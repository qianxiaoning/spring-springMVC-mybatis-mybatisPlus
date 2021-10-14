package com.qxn.pj.companys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.qxn.pj.companys.pojo.GameCompanys;

public interface GameCompanysDao {
	@Select("select * from game_company")
	List<GameCompanys> findCompanys();
}
