package com.chentian.expenses.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chentian.expenses.bean.Leave;
import com.chentian.expenses.bean.Role;
import com.chentian.expenses.dao.LeaveDao;
import com.chentian.expenses.service.LeaveService;

@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private LeaveDao leaveDao;
	
	
	@Override
	public List<Leave> pageQueryData(Map<String, Object> map) {
		
		/**
		 * 将获得的Leave状态偷梁换柱，换成按钮展示到前端，而不是我们的数据库的内容
		 */
		List<Leave> leaves = leaveDao.pageQueryData(map);
		for(Leave l : leaves) {
			if(l.getStatus().equals("0")) {
				l.setStatus("<button  class='btn btn-warning'>未审核</button>");
			}else if(l.getStatus().equals("1")) {
				l.setStatus("<button  class='btn btn-success'>审核通过</button>");
			}else if(l.getStatus().equals("-1")) {
				l.setStatus("<button  class='btn btn-danger'>审核不通过</button>");
			}
		}
		
		return leaves;
	}


	@Override
	public int pageQueryCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return leaveDao.pageQueryCount(map);
	}


	@Override
	public Leave queryById(Integer id) {
		// TODO Auto-generated method stub
		return leaveDao.queryById(id);
	}


	@Override
	public void update(Leave leave) {
		// TODO Auto-generated method stub
		leaveDao.update(leave);
	}


	@Override
	public void deleteLeaves(Map<String, Object> map) {
		// TODO Auto-generated method stub
		leaveDao.deleteLeaves(map);
	}


	@Override
	public void deleteLeave(Integer id) {
		// TODO Auto-generated method stub
		leaveDao.deleteLeave(id);
	}


	@Override
	public void addLeave(Leave leave) {
		// TODO Auto-generated method stub
		leaveDao.addLeave(leave);
	}


	@Override
	public List<Leave> pageQueryDataManager(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<Leave> leaves = leaveDao.pageQueryDataManager(map);
		for(Leave l : leaves) {
			if(l.getStatus().equals("0")) {
				l.setStatus("<button class='btn btn-warning'>未审核</button>");
			}
		}
		
		return leaves;
	}


	@Override
	public int pageQueryCountManager(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return leaveDao.pageQueryCountManager(map);
	}


	@Override
	public void approval(Leave leave) {
		// TODO Auto-generated method stub
		leaveDao.approval(leave);
	}

}
