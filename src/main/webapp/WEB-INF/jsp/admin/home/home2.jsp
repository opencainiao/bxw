<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title></title>

<jsp:include page="/WEB-INF/jsp/include/common_css_gentelella.jsp"></jsp:include>
</head>

<script type="text/javascript">
function handIframeLoad() {
    autoHeight();
}

function autoHeight() {
    var iframe = document.getElementById("frame_content_id");

    var toShow = [];

    var toSetH = 0;

    var iframeContentH = 0;

    if (iframe.Document) { //ie自有属性
        iframeContentH = iframe.Document.documentElement.scrollHeight;
    } else if (iframe.contentDocument) { //ie,firefox,chrome,opera,safari
        iframeContentH = iframe.contentDocument.body.offsetHeight;
    }

    iframeContentH = iframeContentH + 40;
    
    toShow.push("iframeContentH[" + iframeContentH + "]");
    
    var frameH = $("#frame_content_id").height();

    var windowH =  $(window).height();
    
    toShow.push("$(window).height["+ windowH +"]" );
    toShow.push("frameH[" + frameH + "]");

    if (iframeContentH > frameH) {
        toSetH = iframeContentH ;
    } else {
    	if (iframeContentH > windowH){
    		toSetH = iframeContentH ;
    	}else{
    		toSetH = frameH ;
    	}
    }
    
   // alert(toShow.join("\n"));
    //iframe.height = toSetH;
    
    $("#frame_content_id").height(toSetH + 10);
    
  //  if (iframe.Document) { //ie自有属性
  //      iframeDoc = iframe.Document;
  //  } else if (iframe.contentDocument) { //ie,firefox,chrome,opera,safari
  //      iframeDoc = iframe.contentDocument;
 //   }
    
   // iframeDoc.height = toSetH - 5;
}

</script>

<body class="nav-md" style="background: #2a3f54">
	<nav class="navbar navbar-inverse " style="border: 0px;">
		<div class="container-fluid" style="padding: 0 0;">
			<!-- 导航栏 -->
			<div id="top_nav" class="row" style="margin: 0 0">
			<jsp:include
				page="/WEB-INF/jsp/admin/include/common_nav_top_gentelella.jsp"></jsp:include>
			
			</div>
		</div>
	</nav>

	<div class="container-fluid"
		style="padding-left: 0px; padding-right: 0px;">
		<div class="row"
			style="margin-top: 0px; margin-left: 0px; margin-right: 0px;">
			<div id="left_menu_tree" class="col-sm-3 col-md-2 sidebar"
				style="padding-left: 0px; padding-right: 0px; float: left">
				<jsp:include
				page="/WEB-INF/jsp/admin/include/common_nav_left_gentelella.jsp"></jsp:include>	
			</div>
			<div class="col-sm-9 col-md-10 main"
				style="float: left; padding: 10px 10px 0 10px; background-color: white;">
				<iframe id="frame_content_id" name="frame_content_id"
					class="frame_content_container" width="100%" style="height: 100%;"
					frameborder="0" onload="handIframeLoad()"> </iframe>
			</div>
			
		</div>
	</div>
	
	

	<div id="custom_notifications" class="custom-notifications dsp_none">
		<ul class="list-unstyled notifications clearfix"
			data-tabbed_notifications="notif-group">
		</ul>
		<div class="clearfix"></div>
		<div id="notif-group" class="tabbed_notifications"></div>
	</div>

	<jsp:include page="/WEB-INF/jsp/include/common_js_gentelella.jsp"></jsp:include>

	<script type="text/javascript">
    	
	    function refreshHeadImg(_id_m) {
	
			var new_src = $.getSitePath() + "/attachment/" + _id_m;
			
			$("#head_img_top").attr("src", new_src);
			$("#head_img_left").attr("src", new_src);
		}
    
        $(document).ready(function () {
            $("#frame_content_id").load(function(){  
            	var iframe_h = $.autoHeight("frame_content_id");
            });  
            
        	loadTree();
        	
        	initTopNavBehave();
        	
        	$.setSitePath("${ctx}");
        	$.setAllConstants(eval(${ALLCONSTANT}));
        	
        	var sysmodule = $.getConstants("SYS_MODULE");
        	//$.alertObjJson(sysmodule);
        	
        	//$.alertObjJson($.getConstantName("SYS_MODULE","02"));
        });
        
    </script>
</body>

</html>
