package com.chentian.expenses.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chentian.expenses.bean.User;
import com.chentian.expenses.dao.UserDao;
import com.chentian.expenses.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> queryAll() {
		
		
		
		return userDao.queryAll();
	}

	@Override
	public User query4Login(User user) {
		
		
		
		return userDao.query4Login(user);
	}

	/**
	 * ∑÷“≥≤È—Ø
	 */
	@Override
	public List<User> pageQueryData(Map<String, Object> map) {
		
		return userDao.pageQueryData(map);
	}

	@Override
	public int pageQueryCount(Map<String, Object> map) {
		
		return userDao.pageQueryCount(map);
	}


	@Override
	public void insertUser(User user) {

		userDao.insertUser(user);
		
	}

	@Override
	public User queryById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.queryById(id);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(Integer id) {
		
		userDao.deleteUser(id);
	}

	@Override
	public void deleteUsers(Map<String, Object> map) {
		// TODO Auto-generated method stub
		userDao.deleUsers(map);
	}

	@Override
	public void deleteUserRoles(Map<String, Object> map) {
		// TODO Auto-generated method stub
		userDao.deleteUserRoles(map);
	}

	@Override
	public void insertUserRoles(Map<String, Object> map) {
		// TODO Auto-generated method stub
		userDao.insertUserRoles(map);
	}

	@Override
	public List<Integer> queryRoleidByUserid(Integer id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		return userDao.queryRoleidByUserid(id);
	}

	@Override
	public void updateMyself(User user) {
		// TODO Auto-generated method stub
		userDao.updateMyself(user);
	}

	@Override
	public User refreshUser(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.refreshUser(map);
	}

	@Override
	public Integer checkPassword(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.checkPassword(map);
	}

	@Override
	public void updatepassword(Map<String, Object> map) {
		// TODO Auto-generated method stub
		userDao.updatepassword(map);
	}

	@Override
	public List<User> queryAllUserAndRole() {
		// TODO Auto-generated method stub
		return userDao.queryAllUserAndRole();
	}
	
}
