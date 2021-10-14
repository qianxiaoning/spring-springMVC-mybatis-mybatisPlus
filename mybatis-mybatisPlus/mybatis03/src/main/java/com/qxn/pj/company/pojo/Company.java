package com.qxn.pj.company.pojo;

import java.io.Serializable;
import java.util.Date;
/*
 * pojo对象
 * */
public class Company implements Serializable{
	private static final long serialVersionUID = -4797106974444530770L;
	private Long id;
	private String name;
	private String remark;
	private Date createdTime;
	
	public Company() {
		super();
	}
	public Company(Long id) {
		super();
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", remark=" + remark + ", createdTime=" + createdTime + "]";
	}
	
}
