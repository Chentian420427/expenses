<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul style="padding-left:0px;" class="list-group" id="menu">

			<c:forEach items="${rootPermission.children}" var="permission">
				<c:if test="${empty permission.children}">
					<li class="list-group-item"  style="padding:0;border:none;">
						
						<div class="parentMenu">
						<i class="${permission.icon}"></i> ${permission.name} 
						<span class="label label-info" style="float:right">1</span>
						</div> 

						<ul style="display:block;">
							<li class="childMenu">
								<a href="${APP_PATH}/main">
									<i class="fa fa-chevron-right "></i>
									<span> 主页</span>
								</a> 
							</li>	
						</ul>
					
					</li>
					
				</c:if>
				<c:if test="${not empty permission.children}">
					<li class="list-group-item" style="padding:0;border:none;">
						<div class="parentMenu">
						<i class="${permission.icon}"></i> ${permission.name} 
						<span class="label label-info" style="float:right">${permission.children.size()}</span>
						</div> 
						
						<ul style="display:block;">
							<li class="childMenu">
								<c:forEach items="${permission.children}" var="child">
	
										<a href="${APP_PATH}${child.url}">
											<i class="${child.icon}"></i>
											<span> ${child.name}</span>
										</a> 
	
								</c:forEach>
							</li>							
						</ul>
					</li>
				</c:if>
			</c:forEach>		
					
</ul>





