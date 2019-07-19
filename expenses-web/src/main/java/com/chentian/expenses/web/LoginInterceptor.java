package com.chentian.expenses.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.chentian.expenses.bean.User;

/**
 * ��¼������
 * @author ����
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * �������ͼ����Ⱦ֮��
	 * ִ�д˷���
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * �ڿ�����ִ�����֮��ִ�еĲ���
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * �ڿ�����ִ��֮ǰ���ҵ���߼�����
	 * ����ֵ�����߼��Ƿ����ִ��
	 * ����false ������������
	 * ����true ���������
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		
		// �жϵ�ǰ���û��Ƿ��Ѿ���¼
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		if(loginUser == null) {
			String path = session.getServletContext().getContextPath();
			response.sendRedirect(path + "/login");
			
			return false;
		}else {
			return true;
		}
		
		
	}

}
