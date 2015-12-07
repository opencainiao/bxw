<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="${ctx}/resources/css/cus/cus-style.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="${ctx}/resources/laytpl/laytpl.js"></script>


<input type="hidden" name="_id_m" value="${contract._id_m }" />

<div id="content_inner_page" class="innercontent">
	<div class="navbar navbar-default ">
		<form class="navbar-form navbar-left">
			<button class="btn btn-primary" type="button" id="btn_add_file"
				>添加附件</button>
		</form>
	</div>

	<div id="file_div" class="panel panel-danger" style="margin: 3px">
		<div class="panel-heading hide">
			<span style="display: inline-block; width:160px!important;"> 
				附件【
				<span id="file_count_inpage">0</span>
				】个
			</span>
		</div>
		<div class="panel-body" id="file_div_body"></div>
	</div>
</div>

	<!-- 第一步：编写模版。你可以使用一个script标签存放模板，如： -->
	<script id="file_tpl" type="text/html">
				{{# for(var i = 0, len = d.length; i < len; i++){ }}
				<div class="panel panel-default" style="margin: 3px" id="{{ d[i].id}}"">
					<div class="panel-body" id="content" style="overflow:auto">
						<a href="${ctx }/attachment/{{ d[i].id}}">{{ d[i].name }}.{{d[i].suffix}}</a>
					</div>

					<div class="panel-footer">
						<div class="row ">
							<div class="btn-group  btn-group-xs pull-right" data_id="{{  d[i].id }}">
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
	</script>

<script type="text/javascript">

	function showFiles() {
		$("#file_count").html(0);
		$("#file_div_body").html("");

		var url_to = $.getSitePath()
				+ "/front/contract/get_files?contract_id=${contract._id_m}";

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
					
					var files = data.object;
					
					if (files.length>0){
						var gettpl = document.getElementById('file_tpl').innerHTML;
						laytpl(gettpl).render(files, function(html) {
							document.getElementById('file_div_body').innerHTML = html;
						});

						var file_count = files.length;

						$("#file_count").html(file_count);

						iniFilesButtonEvent();
					}
					
					note_count = data.total;
				}
			}
		});

		return note_count;
	}
	
	function iniFilesButtonEvent(){
		$("button",$("#file_div")).bind("click",function(){
			var name = $(this).attr("r_name");
			var _id = $(this).closest(".btn-group").attr("data_id");
			
			var params = [];
			params.push("name=" + name);
			params.push("_id=" + _id);
			//alert(params.join("\n"));
			
			if (name=="delete"){
				var url_to = $.getSitePath() + "/front/contract/delete_file?contract_id=${contract._id_m}&file_id=" + _id ;

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
							showFiles();
						}
					}
				});
			}
		});
	}
	
	function closeUpload_file() {
		$.closeWindow("add_file", $("#btn_add_file"));
	}

	function toUpload_file() {
		var url = $.getSitePath() + '/front/contract/to_upload_file?contract_id=${contract._id_m}';
		//alert(url);
		$.popUpWindow("上传附件", url, "800", "500", "add_file", $("#btn_add_file"),["","80px"]);
	}
	
	$().ready(function() {
		
		$("#btn_add_file").css("margin-left","-5px");
		$("#btn_add_file").click(function() {
			//alert("11");
			toUpload_file();
		})
		
		showFiles();
		
	});
</script>
