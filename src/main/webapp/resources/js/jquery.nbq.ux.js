;;
(function($) {
	$.extend({
		/***********************************************************************
		 * 设置系统路径
		 * 
		 * @returns
		 */
		setSitePath : function(ctx) {
			localStorage.setItem("SITE_PATH",ctx);
		},
		/***********************************************************************
		 * 取系统路径
		 * 
		 * @returns
		 */
		getSitePath : function() {
			return localStorage.getItem("SITE_PATH");
		},
		logJson:function(obj,str){
			if (str){
				console.log(str + "---#" +JSON.stringify(obj) +"#");
			}else{
				console.log(JSON.stringify(obj));
			}
		},
		alertObjJson : function(obj) {
			alert(JSON.stringify(obj));
		},
		toJsonStr : function(obj){
			return JSON.stringify(obj);
		},
		loadPage : function(url_to) {
			window.location.href = url_to;
		},
		setPWindowH:function(key,$obj,H){
			var index = $obj.attr(key);
			
			$.logJson("index--" + index);
			$.logJson("H--" + H);
			
			var pWindow = $("#xubox_layer" + index);
			pWindow.height(H);

			var pWindowIframe = $("#xubox_iframe" + index);
			pWindowIframe.height(H - 40);
			
		},
		closeWindow : function(key, $obj) {
			layer.close($obj.attr(key));
		},
		popUpWindow : function(title, url, width, height, key, $obj, offset) {

			var w = width || '80%';
			var h = height || '80%';

			var offset_default = [ '', '' ];

			if (offset) {
				offset_default = offset;
			}

			$.layer({
				type : 2,
				title : [ title, 'background:#2B2E37; height:40px; color:#fff; border:none;' // 自定义标题样式
				],
				border : [ 0 ],
				area : [ w, h ],
				offset : offset_default,
				btns : 0,
				btn : [],
				iframe : {
					scrolling : 'yes',
					src : url
				},
				closeBtn : [ 0, true ],
				yes : function(index) {
					layer.close(index);
				},
				no : function(index) {
				},
				success : function(layero) {
					var popid = layero.selector;
					var index = $.getLayerIndex(popid);

					$obj.attr(key, index);
				}
			})
		},
		showDetailWindow : function(title, url, width, height) {

			var w = width || '80%';
			var h = height || '80%';

			$.layer({
				type : 2,
				title : [ title, 'background:#2B2E37; height:40px; color:#fff; border:none;' // 自定义标题样式
				],
				border : [ 0 ],
				area : [ w, h ],
				btns : 0,
				btn : [],
				iframe : {
					scrolling : 'yes',
					src : url
				},
				closeBtn : [ 0, true ],
				yes : function(index) {
					layer.close(index);
				},
				no : function(index) {
				},
				success : function(layero) {
					var popid = layero.selector;
					var $edit_main = $("#edit_materialtype_main");

					$edit_main.attr("popid", popid);
				}
			})
		},
		alertSuccessCallback : function(title, message, callback, offset) {
			var obj = {};

			obj["type"] = "success";
			obj["title"] = title;
			obj["message"] = message;
			if (offset) {
				obj["offset"] = offset;
			}

			if (callback) {
				$.alertMsg(obj, callback);
			}
		},
		alertSuccessNewPageMask:function(title, message, newpage){
			$.alertSuccessNewPage(title, message, newpage,[0.5, '#000']);
		},
		alertSuccessNewPage : function(title, message, newpage, shade) {
			var obj = {};

			if (newpage) {
				obj["newpage"] = newpage;
			}
			obj["type"] = "success";
			obj["title"] = title;
			obj["message"] = message;
			obj["shade"] = shade;

			$.alertMsg(obj);
		},
		alertSuccess : function(title, message, offset) {
			var obj = {};

			obj["type"] = "success";
			obj["title"] = title;
			obj["message"] = message;
			if (offset) {
				obj["offset"] = offset;
			}
			obj["shade"] = [0.5, '#000'];

			$.alertMsg(obj);
		},
		alertError : function(message, title, offset) {
			var obj = {};

			obj["type"] = "error";
			obj["title"] = title || "信息";
			obj["message"] = message;
			if (offset) {
				obj["offset"] = offset;
			}

			$.alertMsg(obj);
		},
		alertErrorMask : function(message, title, offset) {
			var obj = {};

			obj["type"] = "error";
			obj["title"] = title || "信息";
			obj["message"] = message;
			if (offset) {
				obj["offset"] = offset;
			}
			obj["shade"] = [0.5, '#000'];
			$.alertMsg(obj);
		},
		alertBRErrorMask : function(brErrors, title, offset) {
			
			var error = "";
			for (var i in brErrors){
				//error = i + "-->" + brErrors[i] + "<br>";
				error = brErrors[i] + "<br>";
			}
			
			var obj = {};

			obj["type"] = "error";
			obj["title"] = title || "信息";
			obj["message"] = error;
			if (offset) {
				obj["offset"] = offset;
			}
			obj["shade"] = [0.5, '#000'];
			$.alertMsg(obj);
		},
		alertMsg : function(obj, call) {
			var title_sucess_css = "background: #337ab7;!important  border-color: #337ab7; color: #fff;font-size: 16px;";
			var html_content = '<div class="panel panel-default" style="width:400px; margin-bottom: 0px;border:0px">                     ' + '    <div class="panel-body" style="padding:0px!important">                                               '
					+ '        <div class="media" style="height:113px">                                                         ' + '            <div class="media-left ">                                                                    '
					+ '                #icon#                                                                                   ' + '                <div style="width: 50px;">                                                               '
					+ '                    &nbsp;                                                                               ' + '                </div>                                                                                   '
					+ '            </div>                                                                                       ' + '            <div class="media-body">                                                                     '
					+ '                <p style="margin-top: 10px">                                                                                      ' + '                    #content#                                                                            '
					+ '                </p>                                                                                     ' + '            </div>                                                                                       '
					+ '        </div>                                                                                           ' + '        <nav class="navbar navbar-default " style="margin-bottom: 0px;border-radius:0px;border:0px;">    '
					+ '            <button class="btn btn-ok #btn-typ# center-block navbar-btn" type="button"  style="margin:8px auto 0 !important;">                       ' + '                确定                                                                                     '
					+ '            </button>                                                                                    ' + '        </nav>                                                                                           '
					+ '    </div>                                                                                               ' + '</div> ';

			var title = obj.title;
			var message = obj.message;
			var type = obj.type;

			if (type == "success") {
				var iconhtml = '<span class="xubox_msg xulayer_png32 xubox_msgico xubox_msgtype1" style="top: 10px;"></span>';

				html_content = html_content.replace("#icon#", iconhtml);

				html_content = html_content.replace("#btn-typ#", "btn-success");

			} else if (type == "error") {
				var iconhtml = '<span class="xubox_msg xulayer_png32 xubox_msgico xubox_msgtype3" style="top: 10px;"></span>';

				html_content = html_content.replace("#icon#", iconhtml);

				message = '<span style="color:red">' + message + '</span>'

				html_content = html_content.replace("#btn-typ#", "btn-primary");
			}

			html_content = html_content.replace("#content#", message);

			var offset_default = [ '', '' ];
			if (obj["offset"]) {
				offset_default = obj["offset"];
			}

			var obj = obj || {};
			var pageii = $.layer({
				type : 1,
				title : [ title, title_sucess_css ],
				area : obj.area ? [ obj.area[0] + 'px', obj.area[1] + 'px' ] : [ '400px', '200px' ],
				border : [ 1, 0.9, '#337ab7' ],
				offset : offset_default,
				shade : obj.shade? obj.shade :[ 1 ], // 0-去掉遮罩
				closeBtn : [ 0, false ], // 去掉默认关闭按钮
				page : {
					html : html_content
				},
				success : function(layero) {

					var popid = layero.selector;
					var $choose_spec = $("#choose_spec");
					var index = $.getLayerIndex(popid);
					$("#xubox_border" + index).css("border-radius", "0px");

					layero.find('.btn-ok').on('click', function() {

						if (obj["newpage"]) {
							window.location.href = obj["newpage"];
						} else {
							if (call) {
								call && call();
							}

							layer.close(pageii);
						}
					});
				}
			});
		},
		getTitleAndFieldFromGrid:function(cfg){
			var colModel = cfg.colModel;
			
			var titles = [];
			var fields = [];
			
			for (var i=0;i<colModel.length; ++i){
				var colModelT = colModel[i];
				
				if (!colModelT.hide){
					
					if (colModelT.display && colModelT.name){
						
						if (colModelT.m_type && colModelT.m_type == 'buttons'){
							
						}else{
							titles.push(colModelT.display);
							fields.push(colModelT.name);
						}
					}
				}
			}
			
			return {
				titles : titles,
				fields : fields
			};
		},
		getEncodVal : function($obj) {
			return $.htmlEncode($obj.val().trim());
		},
		htmlDecodeContainer : function(container) {
			$("input", $(container)).each(function() {
				$(this).val($.htmlDecode($(this).val()));
			})
			$("textarea", $(container)).each(function() {
				$(this).val($.htmlDecode($(this).val()));
			})
		},
		htmlEncode : function(value) {
			return $('<div />').text(value).html();
		},
		htmlDecode : function(value) {
			return $('<div />').html(value).text();
		},
		getLayerIndex : function(layerid) {
			return layerid.substring("#xubox_layer".length);
		},
		/*
		 * 检测对象是否是空对象(不包含任何可读属性)。 方法只既检测对象本身的属性，不检测从原型继承的属性。
		 */
		isOwnEmpty : function(obj) {
			for ( var name in obj) {
				if (obj.hasOwnProperty(name)) {
					return false;
				}
			}
			return true;
		},
		/***********************************************************************
		 * 取同名元素的值，返回为数组
		 */
		getMultiParamValue : function(name) {
			var values = $.map($("input[name='" + name + "']"), function(obj) {
				return $(obj).val();
			});
			return values;
		},

		resizeParentIFrame : function(iframeID, height) {
			var content_iframe = window.parent.document.getElementById(iframeID);// 获取iframeID
			// var div_height = parseInt($(content_iframe).contents()
			// .find("子网页ID").css("height"));// 使iframe高度等于子网页高度
			content_iframe.height = height + 100;
		},

		/***********************************************************************
		 * 将当前页面所在iframe大小调整成页面文档大小
		 */
		resizeParentIframeToPage : function(iframeID) {

			var docH = $(document).height();
			var windowH = $(window).height();

			// var formatStr = [];
			// formatStr.push("docH[" + docH + "]");
			// formatStr.push("window[" + windowH + "]");

			$.resizeParentIFrame(iframeID, docH);

			// alert(formatStr.join("\n"));
		},

		/***********************************************************************
		 * 将当前页面所在iframe大小调整成页面文档大小（当前项目）
		 */
		resizeParentIframePj : function() {
			$.resizeParentIframeToPage("frame_content_id");
		},

		/***********************************************************************
		 * 调用弹出页面的js方法
		 */
		callLayerFunc : function(layerIndex, callback, param) {

			var frameName = "xubox_iframe" + layerIndex;
			var _function = window.frames[frameName].eval(callback);

			if (arguments.length > 2) {
				return _function(param);
			} else {
				return _function();
			}
		},
		/***********************************************************************
		 * 取iframe的页面的Document
		 */
		getIframeDoc : function() {

			var iframeDoc;
			var iframe = document.getElementById("frame_content_id");

			if (iframe.Document) {// ie自有属性
				iframeDoc = iframe.Document;
			} else if (iframe.contentDocument) {// ie,firefox,chrome,opera,safari
				iframeDoc = iframe.contentDocument;
			}

			return iframeDoc;
		},
		downLoadFile : function(config) {
			
			var url = config.url; //  下载路径
			
			var form = $("<form>");//定义一个form表单
			form.attr('style','display:none');
			form.attr('target','');
			form.attr('method','post');
			form.attr('action',url);
			
			var params = config.params;
			
			for (var i in params){
				var param_name = i;
				var param_value = params[i];
				
				var input = $("<input>");
				input.attr('type','hidden');
				input.attr('name',param_name);
				input.attr('value',param_value);
				
				form.append(input);
			}
			
			//将表单放到body中
			$('body').append(form);
			form.submit();//提交表单
		},
		/***********************************************************************
		 * 取iframe的页面的window
		 */
		getIframeWindow : function() {

			var iframe = document.getElementById("frame_content_id");
			var iframeWindow = iframe.contentWindow;

			return iframeWindow;
		},
		setIframeHeight : function(iframe_id, h) {

			var iframe = document.getElementById(iframe_id);

			$(iframe).height(h);
		},
		autoHeight : function(iframe_id) {

			var iframe = document.getElementById(iframe_id);

			var toShow = [];

			var toSetH = 0;

			var iframeContentH = 0;

			if (iframe.Document) { // ie自有属性
				iframeContentH = iframe.Document.documentElement.scrollHeight;
			} else if (iframe.contentDocument) { // ie,firefox,chrome,opera,safari

				iframeContentH = $("#" + iframe_id).contents().find("body").height();

				// iframeContentH = iframe.contentDocument.body.offsetHeight;
			}

			toShow.push("iframeContentH[" + iframeContentH + "]");

			toSetH = iframeContentH + 10;

			// alert(toShow.join("\n"));

			iframe.height = toSetH;

			if (iframe.Document) { // ie自有属性
				iframeDoc = iframe.Document;
			} else if (iframe.contentDocument) { // ie,firefox,chrome,opera,safari
				iframeDoc = iframe.contentDocument;
			}

			iframeDoc.height = toSetH + 5;
			$(iframe).height(toSetH + 8);

			return iframeDoc.height;
		},
		time2minut:function(time){
			return time.substring(0, 16);
		}
	});
})(jQuery);
;;

