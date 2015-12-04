<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<jsp:include page="/WEB-INF/jsp/include/common_css.jsp"></jsp:include>
<jsp:include page="/WEB-INF/jsp/include/common_js.jsp"></jsp:include>
<jsp:include page="/WEB-INF/jsp/include/common_flexigrid.jsp"></jsp:include>

</head>

<body>
	<input type="hidden" name="ctx" value="<%=request.getContextPath()%>" />

	<ul class="breadcrumb">
		<li class="active">合同信息</li>
	</ul>

	<div id="content_inner_page" class="innercontent">
		<div class="navbar navbar-default ">
			<form class="navbar-form navbar-left">
				<div class="form-group ">
					<span>姓名</span>
					<input class="form-control input-sm" style="width: 300px"
						type="text" id="username" name="username"
						placeholder="输入客户姓名、拼音或是首字母">
				</div>
				<button class="btn btn-info" type="button" id="btn_search">
					查询</button>

				<span>阶段</span>
				<select id="exhibition_stage" name="exhibition_stage"
					class="form-control input-sm" data-src="constant"
					data-typecode="EXHIBITION_STAGE"
					data-value="" data-allownull></select>

				<span>状态</span>
				<select id="exhibition_state" name="exhibition_state"
					class="form-control input-sm" data-src="constant"
					data-typecode="EXHIBITION_STATE" 
					data-value="" data-allownull></select>

				<button class="btn btn-primary" type="button" id="btn_add"
					style="margin-left: 50px;">添加合同</button>
			</form>
		</div>

		<div id="data_manage">
			<table id="list"></table>
		</div>
	</div>

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/front/contract/contract/list.js"></script>

	<script>
		/****
		 * 弹出选择客户窗口
		 */
		var popUpChooseClient = function() {
			var url_to = $.getSitePath()
					+ '/front/familly/choose_client?user_id=#USERID#&user_name=#USERNAME#&user_sex=#USERSEX#';

			url_to = url_to.replaceAll("#USERID#", "${userid}");
			url_to = url_to.replaceAll("#USERNAME#", "${username}");
			url_to = url_to.replaceAll("#USERSEX#", "${user_sex}");

			$.popUpWindow("选择客户", url_to, "90%", "90%", "choose_client",
					$("#btn_add"));
		}

		/****
		 * 设置选择的客户信息（在弹出的选择客户页面）
		 */
		var setSelectedClient = function(selectedObj) {

			// 设置选择客户信息
			var layerIndex = $("#content_inner_page").attr("add");
			$.callLayerFunc(layerIndex, "setSelectedClient", selectedObj);

			// 关闭选择客户弹出窗口
			$.closeWindow("choose_client", $("#btn_add"));
		}
	</script>
</body>

</html>