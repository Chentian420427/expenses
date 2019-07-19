package com.chentian.expenses.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chentian.expenses.bean.AJAXResult;
import com.chentian.expenses.bean.Page;
import com.chentian.expenses.bean.Role;
import com.chentian.expenses.bean.User;
import com.chentian.expenses.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping("/index")
	public String index() {
		
		return "role/index";
	}
	
	@RequestMapping("/assign")
	public String assign() {
		
		return "role/assign";
	}
	
	@RequestMapping("/add")
	public String add() {
		
		return "role/add";
	}
	
	
	@RequestMapping("/edit")
	public String edit( Integer id, Model model) {
		
		Role role = roleService.queryById(id);
		model.addAttribute("role", role);
		
		
		return "role/edit";
	}
	
	
	
	@ResponseBody
	@RequestMapping("/delete")
	public Object deleteRole(Integer id) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			roleService.deleteRole(id);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/deletes")
	public Object deleteRoles(Integer[] roleid) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			Map<String, Object> map = new HashMap<>();
			map.put("roleids", roleid);
			
			roleService.deleteRoles(map);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		
		return result;
	}
	
	
	
	@ResponseBody
	@RequestMapping("/insert")
	public Object insert(Role role) {
		AJAXResult result = new AJAXResult();
		try {
			
			role.setAssigndate(new Date());
			
			roleService.insertRole(role);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		
		return result;
	}
	
	
	
	@ResponseBody
	@RequestMapping("/update")
	public Object update(Role role) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			roleService.updateRole(role);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		
		return result;
	}
	
	
	
	
	
	
	@ResponseBody
	@RequestMapping("/doAssign")
	public Object doAssign(Integer roleid,Integer[] permissionids) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("roleid", roleid);
			paramMap.put("permissionids", permissionids);
			paramMap.put("assigndate", new Date());
			
			roleService.updateAssignDate(paramMap);
			
			roleService.insertRolePermission(paramMap);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		
		return result;
	}
	
	
	
	@ResponseBody
	@RequestMapping("/pageQuery")
	public Object pageQuery( String queryText, Integer pn, Integer pagesize) {
		
		AJAXResult result = new AJAXResult();
		
		try {
			//分页查询
			// 分页查询
			Map<String, Object> map = new HashMap<>();
			map.put("start", (pn-1)*pagesize);
			map.put("size", pagesize);
			map.put("queryText", queryText);
			
			List<Role> roles = roleService.pageQueryData(map);
			
			//总数据条数
			int totalsize = roleService.pageQueryCount(map);
			//总页码
			int totalpn=0;
			if(totalsize % pagesize == 0) {
				totalpn = totalsize / pagesize;
			}else {
				totalpn = totalsize / pagesize + 1;
			}
			// 分页对象
			Page<Role> rolePage = new Page<Role>();
			rolePage.setDatas(roles);
			rolePage.setTotalpn(totalpn);
			rolePage.setTotalsize(totalsize);
			rolePage.setPn(pn);
			
			result.setData(rolePage);
			result.setSuccess(true);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
		
		
	}
	
	
}
