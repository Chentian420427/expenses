package com.chentian.expenses.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.chentian.expenses.bean.Permission;
import com.chentian.expenses.service.PermissionService;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private PermissionService permissionService;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取当前用户的请求地址
		String uri = request.getRequestURI();
		//获取项目路径
		String path = request.getSession().getServletContext().getContextPath();
		// 判断当前的路径是否需要进行权限验证
		
		// 查询所有需要验证的路径集合
		List<Permission> permissions = permissionService.queryAll();
		Set<String> uriSet = new HashSet<>();
		for(Permission permission : permissions) {
			if( permission.getUrl() != null && !"".equals(permission.getUrl())) {
				uriSet.add(path + permission.getUrl());
			}
		}
		
		if(uriSet.contains(uri)) {
			//权限验证
			//判断当前的用户是否拥有对应的权限
			Set<String> authUriSet = (Set<String>) request.getSession().getAttribute("authUriSet");
			if(authUriSet.contains(uri)) {
				return true;
			}else {
				
				response.sendRedirect(path + "/error");
				
				return false;
			}
		
		}else {
			return true;
		}
	
	
	}
	
	
}
