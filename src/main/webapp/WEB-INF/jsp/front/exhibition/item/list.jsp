<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<jsp:include page="/WEB-INF/jsp/include/common_css.jsp"></jsp:include>
<jsp:include page="/WEB-INF/jsp/include/common_js.jsp"></jsp:include>
<jsp:include page="/WEB-INF/jsp/include/common_flexigrid.jsp"></jsp:include>
<script type="text/javascript" src="${ctx}/resources/laytpl/laytpl.js"></script>

<style>
.navbar-form span{
color: #c7254e;
font-weight: bold;
}
</style>
</head>

<body>
	<input type="hidden" id="user_id" name="user_id" value="${user_id }" />

	<ul class="breadcrumb">
		<c:if test="${source == null}">
			<li><a
				href="<%=request.getContextPath()%>/front/exhibition/list">展业信息</a>
				<span class="divider"></span></li>
		</c:if>

		<li class="active">展业记录</li>
	</ul>

	<div id="content_inner_page" class="innercontent">
		<div class="box-mou1" id="action_buttons">
			<div class="btn-group ">
				<button type="button" class="btn btn-primary btn-sm">创建展业计划</button>
				<button type="button" class="btn btn-primary dropdown-toggle btn-sm"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<span class="caret"></span> <span class="sr-only">创建展业计划</span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="#" data-name="PLAN_PHONE">（计划）电话约访</a></li>
					<li><a href="#" data-name="PLAN_MEET">（计划）客户拜访</a></li>
				</ul>
			</div>
			<div class="btn-group ">
				<button type="button" class="btn btn-success btn-sm">创建展业记录</button>
				<button type="button" class="btn btn-success dropdown-toggle btn-sm"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<span class="caret"></span> <span class="sr-only">创建展业记录</span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="#" data-name="RECORD_PHONE">（记录）-电话约访</a></li>
					<li><a href="#" data-name="RECORD_MEET">（记录）-客户拜访</a></li>
				</ul>
			</div>
			<button class="btn btn-info btn-sm" type="button" id="create_action" data-name="ACTION">
				创建活动</button>
			<button class="btn btn-warning btn-sm" type="button" id="create_other" data-name="OTHER">
				创建其他记录</button>
		</div>

		<div class="navbar navbar-default ">
			<form class="navbar-form navbar-left ">
				<div class="form-group ">
					<span>姓名</span> <input class="form-control input-sm"
						style="width: 200px" type="text" id="username" name="username"
						placeholder="输入客户姓名、拼音或是首字母" value="${username_ }">
				</div>
				<button class="btn btn-info" type="button" id="btn_search">
					查询</button>

				<span>性质</span> <select id="character" name="character"
					class="form-control input-sm" data-src="constant"
					data-typecode="EXHIBITION_CHARACTER" data-value="" data-allownull></select>
				
				<span class="hide">
					<span>类型</span> <select id="type" name="type"
						class="form-control input-sm" data-src="constant"
						data-typecode="EXHIBITION_TYPE" data-value="" data-allownull></select>
	
					<span>阶段</span> <select id="exhibition_stage"
						name="exhibition_stage" class="form-control input-sm"
						data-src="constant" data-typecode="EXHIBITION_STAGE" data-value=""
						data-allownull></select> <span>状态</span> <select
						id="exhibition_state" name="exhibition_state"
						class="form-control input-sm" data-src="constant"
						data-typecode="EXHIBITION_STATE" data-value="" data-allownull></select>
				</span>
				
			</form>
		</div>

		<div id="data_manage">
			<table id="list"></table>
		</div>
		
		<div id="tpl_list"></div>
	</div>

	<!-- 第一步：编写模版。你可以使用一个script标签存放模板，如： -->
	<script id="list_tpl" type="text/html">
				
		<div class="container-fluid" style="padding:12px">
			<div class="row">
				<a href="#" data-type="detail" data-id="{{d._id_m}}" data-type-name="{{d.type_name}}">
					<span class="pull-left" style='font: 18px/25px  "微软雅黑","simhei"; margin-top: -20px;'>
						{{ d.title }}
					</span>
				</a>
				<span class="pull-right" style="margin-top: -15px;">
					<span class="glyphicon glyphicon-time" aria-hidden="true" style="margin-right:3px"></span>
					{{ d.start_time }} - {{d.end_time}}
				</span>
			</div>
			<div class="row">
				<span class="pull-left" style="color: #818181">{{ d.content }}</span>
			</div>
			<div class="row">
				<span class="pull-right" style="color: #818181">
					<span style="color: #563d7c;font-weight:bold;">
						记录数【{{ d.note_count }}】
					</span>
					最后编辑于【{{ d.last_op_time }}】
				</span>
			</div>
		</div>
	</script>
	
	<script id="discrib_tpl" type="text/html">
		<div class="container-fluid" style="padding-left:8px">
			<div class="row">
				<span class="pull-left">
					<span class="glyphicon glyphicon-user" aria-hidden="true" style="margin-right:3px"></span>
					{{ d.username }}
				</span>
			</div>
			<div class="row">
				<span class="pull-left" >{{ d.type_name }}</span>
			</div>
			<div class="row " >
				<span class="pull-left bg-danger" style="padding:3px 9px 3px 9px;   border-radius: 4px;">{{ d.character_name }}</span>
			</div>
		</div>
	</script>
	
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/front/exhibition/item/list.js"></script>

	
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