package com.chentian.expenses.bean;

import java.util.Date;

public class User {
	
	private Integer id;
	
	private String username;
	
	private String loginacct;
	
	private String userpswd;
	
	private String jobnum;
	
	private String agency;
	
	private Date startdate;
	
	private Date updatedate;
	
	private Integer status;
	
	private String sex;
	
	private String name;
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getJobnum() {
		return jobnum;
	}

	public void setJobnum(String jobnum) {
		this.jobnum = jobnum;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String getLoginacct() {
		return loginacct;
	}

	public void setLoginacct(String loginacct) {
		this.loginacct = loginacct;
	}

	public String getUserpswd() {
		return userpswd;
	}

	public void setUserpswd(String userpswd) {
		this.userpswd = userpswd;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", loginacct=" + loginacct + ", userpswd=" + userpswd
				+ ", jobnum=" + jobnum + ", agency=" + agency + ", startdate=" + startdate + ", updatedate="
				+ updatedate + ", status=" + status + ", sex=" + sex + ", name=" + name + "]";
	}

	

	
	
	

}