$.browser = {
	mozilla : /firefox/.test(navigator.userAgent.toLowerCase()),
	webkit : /webkit/.test(navigator.userAgent.toLowerCase()),
	opera : /opera/.test(navigator.userAgent.toLowerCase()),
	msie : /msie/.test(navigator.userAgent.toLowerCase())
};

(function($) {
	$.fn.isExist_ux = function() {
		return this.length > 0;
	};
	
	$.fn.trim_value = function(){
		var value = $.htmlDecode($(this).val().trim());
		return value;
	};
	
	$.fn.serializeJsonObject = function()
	{
	  var o = {};
	  var a = this.serializeArray();
	  $.each(a, function() {
	    if (o[this.name] !== undefined) {
	      if (!o[this.name].push) {
	        o[this.name] = [o[this.name]];
	      }
	      o[this.name].push(this.value || '');
	    } else {
	      o[this.name] = this.value || '';
	    }
	  });
	  return o;
	};

	/**
	 * 将表单中各域的值自动封装成参数对象<br>
	 * 包括 DDL方式的下拉列表对象
	 * 
	 * @param {Object}
	 *            oFrm 表单对象
	 */
	$.fn.getFormParam_ux = function() {
		var oFrm = $(this)[0];
		var len = oFrm.elements.length;
		var ret = {};
		// 普通元素
		for (var i = 0; i < len; i++) {

			var oEle = oFrm.elements[i];
			
			var key = oEle.id || oEle.name;
			var value = oEle.value.trim();
			
			if (oEle.type === "radio") {
				if (oEle.checked) {
					ret[key] = value;
				}
			} else if (oEle.type === "checkbox") {
				var curVal = ret[key];
				if (curVal === undefined) {
					ret[key] = [];
					if (oEle.checked) {
						ret[key].push(value);
					}
				} else {
					if (oEle.checked) {
						ret[key].push(value);
					}
				}
			} else {
				ret[key] = value;
			}
		}
		return ret;
	};
})(jQuery);

