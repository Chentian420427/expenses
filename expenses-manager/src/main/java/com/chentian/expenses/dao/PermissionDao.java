package com.chentian.expenses.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.chentian.expenses.bean.Permission;
import com.chentian.expenses.bean.User;

public interface PermissionDao {

	/**
	 * ���Ҹ��ڵ�
	 * @return
	 */
	@Select("select * from t_permission where pid is null")
	Permission queryRootPermission();

	/**
	 * ���Ҹ��ڵ�
	 * @param pid
	 * @return
	 */
	@Select("select * from t_permission where pid=#{id}")
	List<Permission> queryChildPermissions(Integer id);

	/**
	 * ��ѯ������ɲ˵� 
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
	 * ���ݽ�ɫid��Ȩ��
	 * @param roleid
	 * @return
	 */
	@Select("select permissionid from t_role_permission where roleid=#{roleid}")
	List<Integer> queryPermissionidsByRoleid(Integer roleid);

	/**
	 * �����û���Ȩ��
	 * @param dbUser
	 * @return
	 */
	List<Permission> queryPermissionsByUser(User dbUser);

}
