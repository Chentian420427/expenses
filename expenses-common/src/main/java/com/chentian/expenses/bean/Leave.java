package com.chentian.expenses.bean;

import java.util.Date;

public class Leave {
	
	private Integer id;
	
	private String leavename;
	
	private String leavedetail;
	
	private Date createtime;
	
	private String status;
	
	private Integer userid;
	
	private String username;
	
	private String feedback;
	
	

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
	
	
	
	

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLeavename() {
		return leavename;
	}

	public void setLeavename(String leavename) {
		this.leavename = leavename;
	}

	public String getLeavedetail() {
		return leavedetail;
	}

	public void setLeavedetail(String leavedetail) {
		this.leavedetail = leavedetail;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Leave [id=" + id + ", leavename=" + leavename + ", leavedetail=" + leavedetail + ", createtime="
				+ createtime + ", status=" + status + ", userid=" + userid + ", username=" + username + "]";
	}

	
	
	

}
