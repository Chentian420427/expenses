package com.chentian.expenses.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chentian.expenses.bean.AJAXResult;
import com.chentian.expenses.bean.Expense;
import com.chentian.expenses.bean.Leave;
import com.chentian.expenses.bean.Page;
import com.chentian.expenses.service.ExpenseService;

@Controller
@RequestMapping("/expense")
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	

	@RequestMapping("/myexpense")
	public String myexpense() {
		return "expense/myexpense";
	}
	
	@RequestMapping("/finance")
	public String finance() {
		return "expense/finance";
	}
	
	@RequestMapping("/manager")
	public String manager() {
		return "expense/manager";
	}
	
	
	/**
	 * 经理审批
	 * @param leave
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/approvalManager")
	public Object approval(Expense expense) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			expense.setCreatetime(new Date());
			
			
			expenseService.approvalManager(expense);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		
		return result;
	}
	
	/**
	 * 财务审批
	 * @param leave
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/approvalFinance")
	public Object approvalFinance(Expense expense) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			expense.setCreatetime(new Date());
			
			
			expenseService.approvalFinance(expense);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		
		return result;
	}
	
	
	
	
	
	@ResponseBody
	@RequestMapping("/deletes")
	public Object deletes( Integer[] id) {
		AJAXResult result = new AJAXResult();
		
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("expenseids", id);
			expenseService.deleteExpenses(map);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		
		return result;
	}
	
	
	
	
	
	@ResponseBody
	@RequestMapping("/delete")
	public Object deleteLeave(Integer id) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			expenseService.deleteExpense(id);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		
		return result;
	}
	
	
	
	
	
	@ResponseBody
	@RequestMapping("/update")
	public Object update(Expense expense) {
		AJAXResult result = new AJAXResult();
		
		try {
			System.out.println(expense);
			expenseService.update(expense);
			
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	
	
	
	
	
	@ResponseBody
	@RequestMapping("/queryById")
	public Object queryById(Integer id) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			Expense expense = expenseService.queryById(id);
			result.setData(expense);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	@ResponseBody
	@RequestMapping("/add")
	public Object add(Expense expense) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			expense.setCreatetime(new Date());
			System.out.println(expense);
			
			expenseService.addExpense(expense);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		
		return result;
	}
	
	
	
	@ResponseBody
	@RequestMapping("/pageQueryFinance")
	public Object pageQueryFinance( String queryText, Integer pn, Integer pagesize, Integer userid) {
		
		AJAXResult result = new AJAXResult();
		
		try {
			//分页查询
			// 分页查询
			Map<String, Object> map = new HashMap<>();
			map.put("start", (pn-1)*pagesize);
			map.put("size", pagesize);
			map.put("queryText", queryText);
			map.put("userid", userid);
			
			List<Expense> expenses = expenseService.pageQueryDataFinance(map);
			
			//总数据条数
			int totalsize = expenseService.pageQueryCountFinance(map);
			//总页码
			int totalpn=0;
			if(totalsize % pagesize == 0) {
				totalpn = totalsize / pagesize;
			}else {
				totalpn = totalsize / pagesize + 1;
			}
			// 分页对象
			Page<Expense> rolePage = new Page<Expense>();
			rolePage.setDatas(expenses);
			rolePage.setTotalpn(totalpn);
			rolePage.setTotalsize(totalsize);
			rolePage.setPn(pn);
			
			result.setData(rolePage);
			result.setSuccess(true);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
		
		
	}
	
	
	
	
	@ResponseBody
	@RequestMapping("/pageQueryManager")
	public Object pageQueryManager( String queryText, Integer pn, Integer pagesize, Integer userid) {
		
		AJAXResult result = new AJAXResult();
		
		try {
			//分页查询
			// 分页查询
			Map<String, Object> map = new HashMap<>();
			map.put("start", (pn-1)*pagesize);
			map.put("size", pagesize);
			map.put("queryText", queryText);
			map.put("userid", userid);
			
			List<Expense> expenses = expenseService.pageQueryDataManager(map);
			
			//总数据条数
			int totalsize = expenseService.pageQueryCountManager(map);
			//总页码
			int totalpn=0;
			if(totalsize % pagesize == 0) {
				totalpn = totalsize / pagesize;
			}else {
				totalpn = totalsize / pagesize + 1;
			}
			// 分页对象
			Page<Expense> rolePage = new Page<Expense>();
			rolePage.setDatas(expenses);
			rolePage.setTotalpn(totalpn);
			rolePage.setTotalsize(totalsize);
			rolePage.setPn(pn);
			
			result.setData(rolePage);
			result.setSuccess(true);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
		
		
	}
	
	
	
	
	
	
	
	/**
	 * 查询我的报销
	 * @param queryText
	 * @param pn
	 * @param pagesize
	 * @param userid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/pageQuery")
	public Object pageQuery( String queryText, Integer pn, Integer pagesize, Integer userid) {
		
		AJAXResult result = new AJAXResult();
		
		try {
			//分页查询
			// 分页查询
			Map<String, Object> map = new HashMap<>();
			map.put("start", (pn-1)*pagesize);
			map.put("size", pagesize);
			map.put("queryText", queryText);
			map.put("userid", userid);
			
			List<Expense> expenses = expenseService.pageQueryData(map);
			
			//总数据条数
			int totalsize = expenseService.pageQueryCount(map);
			//总页码
			int totalpn=0;
			if(totalsize % pagesize == 0) {
				totalpn = totalsize / pagesize;
			}else {
				totalpn = totalsize / pagesize + 1;
			}
			// 分页对象
			Page<Expense> rolePage = new Page<Expense>();
			rolePage.setDatas(expenses);
			rolePage.setTotalpn(totalpn);
			rolePage.setTotalsize(totalsize);
			rolePage.setPn(pn);
			
			result.setData(rolePage);
			result.setSuccess(true);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
		
		
	}
	
	
}
