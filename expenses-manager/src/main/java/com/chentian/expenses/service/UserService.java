package com.chentian.expenses.service;

import java.util.List;
import java.util.Map;

import com.chentian.expenses.bean.User;

public interface UserService {

	List<User> queryAll();

	/**
	 * 登录
	 * @param user
	 * @return
	 */
	User query4Login(User user);

	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	List<User> pageQueryData(Map<String, Object> map);

	/**
	 * 查数据总数量
	 * @param map
	 * @return
	 */
	int pageQueryCount(Map<String, Object> map);

	/**
	 * 添加用户
	 * @param user
	 */
	void insertUser(User user);

	/**
	 * 根据id查用户
	 * @param id
	 * @return
	 */
	User queryById(Integer id);

	/**
	 * 修改用户
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * 删除用户
	 * @param id
	 */
	void deleteUser(Integer id);

	/**
	 * 批量删除用户
	 * 
	 * @param map
	 */
	void deleteUsers(Map<String, Object> map);

	/**
	 * 取消分配角色
	 * @param map
	 */
	void deleteUserRoles(Map<String, Object> map);

	/**
	 * 分配角色
	 * @param map
	 */
	void insertUserRoles(Map<String, Object> map);

	/**
	 * 根据用户id查关系表数据
	 * @param id
	 * @return
	 */
	List<Integer> queryRoleidByUserid(Integer id);

	/**
	 * 修改个人信息
	 * @param user
	 */
	void updateMyself(User user);

	/**
	 * 刷新个人信息
	 * @param map
	 * @return
	 */
	User refreshUser(Map<String, Object> map);

	/**
	 * 校验原密码
	 * @param map
	 * @return
	 */
	Integer checkPassword(Map<String, Object> map);

	/**
	 * 修改密码
	 * @param map
	 */
	void updatepassword(Map<String, Object> map);

	/**
	 * 查询所有的用户，包括他们的角色
	 * @return
	 */
	List<User> queryAllUserAndRole();

}
