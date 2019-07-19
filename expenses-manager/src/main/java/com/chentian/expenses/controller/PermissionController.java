package com.chentian.expenses.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chentian.expenses.bean.AJAXResult;
import com.chentian.expenses.bean.Permission;
import com.chentian.expenses.service.PermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {
	
	@Autowired
	private PermissionService permissionService;
	
	
	@ResponseBody
	@RequestMapping("/delete")
	public Object delete(Permission permission) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			permissionService.deletePermission(permission);
			
			result.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	
	
	
	
	@ResponseBody
	@RequestMapping("/update")
	public Object update(Permission permission) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			permissionService.updatePermission(permission);
			
			result.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	
	
	
	@ResponseBody
	@RequestMapping("/insert")
	public Object insert(Permission permission) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			permission.setIcon("fa fa-chevron-right");
			
			permissionService.insertPermission(permission);
			
			result.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
		
	}
	
	
	
	
	@RequestMapping("/add")
	public String add() {
		return "permission/add";
	}
	
	@RequestMapping("/edit")
	public String edit( Integer id,Model model) {
		
		Permission permission = permissionService.queryById(id);
		model.addAttribute("permission", permission);
		
		return "permission/edit";
	}
	
	
	
	@RequestMapping("/index")
	public String index() {
		return "permission/index";
	}
	
	
	
	
	@ResponseBody
	@RequestMapping("/loadAssignData")
	public Object loadAssignData( Integer roleid) {
		List<Permission> permissions = new ArrayList<>();
		List<Permission> ps = permissionService.queryAll();
		
		
		//��ȡ��ǰ��ɫ�Ѿ�����������Ϣ
		List<Integer> permissionids = permissionService.queryPermissionidsByRoleid(roleid);
		
		
		Map<Integer, Permission> permissionMap = new HashMap<>();
		for(Permission p : ps) {
			if(permissionids.contains(p.getId())) {
				p.setChecked(true);
			}else {
				p.setChecked(false);
			}
			permissionMap.put(p.getId(), p);
		}
		for(Permission p : ps) {
			Permission child = p;
			if(child.getPid() == 0) {
				permissions.add(p);
			}else {
				Permission parent = permissionMap.get(child.getPid());
				parent.getChildren().add(child);
			}
		}
		
		return permissions;
	}
	
	
	
	/**
	 * �첽��ȡ���νṹ����  �˵�
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/loadData")
	public Object loadData() {
		List<Permission> permissions = new ArrayList<>();
		
//		Permission root = new Permission();
//		root.setName("�����ڵ�");
//		
//		Permission child = new Permission();
//		child.setName("�ӽڵ�");
//		
//		root.getChildren().add(child);
//		permissions.add(root);
		
		//��ȡ���νṹ������ �˵�������
		/*Permission root = permissionService.queryRootPermission();
		
		List<Permission> childPermissions = permissionService.queryChildPermissions(root.getId());
		for( Permission childPermission : childPermissions) {
			List<Permission> childChildPermissions = permissionService.queryChildPermissions(childPermission.getId());			
			childPermission.setChildren(childChildPermissions);
		}
		root.setChildren(childPermissions);
		permissions.add(root);*/
		
		/*Permission parent = new Permission();
		parent.setId(0);
		
		queryChildPermissions(parent);
		
		return parent.getChildren();*/
		
		//��ѯ���� �˵� �������
		List<Permission> ps = permissionService.queryAll();
		
		/*for(Permission p : ps) {
			// �Ӳ˵�
			Permission child = p;
			if(p.getPid() == 0) {
				permissions.add(p);
			}else {
				for(Permission innerPermission : ps) {
					if(child.getPid().equals(innerPermission.getId())) {
						// ���ڵ�
						Permission parent = innerPermission;
						//��ϸ��ӽڵ�Ĺ�ϵ
						parent.getChildren().add(child);
					}
				}
			}
		}*/
		
		Map<Integer, Permission> permissionMap = new HashMap<>();
		for(Permission p : ps) {
			permissionMap.put(p.getId(), p);
		}
		for(Permission p : ps) {
			Permission child = p;
			if(child.getPid() == 0) {
				permissions.add(p);
			}else {
				Permission parent = permissionMap.get(child.getPid());
				parent.getChildren().add(child);
			}
		}
		
		return permissions;
	}
	
	/**
	 * �ݹ��㷨�����ڲ�ѯ�˵���Ϣ  �����Ϣ
	 * @param parent
	 */
	private void queryChildPermissions(Permission parent) {
		List<Permission> childPermissions = permissionService.queryChildPermissions(parent.getId());
		
		for(Permission permission : childPermissions) {
			queryChildPermissions(permission);
		}
		
		
		parent.setChildren(childPermissions);
		
		
	
	
	}
	
}
