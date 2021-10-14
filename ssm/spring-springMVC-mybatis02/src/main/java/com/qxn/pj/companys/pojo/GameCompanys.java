package com.qxn.pj.companys.pojo;

import java.io.Serializable;
import java.util.Date;

public class GameCompanys implements Serializable {
	private static final long serialVersionUID = 690138036951052829L;
	private Long id;
	private String name;
	private String remark;
	private Date createdTime;

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
		return "GameCompanys [id=" + id + ", name=" + name + ", remark=" + remark + ", createdTime=" + createdTime + "]";
	}
}
