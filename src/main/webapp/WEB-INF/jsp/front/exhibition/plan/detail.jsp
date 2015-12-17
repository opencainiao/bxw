<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" />
<link id="xheCSS_default"
	href="${ctx }/resources/xheditor-1.2.2/xheditor_skin/default/ui.css"
	type="text/css" rel="stylesheet" />
<link rel="stylesheet"
	href="${ctx }/resources/xheditor-1.2.2/demos/common.css"
	type="text/css" media="screen" />
<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${ctx }/resources/xheditor-1.2.2/xheditor-1.2.2.js"></script>
<script type="text/javascript"
	src="${ctx }/resources/xheditor-1.2.2/xheditor_lang/zh-cn.js"></script>
<script src="http://apps.bdimg.com/libs/layer/2.0/layer.js"></script>
<script type="text/javascript"
	src="${ctx}/resources/js/jquery.nbq.ux.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery_ux_select.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/laydate-v1.1/laydate/laydate.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/layer-v2.0/layer/layer.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/layer/extend/layer.ext.js"></script>

<style>
.col-xs-5{
	padding-left: 0px;
}

.col-sm-3{
	padding-right: 0px;
}

label{
	padding-top: 6px;
}

#laydate_YY {
	width: 123px !important;
	height: 26px !important;
}

#laydate_MM {
	width: 101px !important;
	height: 26px !important;
}

#laydate_table {
	border-top-width: 0px !important;
}

#laydate_box {
	width: 242px !important;
}

.laydate_ym   label {
	margin-right: -3px !important;
}

#laydate_ys {
	width: 124px !important;
}

div.laydate_yms {
	width: 124px !important;
}

.laydate_bottom {
	height: 30px !important;
}
</style>
</head>
<body>
	<sf:form method="post" modelAttribute="plan" id="addForm"
		style="margin:0 0!important; padding: 0 0!important">

		<input type="hidden" id="type" name="type" value="${plan.type }" />

		<div class="panel panel-info" style="border:0px!important;margin-bottom: 2px;">
			<div class="panel-body">
				<div class="row" id="year_month_div" >
					<div class=" col-sm-4 " id="year_div">
						<span id="year">${plan.year }年</span>
						<span id="month">${plan.month }月</span>
						<span id="date">${plan.start_date } - ${plan.end_date }</span>
					</div>
					<div class=" col-sm-4 pull-right" id="edit_div">
						<span >最后编辑于【${plan.last_op_time }】</span>
					</div>
				</div>
			</div>
		</div>

		<div class="panel panel-info" style="margin-bottom: 0px;border:0px!important;">
			<div class="panel-body">
				${plan.content }
			</div>
		</div>
	</sf:form>

	<script>
		var content_editor;
		$().ready(
			function() {

				var plan_type = $("#type").val();
				if (plan_type == "PLAN_YEAR") {
					$("#month").hide();
					$("#date").hide();
				} else if (plan_type == "PLAN_MONTH") {
					$("#date").hide();
				} else if (plan_type == "PLAN_OTHER") {
					$("#year").hide();
					$("#month").hide();
				}

				content_editor = $('#content').xheditor();

				content_editor.settings.upImgUrl = "${ctx}/attachment/upload_xheditor?immediate=1";
				content_editor.settings.onUpload = function insertUpload(
						msg) {
					var attach = msg[0].attach;
					var attach_id = attach._id_m;
					addAttatch(attach_id);
				};

				$("#btn_save").bind("click", save);
				
				$("#start_date").click(function() {
					laydate({
						elem : '#start_date',
						istime : true,
						format : 'YYYY-MM-DD', // 分隔符可以任意定义，该例子表示只显示年月
						festival : true, //显示节日
						choose : function(datas) { //选择日期完毕的回调
							console.log(datas);
						}
					});
				});

				$("#start_date").val();

				$("#end_date").click(function() {
					laydate({
						elem : '#end_date',
						istime : true,
						format : 'YYYY-MM-DD', // 分隔符可以任意定义，该例子表示只显示年月
						festival : true, //显示节日
						choose : function(datas) { //选择日期完毕的回调

							console.log(datas);
						}
					});
				});
				$("#end_date").val();
		});

		function addAttatch(attach_id) {
			var attaches = $("#content").data("attaches");

			if (attaches == null) {
				attaches = [];
			}

			attaches.push(attach_id);

			$("#content").data("attaches", attaches);
		}
		//保存
		var save = function() {

			var content = content_editor.getSource();
			if (content.trim() == "") {
				layer.alert("内容不能为空");
				return false;
			}

			var paramForm = $('form').getFormParam_ux();
			paramForm["content"] = content.trim();
			paramForm["attaches"] = JSON.stringify($("#content").data(
					"attaches"));
			$.logJson(paramForm);

			var url_to = $.getSitePath() + "/front/plan/add";
			var params = [];
			params.push("ts=" + new Date().getTime());
			url_to = url_to + "?" + params.join("&");

			// 控制按钮为禁用
			$.disableButton("btn_save");

			$.ajax({
				type : 'POST',
				url : url_to,
				data : $.extend({
					ts : new Date().getTime()
				}, paramForm),
				dataType : 'json',
				success : function(data) {

					if (data['success'] == 'n') {
						if (data['brErrors']) {
							$.alertBRErrorMask(data['brErrors'],
									"错误");
						} else {
							$.alertError(data['message']);
						}
					} else {

						var callback = parent.closeAddNoteWindow;

						layer.open({
							title : [ '成功',
									'font-size:18px;background-color: #dff0d8;' ],
							content : '添加成功',
							yes : function(index) {
								var url_to = $.getSitePath() + '/front/plan/list';

								window.location.href = url_to;
							}
						});
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