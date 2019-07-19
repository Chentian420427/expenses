package com.chentian.expenses.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chentian.expenses.bean.Role;
import com.chentian.expenses.dao.RoleDao;
import com.chentian.expenses.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> queryAll() {
		// TODO Auto-generated method stub
		return roleDao.queryAll();
	}

	@Override
	public List<Role> pageQueryData(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return roleDao.pageQueryData(map);
	}

	@Override
	public int pageQueryCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return roleDao.pageQueryCount(map);
	}

	@Override
	public void insertRolePermission(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		roleDao.deleteRolePermission(paramMap);
		roleDao.insertRolePermission(paramMap);
	}

	@Override
	public Role queryById(Integer id) {
		// TODO Auto-generated method stub
		return roleDao.queryById(id);
	}

	@Override
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		roleDao.updateRole(role);
	}

	@Override
	public void insertRole(Role role) {
		// TODO Auto-generated method stub
		roleDao.insertRole(role);
	}

	@Override
	public void deleteRole(Integer id) {
		// TODO Auto-generated method stub
		roleDao.deleteRole(id);
	}

	@Override
	public void deleteRoles(Map<String, Object> map) {
		// TODO Auto-generated method stub
		roleDao.deleteRoles(map);
	}

	@Override
	public List<Map<String, Object>> queryRoleNum() {
		// TODO Auto-generated method stub
		return roleDao.queryRoleNum();
	}

	@Override
	public void updateAssignDate(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		roleDao.updateAssignDate(paramMap);
	}

	

	

}
