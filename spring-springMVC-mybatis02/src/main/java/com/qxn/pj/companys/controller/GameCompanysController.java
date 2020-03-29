package com.qxn.pj.companys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qxn.pj.companys.pojo.GameCompanys;
import com.qxn.pj.companys.service.GameCompanysService;

@Controller
@RequestMapping("/companys/")
public class GameCompanysController {
	@Autowired
	private GameCompanysService gameCompanysService; 
	@RequestMapping("doFindCompanys")
	@ResponseBody
	public List<GameCompanys> doFindGoods() {
		return gameCompanysService.findCompanys();
	}
}
