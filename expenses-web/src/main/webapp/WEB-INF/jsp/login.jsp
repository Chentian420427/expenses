<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	
	<style type="text/css">
		.form-bg{
		    background: #e9ecf3;
		}
		.form-horizontal{
		    background: #fff;
		    padding-bottom: 40px;
		    border-radius: 15px;
		    text-align: center;
		}
		.form-horizontal .heading{
		    display: block;
		    font-size: 35px;
		    font-weight: 700;
		    padding: 35px 0;
		    border-bottom: 1px solid #f0f0f0;
		    margin-bottom: 30px;
		}
		.form-horizontal .form-group{
		    padding: 0 40px;
		    margin: 0 0 25px 0;
		    position: relative;
		}
		.form-horizontal .form-control{
		    background: #f0f0f0;
		    border: none;
		    border-radius: 20px;
		    box-shadow: none;
		    padding: 0 20px 0 45px;
		    height: 40px;
		    transition: all 0.3s ease 0s;
		}
		.form-horizontal .form-control:focus{
		    background: #e0e0e0;
		    box-shadow: none;
		    outline: 0 none;
		}
		.form-horizontal .form-group i{
		    position: absolute;
		    top: 12px;
		    left: 60px;
		    font-size: 17px;
		    color: #c8c8c8;
		    transition : all 0.5s ease 0s;
		}
		.form-horizontal .form-control:focus + i{
		    color: #00b4ef;
		}
		.form-horizontal .fa-question-circle{
		    display: inline-block;
		    position: absolute;
		    top: 12px;
		    right: 60px;
		    font-size: 20px;
		    color: #808080;
		    transition: all 0.5s ease 0s;
		}
		.form-horizontal .fa-question-circle:hover{
		    color: #000;
		}
		.form-horizontal .main-checkbox{
		    float: left;
		    width: 20px;
		    height: 20px;
		    background: #11a3fc;
		    border-radius: 50%;
		    position: relative;
		    margin: 5px 0 0 5px;
		    border: 1px solid #11a3fc;
		}
		.form-horizontal .main-checkbox label{
		    width: 20px;
		    height: 20px;
		    position: absolute;
		    top: 0;
		    left: 0;
		    cursor: pointer;
		}
		.form-horizontal .main-checkbox label:after{
		    content: "";
		    width: 10px;
		    height: 5px;
		    position: absolute;
		    top: 5px;
		    left: 4px;
		    border: 3px solid #fff;
		    border-top: none;
		    border-right: none;
		    background: transparent;
		    opacity: 0;
		    -webkit-transform: rotate(-45deg);
		    transform: rotate(-45deg);
		}
		.form-horizontal .main-checkbox input[type=checkbox]{
		    visibility: hidden;
		}
		.form-horizontal .main-checkbox input[type=checkbox]:checked + label:after{
		    opacity: 1;
		}
		.form-horizontal .text{
		    float: left;
		    margin-left: 7px;
		    line-height: 20px;
		    padding-top: 5px;
		    text-transform: capitalize;
		}
		.form-horizontal .btn{
		    float: right;
		    font-size: 14px;
		    color: #fff;
		    background: #00b4ef;
		    border-radius: 30px;
		    padding: 10px 25px;
		    border: none;
		    text-transform: capitalize;
		    transition: all 0.5s ease 0s;
		}
		@media only screen and (max-width: 479px){
		    .form-horizontal .form-group{
		        padding: 0 25px;
		    }
		    .form-horizontal .form-group i{
		        left: 45px;
		    }
		    .form-horizontal .btn{
		        padding: 10px 20px;
		    }
		}
	</style>
  </head>
  <body style="background:#e9ecf3">
    <div class="htmleaf-container">
		
		<div class="demo form-bg" style="padding: 20px 0;">
		        <div class="container">
		            <div class="row">
		                <div class="col-md-offset-3 col-md-6">
		                    <form class="form-horizontal" id="loginForm" action="doLogin" method="post" >
		                        <span class="heading" style="color:#00b4ef">用户登录</span>
		                        <h4 style="color:red">${param.errorMsg }</h4>
		                        <div class="form-group">
		                            <input type="text" class="form-control" name="loginacct" id="loginacct" placeholder="工 号">

		                        </div>
		                        
		                        <div class="form-group">
		                            <input type="password" class="form-control" name="userpswd" id="userpswd" placeholder="密　码">

		                        </div>
		                        
		                         <div class="form-group">
								   <div class="row">
									    <div class="col-md-8">
									    	<input type="text" class="form-control" id="vcode" placeholder="验 证 码">
									    </div>
									    <div class="col-md-4">
									    	<img alt="验证码" id="vimg" src="${APP_PATH}/createCode">
									    </div>
								   </div>
								    
								</div>
								
								
								
								
		                        <div class="form-group">
		                            <div class="main-checkbox">
		                                <input type="checkbox" value="None" id="checkbox1" name="check"/>
		                                <label for="checkbox1"></label>
		                            </div>
		                            <span class="text">记住 我</span>
		                            <div class="row">
		                            	<div class="col-md-4">
		                            	  <label>
							           		 	忘记密码
							          	  </label>
								         
		                            	</div>
		                            </div>
		                            
							         
		                            
		                            <a href="javascript:;" class="btn btn-default" id="login_btn" onclick="dologin()">登录</a>
		                            
		                        </div>
		                        
		                       
		                        
		                    </form>
		                </div>
		            </div>
		        </div>
		    </div>
		
	</div>
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="layer/layer.js"></script>    
    <script>
    
    $("#vimg").click(function(){
    	$("#vimg").attr('src',"${APP_PATH}/createCode?"+new Date()); 
    });
    
    
    
    function dologin() {
        //非空校验
        var loginacct = $("#loginacct").val();
        if(loginacct == ""){
        	layer.msg("用户登录账号不能为空", {time:1000, icon:5, shift:6}, function(){
        		
        	});
        	return;
        }
        var userpswd = $("#userpswd").val();
        if(userpswd == ""){
			layer.msg("登录密码不能为空", {time:1000, icon:5, shift:6}, function(){
        		
        	});
        	return;
        }
        
        //提交表单
        //$("#loginForm").submit();
        //ajax登录
        var loadingIndex = null;
        $.ajax({
        	type:"POST",
        	url:"doAjaxLogin",
        	data:{
        		"loginacct":loginacct,
        		"userpswd":userpswd,
        		"vcode":$("#vcode").val()
        	},
        	beforeSend: function(){
        		loadingIndex = layer.msg('登录中，请稍等', {icon: 16});
        	},
        	success:function(result){
        		layer.close(loadingIndex);
        		if(result.success){
        			window.location.href="main";
        		}else{
        			layer.msg(result.data.errorMsg, {time:1000, icon:5, shift:6}, function(){
                		
                	});
        		}
        	}
        });
    }
    </script>
  </body>
</html>