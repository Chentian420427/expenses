package com.chentian.expenses.service;

import java.util.List;
import java.util.Map;

import com.chentian.expenses.bean.Expense;
import com.chentian.expenses.bean.Leave;

public interface ExpenseService {

	/**
	 * 查询我的报销
	 * @param map
	 * @return
	 */
	List<Expense> pageQueryData(Map<String, Object> map);

	/**
	 * 查询我的报销总条数
	 * @param map
	 * @return
	 */
	int pageQueryCount(Map<String, Object> map);

	/**
	 * 新增报销单
	 * @param expense
	 */
	void addExpense(Expense expense);

	/**
	 * 通过id查询报销单
	 * @param id
	 * @return
	 */
	Expense queryById(Integer id);

	/**
	 * 修改报销单
	 * @param expense
	 */
	void update(Expense expense);

	/**
	 * 单个删除
	 * @param id
	 */
	void deleteExpense(Integer id);

	/**
	 * 批量删除
	 * @param map
	 */
	void deleteExpenses(Map<String, Object> map);

	/**
	 * 经理查询的数据
	 * @param map
	 * @return
	 */
	List<Expense> pageQueryDataManager(Map<String, Object> map);

	/**
	 * 经理查询的总条数
	 * @param map
	 * @return
	 */
	int pageQueryCountManager(Map<String, Object> map);

	/**
	 * 经理审批
	 * @param expense
	 */
	void approvalManager(Expense expense);

	/**
	 * 财务查询的数据
	 * @param map
	 * @return
	 */
	List<Expense> pageQueryDataFinance(Map<String, Object> map);

	/**
	 * 财务查询的总条数
	 * @param map
	 * @return
	 */
	int pageQueryCountFinance(Map<String, Object> map);

	/**
	 * 财务审批
	 * @param expense
	 */
	void approvalFinance(Expense expense);

}
