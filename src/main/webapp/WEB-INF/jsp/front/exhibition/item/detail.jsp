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

<link href="${ctx}/resources/css/cus/cus-style.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="${ctx}/resources/laytpl/laytpl.js"></script>

	
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

.btn-round {
    border-radius: 30px!important;
}

</style>
</head>

<body>
	<div id="item_detail" class="panel panel-default" style="margin: 3px">
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
					
					<span id="accomplish_status_icon" class="glyphicon" aria-hidden="true" 
						style="position: absolute; top: 0px; right: 25px; color: rgb(240, 173, 78); font-size: 50px;  margin-top: 0px;margin-right: 40px; ">
					</span>
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
									<span id="next_action_name"></span>
								</div>
								<div class="row">
									<span id="next_action_cmt"></span>
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
				<div class="btn-group  pull-right">
					<button class="btn btn-primary btn-sm hide" type="button" style="margin-right: 10px; border-radius:3px!important">
						<span class="glyphicon glyphicon-comment" aria-hidden="true"  style="margin-right: 5px;"></span>
						<span class="badge" id="badge">${exhibitionitem.note_count }</span>
						查看记录
					</button>
					
					<button id="btn_accomplished" class="btn btn-round btn-success" type="button" 
							style="margin-left: 10px; margin-right: 10px; padding-top: 5px; padding-bottom: 5px;">
						<span class="glyphicon glyphicon-ok" aria-hidden="true" ></span>
					</button>
					<button id="btn_failed" class="btn btn-round btn-danger " type="button" 
							style="margin-left: 10px; margin-right: 10px; padding-top: 5px; padding-bottom: 5px;" >
						<span class="glyphicon glyphicon-remove" aria-hidden="true" ></span>
					</button>
					
					<button type="button" id="btn_edit" style="margin-left: 10px; margin-right: 10px;border-radius:3px!important"
						class="btn btn-primary btn-sm center-block">
						<span class="glyphicon glyphicon-edit" aria-hidden="true"  style="margin-right: 5px;"></span>		
						编辑
					</button>
					
					<button type="button" id="btn_note" style="margin-left: 10px; margin-right: 10px;border-radius:3px!important"
						class="btn btn-primary btn-sm center-block">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"  style="margin-right: 5px;"></span>		
						记一下
					</button>
				</div>
			</div>
		</div>
	</div>

	<div id="all_notes"></div>
	
	<!-- 第一步：编写模版。你可以使用一个script标签存放模板，如： -->
	<script id="note_tpl" type="text/html">
		<div class="panel panel-danger" style="margin: 3px">
			<div class="panel-heading">全部记录【<span id="all_notes_count">{{ d.total }}</span>】条</div>
			<div class="panel-body" id="all_notes">
				{{# for(var i = 0, len = d.rows.length; i < len; i++){ }}
				<div class="panel panel-default" style="margin: 3px" id="notes_{{ d.rows[i]._id_m }}">
					<div class="panel-heading hide" >{{ d.rows[i].c_time }}</div>
					<div class="panel-body" id="content">{{ d.rows[i].content }}</div>
					<div class="panel-footer">
						<div class="row ">
							<span class="pull-left">{{ d.rows[i].c_time }}</span>
							<div class="btn-group  btn-group-xs pull-right" data_id="{{ d.rows[i]._id_m }}">
								
								<button type="button" id="btn_note" r_name="note" 
									style="margin-left: 10px; margin-right: 10px; border-radius:3px!important"
									class="btn btn-primary btn-sm center-block hide">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>									
									记一下
								</button>
								
								<button type="button" id="btn_edit" r_name="edit"
									style="margin-right: 10px; border-radius:3px!important"
									class="btn btn-primary btn-sm center-block" >
									<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
									编辑
								</button>

								<button class="btn btn-primary btn-sm hide" r_name="detail" type="button" style="margin-right: 10px; border-radius:3px!important">
									<span class="glyphicon glyphicon-comment" aria-hidden="true" ></span>
									<span class="badge" id="badge">{{ d.rows[i].note_count }}</span>
 									查看记录
								</button>

								<button type="button" id="btn_note" r_name="delete"
									style="margin-right: 10px; border-radius:3px!important"
									class="btn btn-danger btn-sm center-block" >
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
									删除
								</button>
								
							</div>
						</div>
					</div>
				</div>
			{{# } }}
			</div>
		</div>
	</script>

	<script>
		$().ready(function() {

			$("#btn_note").bind("click", addNote);

			var exhibitionitem = ${exhibitionitem};
			showDetail(exhibitionitem);
			showNotes();
			
			$("#btn_edit",$("#item_detail")).bind("click",function(){
				toEditExhibitionItem(exhibitionitem);
			});
			
			if (!exhibitionitem.type.startsWith("PLAN")){
				$("#btn_accomplished").hide();
				$("#btn_failed").hide();
			}else{
				var accomplish_flg = exhibitionitem.accomplish_flg;
				
				if (accomplish_flg && accomplish_flg=="01"){
					showOk();
				}
				
				if (accomplish_flg && accomplish_flg=="02"){
					showNotOk();
				}
			}
			
			$("#btn_accomplished").click(function (){
				
				var url_to = $.getSitePath() + "/front/exhibition_item/${exhibitionitem._id_m}/accomplish";
				
				$.ajax({
					type : 'POST',
					url : url_to,
					data : {
						ts : new Date().getTime()
					},
					dataType : 'json',
					async : false,
					success : function(data) {

						$.logJson(data);
						if (data['success'] == 'n') {
						} else {
							showOk();
						}
					}
				});
			});
			
			$("#btn_failed").click(function (){
				
				var url_to = $.getSitePath() + "/front/exhibition_item/${exhibitionitem._id_m}/not_accomplish";
				
				$.ajax({
					type : 'POST',
					url : url_to,
					data : {
						ts : new Date().getTime()
					},
					dataType : 'json',
					async : false,
					success : function(data) {

						$.logJson(data);
						if (data['success'] == 'n') {
						} else {
							showNotOk();
							//	$("#accomplish_status_icon").css("color", "#5cb85c");
						}
					}
				});
			});
		});
		
		function hideOpButtons(){
			$("#btn_accomplished").hide();
			$("#btn_failed").hide();
		}
		
		function showOk(){
			
			hideOpButtons();
			
			$("#accomplish_status_icon").addClass("glyphicon-ok");
			$("#accomplish_status_icon").css("color", "#5cb85c");
			$("#accomplish_status_icon").css("margin-top", "8px");
		}
		
		function showNotOk(){
			
			hideOpButtons();
			
			$("#accomplish_status_icon").append('<i class="not_ok" style="width:70px;height:70px"></i>');
		}
		
		function iniNotesButtonEvent(){
			$("button",$("#all_notes")).bind("click",function(){
				var name = $(this).attr("r_name");
				var _id = $(this).closest(".btn-group").attr("data_id");
				
				var params = [];
				params.push("name=" + name);
				params.push("_id=" + _id);
				//alert(params.join("\n"));
				
				if (name=="delete"){
					var url_to = $.getSitePath() + "/note/" + _id + "/delete";

					$.ajax({
						type : 'POST',
						url : url_to,
						data : {
							ts : new Date().getTime()
						},
						dataType : 'json',
						async : false,
						success : function(data) {

							$.logJson(data);
							if (data['success'] == 'n') {
							} else {
								var segId = "#notes_" + _id;
								$(segId).remove();
								
								var ori_count = $("#all_notes_count").html();
								$("#all_notes_count").html(ori_count - 1);
							}
						}
					});
				}
				
				if (name=="edit"){
					var url_to = $.getSitePath() + "/note/" + _id + "/update";

					var title = "编辑【记录】"

					$.popUpWindow(title, url_to, "800", "360", "edit", $("#btn_edit"));
				}
				
				if (name=="note"){

					var params = [];
					params.push("user_id=${userid}");
					params.push("target_id=" + _id);
					params.push("target_type=note");

					params.push("ts=" + new Date().getTime());

					var url_to = $.getSitePath() + '/note/add/';
					url_to = url_to + "?" + params.join("&");

					$.popUpWindow("记一下", url_to, "800", "360", "add", $("#btn_note"));
				}
			});
		}
		
		function closeEditNoteWindow(){
			$.closeWindow("edit", $("#btn_edit"));
		}
		
		function showNotes() {

			var url_to = $.getSitePath()
					+ "/note/notes_of_target?target_id=${exhibitionitem._id_m}";

			var note_count = 0;
			
			$.ajax({
				type : 'POST',
				url : url_to,
				data : {
					ts : new Date().getTime()
				},
				dataType : 'json',
				async : false,
				success : function(data) {

					$.logJson(data);
					if (data['success'] == 'n') {
					} else {
						var gettpl = document.getElementById('note_tpl').innerHTML;
						laytpl(gettpl).render(data, function(html) {
							document.getElementById('all_notes').innerHTML = html;
						});
						
						note_count = data.total;
					}
				}
			});
			
			$("#badge").html(note_count);
			
			iniNotesButtonEvent();
			
			return note_count;
		}

		function addNote() {

			var params = [];
			params.push("user_id=${userid}");
			params.push("target_id=${exhibitionitem._id_m}");
			params.push("target_type=exhibitionitem");

			params.push("ts=" + new Date().getTime());

			var url_to = $.getSitePath() + '/note/add/';
			url_to = url_to + "?" + params.join("&");

			$.popUpWindow("记一下", url_to, "800", "360", "add", $("#btn_note"));
		}

		function refresh_note_count() {

			var note_count = showNotes();
			$("#badge").html(note_count);
			
			return; 
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
			$.logJson(type);
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
		
		
		/***************************************************************************
		 * 进入修改页面
		 * 
		 * @param data
		 */
		var toEditExhibitionItem= function(exhibitionitem) {
			
			var _id_m = exhibitionitem._id_m;
			var type = exhibitionitem.type;
			var type_name = exhibitionitem.type_name;

			var url = $.getSitePath() + '/front/exhibition_item/' + _id_m
					+ "/update?type=" + type;

			var title = "编辑【" + type_name + "】"

			$.popUpWindow(title, url, "90%", "90%", "edit", $("#btn_edit"));
		}
		
		var data_manage_functions = {

			/***************************************************************************
			 * 关闭编辑窗口
			 */
			closeEditWindow : function() {
				$.closeWindow("edit", $("#btn_edit"));
			},
			refreshPage : function() {
				
				var url_to = $.getSitePath() + '/front/exhibition_item/${exhibitionitem._id_m}/json';
				
				$.ajax({
					type : 'POST',
					url : url_to,
					data : {
						ts : new Date().getTime()
					},
					dataType : 'json',
					async : false,
					success : function(data) {
						$.logJson(data);
						showDetail(data);
					}
				});
			}
		};

	</script>
</body>
</html>