// 封装全局函数
;
(function($) {
	$.extend({
		/***********************************************************************
		 * 判断对象是否是array类型 <br>
		 * aa = [1,2,3]; dd = $.isArray(aa);
		 * 
		 * @param obj
		 * @returns {Boolean}
		 */
		isArray : function(obj) {
			return Object.prototype.toString.call(obj) === '[object Array]';
		},
		isLowerBrowser : function() {
			if ($.isIE()) {
				var version = $.ieVersion();

				if (version <= 9) {
					return true;
				}
			} else {
				return false;
			}

		},
		isIE : function() {
			var browser = navigator.appName;
			if (browser == "Microsoft Internet Explorer") {
				return true;
			}

			return false;
		},
		ieVersion : function() {
			var browser = navigator.appName
			var b_version = navigator.appVersion
			var version = b_version.split(";");
			var trim_Version = version[1].replace(/[ ]/g, "");
			if (browser == "Microsoft Internet Explorer" && trim_Version == "MSIE6.0") {
				return 6;
			} else if (browser == "Microsoft Internet Explorer" && trim_Version == "MSIE7.0") {
				return 7;
			} else if (browser == "Microsoft Internet Explorer" && trim_Version == "MSIE8.0") {
				return 8;
			} else if (browser == "Microsoft Internet Explorer" && trim_Version == "MSIE9.0") {
				return 9;
			} else {
				return 100;
			}
		},
		getNavigatorType : function() {
			if (navigator.userAgent.indexOf("MSIE") > 0) {
				return "MSIE";
			}
			if (isFirefox = navigator.userAgent.indexOf("Firefox") > 0) {
				return "Firefox";
			}
			if (isSafari = navigator.userAgent.indexOf("Safari") > 0) {
				return "Safari";
			}
			if (isOpera = navigator.userAgent.indexOf("Opera") > 0) {
				return "Opera";
			}
			if (isCamino = navigator.userAgent.indexOf("Camino") > 0) {
				return "Camino";
			}
			if (isMozilla = navigator.userAgent.indexOf("Gecko/") > 0) {
				return "Gecko";
			}
		},
		/***********************************************************************
		 * 判断obj是否有propName属性
		 * 
		 * @param obj
		 * @param propName
		 * @returns {Boolean}
		 */
		hasPro : function(obj, propName) {
			return (propName in obj);
		},
		/***********************************************************************
		 * 单form的添加和编辑页面的布局设置
		 */
		pageLayOutForDetail_oneForm : function() {

			var window_h = $(window).height();
			var formdiv_h = $(".formdiv").height();
			var innerPage_h = $(".innerPage").height();

			if ((formdiv_h + 15) <= innerPage_h) {
				$(".innerPage").height(innerPage_h - 15);
			}
			//
			// var arr = [];
			// arr.push("window_h--" + $(window).height());
			// arr.push("innerPage_h--" + $(".innerPage").height());
			// arr.push("formdiv_h--" + $(".formdiv").height());
			// alert(arr.join("\n"));
		},
		/***********************************************************************
		 * 取节点的符合条件的子节点 <br>
		 * var node_ = $.getChildrenNodeByParam_ux(node2,"dptnum", "000071"); //
		 * alert(jsonToString(node_));
		 * 
		 * @param node
		 * @param key
		 * @param value
		 * @returns
		 */
		getChildrenNodeByParam_ux : function(node, key, value) {
			if (!node || !key)
				return null;

			var nodes = node.children;
			for (var i = 0, l = nodes.length; i < l; i++) {
				if (nodes[i][key] == value) {
					return nodes[i];
				}
			}
			return null;
		},
		/***********************************************************************
		 * 控制按钮为禁用
		 * 
		 * @param btnId
		 */
		disableButton : function(btnId) {
			$("#" + btnId).attr({
				"disabled" : "disabled"
			}).addClass('disabled-button');
		},
		/***********************************************************************
		 * 控制按钮为可用(延迟两秒)
		 * 
		 * @param btnId
		 */
		enableButton : function(btnId) {
			setTimeout(function() {
				$("#" + btnId).removeAttr("disabled").removeClass('disabled-button');
			}, 0);
		},
		/***********************************************************************
		 * 控制按钮为可用(延迟单位-秒)
		 * 
		 * @param btnId
		 */
		enableButtonTime : function(btnId, time) {
			setTimeout(function() {
				$("#" + btnId).removeAttr("disabled").removeClass('disabled-button');
			}, 2 * time * 1000);
		},
		//'2013-02-14 10:10:10'
		calDays:function(birthStr){
			var birthStr = birthStr.replace(/-/g,'/');
			var birthDay = new Date(birthStr).getTime();
			var now = new Date().getTime();

			var hours = (now - birthDay)/1000/60/60;
			var year =  Math.floor(hours / (24 * 30 * 12));
			hours = hours % (24 * 30 * 12);
			var months = Math.floor(hours / (24 * 30 ));
			hours = hours % (24 * 30 );
			var days = Math.floor(hours / (24));
			
			return {
				year : year,
				months : months,
				days : days
			};
		},
		
		calAge:function(birthStr){
			var birthStr = birthStr.replace(/-/g,'/');
			var birthDay = new Date(birthStr).getTime();
			var now = new Date().getTime();

			var hours = (now - birthDay)/1000/60/60;
			var year =  Math.floor(hours / (24 * 30 * 12));
			hours = hours % (24 * 30 * 12);
			var months = Math.floor(hours / (24 * 30 ));
			hours = hours % (24 * 30 );
			var days = Math.floor(hours / (24));
			
			
			$.logJson({
				year : year,
				months : months,
				days : days
			});
			
			if (year == 0){
				if (months > 0){
					return 1;
				}else if (months == 0){
					if (days > 0){
						return 1;
					}else if (days == 0){
						return 1;
					}
					return 0;
				}else{
					return 0;
				}
			}else if (year>0){
				return year;
			}else {
				return 0;
			}
		},
		
		/***********************************************************************
		 * 渲染下拉列表（DDL方式）
		 * 
		 * @returns
		 */
		renderplugins : function() {
			$("select").each(function() {
				$(this).ddslick({
					selectText : "请选择"
				});
			});

			var width = "162px";
			var height = "20px";
			var backgroundcolor = "#FFFFFF";

			// render ddl插件
			if ($.isIE()) {
			} else {
				width = "160px";
			}

			$(".dd-container").css({
				width : width
			}).css({
				height : "20px"
			});

			$(".dd-select").css({
				width : width
			}).css({
				height : height
			}).css({
				background : backgroundcolor
			}).css({
				border : "1px solid #999999"
			});

			$(".dd-selected").css({
				padding : "0px"
			});

			$(".dd-options").css({
				width : width
			});
			$(".dd-option").css({
				padding : "1px"
			});
		}
	});
})(jQuery);

