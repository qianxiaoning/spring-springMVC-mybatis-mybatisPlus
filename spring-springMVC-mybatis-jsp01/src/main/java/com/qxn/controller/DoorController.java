package com.qxn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qxn.dao.DoorMapper;
import com.qxn.pojo.Door;
@Controller
public class DoorController {
	@Autowired
	private DoorMapper doorMapper;
	@RequestMapping("/doorPage")
	public String doorPage(Model model) {
		List<Door> list = doorMapper.findAll();
//		System.out.println(list);
		model.addAttribute("list",list);
		return "doorPage";
	}
	@RequestMapping("/addDoorCon")
	public String addDoorCon(Door door) {
		System.out.println(door);
		doorMapper.addDoor(door);
		return "forward:/doorPage";
	}
	@RequestMapping("/deleteDoorById")
	public String deleteDoorById(Integer id) {
		doorMapper.deleteDoorById(id);
		return "redirect:/doorPage";
	}
	//回显
	@RequestMapping("/doorInfo")
	public String doorInfo(Integer id,Model model) {
		Door door = doorMapper.selectById(id);
		model.addAttribute("door",door);
		return "doorEditInfo";
	}
	@RequestMapping("/updateDoorById")
	public String updateDoorById(Door door) {
		doorMapper.updateDoor(door);
		return "forward:/doorPage";
	}
	
}
