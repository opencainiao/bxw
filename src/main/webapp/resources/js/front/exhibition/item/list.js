$().ready(
		function() {

			data_manage.init();

			$("#btn_add").click(
					function() {
						var url_to = $.getSitePath() + '/front/exhibition_item/add';

						var params = [];
						params.push("typecode=" + $("#typecode").val());
						params.push("typename=" + $("#typename").val());
						params.push("ts=" + new Date().getTime());

						url_to = url_to + "?" + params.join("&");

						// $.loadPage(url_to);

						$.popUpWindow("开启新展业", url_to, "780px", "450px", "add",
								$("#content_inner_page"));
					});

			$("#btn_search").click(function(e) {
				data_manage.search();
			});
			
			$("a",$("#action_buttons")).click(function(e){
				e.preventDefault();
				
				var r_name = $(this).attr("data-name");
				
				var params = [];
				params.push("type=" + r_name);
				params.push("ts=" + new Date().getTime());

				var url_to = $.getSitePath() + '/front/exhibition_item/add';
				url_to = url_to + "?" + params.join("&");

				window.location.href = url_to;
			});
		});

var data_manage_functions = {

	closeAddWindow : function() {

		window.location.reload();
		$.closeWindow("add", $("#content_inner_page"));
	},

	/***************************************************************************
	 * 删除
	 * 
	 * @param data
	 */
	delOne : function(data) {

		var url_to = $.getSitePath() + '/front/exhibition_item/' + data["_id_m"]
				+ '/delete';

		$.ajax({
			type : 'POST',
			url : url_to,
			data : $.extend({
				ts : new Date().getTime()
			}, data),
			dataType : 'json',
			success : function(data) {
				data_manage.gridsetting.params = [ {
					name : 'reload',
					value : true
				} ];
				$("#list").flexReload(data_manage.gridsetting);
			}
		});
	},
	/***************************************************************************
	 * 进入修改页面
	 * 
	 * @param data
	 */
	toEdit : function(data) {

		var url = $.getSitePath() + '/front/exhibition_item/' + data["_id_m"]
				+ "/update?type=" + data["type"];
		
		var title = "编辑【" + data["type_name"]+ "】"

		$.popUpWindow(title, url, "90%", "90%", "edit",
				$("#data_manage"));
	},
	/***************************************************************************
	 * 进入详细信息页面
	 * 
	 * @param data
	 * @returns {Boolean}
	 */
	toDetail : function(data) {

		var url = $.getSitePath() + '/front/exhibition_item/' + data["_id_m"];

		$.showDetailWindow("展业信息", url, "600px", "300px");
	},
	/***************************************************************************
	 * 关闭编辑窗口
	 */
	closeEditWindow : function() {
		$.closeWindow("edit", $("#data_manage"));
	},
	refreshPage : function() {
		//window.location.reload();
		data_manage.search();
	},
	/***************************************************************************
	 * 创建展业事项
	 */
	createExhibitionItem : function(data,button) {
		
		var _id_m = data["_id_m"];
		var r_name = $(button).attr("r_name");
		
		var params = [];
		params.push("user_id=" + _id_m);
		params.push("type=" + r_name);
		params.push("ts=" + new Date().getTime());

		//alert(_id_m + "---" + r_name);
		
		var url_to = $.getSitePath() + '/front/exhibition_item/add';
		url_to = url_to + "?" + params.join("&");

		window.location.href = url_to;
	}
};

var data_manage = {

	search : function() {
		
		var username = {};
		username["name"] = "username";
		username["value"] = $("#username").trim_value();

		var exhibition_stage = {};
		exhibition_stage["name"] = "exhibition_stage";
		exhibition_stage["value"] = $("#exhibition_stage").trim_value();

		var exhibition_state = {};
		exhibition_state["name"] = "exhibition_state";
		exhibition_state["value"] = $("#exhibition_state").trim_value();

		var type = {};
		exhibition_state["name"] = "type";
		exhibition_state["value"] = $("#type").trim_value();

		var params = [];
		params.push(username);
		params.push(exhibition_stage);
		params.push(exhibition_state);
		params.push(type);

		data_manage.gridsetting.url = $.getSitePath()
				+ '/front/exhibition_item/list?ts=' + new Date().getTime();

		//$.logJson(params);
		
		params.push({
			name : 'reload',
			value : true
		});
		data_manage.gridsetting.params = params;
		
		$("#list").flexReload(data_manage.gridsetting);
	},
	/***************************************************************************
	 * 页面加载后的初始化方法
	 */
	init : function() {

		var url = $.getSitePath() + '/front/exhibition_item/list';

		var params = [];
		params.push("user_id=" + $("#user_id").trim_value()) ;
		params.push("ts=" + new Date().getTime());

		url = url + "?" + params.join("&");

		data_manage.gridsetting.url = url;

		//alert(data_manage.gridsetting.url);
		$("#list").flexigrid(data_manage.gridsetting);
		$("#data_manage").attr("s_times", 1);

		data_manage.pageLayout();
	},
	pageLayout : function() {

		var inPage_h = $(parent.window).height();
		var nav_h = 160;
		var btnbar_h = 40;
		var table_h = mou_grid_ux.getTableH($("#content_inner_page"), inPage_h
				- nav_h - btnbar_h - 2 - 8);
		mou_grid_ux.resetHeight_grid($("#content_inner_page"), table_h);
	},
	/***************************************************************************
	 * 表格配置
	 */
	gridsetting : {
		showTableToggleBtn : true,
		resizable : false,
		url : '',
		method : 'POST',
		dataType : 'json',
		nowrap : true, // 是否不换行
		autoload : true,// 自动加载
		usepager : true,
		title : '展业记录',
		useRp : true,
		rp : 20, // 默认分页条数
		pagestat : '共有{total}条记录，显示{from} - {to}条记录',
		procmsg : '正在查询，请稍候 ...',
		nomsg : '没有符合条件的数据',
		colModel : [ {
			display : '选择',
			hide : true,
			m_type : 'radio1',
			align : 'center',
			select : [ "_id_m", "name" ]
		}, {
			display : '序号',
			m_type : 'sno',
			align : 'center'
		}, {
			display : '逻辑主键',
			name : '_id_m',
			width : 150,
			hide : true,
			callback : data_manage_functions.toDetail
		}, {
			display : '类型码',
			name : 'type',
			width : 120,
			hide : true
		}, {
			display : '类型',
			name : 'type_name',
			width : 120
		},{
			display : '性质',
			name : 'character_name',
			width : 80
		},{
			display : '标题',
			name : 'title',
			width : 120
		},{
			display : '用户',
			name : 'username',
			width : 120
		}, {
			display : '阶段',
			name : 'stage_name',
			width : 120
		}, {
			display : '状态',
			name : 'state_name',
			width : 120
		}, {
			display : '开始日期',
			name : 'start_date',
			width : 80,
			hide:true
		}, {
			display : '时间',
			name : 'time_info',
			width : 140
		}, {
			display : '操作',
			name : 'operation',
			m_type : 'buttons',
			width : 90,
			buttons : [ {
				r_name : 'del',
				text : '删除',
				callback : data_manage_functions.delOne,
				paramConfig : [ "_id_m" ],
				css : "btn btn-xs btn-danger"
			}, {
				r_name : 'toEdit',
				text : '编辑',
				callback : data_manage_functions.toEdit,
				paramConfig : [ "_id_m" ,"type","type_name","username"]
			} ]
		}]
	}
};
