<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- add scripts -->
<jsp:include page="/WEB-INF/jsp/include/common_css.jsp"></jsp:include>
<link href="${ctx }/resources/file_upload/css/main.css" rel="stylesheet"
	type="text/css" />
<jsp:include page="/WEB-INF/jsp/include/common_js.jsp"></jsp:include>
<script src="${ctx }/resources/file_upload/js/script.js"></script>
<style>
.info input {
	width: 120px;
}
</style>
</head>
<body>
	<div class="upload_form_cont">
		<form id="upload_form" enctype="multipart/form-data" method="post"
			data-url="${ctx}/front/client/${client_id}/upload_file">
			<div>
				<div>
					<input type="file" name="image_file" id="image_file"
						onchange="fileSelected();" />
				</div>
			</div>
			<div>
				<input type="button" value="Upload" onclick="startUploading()" />
			</div>
			<div id="fileinfo">
				<div id="filename"></div>
				<div id="filesize"></div>
				<div id="filetype"></div>
				<div id="filedim"></div>
			</div>
			<div id="error">You should select valid image files only!</div>
			<div id="error2">An error occurred while uploading the file</div>
			<div id="abort">The upload has been canceled by the user or the
				browser dropped the connection</div>
			<div id="warnsize">文件大小超过50M,请选择小文件</div>

			<div id="progress_info">
				<div id="progress"></div>
				<div id="progress_percent">&nbsp;</div>
				<div class="clear_both"></div>
				<div>
					<div id="speed">&nbsp;</div>
					<div id="remaining">&nbsp;</div>
					<div id="b_transfered">&nbsp;</div>
					<div class="clear_both"></div>
				</div>
				<div id="upload_response"></div>
			</div>
		</form>

		<img id="preview" />
	</div>
</body>
<script >
function uploadComplete(responseText) {
	
	var data = JSON.parse(responseText);
	
	$.logJson(data);

	if (data['success'] == 'n') {
		
		$.alertError(data['message']);
		
	} else {
		parent.showFiles();
		parent.closeUpload_file();
	}
}
</script>
</html>