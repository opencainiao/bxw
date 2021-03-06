<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<jsp:include page="/WEB-INF/jsp/include/common_css.jsp"></jsp:include>
<jsp:include page="/WEB-INF/jsp/include/common_js.jsp"></jsp:include>

</head>

<body>
	<input type="hidden" name="ctx" value="<%=request.getContextPath()%>" />

	<ul class="breadcrumb">
		<c:if test="${source == null}">
			<li><a
				href="<%=request.getContextPath()%>/front/exhibition/list">展业信息</a>
				<span class="divider"></span></li>
		</c:if>
		<c:if test="${source != null}">
			<li><a
				href="<%=request.getContextPath()%>/front/exhibition_item/list?source=1">展业记录</a>
				<span class="divider"></span></li>
		</c:if>
		<li class="active">制定电话约访计划</li>
	</ul>
	<div id="add_div" class="onepage">
		<sf:form modelAttribute="exhibitionitem" class="form-horizontal">
			<jsp:include page="/WEB-INF/jsp/front/exhibition/item/base_info.jsp"></jsp:include>
		</sf:form>
	</div>

	<script>
		$().ready(function() {

			$("#attention_info").resize(function() {

				window.top.autoHeight();
			});

			$("#btn_save").bind("click", save);
			
			$("#address_div").hide();
			$("#gift_div").hide();
			
			$("#title").val("（计划）约访客户");

		});

		//保存
		var save = function() {

			var paramForm = $('form').getFormParam_ux();

			var attention_info = getAttentionInfo();
			var client_question_info = $.getTextAreaInfo("client_question_info","client_questions");
			var acclaim_points_info = $.getTextAreaInfo("acclaim_points_info","acclaim_points");
			var grateful_points_info = $.getTextAreaInfo("grateful_points_info","grateful_points");
	
			paramForm = $.extend(paramForm, attention_info);
			paramForm = $.extend(paramForm, client_question_info);
			paramForm = $.extend(paramForm, acclaim_points_info);
			paramForm = $.extend(paramForm, grateful_points_info);

			var successstr = "新增成功";

			var url_to = $.getSitePath()
					+ "/front/exhibition_item/add?type=PLAN_PHONE";
			var url_success = $.getSitePath() + "/front/exhibition_item/list";

			$.logJson(paramForm);
			//return;

			// 控制按钮为禁用
			$.disableButton("btn_save");

			$.ajax({
				type : 'POST',
				url : url_to,
				data : $.extend({
					ts : new Date().getTime()
				}, paramForm),
				type : 'POST',
				dataType : 'json',
				success : function(data) {

					if (data['success'] == 'n') {
						if (data['brErrors']) {
							$.showBRErrors_mou_abs(data['brErrors'],
									$("#add_div"));
						} else {
							$.alertErrorMask(data['message']);
						}
					} else {
						$.alertSuccessNewPage("成功", successstr, url_success,[0.5, '#000']);
					} 
				},
				complete : function(XMLHttpRequest, textStatus) {
					$.enableButton("btn_save");
				}
			});
		};

	</script>
</body>
</html>