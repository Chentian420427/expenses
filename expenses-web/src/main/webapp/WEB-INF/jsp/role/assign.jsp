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

	<link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/main.css">
	<link rel="stylesheet" href="${APP_PATH}/ztree/zTreeStyle.css">
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
			<div class="panel panel-default">
			  <div class="panel-heading">
				<h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
			  </div>
			  <div class="panel-body">
			  	
			  	<button onclick="doAssign()" class="btn btn-success">分配权限</button>
			  
			  	<!-- 树形结构菜单 -->
				<ul id="permissionTree" class="ztree"></ul>
          		
			  </div>
			</div>
        </div>
      </div>
    </div>

    <script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/script/docs.min.js"></script>
	<script src="${APP_PATH}/layer/layer.js"></script>  
	<script src="${APP_PATH}/ztree/jquery.ztree.all-3.5.min.js"></script>  
	<script src="${APP_PATH}/script/clickActive.js"></script>
        <script type="text/javascript">
        	var likeflg = false;
            $(function() {
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
			    
			    var setting = {
			    		check:{
			    			enable:true
			    		},
			    		async:{
			    			enable:true,
			    			url:"${APP_PATH}/permission/loadAssignData?roleid=${param.id}",
			    			autoParam:["id","name=n","level=lv"]
			    		},
			    		view: {
			    			//不支持多选
							selectedMulti: false,
							//改变菜单的图标
							addDiyDom: function(treeId, treeNode){
								var icoObj = $("#" + treeNode.tId + "_ico"); // tId = permissionTree_1, $("#permissionTree_1_ico")
								if ( treeNode.icon ) {
									icoObj.removeClass("button ico_docu ico_open").addClass(treeNode.icon).css("background","");
								}
	                            
							}
						}

			    };
			    
			    
			    
			    //一步获取树形结构的数据
			    $.fn.zTree.init($("#permissionTree"), setting);
			   
            });
            
            function doAssign(){
            	var treeObj = $.fn.zTree.getZTreeObj("permissionTree");
            	var nodes = treeObj.getCheckedNodes(true);
            	
            	if(nodes.length == 0){
					layer.msg("请选择要分配的权限", {time:1000, icon:5, shift:6}, function(){
                		
                	});
            	}else{
            		
            		var d = "roleid=${param.id}";
            		$.each(nodes,function(n,node){
            			d += "&permissionids="+node.id;
            		});
            		
            		$.ajax({
            			type:"POST",
            			url:"${APP_PATH}/role/doAssign",
            			data:d,
            			success:function(result){
            				if(result.success){
								layer.msg("分配权限成功", {time:1000, icon:6}, function(){
                            		
                            	});
            				}else{
            					layer.msg("分配权限失败", {time:1000, icon:5, shift:6}, function(){
                            		
                            	});
            				}
            			}
            		});
            	}
            }
            
            
            
        </script>
  </body>
</html>
