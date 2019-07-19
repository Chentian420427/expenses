package com.chentian.expenses.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.chentian.expenses.bean.Permission;
import com.chentian.expenses.bean.User;

public interface PermissionDao {

	/**
	 * 查找根节点
	 * @return
	 */
	@Select("select * from t_permission where pid is null")
	Permission queryRootPermission();

	/**
	 * 查找父节点
	 * @param pid
	 * @return
	 */
	@Select("select * from t_permission where pid=#{id}")
	List<Permission> queryChildPermissions(Integer id);

	/**
	 * 查询所有许可菜单 
	 * @return
	 */
	@Select("select * from t_permission")
	List<Permission> queryAll();

	void insertPermission(Permission permission);

	@Select("select * from t_permission where id=#{id}")
	Permission queryById(Integer id);

	void updatePermission(Permission permission);

	void deletePermission(Permission permission);

	/**
	 * 根据角色id查权限
	 * @param roleid
	 * @return
	 */
	@Select("select permissionid from t_role_permission where roleid=#{roleid}")
	List<Integer> queryPermissionidsByRoleid(Integer roleid);

	/**
	 * 根据用户查权限
	 * @param dbUser
	 * @return
	 */
	List<Permission> queryPermissionsByUser(User dbUser);

}
