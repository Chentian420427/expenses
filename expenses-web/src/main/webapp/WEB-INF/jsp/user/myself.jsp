<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
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
</style>

</head>
<body>

	<!--  修改密码模态框 -->
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">修改密码</h4>
	      </div>
	      <div class="modal-body">
			<form id="passwordForm">
			
			  <div class="form-group">
			    <label for="exampleInputEmail1">旧密码</label>
			    <input type="password" class="form-control" id="oldpassword" value="" placeholder="请输入旧密码">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">新密码</label>
			    <input type="password" class="form-control" id="newpassword" value="" placeholder="请输入新密码">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">确认密码</label>
			    <input type="password" class="form-control" id="confirmpassword" value="" placeholder="请输入再次输入新密码">
			  </div>
			  		
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" id="passwordsaveBtn" class="btn btn-primary">保存</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!--  修改密码模态框 -->
	
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
				<ol class="breadcrumb">
				  <li><a href="#">首页</a></li>
				  <li><a href="#">数据列表</a></li>
				  <li class="active">个人信息</li>
				</ol>
			<div class="panel panel-default">
              <div class="panel-heading">个人信息<div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-question-sign"></i></div></div>
			  <div class="panel-body">
					
		<form id="userData" class="form-horizontal">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
			<input type="hidden" name="userId" value="" />
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户姓名</label>
					<div class="col-xs-9 ">
						<input type="text" class="form-control" required name="username" value="${loginUser.username}" placeholder="请输入用户姓名" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">工号</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">
						 	${loginUser.jobnum}
						 </p>
					<input type="hidden" name="jobnum" value="${loginUser.jobnum}">	
					<input type="hidden" name="userid" value="${loginUser.id}">	
					</div>
				</div>
			</div>
			
		</div>
		<!--结束1 -->
		<!-- 开始2 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户性别</label>
					<div class="col-xs-3 ">
						<select name="sex" class="form-control">
							<option ${loginUser.sex=='男'?'selected':'' } value="男">男</option>
							<option ${loginUser.sex=='女'?'selected':'' } value="女">女</option>
						</select>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">账号创建时间</label>
					<div class="col-xs-9 ">
					
						<p class="form-control-static">
							<fmt:formatDate value="${loginUser.startdate}" type="both"/> 
						</p>
						<input type="hidden" name="startdate" value="${loginUser.startdate}">
					</div>
				</div>
			</div>
		</div>
		<!--结束2 -->
		<!-- 开始3 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户角色</label>
					<div class="col-xs-4 ">
						 <p class="form-control-static">${loginUser.name}</p>
						<input type="hidden" name="name" value="${loginUser.name}">
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">密码最后修改时间</label>
					<div class="col-xs-9 ">
						 <p class="form-control-static">
						 	<fmt:formatDate value="${loginUser.updatedate}" type="both"/> 
						 </p>
					<input type="hidden" name="updatedate" value="${loginUser.updatedate}">
					</div>
				</div>
			</div>
		</div>
		<!--结束3 -->

		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">账号信息</h5>
		<!-- 开始5 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户账号</label>
					<div class="col-xs-9">
					 <p class="form-control-static">${loginUser.loginacct}</p>
						<input type="hidden" name="loginacct" value="${loginUser.loginacct}">
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户密码</label>
					<div class="col-xs-9 ">
						<input type="button" class="btn btn-success" value="修改密码" id="updatePwd" />
					</div>
				</div>
			</div>
		</div>
		<!--结束5 -->

		

	</form>
	<div class="row">
			<div class="col-xs-3 col-xs-offset-4">
				<input id="updateBtn" type="button" class="btn btn-success" value="修改个人信息" /> 
			</div>

	</div>
					
					
			  </div>
			</div>
        </div>
      </div>
    </div>
	
	


	<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/script/docs.min.js"></script>
	<script src="${APP_PATH}/layer/layer.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$("#updateBtn").click(function(){
		    	
		    	var username = $("#username").val();
		    	if(username==""){
		    		layer.msg("名称不能为空", {time:1000, icon:5, shift:6}, function(){
                		
                	});
		    		return;
		    	}
		    	
		    	
		    	
		    	
		    	var loadingIndex = null;
		    	console.log($("#userData").serialize());
		    	$.ajax({
		    		type: "POST",
		    		url: "${APP_PATH}/user/updatemyself",
		    		data: $("#userData").serialize(),
		    		beforeSend:function(){
						loadingIndex = layer.msg('正在修改个人信息，请稍等', {icon: 16});
		    		},
		    		success:function(result){
		    			layer.close(loadingIndex);
		    			if(result.success){
							layer.msg("修改成功", {time:1000, icon:6}, function(){
		                		window.location.href="${APP_PATH}/user/myself";
		                	});
		    			}else{
		    				layer.msg("个人信息修改失败，请重新操作", {time:1000, icon:5, shift:6}, function(){
		                		
		                	});
		    			}
		    		}
		    	});
		    	
		    });
			
			$("#oldpassword").blur(function(){
				var oldpwd = $("#oldpassword").val();
				var regPass = /^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\W_]+$)(?![a-z0-9]+$)(?![a-z\W_]+$)(?![0-9\W_]+$)[a-zA-Z0-9\W_]{8,}$/;
				
				if(!regPass.test(oldpwd) || oldpwd==""){
					layer.msg("密码格式不正确，必须由数字、字母和特殊符号组成", {time:1000, icon:5, shift:6}, function(){
                		
                	});
					$("#passwordsaveBtn").attr('disabled',true);
					$("#oldpassword").parent().addClass("has-error");
					
		    		return;
				}else{
					$("#oldpassword").parent().removeClass("has-error");
					$("#passwordsaveBtn").attr('disabled',false);
				}
				
			});
			
			$("#newpassword").blur(function(){
				var newpwd = $("#newpassword").val();
				var regPass = /^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\W_]+$)(?![a-z0-9]+$)(?![a-z\W_]+$)(?![0-9\W_]+$)[a-zA-Z0-9\W_]{8,}$/;
				
				if(!regPass.test(newpwd) || newpwd==""){
					layer.msg("密码格式不正确，必须由数字、字母和特殊符号组成", {time:1000, icon:5, shift:6}, function(){
                		
                	});
					$("#newpassword").parent().addClass("has-error");
					$("#passwordsaveBtn").attr('disabled',true);
		    		return;
				}else{
					$("#newpassword").parent().removeClass("has-error");
					$("#passwordsaveBtn").attr('disabled',false);
				}
				
			});
			
			$("#confirmpassword").blur(function(){
				var confirmpwd = $("#confirmpassword").val();
				var regPass = /^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\W_]+$)(?![a-z0-9]+$)(?![a-z\W_]+$)(?![0-9\W_]+$)[a-zA-Z0-9\W_]{8,}$/;
				
				if(!regPass.test(confirmpwd) || confirmpwd==""){
					layer.msg("密码格式不正确，必须由数字、字母和特殊符号组成", {time:1000, icon:5, shift:6}, function(){
                		
                	});
					$("#confirmpassword").parent().addClass("has-error");
					$("#passwordsaveBtn").attr('disabled',true);
		    		return;
				}else{
					$("#confirmpassword").parent().removeClass("has-error");
					$("#passwordsaveBtn").attr('disabled',false);
				}
				
			});
			
			
			//打开修改密码模态框
			$("#updatePwd").click(function(){
				
				$("#passwordForm")[0].reset();
				
				$("#updateModal").modal({
					backdrop:"static"
				});
				
				
				
			});
			
			$("#passwordsaveBtn").click(function(){
				
				var oldpwd = $("#oldpassword").val();
				var newpwd = $("#newpassword").val();
				var confirmpwd = $("#confirmpassword").val();
				
				
				
				console.log(oldpwd);
				console.log(newpwd);
				console.log(confirmpwd);
				
				var loadingIndex = null;
				$.ajax({
					type:"POST",
					url:"${APP_PATH}/user/updatepassword",
					data:{
						oldpassword:oldpwd,
						newpassword:newpwd,
						confirmpassword:confirmpwd,
						loginacct:"${loginUser.loginacct}"
					},
					beforeSend:function(){
						loadingIndex = layer.msg('正在修改个人信息，请稍等', {icon: 16});
		    		},
					success:function(result){
						layer.close(loadingIndex);
						if(result.success){
							layer.msg("修改成功", {time:1000, icon:6}, function(){
		                		window.location.href="${APP_PATH}/user/myself";
		                	});
		    			}else{
		    				layer.msg("密码修改失败，请重新操作", {time:1000, icon:5, shift:6}, function(){
		                		
		                	});
		    			}
					}
				});
			});
			
			
		});
	</script>

</body>
</html>