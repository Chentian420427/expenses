package com.chentian.expenses.bean;

import java.util.Date;

public class Role {
	
	private Integer id;
	
	private String name;
	
	private Date assigndate;
	
	

	public Date getAssigndate() {
		return assigndate;
	}

	public void setAssigndate(Date assigndate) {
		this.assigndate = assigndate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", assigndate=" + assigndate + "]";
	}

	
	
	
	

}
