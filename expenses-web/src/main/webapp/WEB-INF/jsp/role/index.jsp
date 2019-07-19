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
<form class="form-inline" role="form" style="float:left;">
  <div class="form-group has-feedback">
    <div class="input-group">
      <div class="input-group-addon">查询条件</div>
      <input id="queryText" class="form-control has-success" type="text" placeholder="请输入查询条件">
    </div>
  </div>
  <button id="queryBtn" type="button" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
</form>
<button type="button" class="btn btn-danger" onclick="deleteroles()" style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 删除</button>
<button type="button" class="btn btn-primary" style="float:right;" onclick="window.location.href='${APP_PATH}/role/add'"><i class="glyphicon glyphicon-plus"></i> 新增</button>
<br>
 <hr style="clear:both;">
          <div class="table-responsive">
          <form id="roleForm">
            <table class="table  table-hover">
              <thead>
                <tr >
                  <th width="30">#</th>
				  <th width="30"><input type="checkbox" id="allSelBox"></th>
                  <th>角色名称</th>
                  <th>授权时间</th>
                  <th width="100">操作</th>
                </tr>
              </thead>
              
              
              <tbody id="roleData">
              		
 
              </tbody>
              
              
			  <tfoot>
			     <tr >
				     <td colspan="9" align="center">
						<ul class="pagination">
															
								
																
							 </ul>
					 </td>
				 </tr>

			  </tfoot>
            </table>
            </form>
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
			    pageQuery(1);
			    
			    $("#queryBtn").click(function(){
			    	var queryText = $("#queryText").val();
			    	if(queryText == ""){
			    		likeflg =false;
			    	}else{
			    		likeflg=true;
			    	}
			    	
			    	pageQuery(1);
			    });
			    
			    //全选按钮
			    $("#allSelBox").click(function(){
			    	var flg = this.checked;
			    	
			    	$("#roleData :checkbox").each(function(){
			    		this.checked = flg;
			    	});
			    });
			    
            });
            $("tbody .btn-success").click(function(){
                window.location.href = "assignRole.html";
            });
            $("tbody .btn-primary").click(function(){
                window.location.href = "edit.html";
            });
            
            //解析json里的date
    		function getMyDate(str){  
                var oDate = new Date(str),  
                oYear = oDate.getFullYear(),  
                oMonth = oDate.getMonth()+1,  
                oDay = oDate.getDate(),  
                oHour = oDate.getHours(),  
                oMin = oDate.getMinutes(),  
                oSen = oDate.getSeconds(),  
                oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间  
                return oTime;  
            }; 
            //补0操作
            function getzf(num){  
              if(parseInt(num) < 10){  
                  num = '0'+num;  
              }  
              return num;  
            }
            
            //分页查询
			function pageQuery(pn){
				var loadingIndex = null;
				
				var jsonData = {"pn" : pn,"pagesize" : 5};
				if(likeflg==true){
					jsonData.queryText = $("#queryText").val();
				}
				
				$.ajax({
					type: "POST",
					url: "${APP_PATH}/role/pageQuery",
					data:jsonData,
					beforSend:function(){
						loadingIndex = layer.msg('正在查询数据，请稍等', {icon: 16});
					},
					success:function(result){
						layer.close(loadingIndex);
						if(result.success){
							// 局部刷新页面数据
							var tableContent = "";
							var pageContent = "";
							
							//分页数据
							var rolePage = result.data;
							var roles = rolePage.datas;
							
							$.each(roles, function(i,role){
								tableContent += '<tr>';
								tableContent += '	<td>'+(i+1)+'</td>';
								tableContent += '	<td><input type="checkbox" name="roleid" value="'+role.id+'"></td>';
								tableContent += '	<td>'+role.name+'</td>';
								tableContent += '	<td>'+getMyDate(role.assigndate)+'</td>';
								tableContent += '	<td>';
								tableContent += '	  <button type="button" onclick="goAssignPage('+role.id+')" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></button>';
								tableContent += '      <button type="button" onclick="goUpdatePage('+role.id+')" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>';
								tableContent += '	  <button type="button" onclick="deleterole('+role.id+',\''+role.name+'\')" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>';
								tableContent += '	</td>';
								tableContent += '</tr>';
							});
							
							if(pn > 1){
								pageContent += '<li><a href="#" onclick="pageQuery('+(pn-1)+')">上一页</a></li>';
							}
							
							for( var i= 1;i<=rolePage.totalpn;i++){
								if(i == pn){
									pageContent += '<li class="active"><a href="#" onclick="pageQuery('+i+')">'+i+'</a></li>';
								}else{
									pageContent += '<li><a href="#" onclick="pageQuery('+i+')">'+i+'</a></li>';
								}
							}
							
							if(pn < rolePage.totalpn){
								pageContent += '<li><a href="#" onclick="pageQuery('+(pn+1)+')">下一页</a></li>';
							}
							
							
							$("#roleData").html(tableContent);
							$(".pagination").html(pageContent);
							
						    }else{
							
						    	layer.msg("网络异常，查询失败", {time:1000, icon:5, shift:6}, function(){
		                		
		                	});
						}
					}
				});
			}
            
            //跳转到分配页面
            function goAssignPage(id){
            	window.location.href = "${APP_PATH}/role/assign?id="+id;
            }
            
            
            //跳转修改页面
            function goUpdatePage(id){
            	window.location.href = "${APP_PATH}/role/edit?id="+id;
            }
            
            
            function deleteroles(){
            	var boxes = $("#roleData :checkbox");
            	if(boxes.length == 0){
            		layer.msg("请选择要删除的用户", {time:1000, icon:5, shift:6}, function(){
                		
                	});
            	}else{
            		layer.confirm("是否要删除选择的用户信息",  {icon: 3, title:'提示'}, function(cindex){
        			    
            			
                		//删除选择用户信息
                		$.ajax({
                			type:"POST",
                			url:"${APP_PATH}/role/deletes",
                			data:$("#roleForm").serialize(),
                			success:function(result){
                				if(result.success){
                					pageQuery(1);
                				}else{
                					layer.msg("用户删除失败", {time:1000, icon:5, shift:6}, function(){
        		                		
        		                	});
                				}
                			}
                		});
                		
                		
                		
                		layer.close(cindex);
        			}, function(cindex){
        			    layer.close(cindex);
        			});
            	}
            }
            
            //删除用户
            function deleterole(id,rolename){
            	layer.confirm("是否要删除【"+rolename+"】",  {icon: 3, title:'提示'}, function(cindex){
    			    
            		//删除用户信息
            		$.ajax({
            			type:"POST",
            			url:"${APP_PATH}/role/delete",
            			data:{id:id},
            			success:function(result){
            				if(result.success){
            					pageQuery(1);
            				}else{
            					layer.msg("用户删除失败", {time:1000, icon:5, shift:6}, function(){
    		                		
    		                	});
            				}
            			}
            		});
            		
            		
            		
            		layer.close(cindex);
    			}, function(cindex){
    			    layer.close(cindex);
    			});
            }
            
            
        </script>
  </body>
</html>
