$().ready(function() {

	data_manage.init();

	$("#btn_add").click(function() {
		var url_to = $.getSitePath() + '/front/contract/add';
		window.location.href = url_to;
	});

	$("#btn_search").click(function() {
		data_manage.search();
	});
	
	$("#btn_download").click(function() {

		var config = $.getTitleAndFieldFromGrid(data_manage.gridsetting);

		$.logJson(config);

		// return;
		var titles = config["titles"];
		var fields = config["fields"];
		var fileName = "客户信息表";
		var beanName = "clientService";
		var methodName = "downLoadAllClientByUserId";

		var url = $.getSitePath() + '/front/client/download_clients';
		
		var config = {
				url:url,
				params:{
					titles:titles,
					fields:fields,
					fileName:fileName,
					beanName:beanName,
					methodName:methodName
				}
		}
		
		// $.logJson(config);
		
		$.downLoadFile(config);
	});
});

var data_manage_functions = {

	/***************************************************************************
	 * 删除
	 * 
	 * @param data
	 */
	delOne : function(data) {

		var url_to = $.getSitePath() + '/front/client/' + data["_id_m"] + '/delete';

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

		var url = $.getSitePath() + '/front/client/' + data["_id_m"] + "/update";

		$.popUpWindow("编辑用户信息", url, "800px", "400px", "edit", $("#data_manage"));
	},
	/***************************************************************************
	 * 进入详细信息页面
	 * 
	 * @param data
	 * @returns {Boolean}
	 */
	toDetail : function(data) {

		var url = $.getSitePath() + '/front/client/' + data["_id_m"];

		$.loadPage(url);

		// $.showDetailWindow("用户信息", url, "600px", "300px");
	},
	/***************************************************************************
	 * 关闭编辑窗口
	 */
	closeEditWindow : function() {
		$.closeWindow("edit", $("#data_manage"));
	},
	refreshPage : function() {
		data_manage.search();
	}
};

var data_manage = {

	search : function() {
		var searchcondition = {};
		searchcondition["name"] = "search_condition";
		searchcondition["value"] = $("#search_condition").val().trim();

		var params = [];
		params.push(searchcondition);

		data_manage.gridsetting.url = $.getSitePath() + '/front/contract/list?ts=' + new Date().getTime();

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

		data_manage.gridsetting.url = $.getSitePath() + '/front/contract/list';
		// alert(data_manage.gridsetting.url);
		$("#list").flexigrid(data_manage.gridsetting);

		data_manage.pageLayout();

		$("#data_manage").attr("s_times", 1);
	},
	pageLayout : function() {

		var inPage_h = $(parent.window).height();
		var nav_h = 160;
		var btnbar_h = 40;
		var table_h = mou_grid_ux.getTableH($("#content_inner_page"), inPage_h - nav_h - btnbar_h - 2 - 8);
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
		title : '客户列表',
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
			hide : true
		}, {
			display : '归属用户id',
			name : 'owner_user_id',
			width : 120,
			hide : true
		}, {
			display : '归属用户',
			name : 'owner_user_name',
			width : 120,
			hide : true
		}, {
			display : '合同编号',
			name : 'identifier_num',
			width : 110,
			m_type : 'link',
			select : [ "_id_m" ],
			hide : false,
			callback : data_manage_functions.toDetail
		},  {
			display : '合同生效日期',
			name : 'effective_date',
			width : 100
		}, {
			display : '投保人',
			name : 'applicant_name',
			width : 90
		}, {
			display : '投保人<br>身份证号',
			name : 'applicant_id_card',
			width : 110
		},{
			display : '被保险人',
			name : 'assured_name',
			width : 90
		}, {
			display : '被保险人<br>身份证号',
			name : 'assured_id_card',
			width : 110
		},{
			display : '被保险人<br>性别',
			name : 'assured_sex',
			width : 70,
			condition : {
				'0' : '女',
				'1' : '男'
			}
		},{
			display : '被保险人<br>出生日期',
			name : 'assured_birth_date',
			width : 110
		},{
			display : '被保险人<br>投保年龄',
			name : 'assured_age',
			width : 110
		},{
			display : '险种',
			name : 'insurance_character',
			width : 120,
			condition: $.getConstants("INSURANCE_CHARACTER")
		}, {
			display : '类别',
			name : 'insurance_type',
			width : 120,
			condition: $.getConstants("INSURANCE_TYPE")
		}, 
		{
			display : '保额',
			name : 'insurance_amt',
			width : 110
		}, {
			display : '保险期间',
			name : 'insurance_time_type',
			width : 130
		}, {
			display : '缴费期间',
			name : 'payment_period',
			width : 70
		}, {
			display : 'AFYP',
			name : 'AFYP',
			width : 120
		}, {
			display : 'AFYC',
			name : 'AFYC',
			width : 120
		}, {
			display : '缴法',
			name : 'payment_characher',
			width : 120,
			condition: $.getConstants("INSURANCE_CHARACTER")
		}, {
			display : '缴费方式',
			name : 'payment_type',
			width : 120,
			condition: $.getConstants("PAYMENT_TYPE")
		}, {
			display : '银行',
			name : 'bank_type',
			width : 120,
			condition: $.getConstants("BANK_TYPE")
		}, {
			display : '银行卡号',
			name : 'bank_number',
			width : 120
		}, {
			display : '身故受益人',
			name : 'death_beneficiary',
			width : 120
		}, {
			display : '身故受益人<br>身份证',
			name : 'death_beneficiary_id_card',
			width : 120
		}, {
			display : '关系',
			name : 'relation_ship',
			width : 180
		}, {
			display : '受益比例',
			name : 'beneficiary_percent',
			width : 120
		}, {
			display : '是否体检',
			name : 'is_physical_examination',
			width : 120,
			condition : {
				'0' : '不体检',
				'1' : '体检'
			}
		}, {
			display : '体检项目',
			name : 'physical_examination_items',
			width : 120
		}, {
			display : '其他',
			name : 'remark',
			width : 120
		}, {
			display : '操作',
			name : 'operation',
			m_type : 'buttons',
			width : 200,
			buttons : [ {
				r_name : 'del',
				text : '删除',
				callback : data_manage_functions.delOne,
				paramConfig : [ "_id_m" ],
				css : "btn btn-xs btn-danger"
			} ]
		} ]

	}
};
