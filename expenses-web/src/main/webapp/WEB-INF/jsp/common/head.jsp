<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="row" style="margin-bottom: 40px">
<nav class="navbar  navbar-fixed-top" role="navigation" style="background:white;padding:15px">
      <div class="container-fluid">
        <div class="navbar-header">
          <div><a class="navbar-brand" style="font-size:25px;" href="${APP_PATH}/main">用户权限管理系统</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li style="padding-top:8px;">
				<div class="btn-group">
				  <button type="button" class="btn btn-default btn-info dropdown-toggle" data-toggle="dropdown">
					<i class="glyphicon glyphicon-user"></i>${loginUser.jobnum} : ${loginUser.username} <span class="caret"></span>
				  </button>
					  <ul class="dropdown-menu" role="menu">
						<li><a href="${APP_PATH}/user/myself"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
						<li><a href="${APP_PATH}/main"><i class="glyphicon glyphicon-comment"></i> 主页</a></li>
						<li class="divider"></li>
						<li><a href="${APP_PATH}/logout"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
					  </ul>
			    </div>
			</li>
            
          </ul>
          
        </div>
      </div>
    </nav>
</div>