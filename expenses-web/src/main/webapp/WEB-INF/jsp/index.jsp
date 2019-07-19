<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet"
	href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${APP_PATH}/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="${APP_PATH}/assets/css/ace.min.css" />
<link rel="stylesheet" href="${APP_PATH}/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="${APP_PATH}/assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="${APP_PATH}/css/menu.css" />

<script src="${APP_PATH}/assets/js/ace-extra.min.js"></script>

<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/script/docs.min.js"></script>
<script src="${APP_PATH}/layer/layer.js"></script>
<script src="${APP_PATH}/assets/jquery.min.js"></script>
<script src="${APP_PATH}/jquery/menu.js"></script>



</head>
<body>

	<div class="col-md-2 side-nav">
		<div class="panel-group" id="accordion">
			<div class="panel-heading panel">
				<a href="index.html" class="side-nav-item item-title"> 首页 </a>
				<div class="item-body collapse" id='index'></div>
			</div>

			<div class="panel-heading panel">
				<a data-toggle="collapse" data-parent="#accordion"
					href="#item-cangku" id="headcangku"
					class="side-nav-item item-title"> 仓库管理 </a>
				<div id="item-cangku" class="panel-collapse collapse">
					<div class="item-body">
						<ul class="list-unstyled">
							<li class="item-second" id='a'><a href="a.html">产品库存</a></li>
							<li class="item-second" id='b'><a href="b.html">原料库存</a></li>
						</ul>
					</div>
				</div>
			</div>

			<div class="panel-heading panel">
				<a data-toggle="collapse" data-parent="#accordion"
					href="#item-caiwu" id="headcaiwu"
					class="side-nav-item item-title collapsed"> 财务管理 </a>
				<div id="item-caiwu" class="panel-collapse collapse">
					<div class="item-body">222</div>
				</div>
			</div>

			<div class="panel-heading panel">
				<a data-toggle="collapse" data-parent="#accordion"
					href="#item-renshi" id="headrenshi"
					class="side-nav-item item-title collapsed"> 人事管理 </a>
				<div id="item-renshi" class="panel-collapse collapse">
					<div class="item-body"></div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>