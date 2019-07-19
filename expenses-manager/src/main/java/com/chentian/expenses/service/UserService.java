package com.chentian.expenses.service;

import java.util.List;
import java.util.Map;

import com.chentian.expenses.bean.User;

public interface UserService {

	List<User> queryAll();

	/**
	 * ��¼
	 * @param user
	 * @return
	 */
	User query4Login(User user);

	/**
	 * ��ҳ��ѯ
	 * @param map
	 * @return
	 */
	List<User> pageQueryData(Map<String, Object> map);

	/**
	 * ������������
	 * @param map
	 * @return
	 */
	int pageQueryCount(Map<String, Object> map);

	/**
	 * ����û�
	 * @param user
	 */
	void insertUser(User user);

	/**
	 * ����id���û�
	 * @param id
	 * @return
	 */
	User queryById(Integer id);

	/**
	 * �޸��û�
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * ɾ���û�
	 * @param id
	 */
	void deleteUser(Integer id);

	/**
	 * ����ɾ���û�
	 * 
	 * @param map
	 */
	void deleteUsers(Map<String, Object> map);

	/**
	 * ȡ�������ɫ
	 * @param map
	 */
	void deleteUserRoles(Map<String, Object> map);

	/**
	 * �����ɫ
	 * @param map
	 */
	void insertUserRoles(Map<String, Object> map);

	/**
	 * �����û�id���ϵ������
	 * @param id
	 * @return
	 */
	List<Integer> queryRoleidByUserid(Integer id);

	/**
	 * �޸ĸ�����Ϣ
	 * @param user
	 */
	void updateMyself(User user);

	/**
	 * ˢ�¸�����Ϣ
	 * @param map
	 * @return
	 */
	User refreshUser(Map<String, Object> map);

	/**
	 * У��ԭ����
	 * @param map
	 * @return
	 */
	Integer checkPassword(Map<String, Object> map);

	/**
	 * �޸�����
	 * @param map
	 */
	void updatepassword(Map<String, Object> map);

	/**
	 * ��ѯ���е��û����������ǵĽ�ɫ
	 * @return
	 */
	List<User> queryAllUserAndRole();

}
