package com.chentian.expenses.service;

import java.util.List;
import java.util.Map;

import com.chentian.expenses.bean.Role;
import com.chentian.expenses.bean.User;

public interface RoleService {

	/**
	 * ��ѯ���н�ɫ
	 * @return
	 */
	List<Role> queryAll();

	/**
	 * ��ѯ���н�ɫ��Ϣ
	 * @param map
	 * @return
	 */
	List<Role> pageQueryData(Map<String, Object> map);

	/**
	 * ��ѯ������
	 * @param map
	 * @return
	 */
	int pageQueryCount(Map<String, Object> map);

	/**
	 * ����Ȩ��
	 * @param paramMap
	 */
	void insertRolePermission(Map<String, Object> paramMap);

	/**
	 * ���ݽ�ɫid��ѯ��ɫ��Ϣ
	 * @param id 
	 * @return
	 */
	Role queryById(Integer id);

	/**
	 * ���½�ɫ��Ϣ
	 * @param role
	 */
	void updateRole(Role role);

	/**
	 * ������ɫ
	 * @param role
	 */
	void insertRole(Role role);

	/**
	 * ɾ����ɫ
	 * @param id
	 */
	void deleteRole(Integer id);

	/**
	 * ����ɾ����ɫ��Ϣ
	 * @param map
	 */
	void deleteRoles(Map<String, Object> map);

	/**
	 * ��ѯÿ����ɫ��Ӧ��Ա������
	 * @return
	 */
	List<Map<String, Object>> queryRoleNum();

	/**
	 * ���½�ɫ����Ȩʱ��
	 * @param paramMap
	 */
	void updateAssignDate(Map<String, Object> paramMap);

	

}
