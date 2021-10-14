package com.qxn.dao;

import java.util.List;

import com.qxn.pojo.Emp;

public interface EmpMapper {
	//查询所有员工信息
	List<Emp> findAllEmp();
	//根据id查询员工信息
	Emp findEmpById(int i);
	//新增员工信息
	int insertEmp(Emp emp);
	//修改指定id的员工信息 10 小王总 兼职 2900
	int updateEmp(Emp emp);
	//根据id删除员工信息
	int deleteEmpById(int i);
	
}
