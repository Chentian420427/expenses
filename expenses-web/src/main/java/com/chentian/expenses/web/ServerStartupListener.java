package com.chentian.expenses.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServerStartupListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//��webӦ�����ƣ�·�������浽application��Χ��
		ServletContext application = sce.getServletContext();
		String path = application.getContextPath();
		application.setAttribute("APP_PATH", path);

	}

}
