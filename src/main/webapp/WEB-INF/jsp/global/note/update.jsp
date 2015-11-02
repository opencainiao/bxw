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
		href="http://xheditor.com/js/xheditor_skin/default/ui.css"
		type="text/css" rel="stylesheet" />
		<link rel="stylesheet"
			href="${ctx }/resources/xheditor-1.2.2/demos/common.css"
			type="text/css" media="screen" />
		<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
		<script type="text/javascript"
			src="${ctx }/resources/xheditor-1.2.2/xheditor-1.2.2.min.js"></script>
		<script type="text/javascript"
			src="${ctx }/resources/xheditor-1.2.2/xheditor_lang/zh-cn.js"></script>
		<script src="http://apps.bdimg.com/libs/layer/2.0/layer.js"></script>
		<script type="text/javascript"
			src="${ctx}/resources/js/jquery.nbq.ux.js"></script>
</head>
<body>
	<sf:form method="post" modelAttribute="note" id="addForm" style="margin:0 0!important; padding: 0 0!important">
		<input type="hidden" id="user_id" name="user_id"
			value="${note.user_id }" />
		<input type="hidden" id="target_id" name="target_id"
			value="${note.target_id }" />
		<input type="hidden" id="target_type" name="target_type"
			value="${note.target_type }" />
		<div class="panel panel-info" style="margin-bottom: 0px;">
			<div class="panel-heading hide">
				<h3 class="panel-title">编辑【记录】</h3>
			</div>
			<div class="panel-body">
				<textarea id="content" name="content"
					class="xheditor-simple {upImgUrl:'/uploadImg',upImgExt:'jpg,jpeg,gif,png'}"
					rows="12" cols="80" style="width: 100%">${note.content }</textarea>
			</div>
			<div class="panel-footer">
				<div class="row ">
					<button type="button" id="btn_save"
						class="btn btn-primary btn-sm center-block">提交</button>
				</div>
			</div>
		</div>
	</sf:form>

	<script>
		var content_editor;
		$().ready(function() {

			content_editor = $('#content').xheditor();

			$("#btn_save").bind("click", save);
		});

		//保存
		var save = function() {

			var content = content_editor.getSource();
			if (content.trim() == "") {
				layer.alert("内容不能为空");
				return false;
			}

			var paramForm = $('form').getFormParam_ux();
			paramForm["content"] = content.trim();
			$.logJson(paramForm);

			var url_to = $.getSitePath() + "/note/${note._id_m }/update";
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
							$.showBRErrors_mou_abs(data['brErrors'],
									$("#addForm"));
						} else {
							$.alertError(data['message']);
						}
					} else {

						var callback = parent.closeAddNoteWindow;
						
						layer.open({
							title: ['成功', 'font-size:18px;background-color: #dff0d8;'],
						    content: '修改成功',
						    yes: function(index){
						    	parent.refresh_note_count();
						    	parent.closeEditNoteWindow(); //一般设定yes回调，必须进行手工关闭
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