// 封装全局函数---控件相关
;
(function($) {
	$.extend({
		/***********************************************************************
		 * 渲染输入控件
		 * 
		 * @param iptSetting
		 */
		renderInputControl : function(iptSetting) {
			// 1. 注册点击事件
			$(".inputControl span").click(function(event) {
				event.preventDefault();

				$.handleReference($(this));
			});

			// 2. 登记控件要素信息
			for (var i = 0, len = iptSetting.eles.length; i < len; ++i) {
				iptSetting.eles[i].no = i;

				iptSetting.eleNoMap[iptSetting.eles[i].name] = i;
			}
		},
		/***********************************************************************
		 * 处理控件参照
		 * 
		 * @param o
		 */
		handleReference : function(o) {
			// alert("call handleReference");
			var name = o.parents('.inputControl').children("input").attr('name');
			var config = inputControlSetting.eles[inputControlSetting.eleNoMap[name]];
			// alert(jsonToString(config));
			if (config.vType == "grid") {
				$.handleGridReference(config);
			} else if (config.vType == "tree") {
				$.handleTreeReference(config);
			}
		},
		/***********************************************************************
		 * 处理表格型控件
		 * 
		 * @param config
		 */
		handleGridReference : function(config) {
			var url = $.getSitePath() + "/Ref/grid.do";
			cur_ipt_controll_config = config;
			// alert(jsonToString(cur_ipt_controll_config));
			// alert("处理表格型控件 \n" + jsonToString(config));
			// alert(url);
			// 1. 弹出窗口
			jw.dialog($.extend({
				iframe : url,
				iframeScroll : true,
				resizable : false,
				title : config.title
			}, config));
		},
		/***********************************************************************
		 * 处理树型控件
		 * 
		 * @param config
		 */
		handleTreeReference : function(config) {
			var url = $.getSitePath() + "/Ref/tree.do";
			cur_ipt_controll_config = config;
			// alert(jsonToString(cur_ipt_controll_config));
			// alert("处理树型控件 \n" + jsonToString(config));
			// alert(url);
			// 1. 弹出窗口
			jw.dialog($.extend({
				iframe : url,
				iframeScroll : true,
				resizable : false,
				title : config.title
			}, config));
		}
	});
})(jQuery);

