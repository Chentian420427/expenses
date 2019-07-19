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
		//��ȡ��ǰ�û��������ַ
		String uri = request.getRequestURI();
		//��ȡ��Ŀ·��
		String path = request.getSession().getServletContext().getContextPath();
		// �жϵ�ǰ��·���Ƿ���Ҫ����Ȩ����֤
		
		// ��ѯ������Ҫ��֤��·������
		List<Permission> permissions = permissionService.queryAll();
		Set<String> uriSet = new HashSet<>();
		for(Permission permission : permissions) {
			if( permission.getUrl() != null && !"".equals(permission.getUrl())) {
				uriSet.add(path + permission.getUrl());
			}
		}
		
		if(uriSet.contains(uri)) {
			//Ȩ����֤
			//�жϵ�ǰ���û��Ƿ�ӵ�ж�Ӧ��Ȩ��
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
