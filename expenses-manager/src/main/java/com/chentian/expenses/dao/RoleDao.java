package com.chentian.expenses.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chentian.expenses.bean.Role;

public interface RoleDao {

	@Select("select * from t_role")
	List<Role> queryAll();

	List<Role> pageQueryData(Map<String, Object> map);

	int pageQueryCount(Map<String, Object> map);

	void insertRolePermission(Map<String, Object> paramMap);

	void deleteRolePermission(Map<String, Object> paramMap);

	@Select("select * from t_role where id=#{id}")
	Role queryById(Integer id);

	@Update("update t_role set name=#{name} where id=#{id}")
	void updateRole(Role role);

	@Insert("insert into t_role (name,assigndate) values(#{name},#{assigndate})")
	void insertRole(Role role);

	
	@Delete("delete from t_role where id=#{id}")
	void deleteRole(Integer id);

	void deleteRoles(Map<String, Object> map);

	/**
	 * 查询每个角色对应的员工个数
	 * @return
	 */
	List<Map<String, Object>> queryRoleNum();

	@Update("update t_role set assigndate=#{assigndate} where id=#{roleid}")
	void updateAssignDate(Map<String, Object> paramMap);

}
