package com.chentian.expenses.service;

import java.util.List;
import java.util.Map;

import com.chentian.expenses.bean.Leave;
import com.chentian.expenses.bean.Role;

public interface LeaveService {

	List<Leave> pageQueryData(Map<String, Object> map);

	int pageQueryCount(Map<String, Object> map);

	/**
	 * 根据id查询请假单
	 * @param id
	 * @return
	 */
	Leave queryById(Integer id);

	/**
	 * 修改请假单
	 * @param leave
	 */
	void update(Leave leave);

	/**
	 * 批量删除
	 * @param map
	 */
	void deleteLeaves(Map<String, Object> map);

	/**
	 * 根据id删除
	 * @param id
	 */
	void deleteLeave(Integer id);

	/**
	 * 新增请假单
	 * @param leave
	 */
	void addLeave(Leave leave);

	/**
	 * 经理审批的查询
	 * @param map
	 * @return
	 */
	List<Leave> pageQueryDataManager(Map<String, Object> map);

	/**
	 * 数量
	 * @param map
	 * @return
	 */
	int pageQueryCountManager(Map<String, Object> map);

	/**
	 * 经理审批
	 * @param leave
	 */
	void approval(Leave leave);

}
