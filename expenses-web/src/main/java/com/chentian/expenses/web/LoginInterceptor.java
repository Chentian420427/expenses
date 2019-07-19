package com.chentian.expenses.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.chentian.expenses.bean.User;

/**
 * 登录拦截器
 * @author 陈添
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * 在完成视图的渲染之后
	 * 执行此方法
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 在控制器执行完毕之后执行的操作
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 在控制器执行之前完成业务逻辑操作
	 * 返回值决定逻辑是否继续执行
	 * 返回false 不会进入控制器
	 * 返回true 进入控制器
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		
		// 判断当前的用户是否已经登录
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