(function($) {
	$.extend({
		/***********************************************************************
		 * 垂直百分比、水平居中布局
		 * 
		 * @param containerdiv
		 * @param centerdiv
		 */
		vpart_l_center : function(containerdiv, centerdiv, percent) {

			containerdiv.css({
				position : "relative"
			});
			centerdiv.css({
				position : "absolute"
			});
			centerdiv.css({
				top : "50%",
				left : "50%"
			});

			// var height_ref_button = 0 - centerdiv.height() / 2;
			var height_ref_button = 0 - containerdiv.height() * (50 - percent) / 100;
			var width_ref_button = 0 - centerdiv.width() / 2;
			centerdiv.css({
				"margin-top" : height_ref_button
			});
			centerdiv.css({
				"margin-left" : width_ref_button
			});
		},
		/***********************************************************************
		 * 垂直、水平居中布局
		 * 
		 * @param containerdiv
		 * @param centerdiv
		 */
		v_l_center : function(containerdiv, centerdiv) {

			containerdiv.css({
				position : "relative"
			});
			centerdiv.css({
				position : "absolute"
			});
			centerdiv.css({
				top : "50%",
				left : "50%"
			});

			var height_ref_button = 0 - centerdiv.height() / 2;
			var width_ref_button = 0 - centerdiv.width() / 2;
			centerdiv.css({
				"margin-top" : height_ref_button
			});
			centerdiv.css({
				"margin-left" : width_ref_button
			});
		},
		/***********************************************************************
		 * Flexigrid的宽度自动调整
		 * 
		 * @param config
		 */
		setFlexiGridWith : function(p, g) {
			var height = p.height;
			var h_all = p.total * 19;

			var flg = height - h_all;

			var width_all = 0;
			var num = 0;
			var widths = [];
			var numToUse = 0;
			$('thead tr:first th div', g.hDiv).each(function() {
				var width_tmp = parseInt($(this)[0].style.width);
				width_all += (width_tmp + 8);
				if ($.browser.mozilla) {
					width_all += 1;
					numToUse += 1;
				}
				widths.push(width_tmp);
				num++;
			});

			if (p.checkbox || p.radiobox) {
				width_all += 22;
				if ($.browser.mozilla) {
					width_all += 1;
				}
			}

			var width_h = $($('.flexigrid')[0]).width();
			var widthLeft = width_h - width_all - 8;
			if ($.browser.mozilla) {
				widthLeft -= 1;
			}

			if (widthLeft > 0) {
				var widthToSet = widths[num - 1] + widthLeft - numToUse - 25;
				if ($.browser.mozilla) {
					widthToSet += 15;
				}
				// if (flg >= 0) {
				// widthToSet += 15;
				// }
				$('thead tr:first th div', g.hDiv).each(function() {
					if (num == 1) {
						$(this).css({
							width : widthToSet
						});
					}

					num--;
				});
			}
		}
	});

})(jQuery);
;

