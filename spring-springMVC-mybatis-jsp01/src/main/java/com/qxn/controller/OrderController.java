package com.qxn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qxn.dao.DoorMapper;
import com.qxn.dao.OrderMapper;
import com.qxn.pojo.Door;
import com.qxn.pojo.Order;
@Controller
public class OrderController {
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private DoorMapper doorMapper;
	@RequestMapping("/orderPage")
	public String orderPage(Model model) {
		List<Order> list = orderMapper.findAll();
//		System.out.println(list);
		model.addAttribute("list",list);
		List<Door> doorList = doorMapper.findAll();
		model.addAttribute("doorList",doorList);
		return "orderPage";
	}	
	@RequestMapping("/goToAdd")
	private String goToAdd(Model model) {
		List<Door> doorList = doorMapper.findAll();
		model.addAttribute("doorList",doorList);
		return "addOrder";
	}
	@RequestMapping("/addOrderCon")
	private String addOrderCon(Order order) {
		orderMapper.orderInsert(order);
		return "forward:orderPage";
	}
	@RequestMapping("/deleteOrderById")
	private String deleteOrderById(Integer id) {
		orderMapper.deleteById(id);
		return "redirect:orderPage";
	}
	//回显
	@RequestMapping("/orderInfo")
	private String orderInfo(Integer id,Model model) {
		Order order = orderMapper.findById(id);
		List<Door> doorList = doorMapper.findAll();
		model.addAttribute("order",order);
		model.addAttribute("doorList",doorList);
		return "orderEditInfo";
	}
	@RequestMapping("/updateOrderById")
	private String updateOrderById(Order order) {
		orderMapper.updateById(order);
		return "forward:orderPage";
	}
}
