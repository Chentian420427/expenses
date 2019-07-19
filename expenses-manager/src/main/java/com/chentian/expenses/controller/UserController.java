package com.chentian.expenses.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chentian.expenses.bean.AJAXResult;
import com.chentian.expenses.bean.Page;
import com.chentian.expenses.bean.Role;
import com.chentian.expenses.bean.User;
import com.chentian.expenses.service.RoleService;
import com.chentian.expenses.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping("/assign")
	public String assign( Integer id, Model model) {
		
		User user = userService.queryById(id);
		model.addAttribute("user", user);
		
		
		List<Role> roles = roleService.queryAll();
				
		//�ѷ���Ľ�ɫ
		List<Role> assignedRoles = new ArrayList<>();
		//δ����Ľ�ɫ
		List<Role> unassignedRoles = new ArrayList<>();
		
		//��ȡ��ϵ�������
		List<Integer> roleids = userService.queryRoleidByUserid(id);
		
		System.out.println(roleids);
		for(Role role : roles) {
			if(roleids.contains(role.getId())) {
				assignedRoles.add(role);
			}else {
				unassignedRoles.add(role);
			}
		}
		
		
		model.addAttribute("assignedRoles", assignedRoles);
		model.addAttribute("unassignedRoles", unassignedRoles);
		
		return "user/assign";
	}
	
	
	/**
	 * ȡ�������ɫ
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dounAssign")
	public Object dounAssign(Integer userid, Integer[] assignroleids) {
		AJAXResult result = new AJAXResult();
		
		try {
			//ɾ����ϵ������
			Map<String, Object> map = new HashMap<>();
			map.put("userid", userid);
			map.put("roleids", assignroleids);
			userService.deleteUserRoles(map);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	
	
	/**
	 * �����ɫ
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/doAssign")
	public Object doAssign( Integer userid, Integer[] unassignroleids) {
		AJAXResult result = new AJAXResult();
		
		try {
			//���ӹ�ϵ������
			Map<String, Object> map = new HashMap<>();
			map.put("userid", userid);
			map.put("roleids", unassignroleids);
			userService.insertUserRoles(map);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	
	
	
	@ResponseBody
	@RequestMapping("/deletes")
	public Object deletes( Integer[] userid) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			Map<String, Object> map = new HashMap<>();
			map.put("userids", userid);
			userService.deleteUsers(map);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		
		return result;
	}
	
	
	
	
	@ResponseBody
	@RequestMapping("/delete")
	public Object delete( Integer id) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			userService.deleteUser(id);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping("/updatepassword")
	public Object updatepassword( String oldpassword,String newpassword,String confirmpassword,String loginacct,HttpSession session) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			Map<String, Object> map = new HashMap<>();
			map.put("loginacct", loginacct);
			map.put("oldpassword", oldpassword);
			map.put("newpassword", newpassword);
			map.put("confirmpassword", confirmpassword);
			map.put("updatedate", new Date());
			System.out.println(map);
			
			Integer row = userService.checkPassword(map);
			if(row>0) {
				userService.updatepassword(map);
				//ˢ�¸�����Ϣ
				User u = userService.refreshUser(map);
				session.setAttribute("loginUser", u);
				
				result.setSuccess(true);
			}else {
				result.setSuccess(false);
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	
	
	
	@ResponseBody
	@RequestMapping("/updatemyself")
	public Object updatemyself(User user,HttpSession session) {
		AJAXResult result = new AJAXResult();
		
		try {
			System.out.println(user);
			userService.updateMyself(user);
			Map<String, Object> map = new HashMap<>();
			map.put("loginacct", user.getLoginacct());
			User u = userService.refreshUser(map);
			session.setAttribute("loginUser", u);
			
			result.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	
	
	
	@ResponseBody
	@RequestMapping("/update")
	public Object update( User user) {
		AJAXResult result = new AJAXResult();
		
		try {
			System.out.println(user);
			userService.updateUser(user);
			
			result.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	
	
	
	@RequestMapping("/edit")
	public String edit( Integer id, Model model) {
		
		User user = userService.queryById(id);
		model.addAttribute("user", user);
		
		return "user/edit";
	}
	
	
	@RequestMapping("/myself")
	public String myself() {
		
		return "user/myself";
	}
	
	
	
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/insert")
	public Object insert( User user) {
		
		AJAXResult result = new AJAXResult();
		
		try {
			user.setUserpswd("123456");
			user.setStartdate(new Date());
			user.setUpdatedate(new Date());
			userService.insertUser(user);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	
	
	@RequestMapping("/add")
	public String add() {
		
		return "user/add";
	}
	
	
	
	@ResponseBody
	@RequestMapping("/pageQuery")
	public Object pageQuery( String queryText, Integer pn, Integer pagesize) {
		
		AJAXResult result = new AJAXResult();
		
		try {
			//��ҳ��ѯ
			// ��ҳ��ѯ
			Map<String, Object> map = new HashMap<>();
			map.put("start", (pn-1)*pagesize);
			map.put("size", pagesize);
			map.put("queryText", queryText);
			
			List<User> users = userService.pageQueryData(map);
			
			//����������
			int totalsize = userService.pageQueryCount(map);
			//��ҳ��
			int totalpn=0;
			if(totalsize % pagesize == 0) {
				totalpn = totalsize / pagesize;
			}else {
				totalpn = totalsize / pagesize + 1;
			}
			
			//��ҳ����
			Page<User> userPage = new Page<>();
			userPage.setDatas(users);
			userPage.setPn(pn);
			userPage.setTotalsize(totalsize);
			userPage.setTotalpn(totalpn);
			
			result.setSuccess(true);
			result.setData(userPage);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
		
		
	}
	
	
	
	@RequestMapping("/index")
	public String index() {
		return "user/index";
	}
	
	
	

}