/*******************************************************************************
 * 文件上传
 */
;
;
(function($) {
	$.extend({
		/***********************************************************************
		 * 删除服务器文件
		 */
		delSeverFile : function(fileid) {

			var url_to = $.getSitePath() + "/fileupload/ajaxDeleteOneFile";

			// alert(url_to);
			if (fileid && fileid.length > 0) {
				$.ajax({
					url : url_to,
					data : {
						ts : new Date().getTime(),
						_id_m : fileid
					},
					type : 'GET',
					dataType : 'json',
					success : function(data) {
						// alert(JSON.stringify(data));
					}
				});
			}
		},

		/***********************************************************************
		 * 异步上传一个图片
		 */
		picupload : function(picNoSuffix) {

			var file_id = picNoSuffix + "_file";
			var file_hidden_id = picNoSuffix + "_hidden";
			var file_show_id = picNoSuffix + "_show";

			if ($("#" + file_id).val() == "") {
				alert("上传文件不能为空!");
				return false;
			}

			var txtImg_url = $("#" + file_id).val().toLowerCase();

			var txtImg_ext = txtImg_url.substring(txtImg_url.length - 3, txtImg_url.length).toLowerCase();

			if (txtImg_ext != "png" && txtImg_ext != "gif" && txtImg_ext != "jpg" && txtImg_ext != "jpeg") {

				alert("请选择png或gif、jpg、jpeg格式的文件!");

				$("#" + file_id).select();

				$("#" + file_id).focus();

				return false;

			}

			if (arguments.length > 1) {

				var MAXSIZE = arguments[1];

				var imagefile = document.getElementById("#" + file_id).files[0];

				var size = imagefile.size / 1024.0;

				if (size > MAXSIZE) {

					oms_message("图片大小不超过" + MAXSIZE + "K!");

					return false;
				}
			}

			var url_to_upload = $.getSitePath() + "/fileupload/ajaxUpload";

			// alert(url_to_upload);

			$.ajaxFileUpload({
				url : url_to_upload,
				secureuri : false,
				fileElementId : file_id,// 文件选择框的id属性
				dataType : 'json', // 也可以是json
				beforeSend : function() {
					$("#loading").show();
				},
				complete : function() {
					$("#loading").hide();
				},
				success : function(data) {

					// alert(JSON.stringify(data));
					var urlrtn = data["path"];

					var urlbefore = $('#' + file_hidden_id).val();

					$('#' + file_hidden_id).val(urlrtn);

					$('#' + file_show_id).attr("src", $.getSitePath() + urlrtn);

					// var alertStr = [];
					// alertStr.push("before--["+urlbefore+"]");
					// alertStr.push("after---["+urlrtn+"]");
					// alert(alertStr.join("\n"));

					$.delSeverFile(urlbefore);
				},
				error : function(data, status, e) {
					alert(e);
				}
			});
			return false;
		},

		/***********************************************************************
		 * 异步上传一个图片，并压缩
		 */
		picupload_zip : function(picNoSuffix) {

			var file_id = picNoSuffix + "_file";
			var file_hidden_id = picNoSuffix + "_hidden";
			var file_show_id = picNoSuffix + "_show";

			if ($("#" + file_id).val() == "") {
				alert("上传文件不能为空!");
				return false;
			}

			var txtImg_url = $("#" + file_id).val().toLowerCase();

			var txtImg_ext = txtImg_url.substring(txtImg_url.length - 3, txtImg_url.length).toLowerCase();

			if (txtImg_ext != "png" && txtImg_ext != "gif" && txtImg_ext != "jpg" && txtImg_ext != "jpeg") {

				alert("请选择png或gif、jpg、jpeg格式的文件!");

				$("#" + file_id).select();

				$("#" + file_id).focus();

				return false;

			}

			if (arguments.length > 1) {

				var MAXSIZE = arguments[1];

				var imagefile = document.getElementById("#" + file_id).files[0];

				var size = imagefile.size / 1024.0;

				if (size > MAXSIZE) {

					oms_message("图片大小不超过" + MAXSIZE + "K!");

					return false;
				}
			}

			var url_to_upload = $.getSitePath() + "/fileupload/ajaxUpload?zip=1";

			// alert(url_to_upload);

			$.ajaxFileUpload({
				url : url_to_upload,
				secureuri : false,
				fileElementId : file_id,// 文件选择框的id属性
				dataType : 'json', // 也可以是json
				beforeSend : function() {
					$("#loading").show();
				},
				complete : function() {
					$("#loading").hide();
				},
				success : function(data) {

					// alert(JSON.stringify(data));
					var urlrtn = data["path"];
					var fileid = data["fileid"];

					var idbefore = $('#' + file_hidden_id).val();

					$('#' + file_hidden_id).val(fileid);

					$('#' + file_show_id).attr("src", $.getSitePath() + urlrtn);

					// var alertStr = [];
					// alertStr.push("before--["+idbefore+"]");
					// alertStr.push("after---["+fileid+"]");
					// alert(alertStr.join("\n"));

					$.delSeverFile(idbefore);
				},
				error : function(data, status, e) {
					alert(e);
				}
			});
			return false;
		}
	});
})(jQuery);
;;
var ajax_attach_uploader_mou = {

	/***************************************************************************
	 * 异步上传一个文件
	 */
	ajaxupload : function(opt) {

		var file_id = opt.fileid;
		var maxsize = opt.maxsize || 50000;
		var extallow = opt.extallow || "";
		var cp_param = opt.cp_param || "150x120x0";
		var isattach = opt.is_attach || "0";
		var iscompress = opt.iscompress || "0";
		// var url_to_upload = opt.url || $.getSitePath() +
		// "/fileupload/ajaxUploadOneAttachment";

		var url_to_upload = opt.url || $.getSitePath() + "/attachmentupload/ajaxUploadOneAttachment?cp_param=" + cp_param + "&isattach=" + isattach + "&iscompress=" + iscompress;

		var _file = $("#" + file_id);

		if (_file.val() == "") {
			alert("上传文件不能为空!");
			return false;
		}

		if (extallow.length > 0) {
			var _url = _file.val().toLowerCase();
			var _ext = _url.substring(_url.length - 3, _url.length).toLowerCase();

			if (extallow.indexOf(_ext) < 0) {
				alert("非法的文件类型，不允许上传!");
				return false;
			}
		}

		var file = document.getElementById(file_id).files[0];
		var size = file.size / 1024.0;

		if (size > maxsize) {
			alert("文件大小不能超过" + maxsize + "K!");
			return false;
		}

		$.ajaxFileUpload({
			url : url_to_upload,
			secureuri : false,
			fileElementId : file_id,// 文件选择框的id属性
			dataType : 'json', // 也可以是json
			beforeSend : function() {
				$("#loading").show();
			},
			complete : function() {
				$("#loading").hide();
			},
			success : function(data) {
				// alert(JSON.stringify(data));
				if (opt.success) {
					opt.success(data);
				}
			},
			error : function(data, status, e) {
				alert(e);
			}
		});
		return false;
	}
}
