package com.chentian.expenses.service;

import java.util.List;

import com.chentian.expenses.bean.Permission;
import com.chentian.expenses.bean.User;

public interface PermissionService {

	/**
	 * ���Ҹ��ڵ�
	 * @return
	 */
	Permission queryRootPermission();

	/**
	 * ���Ҹ��ڵ�
	 * @param pid
	 * @return
	 */
	List<Permission> queryChildPermissions(Integer id);

	/**
	 * ��ѯ�������
	 * @return
	 */
	List<Permission> queryAll();

	/**
	 * ���Ȩ����Ϣ
	 * @param permission
	 */
	void insertPermission(Permission permission);

	/**
	 * ����id��Ȩ��
	 * @param id
	 * @return
	 */
	Permission queryById(Integer id);

	/**
	 * �޸�Ȩ����Ϣ
	 * @param permission
	 */
	void updatePermission(Permission permission);

	/**
	 * ɾ��Ȩ��
	 * @param permission
	 */
	void deletePermission(Permission permission);

	/**
	 * ���ݽ�ɫid��Ȩ��
	 * @param roleid
	 * @return
	 */
	List<Integer> queryPermissionidsByRoleid(Integer roleid);

	/**
	 * �����û���Ȩ��
	 * @param dbUser
	 * @return
	 */
	List<Permission> queryPermissionsByUser(User dbUser);

}
