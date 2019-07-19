package com.chentian.expenses.service;

import java.util.List;
import java.util.Map;

import com.chentian.expenses.bean.Leave;
import com.chentian.expenses.bean.Role;

public interface LeaveService {

	List<Leave> pageQueryData(Map<String, Object> map);

	int pageQueryCount(Map<String, Object> map);

	/**
	 * ����id��ѯ��ٵ�
	 * @param id
	 * @return
	 */
	Leave queryById(Integer id);

	/**
	 * �޸���ٵ�
	 * @param leave
	 */
	void update(Leave leave);

	/**
	 * ����ɾ��
	 * @param map
	 */
	void deleteLeaves(Map<String, Object> map);

	/**
	 * ����idɾ��
	 * @param id
	 */
	void deleteLeave(Integer id);

	/**
	 * ������ٵ�
	 * @param leave
	 */
	void addLeave(Leave leave);

	/**
	 * ���������Ĳ�ѯ
	 * @param map
	 * @return
	 */
	List<Leave> pageQueryDataManager(Map<String, Object> map);

	/**
	 * ����
	 * @param map
	 * @return
	 */
	int pageQueryCountManager(Map<String, Object> map);

	/**
	 * ��������
	 * @param leave
	 */
	void approval(Leave leave);

}
