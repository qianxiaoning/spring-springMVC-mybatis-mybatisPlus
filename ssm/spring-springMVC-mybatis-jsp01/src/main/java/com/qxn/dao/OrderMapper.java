package com.qxn.dao;

import java.util.List;

import com.qxn.pojo.Order;

public interface OrderMapper {	
	public List<Order> findAll();

	public void orderInsert(Order order);

	public void deleteById(Integer id);

	public Order findById(Integer id);

	public void updateById(Order order);

}
