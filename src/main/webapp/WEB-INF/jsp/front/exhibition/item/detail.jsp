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
.row {
	margin: 0 0 0 0;
}

span {
	padding: 0 0;
}

label {
	color: #428bca;
}
</style>
</head>

<body>
	<div class="panel panel-default" style="margin: 3px">
		<div class="panel-body" style="padding: 0 0 8px 0">
			<div class="row bg-info"
				style="padding: 0 0 8px 0; margin-bottom: 8px">
				<div class="col-sm-12">
					<div class="row">
						<label class="col-sm-1"
							style="margin-bottom: 0px; margin-top: 3px;"> <span
								id="type_icon" class="pull-right" aria-hidden="true"> </span>
						</label>
						<div class="col-xs-9">
							<h4 class="pull-left">
								<span id="user_info" style="margin-right: 20px">
									<span id="username_icon" class="glyphicon glyphicon-user"
										aria-hidden="true" style="color: #428bca"> </span>
									<span id="username" style="color: #428bca;"> </span>
								</span>
								<span id="title"></span>
							</h4>
						</div>
					</div>
					<div class="row">
						<label class="col-sm-1"
							style="margin-bottom: 0px; margin-top: 3px;"> </label>
						<div class="col-xs-9">

							<span class="pull-left">性质：</span>
							<span id="character" style="color: #428bca;"> </span>

							<span style="padding-left: 15px;">创建于：</span>
							<span id="c_time"> </span>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<label class="col-sm-2" style="text-align: right"> 时间 <span
						id="gift_icon" class="glyphicon glyphicon-time" aria-hidden="true"
						style="color: #428bca"> </span>
				</label>
				<div class="col-xs-9">
					<span id="start_time"></span>
					-
					<span id="end_time"></span>
				</div>
			</div>
			<div class="row" id="address_info">
				<label class="col-sm-2" style="text-align: right"> 地点 <span
						id="address_icon" class="glyphicon glyphicon-map-marker"
						aria-hidden="true" style="color: #428bca"> </span>
				</label>
				<div class="col-xs-9">
					<span id="address"></span>
				</div>
			</div>
			<div class="row" id="content_info">
				<label class="col-sm-2" style="text-align: right"> 内容 <span
						id="gift_icon" class="glyphicon glyphicon-inbox"
						aria-hidden="true" style="color: #428bca"> </span>
				</label>
				<div class="col-xs-9">
					<div class="row" id="content_info">
						<span id="content"></span>
					</div>
					<div class="row" id="remark_info">
						<span id="remark"></span>
					</div>
				</div>
			</div>
			<div class="row" id="">
				<label class="col-sm-2" style="text-align: right"> 客户状态 <span
						class="glyphicon glyphicon-scale" aria-hidden="true"
						style="color: #428bca"> </span>
				</label>
				<div class="col-sm-9">
					<div class="row" id="client_exhibition_info ">
						<div class="col-sm-4" id="next_info" style="padding-left: 0px;">
							<label class="col-sm-2 hide"
								style="text-align: left; padding-left: 0px;"> 客户状态 </label>
							<div class="col-xs-9" style="padding-left: 0px;">
								<div class="row">
									<span id="client_exhibiton_state_name"></span>
								</div>
								<div class="row">
									<span id="client_exhibiton_state_cmt"></span>
								</div>
							</div>
						</div>
						<div class="col-sm-4" id="next_info">
							<label class="col-sm-2 hide"
								style="text-align: left; padding-left: 0px;"> 下一步 </label>
							<div class="col-xs-9" style="padding-left: 0px;">
								<div class="row">
									<span id="next_action_name">2222</span>
								</div>
								<div class="row">
									<span id="next_action_cmt">3333</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row" id="attentions_info">
				<label class="col-sm-2" style="text-align: right"> 注意事项 <span
						id="attention_icon" class="glyphicon glyphicon-th-list"
						aria-hidden="true" style="color: #428bca"> </span>
				</label>
				<div class="col-xs-9">
					<span id="attentions"></span>
				</div>
			</div>
			<div class="row" id="gift_info">
				<label class="col-sm-2" style="text-align: right"> 随手礼 <span
						id="gift_icon" class="glyphicon glyphicon-gift" aria-hidden="true"
						style="color: #428bca"> </span>
				</label>
				<div class="col-xs-9">
					<span id="gift"></span>
				</div>
			</div>
			<div class="row" id="client_questions_info">
				<label class="col-sm-2" style="text-align: right"> 客户问题 <span
						id="client_question_icon"
						class="glyphicon glyphicon-question-sign" aria-hidden="true"
						style="color: #428bca"> </span>
				</label>
				<div class="col-xs-9">
					<span id="client_questions"></span>
				</div>
			</div>
			<div class="row" id="acclaim_points_info">
				<label class="col-sm-2" style="text-align: right"> 赞美点 <span
						id="acclaim_points_icon" class="glyphicon glyphicon-heart"
						aria-hidden="true" style="color: #428bca"> </span>
				</label>
				<div class="col-xs-9">
					<span id="acclaim_points"></span>
				</div>
			</div>
			<div class="row" id="grateful_points_info">
				<label class="col-sm-2" style="text-align: right"> 感恩点 <span
						id="grateful_points_icon" class="glyphicon glyphicon-leaf"
						aria-hidden="true" style="color: #428bca"> </span>
				</label>
				<div class="col-xs-9">
					<span id="grateful_points"></span>
				</div>
			</div>
		</div>
		<div class="panel-footer">
			<div class="row ">
				<button type="button" id="btn_note"
					class="btn btn-primary btn-sm center-block">记一下</button>
			</div>
		</div>
	</div>

	<script>
		$().ready(function() {
			
			$("#btn_note").bind("click", addNote);
			
			var exhibitionitem = ${exhibitionitem};
			showDetail(exhibitionitem);
		});

		function addNote() {

			var params = [];
			params.push("user_id=${userid}");
			params.push("target_id=${exhibitionitem._id_m}" );
			params.push("ts=" + new Date().getTime());

			var url_to = $.getSitePath() + '/note/add/';
			url_to = url_to + "?" + params.join("&");

			$.popUpWindow("记一下", url_to, "800", "360", "add", $("#btn_note"));
		}

		function closeAddNoteWindow() {
			$.closeWindow("add", $("#btn_note"));
		}

		function showDetail(exhibitionitem) {

			if (!exhibitionitem) {
				return;
			}
			//$.logJson(exhibitionitem);

			var type = exhibitionitem.type;
			if (type.startsWith("PLAN")) {
				$("#type_icon").addClass("glyphicon glyphicon-time");
				$("#type_icon").css("color", "#f0ad4e");
			} else {
				$("#type_icon").addClass("glyphicon glyphicon-list-alt");
				$("#type_icon").css("color", "#5cb85c");
			}
			$("#type_icon").css("font-size", "50px");
			$("#type_icon").css("position", "absolute");
			$("#type_icon").css("margin-left", "20px");
			$("#type_icon").css("margin-top", "4px");

			$("#c_time").html($.time2minut(exhibitionitem.c_time));
			$("#title").html(exhibitionitem.title);
			$("#character").html(exhibitionitem.character_name);

			if (exhibitionitem.username && exhibitionitem.username.length > 0) {
				$("#username").html(exhibitionitem.username);
			} else {
				$("#user_info").hide();
			}

			$("#start_time").html($.time2minut(exhibitionitem.start_time));
			$("#end_time").html($.time2minut(exhibitionitem.end_time));

			if (exhibitionitem.address && exhibitionitem.address.length > 0) {
				$("#address").html(exhibitionitem.address);
			} else {
				$("#address_info").hide();
			}

			$("#content").html(exhibitionitem.content);
			$("#remark").html(exhibitionitem.remark);

			$("#next_action_name").html(exhibitionitem.next_action_name);
			$("#next_action_cmt").html(exhibitionitem.next_action_cmt);

			$("#client_exhibiton_state_name").html(
					exhibitionitem.client_exhibiton_state_name);
			$("#client_exhibiton_state_cmt").html(
					exhibitionitem.client_exhibiton_state_cmt);

			if (exhibitionitem.gift && exhibitionitem.gift.length > 0) {
				$("#gift").html(exhibitionitem.gift);
			} else {
				$("#gift_info").hide();
			}

			if (exhibitionitem.client_questions
					&& exhibitionitem.client_questions.length > 0) {
				$("#client_questions").html(
						exhibitionitem.client_questions.join("<br>"));
			} else {
				$("#client_questions_info").hide();
			}

			if (exhibitionitem.grateful_points
					&& exhibitionitem.grateful_points.length > 0) {
				$("#grateful_points").html(
						exhibitionitem.grateful_points.join("<br>"));
			} else {
				$("#grateful_points_info").hide();
			}

			if (exhibitionitem.acclaim_points
					&& exhibitionitem.acclaim_points.length > 0) {
				$("#acclaim_points").html(
						exhibitionitem.acclaim_points.join("<br>"));
			} else {
				$("#acclaim_points_info").hide();
			}

			if (exhibitionitem.attentions
					&& exhibitionitem.attentions.length > 0) {
				$("#attentions").html(exhibitionitem.attentions.join("<br>"));
			} else {
				$("#attentions_info").hide();
			}
		}
	</script>
</body>
</html>