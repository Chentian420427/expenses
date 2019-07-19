package com.chentian.expenses.service;

import java.util.List;
import java.util.Map;

import com.chentian.expenses.bean.Expense;
import com.chentian.expenses.bean.Leave;

public interface ExpenseService {

	/**
	 * ��ѯ�ҵı���
	 * @param map
	 * @return
	 */
	List<Expense> pageQueryData(Map<String, Object> map);

	/**
	 * ��ѯ�ҵı���������
	 * @param map
	 * @return
	 */
	int pageQueryCount(Map<String, Object> map);

	/**
	 * ����������
	 * @param expense
	 */
	void addExpense(Expense expense);

	/**
	 * ͨ��id��ѯ������
	 * @param id
	 * @return
	 */
	Expense queryById(Integer id);

	/**
	 * �޸ı�����
	 * @param expense
	 */
	void update(Expense expense);

	/**
	 * ����ɾ��
	 * @param id
	 */
	void deleteExpense(Integer id);

	/**
	 * ����ɾ��
	 * @param map
	 */
	void deleteExpenses(Map<String, Object> map);

	/**
	 * �����ѯ������
	 * @param map
	 * @return
	 */
	List<Expense> pageQueryDataManager(Map<String, Object> map);

	/**
	 * �����ѯ��������
	 * @param map
	 * @return
	 */
	int pageQueryCountManager(Map<String, Object> map);

	/**
	 * ��������
	 * @param expense
	 */
	void approvalManager(Expense expense);

	/**
	 * �����ѯ������
	 * @param map
	 * @return
	 */
	List<Expense> pageQueryDataFinance(Map<String, Object> map);

	/**
	 * �����ѯ��������
	 * @param map
	 * @return
	 */
	int pageQueryCountFinance(Map<String, Object> map);

	/**
	 * ��������
	 * @param expense
	 */
	void approvalFinance(Expense expense);

}
