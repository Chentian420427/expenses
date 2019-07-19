package com.chentian.expenses.service;

import java.util.List;
import java.util.Map;

import com.chentian.expenses.bean.Role;
import com.chentian.expenses.bean.User;

public interface RoleService {

	/**
	 * 查询所有角色
	 * @return
	 */
	List<Role> queryAll();

	/**
	 * 查询所有角色信息
	 * @param map
	 * @return
	 */
	List<Role> pageQueryData(Map<String, Object> map);

	/**
	 * 查询总条数
	 * @param map
	 * @return
	 */
	int pageQueryCount(Map<String, Object> map);

	/**
	 * 分配权限
	 * @param paramMap
	 */
	void insertRolePermission(Map<String, Object> paramMap);

	/**
	 * 根据角色id查询角色信息
	 * @param id 
	 * @return
	 */
	Role queryById(Integer id);

	/**
	 * 更新角色信息
	 * @param role
	 */
	void updateRole(Role role);

	/**
	 * 新增角色
	 * @param role
	 */
	void insertRole(Role role);

	/**
	 * 删除角色
	 * @param id
	 */
	void deleteRole(Integer id);

	/**
	 * 批量删除角色信息
	 * @param map
	 */
	void deleteRoles(Map<String, Object> map);

	/**
	 * 查询每个角色对应的员工个数
	 * @return
	 */
	List<Map<String, Object>> queryRoleNum();

	/**
	 * 更新角色的授权时间
	 * @param paramMap
	 */
	void updateAssignDate(Map<String, Object> paramMap);

	

}
