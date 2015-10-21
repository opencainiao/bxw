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
	<input type="hidden" name="ctx" value="<%=request.getContextPath()%>" />

	<ul class="breadcrumb">
		<li><a href="<%=request.getContextPath()%>/front/exhibition/list">展业信息</a>
			<span class="divider"></span></li>
		<li class="active">制定电话约访计划</li>
	</ul>
	<div id="add_div" class="onepage">
		<input type="hidden" name="_id" />
		<sf:form modelAttribute="exhibitionitem" class="form-horizontal">
			<div class="container-fluid" style="margin-top: 30px">

				<div class="panel panel-info">
					<div class="panel-heading hide">创建电话约访计划</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-xs-6">
								<div class="row">
									<div class="form-group form-group-sm  ">
										<label for="character" class="col-sm-3 control-label">
											性质 </label>
										<div class="col-xs-9">
											<select id="character" name="character"
												class="form-control input-sm" data-src="constant"
												data-typecode="EXHIBITION_CHARACTER" data-value=""
												style="width: 580px">
											</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="form-group form-group-sm  ">
										<label for="title" class="col-sm-3 control-label"> 标题
										</label>
										<div class="col-xs-9">
											<div class="input-group input-group-xs " style="width: 580px">
												<input id="title" class="form-control" name="title"
													type="text" placeholder="请输入标题">
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="form-group form-group-sm  ">
										<label for="content" class="col-sm-3 control-label">
											内容 </label>
										<div class="col-xs-9">
											<textarea type="text" class="form-control " id="content"
												name="remark" placeholder="请输入说明"
												style="width: 580px; height: 120px"></textarea>
										</div>
									</div>
								</div>

							</div>
						</div>
						<div class="row">
							<div class="col-xs-6">
								<div class="row">
									<div class="form-group form-group-sm  ">
										<label for="family_income_feature"
											class="col-sm-3 control-label">客户 </label>
										<div class="col-sm-8">
											<div class="input-group" id="family_choose_div">
												<input type="text" id="family_choose" name="family_choose"
													class="form-control" readonly placeholder="请选择"> <span
													class="input-group-btn">
													<button class="btn btn-default btn-sm" type="button">
														<span class="glyphicon glyphicon-chevron-right"
															aria-hidden="true"></span>
													</button>
												</span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-6">
								<div class="row">
									<div class="form-group form-group-sm  ">
										<label for="start_time" class="col-sm-3 control-label">开始
										</label>
										<div class="col-sm-8">
											<input id="start_time" name="start_time" placeholder="请输入日期"
												class="laydate-icon form-control dateipt" value="">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="form-group form-group-sm  ">
										<label for="end_time" class="col-sm-3 control-label">结束
										</label>
										<div class="col-sm-8">
											<input id="end_time" name="end_time" placeholder="请输入日期"
												class="laydate-icon form-control dateipt" value="">
										</div>
									</div>
								</div>
							</div>
							<div class="col-xs-6"></div>
						</div>
						<div class="row">
							<div class="col-xs-6">
								<div class="row">
									<div class="form-group form-group-sm  ">
										<label for="phone_info" class="col-sm-3 control-label">
											注意事项 </label>
										<div class="col-sm-8">
											<div class="row" id="phone_info">
												<div
													class="input-group input-group-xs  online-input col-md-12"
													style="padding-left: 15px;">
													<button type="button" id="add_phone"
														class="btn btn-info btn-sm">添加</button>
												</div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>

				<hr />

				<div class="col-sm-12">
					<button type="button" id="btn_save"
						class="btn btn-primary btn-lg center-block">提交</button>
				</div>
		</sf:form>
	</div>

	<script>
		$().ready(function() {

			$("#btn_save").bind("click", save);

			$("#start_time").click(function() {
				laydate({
					elem : '#start_time',
					istime : true,
					format : 'YYYY-MM-DD hh:mm:ss', // 分隔符可以任意定义，该例子表示只显示年月
					festival : true, //显示节日
					min : laydate.now(),
					choose : function(datas) { //选择日期完毕的回调
						console.log(datas);
					}
				});
			});

			$("#start_time").val(laydate.now());

			$("#end_time").click(function() {
				laydate({
					elem : '#end_time',
					istime : true,
					format : 'YYYY-MM-DD hh:mm:ss', // 分隔符可以任意定义，该例子表示只显示年月
					festival : true, //显示节日
					min : laydate.now(),
					choose : function(datas) { //选择日期完毕的回调

						console.log(datas);
					}
				});
			});
			$("#end_time").val(laydate.now());
		});

		//保存
		var save = function() {

			// 控制按钮为禁用
			$.disableButton("btn_save");

			var paramForm = $('form').getFormParam_ux();

			var successstr = "新增成功";

			var url_to = $.getSitePath() + "/backend/sysconsttype/add";
			var url_success = $.getSitePath() + "/backend/sysconsttype/list";

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
						$.alertSuccessNewPage("成功", successstr, url_success);
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