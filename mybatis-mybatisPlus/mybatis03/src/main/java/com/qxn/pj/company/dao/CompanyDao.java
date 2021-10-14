package com.qxn.pj.company.dao;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.qxn.pj.company.pojo.Company;
//开启二级缓存，针对注解的sql语句
//@CacheNamespace
//使用xml的cache，不冲突
//@CacheNamespaceRef(name="com.qxn.pj.company.dao.companyDao")
public interface CompanyDao {
	//简单sql可以使用注解
	@Select("select count(*) from game_company")
	int getRowCount();
	int deleteObjects(int...ids);
	//起始位置，页面大小
//	List<Goods> findPageObjects(
//			int startIndex,int pageSize);
//	xml中select * from game_company limit #{arg0},#{arg1}
	List<Company> findPageObjects(
			@Param("startIndex") int startIndex,
			@Param("pageSize") int pageSize);
}
