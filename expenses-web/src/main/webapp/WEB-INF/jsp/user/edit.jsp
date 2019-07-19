<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	<link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.css">
	<link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/main.css">
	<link rel="stylesheet" href="${APP_PATH}/css/doc.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/menu.css">
	<style>
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	.tree-closed {
	    height : 40px;
	}
	.tree-expanded {
	    height : auto;
	}
	.tree a {
		text-decoration:none;
	}
	.menuactive span,.menuactive i{
	font-size: 16px;
	color:#5b9bd1;
	}
	.menuactive {
	background:#f2f6f9;
	
	display: block;
	}
	.parentactive {
	color:#5b9bd1;
	background:#f2f6f9;
	border-left: 3px solid;
	display: block;
	}
	</style>
  </head>

  <body>

    <div class="container-fluid">
   		<%@include file="/WEB-INF/jsp/common/head.jsp" %>
    </div>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar"  style="background:#e9ecf3;top:90px">
			<div class="tree">
				
				<%@include file="/WEB-INF/jsp/common/menu.jsp" %>
				
			</div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2" style="margin-top: 20px;background:#e9ecf3">
				<ol class="breadcrumb" style="background:#e9ecf3">
				  <li><a href="${APP_PATH}/main">首页</a></li>
				  <li><a href="${APP_PATH}/user/index">数据列表</a></li>
				  <li class="active">修改</li>
				</ol>
			<div class="panel panel-default">
              <div class="panel-heading">表单数据<div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-question-sign"></i></div></div>
			  <div class="panel-body">
				<form id="userForm" role="form">
				  <div class="form-group">
					<label for="exampleInputPassword1">登陆账号</label>
					<input type="text" class="form-control" id="loginacct" value="${user.loginacct}" placeholder="请输入登陆账号">
				  </div>
				 
				  <div class="form-group">
					<label for="exampleInputPassword1">工号</label>
					<input type="text" class="form-control" id="jobnum" value="${user.jobnum}" placeholder="请输入用户工号">
				  </div>
				  <div class="form-group">
					<label for="exampleInputPassword1">姓名</label>
					<input type="text" class="form-control" id="username" value="${user.username}" placeholder="请输入用户名称">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">性别</label>
					<select class="form-control" id="sex">
		                <option ${user.sex=='男'?'selected':'' } value="男">男</option>
		                <option ${user.sex=='女'?'selected':'' } value="女">女</option>
		            </select>
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleInputPassword1">机构</label>
					<select class="form-control" id="agency">
		                <option ${user.agency=='开发部'?'selected':'' } value="开发部">开发部</option>
		                <option ${user.agency=='人事部'?'selected':'' } value="人事部">人事部</option>
		                <option ${user.agency=='财务部'?'selected':'' } value="财务部">财务部</option>
		                <option ${user.agency=='设计部'?'selected':'' } value="设计部">设计部</option>
		            </select>
				  </div>
				  								 
				  <button id="updateBtn" type="button" class="btn btn-success"><i class="glyphicon glyphicon-pencil"></i> 修改</button>
				  <button id="resetBtn" type="button" class="btn btn-danger"><i class="glyphicon glyphicon-refresh"></i> 重置</button>
				</form>
			  </div>
			</div>
        </div>
      </div>
    </div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
		<div class="modal-content">
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
			<h4 class="modal-title" id="myModalLabel">帮助</h4>
		  </div>
		  <div class="modal-body">
			<div class="bs-callout bs-callout-info">
				<h4>测试标题1</h4>
				<p>测试内容1，测试内容1，测试内容1，测试内容1，测试内容1，测试内容1</p>
			  </div>
			<div class="bs-callout bs-callout-info">
				<h4>测试标题2</h4>
				<p>测试内容2，测试内容2，测试内容2，测试内容2，测试内容2，测试内容2</p>
			  </div>
		  </div>
		  <!--
		  <div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<button type="button" class="btn btn-primary">Save changes</button>
		  </div>
		  -->
		</div>
	  </div>
	</div>
    <script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/script/docs.min.js"></script>
	<script src="${APP_PATH}/layer/layer.js"></script>
	<script src="${APP_PATH}/script/clickActive.js"></script>
        <script type="text/javascript">
            $(function () {
			    $(".list-group-item").click(function(){
				    if ( $(this).find("ul") ) {
						$(this).toggleClass("tree-closed");
						if ( $(this).hasClass("tree-closed") ) {
							$("ul", this).hide("fast");
						} else {
							$("ul", this).show("fast");
						}
					}
				});
			    
			    
			    
			    //重置
			    $("#resetBtn").click(function(){
			    	// jquery 变成  dom对象 
			    	
			    	$("#userForm")[0].reset();

			    });
			    
			    
			    $("#updateBtn").click(function(){
			    	
			    	var loginacct = $("#loginacct").val();
			    	var jobnum = $("#jobnum").val();
			    	var username = $("#username").val();
			    	var sex = $("#sex").val();
			    	var agency = $("#agency").val();
			    	if(loginacct==""){
			    		layer.msg("账号不能为空", {time:1000, icon:5, shift:6}, function(){
	                		
	                	});
			    		return;
			    	}
			    	if(jobnum==""){
			    		layer.msg("工号不能为空", {time:1000, icon:5, shift:6}, function(){
	                		
	                	});
			    		return;
			    	}
			    	if(username==""){
			    		layer.msg("姓名不能为空", {time:1000, icon:5, shift:6}, function(){
	                		
	                	});
			    		return;
			    	}
			    	if(sex==""){
			    		layer.msg("性别不能为空", {time:1000, icon:5, shift:6}, function(){
	                		
	                	});
			    		return;
			    	}
			    	if(agency==""){
			    		layer.msg("机构不能为空", {time:1000, icon:5, shift:6}, function(){
	                		
	                	});
			    		return;
			    	}
			    	
			    	var loadingIndex = null;
			    	
			    	$.ajax({
			    		type: "POST",
			    		url: "${APP_PATH}/user/update",
			    		data: {
			    			"loginacct":loginacct,
			    			"jobnum":$("#jobnum").val(),
			    			"username":$("#username").val(),
			    			"sex":$("#sex").val(),
			    			"agency":$("#agency").val(),
			    			"id":${user.id}
			    		},
			    		beforeSend:function(){
							loadingIndex = layer.msg('正在添加用户，请稍等', {icon: 16});
			    		},
			    		success:function(result){
			    			layer.close(loadingIndex);
			    			if(result.success){
								layer.msg("修改成功", {time:1000, icon:6}, function(){
			                		window.location.href="${APP_PATH}/user/index";
			                	});
			    			}else{
			    				layer.msg("用户信息修改失败，请重新操作", {time:1000, icon:5, shift:6}, function(){
			                		
			                	});
			    			}
			    		}
			    	});
			    	
			    });
            });
        </script>
  </body>
</html>
