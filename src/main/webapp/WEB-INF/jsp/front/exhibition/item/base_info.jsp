<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<input type="hidden" name="_id" />
<input type="hidden" id="user_id" name="user_id"
	value="${exhibitionitem.user_id}">
<input type="hidden" id="username" name="username"
	value="${exhibitionitem.username}">

<div class="container-fluid"
	style="margin-top: 10px; margin-bottom: 15px">
	<div class="panel panel-info">
		<div class="panel-heading hide">创建电话约访计划</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-xs-6">
					<div class="row">
						<div class="form-group form-group-sm  ">
							<label for="" class="col-sm-3 control-label">客户 </label>
							<div class="col-sm-8">
								<div class="input-group" id="choose_client_div"
									style="width: 580px">
									<input type="text" id="choose_client" name="choose_client"
										class="form-control" readonly placeholder="请选择"
										value="${exhibitionitem.username}"> <span
										class="input-group-btn">
										<button class="btn btn-default btn-sm" id="choose_client_btn"
											type="button">
											<span class="glyphicon glyphicon-chevron-right"
												aria-hidden="true"></span>
										</button>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group form-group-sm  ">
							<label for="character" class="col-sm-3 control-label"> 性质
							</label>
							<div class="col-xs-9">
								<select id="character" name="character"
									class="form-control input-sm" data-src="constant"
									data-typecode="EXHIBITION_CHARACTER"
									data-value="${exhibitionitem.character }" style="width: 580px">
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group form-group-sm  ">
							<label for="start_time" class="col-sm-3 control-label">开始
							</label>
							<div class="col-sm-8">
								<input id="start_time" name="start_time" placeholder="请输入日期"
									class="laydate-icon form-control dateipt" style="width: 580px"
									value="${exhibitionitem.start_time }">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group form-group-sm  ">
							<label for="end_time" class="col-sm-3 control-label">结束 </label>
							<div class="col-sm-8">
								<input id="end_time" name="end_time" placeholder="请输入日期"
									class="laydate-icon form-control dateipt" style="width: 580px"
									value="${exhibitionitem.end_time }">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group form-group-sm  " id="address_div">
							<label for="address" class="col-sm-3 control-label"> 地点 </label>
							<div class="col-xs-9">
								<textarea type="text" class="form-control " id="address"
									name="address" placeholder=""
									style="width: 580px; height: 50px">${exhibitionitem.address }</textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group form-group-sm  ">
							<label for="title" class="col-sm-3 control-label"> 标题 </label>
							<div class="col-xs-9">
								<div class="input-group input-group-xs " style="width: 580px">
									<input id="title" class="form-control" name="title" type="text"
										placeholder="请输入标题" value="${exhibitionitem.title }">
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group form-group-sm  ">
							<label for="content" class="col-sm-3 control-label"> 内容 </label>
							<div class="col-xs-9">
								<textarea type="text" class="form-control " id="content"
									name="content" placeholder="请输入说明"
									style="width: 580px; height: 120px">${exhibitionitem.content }</textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group form-group-sm  ">
							<label for="remark" class="col-sm-3 control-label"> 其他 </label>
							<div class="col-xs-9">
								<textarea type="text" class="form-control " id="remark"
									name="content" placeholder=""
									style="width: 580px; height: 120px">${exhibitionitem.remark }</textarea>
							</div>
						</div>
					</div>
					<div class="row" id="next_info_div">
						<div class="form-group form-group-sm ">
							<label class="col-sm-3 control-label" for="next_info">
								下一步 </label>
							<div class="col-sm-8">
								<div id="_info" class="row"
									style="width: 595px; padding-top: 6px;">
									<div class="input-group input-group-xs online-input col-md-12"
										style="padding-left: 15px;">
										<select id="next_action" name="next_action"
											class="form-control input-sm " data-src="constant"
											data-typecode="EXHIBITION_CHARACTER"
											data-value="${exhibitionitem.next_action}"
											style="width: 580px">
										</select>
									</div>
									<div class="input-group input-group-xs online-input col-md-12"
										style="padding-left: 15px; padding-top: 15px">
										<div style="width: 120px">动作说明</div>
										<textarea type="text" class="form-control "
											id="next_action_cmt" name="next_action_cmt" placeholder=""
											style="width: 580px; height: 50px">${exhibitionitem.next_action_cmt }</textarea>
									</div>

								</div>
							</div>
						</div>
					</div>

					<div class="row" id="client_exhibiton_state_div">
						<div class="form-group form-group-sm ">
							<label class="col-sm-3 control-label" for="">
								客户状态 </label>
							<div class="col-sm-8">
								<div id="_info" class="row"
									style="width: 595px; padding-top: 6px;">
									<div class="input-group input-group-xs online-input col-md-12"
										style="padding-left: 15px;">
										<select id="client_exhibiton_state"
											name="client_exhibiton_state" class="form-control input-sm"
											data-src="constant" data-typecode="EXHIBITION_STATE"
											data-value="${exhibitionitem.client_exhibiton_state}" style="width: 580px"></select>

									</div>
									<div class="input-group input-group-xs online-input col-md-12"
										style="padding-left: 15px; padding-top: 15px">
										<div style="width: 120px">说明</div>
										<textarea type="text" class="form-control "
											id="client_exhibiton_state_cmt"
											name="client_exhibiton_state_cmt" placeholder=""
											style="width: 580px; height: 50px">${exhibitionitem.client_exhibiton_state_cmt }</textarea>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-6">
					
					<div class="row">
						<div class="form-group form-group-sm  " id="gift_div">
							<label id="gift_label" for="gift" class="col-sm-3 control-label"> 随手礼 </label>
							<div class="col-xs-9">
								<textarea type="text" class="form-control " id="gift"
									name="gift" placeholder="" style="width: 580px; height: 80px">${exhibitionitem.gift }</textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group form-group-sm  ">
							<label for="attention_info" class="col-sm-3 control-label">
								注意事项 </label>
							<div class="col-sm-8">
								<div class="row" id="attention_info">
									<div class="input-group input-group-xs  online-input col-md-12"
										style="padding-left: 15px;">
										<button type="button" id="add_attention"
											class="btn btn-info btn-sm">添加</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row" id="client_question_div">
						<div class="form-group form-group-sm  ">
							<label for="client_question_info" class="col-sm-3 control-label">
								客户问题 </label>
							<div class="col-sm-8">
								<div class="row" id="client_question_info">
									<div class="input-group input-group-xs  online-input col-md-12"
										style="padding-left: 15px;">
										<button type="button" id="add_client_question"
											class="btn btn-info btn-sm">添加</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row" id="acclaim_points_div">
						<div class="form-group form-group-sm  ">
							<label for="acclaim_points_info" class="col-sm-3 control-label">
								赞美点 </label>
							<div class="col-sm-8">
								<div class="row" id="acclaim_points_info">
									<div class="input-group input-group-xs  online-input col-md-12"
										style="padding-left: 15px;">
										<button type="button" id="add_acclaim_points"
											class="btn btn-info btn-sm">添加</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row" id="grateful_points_div">
						<div class="form-group form-group-sm  ">
							<label for="grateful_points_info" class="col-sm-3 control-label">
								感恩点 </label>
							<div class="col-sm-8">
								<div class="row" id="grateful_points_info">
									<div class="input-group input-group-xs  online-input col-md-12"
										style="padding-left: 15px;">
										<button type="button" id="add_grateful_points"
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
</div>
<script>
	$().ready(function() {

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

		$("#start_time").val();

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
		$("#end_time").val();

		iniAttention();
		iniClient_questions();
		iniAcclaim_points();
		iniGrateful_points();

		$("#choose_client_btn").bind("click", popUpChooseClient);
	});

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

		var attentions = [];
		<c:forEach var="i" items="${exhibitionitem.attentions}">
		attentions.push("${i}");
		</c:forEach>

		if (attentions.length > 0) {
			for (var i = 0; i < attentions.length; ++i) {
				addAttention({
					ipt_val : attentions[i]
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

		if (attention_info.length > 0) {
			return {
				"attentions" : JSON.stringify(attention_info)
			};
		} else {
			return {};
		}
	}

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
				$("#choose_client_div"));
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

	//初始化客户赞美点信息
	function iniAcclaim_points() {

		var config = {
			container_id : "acclaim_points_info"
		};

		var values = [];
		<c:forEach var="i" items="${exhibitionitem.acclaim_points}">
		values.push("${i}");
		</c:forEach>

		if (values.length > 0) {
			for (var i = 0; i < values.length; ++i) {
				config["ipt_val"] = values[i];
				$.addOneTextArea(config);
			}
		} else {
			$.addOneTextArea(config);
		}

		$("#add_acclaim_points").click(function() {
			$.addOneTextArea(config);
		})
	}

	// 初始化客户问题信息
	function iniClient_questions() {

		var config = {
			container_id : "client_question_info"
		};

		var values = [];
		<c:forEach var="i" items="${exhibitionitem.client_questions}">
		values.push("${i}");
		</c:forEach>

		if (values.length > 0) {
			for (var i = 0; i < values.length; ++i) {
				config["ipt_val"] = values[i];
				$.addOneTextArea(config);
			}
		} else {
			$.addOneTextArea(config);
		}

		$("#add_client_question").click(function() {
			$.addOneTextArea(config);
		})
	}

	// 初始化客户感恩信息
	function iniGrateful_points() {

		var config = {
			container_id : "grateful_points_info"
		};

		var values = [];
		<c:forEach var="i" items="${exhibitionitem.grateful_points}">
		values.push("${i}");
		</c:forEach>

		if (values.length > 0) {
			for (var i = 0; i < values.length; ++i) {
				config["ipt_val"] = values[i];
				$.addOneTextArea(config);
			}
		} else {
			$.addOneTextArea(config);
		}

		$("#add_grateful_points").click(function() {
			$.addOneTextArea(config);
		})
	}
</script>