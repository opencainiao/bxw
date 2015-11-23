<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="${ctx}/resources/css/cus/cus-style.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="${ctx}/resources/laytpl/laytpl.js"></script>


<input type="hidden" name="_id_m" value="${client._id_m }" />

<div id="content_inner_page" class="innercontent">
	<div class="navbar navbar-default hide">
		<form class="navbar-form navbar-left">
			<button class="btn btn-primary" type="button" id="btn_add"
				style="margin-left: 1px !important;">添加图片</button>
		</form>
	</div>

	<div id="visiting_card" class="panel panel-danger" style="margin: 3px">
		<div class="panel-heading">
			<span style="display: inline-block; width:160px!important;"> 
				名片【
				<span id="all_visiting_cart_count">0</span>
				】张
			</span>
			<span> <button class="btn btn-primary" type="button" id="btn_add_visiting_card"
				style="margin-left: 1px !important; margin-bottom: -3px;">添加名片</button> </span>
		</div>
		<div class="panel-body" id="visiting_card_body"></div>
	</div>
	
	<div id="id_card" class="panel panel-info" style="margin: 3px">
		<div class="panel-heading">
			<span style="display: inline-block; width:160px!important;"> 
				身份证【
				<span id="all_id_cart_count">0</span>
				】张
			</span>
			<span> <button class="btn btn-primary" type="button" id="btn_add_id_card"
				style="margin-left: 1px !important; margin-bottom: -3px;">添加身份证</button> </span>
		</div>
		<div class="panel-body" id="id_card_body"></div>
	</div>
</div>

	<!-- 第一步：编写模版。你可以使用一个script标签存放模板，如： -->
	<script id="visiting_tpl" type="text/html">
				{{# for(var i = 0, len = d.length; i < len; i++){ }}
				<div class="panel panel-default" style="margin: 3px" id="{{ d[i]}}"">
					<div class="panel-body" id="content" style="overflow:auto">
						<img  src="${ctx }/attachment/{{ d[i]}}" alt="" style="max-width:400px">
					</div>

					<div class="panel-footer">
						<div class="row ">
							<div class="btn-group  btn-group-xs pull-right" data_id="{{  d[i] }}">
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

	<script id="id_card_tpl" type="text/html">
				{{# for(var i = 0, len = d.length; i < len; i++){ }}
				<div class="panel panel-default" style="margin: 3px" id="{{ d[i]}}"">
					<div class="panel-body" id="content" style="overflow:auto">
						<img  src="${ctx }/attachment/{{ d[i]}}" alt=""  style="max-width:400px">
					</div>

					<div class="panel-footer">
						<div class="row ">
							<div class="btn-group  btn-group-xs pull-right" data_id="{{  d[i] }}">
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

	function showVisitIngCards() {
		$("#all_visiting_cart_count").html(0);
		$("#visiting_card_body").html("");

		var url_to = $.getSitePath()
				+ "/front/client/get_visiting_cards?client_id=${client._id_m}";

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
					
					var visiting_cards = data.object;
					
					if (visiting_cards.length>0){
						var gettpl = document.getElementById('visiting_tpl').innerHTML;
						laytpl(gettpl).render(visiting_cards, function(html) {
							document.getElementById('visiting_card_body').innerHTML = html;
						});

						var visiting_card_count = visiting_cards.length;

						$("#all_visiting_cart_count").html(visiting_card_count);

						iniVisitingCardButtonEvent();
					}
					
					note_count = data.total;
				}
			}
		});

		return note_count;
	}
	
	function iniVisitingCardButtonEvent(){
		$("button",$("#visiting_card")).bind("click",function(){
			var name = $(this).attr("r_name");
			var _id = $(this).closest(".btn-group").attr("data_id");
			
			var params = [];
			params.push("name=" + name);
			params.push("_id=" + _id);
			//alert(params.join("\n"));
			
			if (name=="delete"){
				var url_to = $.getSitePath() + "/front/client/delete_visiting_card?client_id=${client._id_m}&card_id=" + _id ;

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
							showVisitIngCards();
						}
					}
				});
			}
		});
	}
	
	function closeUpload_Visiting_Card_Img() {
		$.closeWindow("add_visiting_card", $("#btn_add_visiting_card"));
	}

	function toUpload_Visiting_Card_Img() {
		var url = $.getSitePath() + '/front/client/to_upload_visiting_card?client_id=${client._id_m}';
		//alert(url);
		$.popUpWindow("上传用户名片", url, "90%", "90%", "add_visiting_card", $("#btn_add_visiting_card"));
	}
	
	
	function showIdCards() {
		$("#all_id_cart_count").html(0);
		$("#id_card_body").html("");

		var url_to = $.getSitePath()
				+ "/front/client/get_id_cards?client_id=${client._id_m}";

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
					
					var id_cards = data.object;
					
					if (id_cards.length>0){
						var gettpl = document.getElementById('id_card_tpl').innerHTML;
						laytpl(gettpl).render(id_cards, function(html) {
							document.getElementById('id_card_body').innerHTML = html;
						});

						var id_card_count = id_cards.length;

						$("#all_id_cart_count").html(id_card_count);

						iniIdCardButtonEvent();
					}
				}
			}
		});

	}
	
	function iniIdCardButtonEvent(){
		$("button",$("#id_card")).bind("click",function(){
			var name = $(this).attr("r_name");
			var _id = $(this).closest(".btn-group").attr("data_id");
			
			var params = [];
			params.push("name=" + name);
			params.push("_id=" + _id);
			//alert(params.join("\n"));
			
			if (name=="delete"){
				var url_to = $.getSitePath() + "/front/client/delete_id_card?client_id=${client._id_m}&card_id=" + _id ;

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
							showIdCards();
						}
					}
				});
			}
		});
	}
	
	function closeUpload_Id_Card_Img() {
		$.closeWindow("add_id_card", $("#btn_add_id_card"));
	}

	function toUpload_Id_Card_Img() {
		var url = $.getSitePath() + '/front/client/to_upload_id_card?client_id=${client._id_m}';
		//alert(url);
		$.popUpWindow("上传用户身份证", url, "90%", "90%", "add_id_card", $("#btn_add_id_card"));
	}
	
	
	$().ready(function() {
		$("#btn_add_visiting_card").click(function() {
			toUpload_Visiting_Card_Img();
		})
		
		showVisitIngCards();
		
		$("#btn_add_id_card").click(function() {
			toUpload_Id_Card_Img();
		})
		
		showIdCards();
	});
</script>
<script type="text/javascript"
	src="${ctx }/resources/js/front/client/client_info/full/list_familly.js"></script>
