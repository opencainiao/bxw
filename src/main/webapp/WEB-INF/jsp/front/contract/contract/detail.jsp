<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<jsp:include page="/WEB-INF/jsp/include/common_css.jsp"></jsp:include>

</head>

<body>
	<ul class="breadcrumb" style="margin-bottom: 5px;">
		<li>
			<a href="<%=request.getContextPath()%>/front/contract/list">合同管理</a>
			<span class="divider"></span>
		</li>
		<li class="active">合同信息</li>
	</ul>
	<div>
		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
			<li role="presentation" class="active">
				<a href="#personal" aria-controls="home" role="tab"
					data-toggle="tab">基本信息</a>
			</li>
			<li role="presentation">
				<a href="#files" aria-controls="files" role="tab"
					data-toggle="tab">
					附件【
					<span id="file_count">0</span>
					】个
				</a>
			</li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div role="tabpanel" class="tab-pane active" id="personal">
				<jsp:include
					page="/WEB-INF/jsp/front/contract/contract/detail_contract.jsp"></jsp:include>
			</div>
			<div role="tabpanel" class="tab-pane" id="files">
				<jsp:include
					page="/WEB-INF/jsp/front/contract/contract/detail_files.jsp"></jsp:include>
			</div>
		</div>
	</div>
	<script>
		$().ready(function() {
			$("div.tab-pane").css("padding-top", "15px");
		});
	</script>
</body>
</html>