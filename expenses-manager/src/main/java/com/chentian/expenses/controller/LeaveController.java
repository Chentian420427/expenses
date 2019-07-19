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
import com.chentian.expenses.bean.Leave;
import com.chentian.expenses.bean.Page;
import com.chentian.expenses.bean.Role;
import com.chentian.expenses.service.LeaveService;

@Controller
@RequestMapping("/leave")
public class LeaveController {
	
	@Autowired
	private LeaveService leaveService;
	
	
	@RequestMapping("/myleave")
	public String myleave() {
		
		return "leave/myleave";
	}
	
	
	@RequestMapping("/manager")
	public String managerLeave() {
		
		
		return "leave/managerleave";
	}
	
	
	/**
	 * 经理审批
	 * @param leave
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/approval")
	public Object approval(Leave leave) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			leave.setCreatetime(new Date());
			
			
			leaveService.approval(leave);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		
		return result;
	}
	
	
	
	
	@ResponseBody
	@RequestMapping("/add")
	public Object add(Leave leave) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			leave.setCreatetime(new Date());
			
			
			leaveService.addLeave(leave);
			
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
			
			leaveService.deleteLeave(id);
			
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
			System.out.println(id.toString());
			Map<String, Object> map = new HashMap<>();
			map.put("leaveids", id);
			leaveService.deleteLeaves(map);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		
		return result;
	}
	
	
	
	
	@ResponseBody
	@RequestMapping("/update")
	public Object update(Leave leave) {
		AJAXResult result = new AJAXResult();
		
		try {
			System.out.println(leave);
			leaveService.update(leave);
			
			
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
			
			Leave leave = leaveService.queryById(id);
			result.setData(leave);
			
			result.setSuccess(true);
		} catch (Exception e) {
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
			
			List<Leave> leaves = leaveService.pageQueryDataManager(map);
			
			//总数据条数
			int totalsize = leaveService.pageQueryCountManager(map);
			//总页码
			int totalpn=0;
			if(totalsize % pagesize == 0) {
				totalpn = totalsize / pagesize;
			}else {
				totalpn = totalsize / pagesize + 1;
			}
			// 分页对象
			Page<Leave> rolePage = new Page<Leave>();
			rolePage.setDatas(leaves);
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
			
			List<Leave> leaves = leaveService.pageQueryData(map);
			
			//总数据条数
			int totalsize = leaveService.pageQueryCount(map);
			//总页码
			int totalpn=0;
			if(totalsize % pagesize == 0) {
				totalpn = totalsize / pagesize;
			}else {
				totalpn = totalsize / pagesize + 1;
			}
			// 分页对象
			Page<Leave> rolePage = new Page<Leave>();
			rolePage.setDatas(leaves);
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
