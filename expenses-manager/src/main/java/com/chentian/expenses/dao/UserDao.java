package com.chentian.expenses.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chentian.expenses.bean.User;

public interface UserDao {

	@Select("select * from t_user")
	List<User> queryAll();

	@Select("select * from t_user u,t_role r,t_user_role ur where loginacct=#{loginacct} and userpswd=#{userpswd} and u.id=ur.userid and r.id=ur.roleid")
	User query4Login(User user);

	
	List<User> pageQueryData(Map<String, Object> map);

	int pageQueryCount(Map<String, Object> map);

	void insertUser(User user);

	@Select("select * from t_user where id=#{id}")
	User queryById(Integer id);

	void updateUser(User user);

	@Update("update t_user set status=0 where id=#{id}")
	void deleteUser(Integer id);

	void deleUsers(Map<String, Object> map);

	void insertUserRoles(Map<String, Object> map);

	void deleteUserRoles(Map<String, Object> map);

	
	@Select("select roleid from t_user_role where userid=#{userid}")
	List<Integer> queryRoleidByUserid(Integer id);

	@Update("update t_user set sex=#{sex},username=#{username} where loginacct=#{loginacct}")
	void updateMyself(User user);

	@Select("select * from t_user u,t_role r,t_user_role ur where loginacct=#{loginacct} and u.id=ur.userid and r.id=ur.roleid")
	User refreshUser(Map<String, Object> map);

	@Select("select count(*) from t_user where userpswd=#{oldpassword}")
	Integer checkPassword(Map<String, Object> map);

	@Update("update t_user set userpswd=#{newpassword},updateDate=#{updatedate} where loginacct=#{loginacct}")
	void updatepassword(Map<String, Object> map);

	@Select("select * from t_user u,t_role r,t_user_role ur where u.id=ur.userid and r.id=ur.roleid")
	List<User> queryAllUserAndRole();

}
