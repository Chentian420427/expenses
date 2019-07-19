package com.chentian.expenses.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chentian.expenses.bean.AJAXResult;
import com.chentian.expenses.bean.Permission;
import com.chentian.expenses.bean.Role;
import com.chentian.expenses.bean.User;
import com.chentian.expenses.service.PermissionService;
import com.chentian.expenses.service.RoleService;
import com.chentian.expenses.service.UserService;

@Controller
public class DispatcherController {

	@Autowired
	private UserService userService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping("/error")
	public String error() {
		
		return "error";
	}
	
	@RequestMapping("/index")
	public String index() {
		
		return "index";
	}
	
	
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		//session.removeAttribute("loginUser");
		
		//session直接失效，更方便
		session.invalidate();
		
		return "redirect:login";
	}
	
	
	@RequestMapping("/main")
	public String main() {
		
		return "main";
	}
	
	
	@ResponseBody
	@RequestMapping("/rolenum")
	public Object roleNum() {
		AJAXResult result = new AJAXResult();
		
		try {
			
			List<Map<String, Object>> list = roleService.queryRoleNum();
			Map<String, Object> map = new HashMap<>();
			map.put("roleList", list);
			
			result.setData(map);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	
	
	@ResponseBody
	@RequestMapping("/sexdata")
	public Object sexdata(Model model) {
		AJAXResult result = new AJAXResult();
		
		try {
			Map<String, Object> map = new HashMap<>();
			Integer manNum = 0;
			Integer womenNum =0;
			List<User> users = userService.queryAllUserAndRole();
			for(User u : users) {
				if(u.getSex().equals("男")) {
					manNum++;
				}else {
					womenNum++;
				}
			}
			map.put("manNum", manNum);
			map.put("womenNum", womenNum);
			model.addAttribute("sexNum", map);
			
			
			result.setData(map);
			
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		
		
		return result;
	}
	
	
	
	@ResponseBody
	@RequestMapping("/doAjaxLogin")
	public Object doAjaxLogin(User user, HttpSession session,String vcode) {
		
		AJAXResult result = new AJAXResult();
		Map<String, Object> errorMsg = new HashMap<>();
		
		
		
		//获取验证码
		String sessionCode = (String) session.getAttribute("vcode");
		
		
		
		if(!vcode.equals(sessionCode)) {
			errorMsg.put("errorMsg", "验证码错误");
			result.setData(errorMsg);
			result.setSuccess(false);
			return result;
		}
		
		
		
		User dbUser = userService.query4Login(user);
		
		
		if(dbUser != null){
			session.setAttribute("loginUser", dbUser);
			
			//获取用户所对应的角色的权限信息
			List<Permission> permissions = permissionService.queryPermissionsByUser(dbUser);
			Map<Integer, Permission> permissionMap = new HashMap<>();
			
			Permission root = null;
			
			Set<String> uriSet = new HashSet<>();
			
			
			for(Permission permission : permissions) {
				permissionMap.put(permission.getId(), permission);
				if(permission.getUrl()!=null && !"".equals(permission.getUrl())) {
					uriSet.add(session.getServletContext().getContextPath() + permission.getUrl());
				}
			}
			
			session.setAttribute("authUriSet", uriSet);
			
			
			for(Permission permission:permissions) {
				Permission child = permission;
				if(child.getPid() == 0) {
					root = permission;
				}else {
					Permission parent = permissionMap.get(child.getPid());
					parent.getChildren().add(child);
				}
			}
			session.setAttribute("rootPermission", root);
			
			
			
			result.setSuccess(true);
		}else {
			//失败
			errorMsg.put("errorMsg", "账号或密码错误，请重新输入！");
			result.setData(errorMsg);
			result.setSuccess(false);
		}
		
		return result;
		
		
	}
	
	/**
	 * 执行登录功能
	 * @return
	 */
	@RequestMapping("/doLogin")
	public String doLogin( User user, Model model) {
		
		System.out.println(user);
		
		//查询用户信息
		User dbUser = userService.query4Login(user);
		System.out.println(dbUser);
		
		if(dbUser != null){
			return "main";
		}else {
			//失败
			String errorMsg = "账号或密码错误，请重新输入";
			model.addAttribute("errorMsg", errorMsg);
			return "redirect:login";
			
		}
		
		
		
		
	}
	
}
