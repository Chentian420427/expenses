<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

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
				  <li class="active">分配角色</li>
				</ol>
			<div class="panel panel-default">
			  <div class="panel-body">
				<form id="roleForm" role="form" class="form-inline">
				  <input type="hidden" name="userid" value="${user.id}">
				  <div class="form-group">
					<label for="exampleInputPassword1">未分配角色列表</label><br>
					<select name="unassignroleids" id="leftList" class="form-control" multiple size="10" style="width:150px;overflow-y:auto;">
					
                        <c:forEach items="${unassignedRoles}" var="role">
                        	 <option value="${role.id}">${role.name}</option>
                        </c:forEach>
                        
                       
                      
                    </select>
				  </div>
				  <div class="form-group">
                        <ul>
                            <li id="left2RigthBtn" class="btn btn-default glyphicon glyphicon-chevron-right"></li>
                            <br>
                            <li id="right2LeftBtn" class="btn btn-default glyphicon glyphicon-chevron-left" style="margin-top:20px;"></li>
                        </ul>
				  </div>
				  <div class="form-group" style="margin-left:40px;">
					<label for="exampleInputPassword1">已分配角色列表</label><br>
					<select name="assignroleids" id="rightList" class="form-control" multiple size="10" style="width:150px;overflow-y:auto;">
                         
                         <c:forEach items="${assignedRoles}" var="role">
                        	 <option value="${role.id}">${role.name}</option>
                        </c:forEach>
                        
                    </select>
				  </div>
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
			    
			    //添加角色 》
			    $("#left2RigthBtn").click(function(){
			    	var opts = $("#leftList :selected");
			    	if(opts.length == 0){
						layer.msg("请选择分配的角色！！", {time:1000, icon:5, shift:6}, function(){
	                		
	                	});
			    	}else{
			    		
			    		$.ajax({
			    			type:"POST",
			    			url:"${APP_PATH}/user/doAssign",
			    			data:$("#roleForm").serialize(),
			    			success:function(result){
			    				if(result.success){
			    					$("#rightList").append(opts);
									layer.msg("分配角色成功！！", {time:1000, icon:6}, function(){
				                		
				                	});
			    				}else{
			    					layer.msg("分配角色失败！！", {time:1000, icon:5, shift:6}, function(){
				                		
				                	});
			    				}
			    			}
			    		});
			    		
			    		
			    	}
			    
			    });
			    
			    //取消角色 《《
			    $("#right2LeftBtn").click(function(){
			    	var opts = $("#rightList :selected");
			    	if(opts.length == 0){
						layer.msg("请选择取消分配的角色！！", {time:1000, icon:5, shift:6}, function(){
	                		
	                	});
			    	}else{
			    		$.ajax({
			    			type:"POST",
			    			url:"${APP_PATH}/user/dounAssign",
			    			data:$("#roleForm").serialize(),
			    			success:function(result){
			    				if(result.success){
			    					$("#leftList").append(opts);
									layer.msg("取消分配角色成功！！", {time:1000, icon:6}, function(){
				                		
				                	});
			    				}else{
			    					layer.msg("取消分配角色失败！！", {time:1000, icon:5, shift:6}, function(){
				                		
				                	});
			    				}
			    			}
			    		});
			    	}
			    
			    });
			    
            });
        </script>
  </body>
</html>
