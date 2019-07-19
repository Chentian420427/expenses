package com.chentian.expenses.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chentian.expenses.bean.Expense;
import com.chentian.expenses.bean.Leave;

public interface ExpenseDao {

	List<Expense> pageQueryData(Map<String, Object> map);

	int pageQueryCount(Map<String, Object> map);

	
	void addExpense(Expense expense);

	@Select("select * from t_expense where id=#{id}")
	Expense queryById(Integer id);

	@Update("update t_expense set expense_reason=#{expense_reason},expense_detail=#{expense_detail},expense_cost=#{expense_cost} where id=#{id}")
	void update(Expense expense);

	@Delete("delete from t_expense where id=#{id}")
	void deleteExpense(Integer id);

	void deleteExpenses(Map<String, Object> map);

	List<Expense> pageQueryDataManager(Map<String, Object> map);

	int pageQueryCountManager(Map<String, Object> map);

	@Update("update t_expense set status=#{status},feedback=#{feedback} where id=#{id}")
	void approvalManager(Expense expense);

	List<Expense> pageQueryDataFinance(Map<String, Object> map);

	int pageQueryCountFinance(Map<String, Object> map);

	@Update("update t_expense set status=#{status},feedback=#{feedback} where id=#{id}")
	void approvalFinance(Expense expense);

}
