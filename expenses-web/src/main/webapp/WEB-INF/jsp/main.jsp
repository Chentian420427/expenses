<%@page import="freemarker.ext.servlet.IncludePage"%>
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
	<link rel="stylesheet" href="${APP_PATH}/css/menu.css">
	<link rel="stylesheet" href="${APP_PATH}/css/highcharts.css">
	<link rel="stylesheet" href="${APP_PATH}/css/grid-light.css">
	
	
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
        <div class="col-sm-3 col-md-2 sidebar"  style="background:#e9ecf3;top:90px;">
			<div class="tree">
				
				<%@include file="/WEB-INF/jsp/common/menu.jsp" %>
				
			</div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2" style="margin-top: 20px;padding-right:35px;background:#e9ecf3">
          <div class="row" style="background:white">
          	<div class="col-md-12">
          		<h1 class="page-header">控制面板</h1>
          	</div>
          </div>

          <div class="row placeholders" style="background:white">
            <div class="col-xs-6 col-sm-6 placeholder">
              <div id="userData" style="min-width:400px;height:400px"></div>
            </div> 
            <div class="col-xs-6 col-sm-6 placeholder">
              <div id="roleData"></div>
            </div>
           
            
            
          </div>
        </div>
      </div>
    </div>
    <script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/script/docs.min.js"></script>
	<script src="${APP_PATH}/script/highcharts.js"></script>
	<script src="${APP_PATH}/script/grid-light.js"></script>
	<script src="${APP_PATH}/script/clickActive.js"></script>
        <script type="text/javascript">
        
        	
        
            $(function () {
            	
            	var manNum = 0;
            	var womenNum = 0;
            	
			    $(".list-group-item").click(function(){
                    // jquery对象的回调方法中的this关键字为DOM对象
                    // $(DOM) ==> JQuery
				    if ( $(this).find("ul") ) { // 3 li
						$(this).toggleClass("tree-closed");
						if ( $(this).hasClass("tree-closed") ) {
							$("ul", this).hide("fast");
						} else {
							$("ul", this).show("fast");
						}
					}
				});
			    
			    sexData();
			    roleNum();
			    
			    
			    
			    
			    
			    
			    
			    
			    function sexData(){
			    	$.ajax({
			    		type:"POST",
			    		url:"${APP_PATH}/sexdata",
			    		async: false,
			    		success:function(result){
			    			if(result.success){
			    				
			    				Highcharts.chart('userData', {
			    			    	chart: {
			    			    		plotBackgroundColor: null,
			    			    		plotBorderWidth: null,
			    			    		plotShadow: false,
			    			    		type: 'pie'
			    			    	},
			    			    	credits: {
			                            enabled: false
			                        },
			    			    	title: {
			    			    		text: '男女个数分布图'
			    			    	},
			    			    	tooltip: {
			    			    		pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
			    			    	},
			    			    	plotOptions: {
			    			    		pie: {
			    			    			allowPointSelect: true,
			    			    			cursor: 'pointer',
			    			    			dataLabels: {
			    			    				enabled: false
			    			    			},
			    			    			showInLegend: true
			    			    		}
			    			    	},
			    			    	series: [{
			    			    		name: '百分比',
			    			    		colorByPoint: true,
			    			    		data: [{
			    			    			name: '男',
			    			    			y: result.data.manNum,
			    			    			sliced: true,
			    			    			selected: true
			    			    		}, {
			    			    			name: '女',
			    			    			y: result.data.womenNum
			    			    		}]
			    			    	}]
			    			    });
			    				
			    				
			    				
			    			}else{
			    				
			    			}
			    		}
			    		
			    	});
			    }
			    
			    
			    function roleNum(){
			    	$.ajax({
			    		type:"POST",
			    		url:"${APP_PATH}/rolenum",
			    		async: false,
			    		success:function(result){
			    			if(result.success){
			    				
			    				var data = result.data;
			    				var roleList = result.data.roleList;
			    				var rolenameArr = [];
			    				var numArr = [];
			    				for(var i=0;i<roleList.length;i++){
			    					rolenameArr[i]=roleList[i].name;
			    					numArr[i]=roleList[i].num;
			    				}
			    				
			    				console.log(data);
			    				console.log(rolenameArr);
			    				
			    				var chart = Highcharts.chart('roleData',{
			    			    	chart: {
			    			    		type: 'column'
			    			    	},
			    			    	credits: {
			                            enabled: false
			                        },
			    			    	title: {
			    			    		text: '人员分布柱形图'
			    			    	},
			    			    	xAxis: {
			    			    		categories: rolenameArr,
			    			    		crosshair: true
			    			    	},
			    			    	yAxis: {
			    			    		min: 0,
			    			    		title: {
			    			    			text: '人数 (个)'
			    			    		}
			    			    	},
			    			    	tooltip: {
			    			    		// head + 每个 point + footer 拼接成完整的 table
			    			    		headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
			    			    		pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
			    			    		'<td style="padding:0"><b>{point.y:.f} </b></td></tr>',
			    			    		footerFormat: '</table>',
			    			    		shared: true,
			    			    		useHTML: true
			    			    	},
			    			    	plotOptions: {
			    			    		column: {
			    			    			borderWidth: 0
			    			    		}
			    			    	},
			    			    	series: [{
			    			    		name: '人数',
			    			    		data: numArr
			    			    	}]
			    			    });
			    				
			    				
			    			}else{
			    				
			    			}
			    		}
			    		
			    	});
			    }
			    
			    
			    
			    
			    
			    
			    
			    
            });
        </script>
  </body>
</html>