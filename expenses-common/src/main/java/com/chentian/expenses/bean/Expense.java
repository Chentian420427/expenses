package com.chentian.expenses.bean;

import java.util.Date;

public class Expense {
	
	private Integer id;
	
	private Integer userid;
	
	private String expense_reason;
	
	private String expense_detail;
	
	private double expense_cost;
	
	private Date createtime;
	
	private String status;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getExpense_reason() {
		return expense_reason;
	}

	public void setExpense_reason(String expense_reason) {
		this.expense_reason = expense_reason;
	}

	public String getExpense_detail() {
		return expense_detail;
	}

	public void setExpense_detail(String expense_detail) {
		this.expense_detail = expense_detail;
	}

	public double getExpense_cost() {
		return expense_cost;
	}

	public void setExpense_cost(double expense_cost) {
		this.expense_cost = expense_cost;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", userid=" + userid + ", expense_reason=" + expense_reason + ", expense_detail="
				+ expense_detail + ", expense_cost=" + expense_cost + ", createtime=" + createtime + ", status="
				+ status + "]";
	}
	
	

}
