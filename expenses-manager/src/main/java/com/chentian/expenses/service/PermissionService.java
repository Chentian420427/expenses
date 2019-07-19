package com.chentian.expenses.service;

import java.util.List;

import com.chentian.expenses.bean.Permission;
import com.chentian.expenses.bean.User;

public interface PermissionService {

	/**
	 * 查找根节点
	 * @return
	 */
	Permission queryRootPermission();

	/**
	 * 查找父节点
	 * @param pid
	 * @return
	 */
	List<Permission> queryChildPermissions(Integer id);

	/**
	 * 查询所有许可
	 * @return
	 */
	List<Permission> queryAll();

	/**
	 * 添加权限信息
	 * @param permission
	 */
	void insertPermission(Permission permission);

	/**
	 * 根据id查权限
	 * @param id
	 * @return
	 */
	Permission queryById(Integer id);

	/**
	 * 修改权限信息
	 * @param permission
	 */
	void updatePermission(Permission permission);

	/**
	 * 删除权限
	 * @param permission
	 */
	void deletePermission(Permission permission);

	/**
	 * 根据角色id查权限
	 * @param roleid
	 * @return
	 */
	List<Integer> queryPermissionidsByRoleid(Integer roleid);

	/**
	 * 根据用户查权限
	 * @param dbUser
	 * @return
	 */
	List<Permission> queryPermissionsByUser(User dbUser);

}
