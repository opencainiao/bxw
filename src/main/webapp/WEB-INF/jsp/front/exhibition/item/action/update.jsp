<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

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
	<div id="edit_div" class="onepage">
		<sf:form modelAttribute="exhibitionitem" class="form-horizontal">
			<jsp:include page="/WEB-INF/jsp/front/exhibition/item/base_info.jsp"></jsp:include>
		</sf:form>

	</div>
	<script>
		$().ready(function() {
			$("#btn_save").bind("click", save);
			
			$("#gift_label").html("礼品");
			
			$("#next_info_div").hide();
			$("#client_exhibiton_state_div").hide();
			$("#client_question_div").hide();
			$("#acclaim_points_div").hide();
			$("#grateful_points_div").hide();
			
			$("#choose_client_btn").unbind();  
			$("#choose_client_btn").bind("click", popUpChooseClientMulti);
		});

		var closeEditWindow = function() {
			parent.data_manage_functions.refreshPage();
			parent.data_manage_functions.closeEditWindow();
		}

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

			var successstr = "修改成功";

			var url_to = window.location.href;

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
									$("#edit_div"));
						} else {
							$.alertError(data['message']);
						}
					} else {
						$.alertSuccessCallback("修改成功", successstr,
								closeEditWindow);
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