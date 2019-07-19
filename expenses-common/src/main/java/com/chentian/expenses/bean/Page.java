package com.chentian.expenses.bean;

import java.util.List;

public class Page<T> {
	
	private List<T> datas;
	private int pn;
	private int totalpn;
	private int totalsize;
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getPn() {
		return pn;
	}
	public void setPn(int pn) {
		this.pn = pn;
	}
	public int getTotalpn() {
		return totalpn;
	}
	public void setTotalpn(int totalpn) {
		this.totalpn = totalpn;
	}
	public int getTotalsize() {
		return totalsize;
	}
	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
	}
	
	

}
