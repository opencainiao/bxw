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
		
			<input type="hidden" id="user_id" name="user_id"
				value="${exhibitionitem.user_id}">
			<input type="hidden" id="username" name="username"
				value="${exhibitionitem.username}">
				
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
										<label for="" class="col-sm-3 control-label">客户 </label>
										<div class="col-sm-8">
											<div class="input-group" id="choose_client_div">
												<input type="text" id="choose_client" name="choose_client"
													class="form-control" readonly placeholder="请选择" value="${exhibitionitem.username}"> <span
													class="input-group-btn">
													<button class="btn btn-default btn-sm" id="choose_client_btn" type="button">
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
										<label for="attention_info" class="col-sm-3 control-label">
											注意事项 </label>
										<div class="col-sm-8">
											<div class="row" id="attention_info">
												<div
													class="input-group input-group-xs  online-input col-md-12"
													style="padding-left: 15px;">
													<button type="button" id="add_attention"
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
					format : 'YYYY-MM-DD hh:mm', // 分隔符可以任意定义，该例子表示只显示年月
					festival : true, //显示节日
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
					format : 'YYYY-MM-DD hh:mm', // 分隔符可以任意定义，该例子表示只显示年月
					festival : true, //显示节日
					choose : function(datas) { //选择日期完毕的回调

						console.log(datas);
					}
				});
			});
			$("#end_time").val(laydate.now());

			iniAttention();

			$("#choose_client_btn").bind("click", popUpChooseClient);
		});

		//保存
		var save = function() {

			var paramForm = $('form').getFormParam_ux();

			var attention_info = getAttentionInfo();
			paramForm = $.extend(paramForm, attention_info);

			var successstr = "新增成功";

			var url_to = $.getSitePath() + "/front/exhibition_item/add?type=PLAN_PHONE";
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

		function registRemoveOne() {
			$(".btn-rm-box").click(function() {
				$(this).css("border-radius", "3px!important");
				$(this).closest('div.one_box').remove();
			});
		}

		var addAttention = function(config) {

			var order = $(".one_box", $("#attention_info")).length + 1;

			var p = $.extend({ // apply default properties
				ipt_w : '500px', // 输入框的宽度
				ipt_val : '',
				margin_l_button_w : '15px' // 按钮至输入框的边距
			}, config);

			var toAdd = '<div   data-order= "#ORDER#"                                                                            '
					+ '			class="input-group input-group-xs  online-input col-md-12 one_box"                   '
					+ '			style="padding-left: 15px; margin-top: 8px; width: 580px">                                 '
					+ '			<textarea type="text" class="form-control "                              '
					+ '				style="margin-left: 0px; width: #IPT_W# ;height: 60px">#IPT_VAL#</textarea>                                 '
					+ '			<span                                                                        '
					+ '				class="pull-right">                                                   '
					+ '				<button class="btn btn-danger btn-sm btn-rm-box"  type="button" style="margin-left: #MARGIN_L_BUTTON_W#">删除</button>        '
					+ '			</span>                                                                      '
					+ '</div>                                                                            ';

			toAdd = toAdd.replace("#IPT_W#", p.ipt_w);
			toAdd = toAdd.replace("#MARGIN_L_BUTTON_W#", p.margin_l_button_w);
			toAdd = toAdd.replace("#IPT_VAL#", p.ipt_val);
			toAdd = toAdd.replace("#ORDER#", order);

			$("#attention_info").append(toAdd);

			registRemoveOne();
		}

		// 初始化注意事项信息
		function iniAttention() {

			var data_attention = eval('${client.attention_info }');
			if (data_attention && data_attention.length > 0) {
				for ( var item in data_attention) {
					var attention_temp = data_attention[item];

					var value = attention_temp["phone_number"];

					addAttention({
						ipt_val : value
					});
				}
			} else {
				addAttention();
			}

			$("#add_attention").click(function() {
				addAttention();
			})
		}

		function getAttentionInfo() {

			var attention_info = [];
			var attention_div = $("#attention_info");

			$(".one_box", attention_div).each(function() {

				var value_attention = $("textarea", $(this)).val().trim();

				if (value_attention == "") {
					return;
				}

				attention_info.push(value_attention);
			});

			return {
				"attentions" : JSON.stringify(attention_info)
			};
		}

		/****
		 * 弹出选择客户窗口
		 */
		var popUpChooseClient = function(){
			var url_to = $.getSitePath() + '/front/familly/choose_client?user_id=#USERID#&user_name=#USERNAME#&user_sex=#USERSEX#';
			
			url_to = url_to.replaceAll("#USERID#","${userid}");
			url_to = url_to.replaceAll("#USERNAME#","${username}");
			url_to = url_to.replaceAll("#USERSEX#","${user_sex}");

			$.popUpWindow("选择客户", url_to, "90%", "90%", "choose_client", $("#choose_client_div"));
		}
		
		//设置选择的客户		
		function setSelectedClient(obj) {
			//$.alertObjJson(obj);

			$("#user_id").val(obj["_id_m"]);
			$("#username").val(obj["client_name"]);

			$("#choose_client").val(obj["client_name"]);
			
			// 关闭选择客户弹出窗口
			$.closeWindow("choose_client", $("#choose_client_div"));
		}
	</script>
</body>
</html>