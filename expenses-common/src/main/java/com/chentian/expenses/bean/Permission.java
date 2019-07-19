package com.chentian.expenses.bean;

import java.util.ArrayList;
import java.util.List;

public class Permission {

	private Integer id;
	private String name;
	private String url;
	private Integer pid;
	private boolean checked=false;
	private boolean open = true;
	private String icon;
	private List<Permission> children = new ArrayList<>();
	
	
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public List<Permission> getChildren() {
		return children;
	}
	public void setChildren(List<Permission> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + ", url=" + url + ", pid=" + pid + ", checked=" + checked
				+ ", open=" + open + ", icon=" + icon + ", children=" + children + "]";
	}
	
	
	
	
}
