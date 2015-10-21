$().ready(
		function() {

			data_manage.init();

			$("#btn_add").click(
					function() {
						var url_to = $.getSitePath() + '/front/exhibition/add';

						var params = [];
						params.push("typecode=" + $("#typecode").val());
						params.push("typename=" + $("#typename").val());
						params.push("ts=" + new Date().getTime());

						url_to = url_to + "?" + params.join("&");

						// $.loadPage(url_to);

						$.popUpWindow("开启新展业", url_to, "780px", "450px", "add",
								$("#content_inner_page"));
					});

			$("#btn_search").click(function() {
				data_manage.search();
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

		var url_to = $.getSitePath() + '/front/exhibition/' + data["_id_m"]
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

		var url = $.getSitePath() + '/front/exhibition/' + data["_id_m"]
				+ "/update";

		$.popUpWindow("编辑展业信息", url, "800px", "400px", "edit",
				$("#data_manage"));
	},
	/***************************************************************************
	 * 进入详细信息页面
	 * 
	 * @param data
	 * @returns {Boolean}
	 */
	toDetail : function(data) {

		var url = $.getSitePath() + '/front/exhibition/' + data["_id_m"];

		$.showDetailWindow("展业信息", url, "600px", "300px");
	},
	/***************************************************************************
	 * 关闭编辑窗口
	 */
	closeEditWindow : function() {
		$.closeWindow("edit", $("#data_manage"));
	},
	refreshPage : function() {
		window.location.reload();
		// data_manage.search();
	},
	/***************************************************************************
	 * 创建展业事项
	 */
	createExhibitionItem : function(data,button) {
		
		
		var _id_m = data["_id_m"];

		var r_name = $(button).attr("r_name");
		alert(_id_m + "---" + r_name);
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

		var params = [];
		params.push(username);
		params.push(exhibition_stage);
		params.push(exhibition_state);

		data_manage.gridsetting.url = $.getSitePath()
				+ '/front/exhibition/list?ts=' + new Date().getTime();

		if ($("#data_manage").attr("s_times")) {
			params.push({
				name : 'reload',
				value : true
			});
			data_manage.gridsetting.params = params;

			$("#list").flexReload(data_manage.gridsetting);
		} else {
			data_manage.gridsetting.params = params;
			$("#list").flexigrid(data_manage.gridsetting);
		}

		$("#data_manage").attr("s_times", 1);
	},
	/***************************************************************************
	 * 页面加载后的初始化方法
	 */
	init : function() {

		var url = $.getSitePath() + '/front/exhibition/list';

		var params = [];
		params.push("typecode=" + $("#typecode").val());
		params.push("ts=" + new Date().getTime());

		url = url + "?" + params.join("&");

		data_manage.gridsetting.url = url;

		// alert(data_manage.gridsetting.url);
		$("#list").flexigrid(data_manage.gridsetting);

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
		title : '展业信息列表',
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
			width : 80
		}, {
			display : '开始时间',
			name : 'start_time',
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
				text : '修改',
				callback : data_manage_functions.toEdit,
				paramConfig : [ "_id_m" ]
			} ]
		}, {
			display : '创建展业活动',
			name : 'operation1',
			m_type : 'drop_down_list_buttons',
			width : 130,
			buttons : {
				r_name : 'createExhibitionItem',
				text : '创建展业活动',
				css : "btn btn-xs btn-success",
				btns : [ [ {
					"text" : "计划",
					"data-name" : "plan"
				}, {
					"text" : "记录",
					"data-name" : "record"
				} ] ]
			},
			select : [ "_id_m" ],
			callback : data_manage_functions.createExhibitionItem
		} ]
	}
};
