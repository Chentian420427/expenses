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
  
  	<!--  批改请假条模态框 -->
	<div class="modal fade" id="approvalexpenseModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">修改请假单</h4>
	      </div>
	      <div class="modal-body">
			<form id="passwordForm">
			
			  <div class="form-group">
			    <label for="exampleInputEmail1">报销原因</label>
			    <input disabled="disabled" type="text" class="form-control" id="approvalexpensereason" value="" placeholder="请输入报销原因">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">报销内容</label>
			    <textarea disabled="disabled" class="form-control" rows="7" id="approvalexpensedetail"></textarea>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail1">报销金额</label>
			    <input disabled="disabled" type="text" class="form-control" id="approvalexpensecost" value="" placeholder="请输入报销金额">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">反馈信息</label>
			    <textarea class="form-control" rows="3" id="approvalexpensefeedback"></textarea>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">审批状态</label>
			    
				<label class="radio-inline">
				  <input type="radio" name="status" id="approvalexpensestatus" checked value="2"> 审批通过
				</label>
				<label class="radio-inline">
				  <input type="radio" name="status" id="approvalexpensestatus" value="-2"> 不通过
				</label>
			  </div>
			 
			  		
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" id="approvalexpensesaveBtn" class="btn btn-primary">保存</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!--  批改请假条模态框 -->
  
  	
  
  
  
  
  
  
  
  

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
		<form class="form-inline" expense="form" style="float:left;">
		  <div class="form-group has-feedback">
		    <div class="input-group">
		      <div class="input-group-addon">查询条件</div>
		      <input id="queryText" class="form-control has-success" type="text" placeholder="请输入查询条件">
		    </div>
		  </div>
		  <button id="queryBtn" type="button" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
		</form>
	<br>
	 <hr style="clear:both;">
          <div class="table-responsive">
          <form id="expenseForm">
            <table class="table  table-hover">
              <thead>
                <tr >
                  <th width="30">#</th>
				  <th width="30"><input type="checkbox" id="allSelBox"></th>
				  <th>报销人</th>
                  <th>报销原因</th>
                  <th>报销金额</th>
                  <th>报销时间</th>
                  <th>报销状态</th>
                  <th width="100">操作</th>
                </tr>
              </thead>
              
              
              <tbody id="expenseData">
              		
 
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
			    	
			    	$("#expenseData :checkbox").each(function(){
			    		this.checked = flg;
			    	});
			    });
			    
            });
            $("tbody .btn-success").click(function(){
                window.location.href = "assignexpense.html";
            });
            $("tbody .btn-primary").click(function(){
                window.location.href = "approval.html";
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
				
				var jsonData = {"pn" : pn,"pagesize" : 5,"userid":${loginUser.id}};
				if(likeflg==true){
					jsonData.queryText = $("#queryText").val();
				}
				
				$.ajax({
					type: "POST",
					url: "${APP_PATH}/expense/pageQueryFinance",
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
							var expensePage = result.data;
							var expenses = expensePage.datas;
							
							$.each(expenses, function(i,expense){
								tableContent += '<tr>';
								tableContent += '	<td>'+(i+1)+'</td>';
								tableContent += '	<td><input type="checkbox" name="id" value="'+expense.id+'"></td>';
								tableContent += '	<td>'+expense.username+'</td>';
								tableContent += '	<td>'+expense.expense_reason+'</td>';
								tableContent += '	<td>'+expense.expense_cost+'</td>';
								tableContent += '	<td>'+getMyDate(expense.createtime)+'</td>';
								tableContent += '	<td>'+expense.status+'</td>';
								tableContent += '	<td>';
								tableContent += '      <button type="button" onclick="goApprovalPage('+expense.id+')" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>';
								tableContent += '	</td>';
								tableContent += '</tr>';
							});
							
							if(pn > 1){
								pageContent += '<li><a href="#" onclick="pageQuery('+(pn-1)+')">上一页</a></li>';
							}
							
							for( var i= 1;i<=expensePage.totalpn;i++){
								if(i == pn){
									pageContent += '<li class="active"><a href="#" onclick="pageQuery('+i+')">'+i+'</a></li>';
								}else{
									pageContent += '<li><a href="#" onclick="pageQuery('+i+')">'+i+'</a></li>';
								}
							}
							
							if(pn < expensePage.totalpn){
								pageContent += '<li><a href="#" onclick="pageQuery('+(pn+1)+')">下一页</a></li>';
							}
							
							
							$("#expenseData").html(tableContent);
							$(".pagination").html(pageContent);
							
						    }else{
							
						    	layer.msg("网络异常，查询失败", {time:1000, icon:5, shift:6}, function(){
		                		
		                	});
						}
					}
				});
			}
            
           
            
            
            //跳转批准页面
            function goApprovalPage(id){
            	
            	$.ajax({
            		type:"POST",
            		url:"${APP_PATH}/expense/queryById",
            		data:{id:id},
            		success:function(result){
            			if(result.success){
            				console.log(result.data);
            				$("#approvalexpensereason").val(result.data.expense_reason);
            				$("#approvalexpensedetail").val(result.data.expense_detail);
            				$("#approvalexpensecost").val(result.data.expense_cost);
            				$("#approvalexpensesaveBtn").attr("approval-id",id);
            			}else{
            				
            			}
            		}
            	});
            	
            	
            	$("#approvalexpenseModal").modal({
					backdrop:"static"
				});
            	
            	
            }
            
            //经理审批按钮
            $("#approvalexpensesaveBtn").click(function(){
            	
            	$.ajax({
            		type:"POST",
            		url:"${APP_PATH}/expense/approvalFinance",
            		data:{
            			id:$("#approvalexpensesaveBtn").attr("approval-id"),
            			status:$('input[name="status"]:checked').val(),
            			feedback:$("#approvalexpensefeedback").val()
            			 
            		},
            		success:function(result){
            			if(result.success){
							layer.msg("保存成功", {time:1000, icon:6}, function(){
								$("#approvalexpenseModal").modal("hide");
								pageQuery(1);
		                	});
            			}else{
            				layer.msg("保存失败", {time:1000, icon:5, shift:6}, function(){
		                		
		                	});
            			}
            		}
            	});
            });
            
            
            
            
           
            
            
        </script>
  </body>
</html>
