package com.chentian.expenses.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chentian.expenses.bean.Leave;
import com.chentian.expenses.bean.Role;

public interface LeaveDao {

	List<Leave> pageQueryData(Map<String, Object> map);

	int pageQueryCount(Map<String, Object> map);

	@Select("select * from t_leave where id=#{id}")
	Leave queryById(Integer id);

	@Update("update t_leave set leavename=#{leavename},leavedetail=#{leavedetail} where id=#{id}")
	void update(Leave leave);

	void deleteLeaves(Map<String, Object> map);

	@Delete("delete from t_leave where id=#{id}")
	void deleteLeave(Integer id);

	
	void addLeave(Leave leave);

	List<Leave> pageQueryDataManager(Map<String, Object> map);

	int pageQueryCountManager(Map<String, Object> map);

	@Update("update t_leave set status=#{status},feedback=#{feedback} where id=#{id}")
	void approval(Leave leave);

}
