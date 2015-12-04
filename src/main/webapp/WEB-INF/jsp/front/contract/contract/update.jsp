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
	<div id="edit_div" class="onepage" style="margin-top: 30px">
		<input type="hidden" name="_id" value="${sysconst._id}" readonly />
		<sf:form modelAttribute="exhibition" class="form-horizontal">
			<input type="hidden" id="user_id" name="user_id"
				value="${exhibition.user_id }" />
			<input type="hidden" id="username" name="username"
				value="${exhibition.username }" />

			<div class="form-group  form-group-sm " style="margin-top: 15px">
				<label for="family_income_feature" class="col-sm-2 control-label">客户</label>
				<div class="col-sm-7">
					<input type="text" id="client_choose" name="client_choose"
						class="form-control " value="${exhibition.username }" readonly>
				</div>
			</div>
			<div class="form-group form-group-sm ">
				<label for="remark" class="col-sm-2 control-label"> 说明 </label>
				<div class="col-sm-7">
					<textarea type="text" class="form-control " id="remark"
						name="remark" placeholder="请输入说明" style="height: 180px">${ exhibition.remark}</textarea>
				</div>
			</div>

			<hr />
			<div class="col-sm-7">
				<button type="button" id="btn_save"
					class="btn btn-primary btn-lg center-block">提交</button>
			</div>
		</sf:form>
	</div>

	<script>
		$().ready(function() {

			$("#btn_save").bind("click", save);

			document.onkeydown = function(event) {
				if (event.keyCode == 13) {
					return false;
				}
			}
		});

		//保存
		var save = function() {

			// 控制按钮为禁用
			$.disableButton("btn_save");

			var paramForm = $('form').serializeJsonObject();

			$.logJson(paramForm);

			var successstr = "修改成功";

			var url_to = window.location.href ;
			var url_success = $.getSitePath() + "/front/exhibition/list";

			var params = [];
			//params.push("typecode=${sysconst.typecode}");
			//params.push("typename=${sysconst.typename}");
			params.push("ts=" + new Date().getTime());

			url_success = url_success + "?" + params.join("&");

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
							$.alertError(data['message']);
						}
					} else {

						var callback = parent.data_manage_functions.closeAddWindow;

						$.alertSuccessCallback("成功", successstr,
								callback);
						//$.alertSuccessNewPage("成功", successstr, url_success);
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