package com.qxn.dao;

import java.util.List;

import com.qxn.pojo.Door;

public interface DoorMapper {
	/**
	 * 1.查询所有门店信息
	 * */
	public List<Door> findAll();

	public void addDoor(Door door);

	public void deleteDoorById(Integer id);

	public Door selectById(Integer id);

	public void updateDoor(Door door);	
}
