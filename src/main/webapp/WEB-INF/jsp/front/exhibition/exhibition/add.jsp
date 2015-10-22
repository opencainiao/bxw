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

<style>
input[readonly] {
	background-color: #eee;
	opacity: 1;
}

input {
	border: 1px solid #ccc;
	border-radius: 4px;
	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
	color: #555;
	font-size: 14px;
	height: 34px;
	line-height: 1.42857;
	padding: 6px 12px;
}

.form-control, input[readonly], input.form-control[readonly] {
	display: inline !important;
}
</style>
</head>
<body>
	<div id="add_div" class="onepage">
		<sf:form modelAttribute="exhibition" class="form-horizontal">
			<input type="hidden" id="user_id"  name="user_id" />
			<input type="hidden" id="username"  name="username" />

			<div class="form-group  form-group-sm " style="margin-top: 15px">
				<label for="family_income_feature" class="col-sm-2 control-label">客户</label>
				<div class="col-sm-7">
					<div class="input-group" id="client_choose_div">
						<input type="text" id="client_choose" name="client_choose"
							class="form-control " placeholder="请选择客户" readonly>
						<span class="input-group-btn">
							<button class="btn btn-default btn-sm" type="button">
								<span class="glyphicon glyphicon-chevron-right"
									aria-hidden="true"></span>
							</button>
						</span>
					</div>
				</div>
			</div>
			<div class="form-group form-group-sm ">
				<label for="remark" class="col-sm-2 control-label"> 说明 </label>
				<div class="col-sm-7">
					<textarea type="text" class="form-control " id="remark"
						name="remark" placeholder="请输入说明" style="height: 180px"></textarea>
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
			$("#client_choose_div").bind("click", parent.popUpChooseClient);

		});

		//设置选择的客户		
		function setSelectedClient(obj) {
			//$.alertObjJson(obj);

			$("#user_id").val(obj["_id_m"]);
			$("#username").val(obj["client_name"]);

			$("#client_choose").val(obj["client_name"]);
		}

		//保存
		var save = function() {

			// 控制按钮为禁用
			$.disableButton("btn_save");

			var paramForm = $('form').serializeJsonObject();
			
			//$.logJson(paramForm);

			var successstr = "开启成功";

			var url_to = $.getSitePath() + "/front/exhibition/add";
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