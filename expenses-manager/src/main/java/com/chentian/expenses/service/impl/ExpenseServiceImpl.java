package com.chentian.expenses.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chentian.expenses.bean.Expense;
import com.chentian.expenses.bean.Leave;
import com.chentian.expenses.dao.ExpenseDao;
import com.chentian.expenses.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseDao expenseDao;

	@Override
	public List<Expense> pageQueryData(Map<String, Object> map) {
		
		List<Expense> expenses = expenseDao.pageQueryData(map);
		for(Expense e : expenses) {
			if(e.getStatus().equals("0")) {
				e.setStatus("<button  class='btn btn-warning'>未审核</button>");
			}else if(e.getStatus().equals("1")) {
				e.setStatus("<button  class='btn btn-info'>经理审核通过</button>");
			}else if(e.getStatus().equals("-1")) {
				e.setStatus("<button  class='btn btn-danger'>经理审核不通过</button>");
			}else if(e.getStatus().equals("2")) {
				e.setStatus("<button  class='btn btn-success'>经理、财务审核通过</button>");
			}else if(e.getStatus().equals("-2")) {
				e.setStatus("<button  class='btn btn-danger'>经理通过，但财务审核不通过</button>");
			}
		}
		
		
		return expenses;
	}

	@Override
	public int pageQueryCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return expenseDao.pageQueryCount(map);
	}

	@Override
	public void addExpense(Expense expense) {
		// TODO Auto-generated method stub
		expenseDao.addExpense(expense);
	}

	@Override
	public Expense queryById(Integer id) {
		// TODO Auto-generated method stub
		return expenseDao.queryById(id);
	}

	@Override
	public void update(Expense expense) {
		// TODO Auto-generated method stub
		expenseDao.update(expense);
	}

	@Override
	public void deleteExpense(Integer id) {
		// TODO Auto-generated method stub
		expenseDao.deleteExpense(id);
	}

	@Override
	public void deleteExpenses(Map<String, Object> map) {
		// TODO Auto-generated method stub
		expenseDao.deleteExpenses(map);
	}

	@Override
	public List<Expense> pageQueryDataManager(Map<String, Object> map) {
		
		List<Expense> expenses =expenseDao.pageQueryDataManager(map);
		for(Expense e : expenses) {
			if(e.getStatus().equals("0")) {
				e.setStatus("<button  class='btn btn-warning'>未审核</button>");
			}
		}
		
		return expenses;
	}

	@Override
	public int pageQueryCountManager(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return expenseDao.pageQueryCountManager(map);
	}

	@Override
	public void approvalManager(Expense expense) {
		// TODO Auto-generated method stub
		expenseDao.approvalManager(expense);
	}

	@Override
	public List<Expense> pageQueryDataFinance(Map<String, Object> map) {
		
		List<Expense> expenses = expenseDao.pageQueryDataFinance(map);
		for(Expense e : expenses) {
			if(e.getStatus().equals("1")) {
				e.setStatus("<button  class='btn btn-info'>经理已审核，等待财务审核</button>");
			}
		}
		
		return expenses;
	}

	@Override
	public int pageQueryCountFinance(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return expenseDao.pageQueryCountFinance(map);
	}

	@Override
	public void approvalFinance(Expense expense) {
		// TODO Auto-generated method stub
		expenseDao.approvalFinance(expense);
	}
}
