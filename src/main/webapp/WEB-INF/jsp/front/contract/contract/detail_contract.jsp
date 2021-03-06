<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<jsp:include page="/WEB-INF/jsp/include/common_css.jsp"></jsp:include>
<jsp:include page="/WEB-INF/jsp/include/common_js.jsp"></jsp:include>

</head>

<body>
	<div id="add_div"
		style="padding-left: 5px; border-right-width: 5px; padding-right: 5px;">
		<sf:form modelAttribute="contract" class="form-horizontal">
			<input type="hidden" name="_id" />
			<input type="hidden" id="owner_user_id" name="owner_user_id"
				value="${ userid}" />
			<input type="hidden" id="owner_user_name" name="owner_user_name"
				value="${ username}" />
			<input type="hidden" id="applicant_id" name="applicant_id" value="${applicant_id }" />
			<input type="hidden" id="applicant_name_choosed"
				name="applicant_name_choosed" value="${ contract.applicant_name}" />
			<input type="hidden" id="assured_id" name="assured_id" value="${ contract.assured_id}"/>
			<input type="hidden" id="assured_name_choosed"
				name="assured_name_choosed" value="${ contract.assured_name}"/>
			<div class="row"  style="margin-left: 0px; margin-right: 0px;">
				<div class="col-xs-6">
					<div class="row">
						<div class="col-md-12 form-horizontal">
							<div class="form-group form-group-sm  ">
								<label for="identifier_num" class="col-sm-3 control-label">
									合同编号 </label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="identifier_num"
										name="identifier_num" value="${contract.identifier_num}"
										placeholder="">
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="applicant_id_select"
									class="col-sm-3 control-label text-primary">投保人 </label>
								<div class="col-sm-8">
									<div class="input-group" id="applicant_choose_div">
										<input type="text" id="applicant_name" name="applicant_name"
											class="form-control"  value="${contract.applicant_name }">
										<span class="input-group-btn">
											<button class="btn btn-default btn-sm" type="button"
												id="applicant_choose_btn">
												<span class="glyphicon glyphicon-chevron-right"
													aria-hidden="true"></span>
											</button>
										</span>
									</div>
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="assured_id_select"
									class="col-sm-3 control-label text-success">被保险人 </label>
								<div class="col-sm-8">
									<div class="input-group" id="assured_choose_div">
										<input type="text" id="assured_name" name="assured_name"
											class="form-control" value="${contract.assured_name }">
										<span class="input-group-btn">
											<button class="btn btn-default btn-sm" type="button"
												id="assured_choose_btn">
												<span class="glyphicon glyphicon-chevron-right"
													aria-hidden="true"></span>
											</button>
										</span>
									</div>
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="assured_birth_date"
									class="col-sm-3 control-label text-success"
									style="margin-top: -11px;"> 出生日期<br>被保险人
								</label>
								<div class="col-sm-8">
									<input id="assured_birth_date" name="assured_birth_date"
										placeholder="请输入日期" class="laydate-icon form-control dateipt"
										value="${contract.assured_birth_date}">
								</div>
							</div>
							<div class="form-group ">
								<label for="assured_age" class="col-sm-3 control-label">
									投保年龄 </label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="assured_age"
										name="assured_age" value="${contract.assured_age}">
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="insurance_character" class="col-sm-3 control-label">
									险种 </label>
								<div class="col-sm-8">
									<select id="insurance_character" name="insurance_character"
										class="form-control" data-src="constant"
										data-typecode="INSURANCE_CHARACTER"
										data-value="${contract.insurance_character}"></select>
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="insurance_type" class="col-sm-3 control-label">
									类别 </label>
								<div class="col-sm-8">
									<select id="insurance_type" name="insurance_type"
										class="form-control" data-src="constant"
										data-typecode="INSURANCE_TYPE"
										data-value="${contract.insurance_type}"></select>
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="afyp" class="col-sm-3 control-label"> AFYP </label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="afyp" name="afyp"
										value="${contract.afyp}" placeholder="">
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="payment_characher" class="col-sm-3 control-label">
									缴法 </label>
								<div class="col-sm-8">
									<select id="payment_characher" name="payment_characher"
										class="form-control" data-src="constant"
										data-typecode="PAYMENT_CHARACHER"
										data-value="${contract.payment_characher}"></select>
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="bank_type" class="col-sm-3 control-label">
									银行 </label>
								<div class="col-sm-8">
									<select id="bank_type" name="bank_type" class="form-control"
										data-src="constant" data-typecode="BANK_TYPE"
										data-value="${contract.bank_type}"></select>
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="death_beneficiary"
									class="col-sm-3 control-label text-danger"> 身故受益人 </label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="death_beneficiary"
										name="death_beneficiary" value="${contract.death_beneficiary}"
										placeholder="">
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="relation_ship"
									class="col-sm-3 control-label text-danger"> 关系 </label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="relation_ship"
										name="relation_ship" value="${contract.relation_ship}"
										placeholder="">
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="is_physical_examination"
									class="col-sm-3 control-label">是否体检 </label>
								<div class="col-sm-8">
									<select id="is_physical_examination"
										name="is_physical_examination" class="form-control"
										data-value="${contract.is_physical_examination}">
										<option value="1">体检</option>
										<option value="0">不体检</option>
									</select>
								</div>
							</div>
						</div>

					</div>
				</div>
				<div class="col-xs-6">
					<div class="row">
						<div class="col-md-12 form-horizontal">
							<div class="form-group form-group-sm  ">
								<label for="effective_date" class="col-sm-3 control-label">
									合同生效日 </label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="effective_date"
										name="effective_date" value="${contract.effective_date}"
										placeholder="格式：yyyy-mm-dd">
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="applicant_id_card"
									class="col-sm-3 control-label text-primary"
									style="margin-top: -11px;"> 身份证<br>投保人
								</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="applicant_id_card"
										name="applicant_id_card" value="${contract.applicant_id_card}"
										placeholder="">
								</div>
							</div>

							<div class="form-group form-group-sm  ">
								<label for="assured_id_card"
									class="col-sm-3 control-label text-success"
									style="margin-top: -11px;"> 身份证<br>被保险人
								</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="assured_id_card"
										name="assured_id_card" value="${contract.assured_id_card}"
										placeholder="">
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="assured_sex"
									class="col-sm-3 control-label text-success"
									style="margin-top: -11px;">性别<br>被保险人
								</label>
								<div class="col-sm-8">
									<select id="assured_sex" name="assured_sex"
										class="form-control" data-value="${contract.assured_sex}">
										<option value="1">男</option>
										<option value="0">女</option>
									</select>
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="insurance_amt" class="col-sm-3 control-label">
									保额 </label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="insurance_amt"
										name="insurance_amt" value="${contract.insurance_amt}"
										placeholder="">
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="insurance_time_type" class="col-sm-3 control-label">
									保险期间 </label>
								<div class="col-sm-8">
									<select id="insurance_time_type" name="insurance_type"
										class="form-control" data-src="constant"
										data-typecode="INSURANCE_TIME_TYPE"
										data-value="${contract.insurance_time_type}"></select>
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="payment_period" class="col-sm-3 control-label">
									缴费期间 </label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="payment_period"
										name="payment_period" value="${contract.payment_period}"
										placeholder="">
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="afyc" class="col-sm-3 control-label"> AFYC </label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="afyc" name="afyc"
										value="${contract.afyc}" placeholder="">
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="payment_type" class="col-sm-3 control-label">
									缴费方式 </label>
								<div class="col-sm-8">
									<select id="payment_type" name="payment_type"
										class="form-control" data-src="constant"
										data-typecode="PAYMENT_TYPE"
										data-value="${contract.payment_type}"></select>
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="bank_number" class="col-xs-3 control-label">
									银行卡号 </label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="bank_number"
										name="bank_number" value="${contract.bank_number}"
										placeholder="">
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="death_beneficiary_id_card"
									class="col-sm-3 control-label text-danger"
									style="margin-top: -11px;"> 身故受益人<br>身份证
								</label>
								<div class="col-sm-8">
									<input type="text" class="form-control"
										id="death_beneficiary_id_card"
										name="death_beneficiary_id_card"
										value="${contract.death_beneficiary_id_card}" placeholder="">
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="beneficiary_percent"
									class="col-sm-3 control-label text-danger"> 受益比例 </label>
								<div class="col-sm-8">
									<input type="text" class="form-control"
										id="beneficiary_percent" name="beneficiary_percent"
										value="${contract.beneficiary_percent}" placeholder="">
								</div>
							</div>
							<div class="form-group form-group-sm  ">
								<label for="physical_examination_items"
									class="col-sm-3 control-label"> 体检项目</label>
								<div class="col-sm-8">
									<input type="text" class="form-control"
										id="physical_examination_items"
										name="physical_examination_items"
										value="${contract.physical_examination_items}" placeholder="">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row"  style="margin-left: 0px; margin-right: 0px;">
				<div class="col-xs-6">
					<div class="form-group form-group-sm  ">
						<label for="remark" class="col-xs-3 control-label">备注 </label>
						<div class="col-sm-8">
							<textarea type="text" class="form-control " id="remark"
								name="remark" placeholder="" style="height: 80px; width: 600px">${contract.remark }</textarea>
						</div>
					</div>
				</div>
			</div>
		</sf:form>
	</div>
	<div class="row" style="margin-right: 0px; margin-left: 0px;">
		<div class="col-sm-12">
			<button type="button" id="btn_save"
				class="btn btn-primary btn-lg center-block">修改</button>
		</div>
	</div>

	<script>
		$().ready(function() {
			
			$("#applicant_id").val("${contract.applicant_id}");
			$("#assured_id").val("${contract.assured_id}");
			
			
			$("#applicant_choose_btn").bind("click", popUpChooseApplicant);
			$("#assured_choose_btn").bind("click", popUpChooseAssured);

			$("#assured_birth_date").click(function() {
				laydate({
					elem : '#assured_birth_date',
					format : 'YYYY-MM-DD', // 分隔符可以任意定义，该例子表示只显示年月
					festival : false, //显示节日
					choose : function(datas) { //选择日期完毕的回调
						$("#assured_birth_date").val(datas);
					}
				});
			});
			
			$("#btn_save").bind("click", save);

		});

		//设置选择的投保人		
		function setSelectedApplicant(obj) {
			//$.alertObjJson(obj);

			$("#applicant_id").val(obj["_id_m"]);
			$("#applicant_name").val(obj["client_name"]);
			$("#applicant_name_choosed").val(obj["client_name"]);

			// 关闭选择客户弹出窗口
			$.closeWindow("choose_applicant", $("#applicant_choose_btn"));
		}

		/****
		 * 弹出选择投保人
		 */
		var popUpChooseApplicant = function() {
			var url_to = $.getSitePath()
					+ '/front/contract/choose_applicant?user_id=#USERID#&user_name=#USERNAME';

			url_to = url_to.replaceAll("#USERID#", $("#owner_user_id").val());
			url_to = url_to.replaceAll("#USERNAME#", $("#owner_user_name")
					.val());

			$.popUpWindow("选择投保人", url_to, "90%", "90%", "choose_applicant",
					$("#applicant_choose_btn"));
		}

		//设置选择的被保险人		
		function setSelectedAssured(obj) {
			//$.alertObjJson(obj);

			$("#assured_id").val(obj["_id_m"]);
			$("#assured_name").val(obj["client_name"]);
			$("#assured_name_choosed").val(obj["client_name"]);

			// 关闭选择客户弹出窗口
			$.closeWindow("choose_assured", $("#assured_choose_btn"));
		}

		/****
		 * 弹出选择被保险人
		 */
		var popUpChooseAssured = function() {
			var url_to = $.getSitePath()
					+ '/front/contract/choose_assured?user_id=#USERID#&user_name=#USERNAME';

			url_to = url_to.replaceAll("#USERID#", $("#owner_user_id").val());
			url_to = url_to.replaceAll("#USERNAME#", $("#owner_user_name")
					.val());

			$.popUpWindow("选择投保人", url_to, "90%", "90%", "choose_assured",
					$("#assured_choose_btn"));
		}

		//保存
		var save = function() {

			if ($("#applicant_name").val() != $("#applicant_name_choosed")
					.val()) {
				$("#applicant_id").val("");
			}

			if ($("#assured_name").val() != $("#assured_name_choosed").val()) {
				$("#assured_id").val("");
			}

			var paramForm = $('form').getFormParam_ux();

			//console.log(JSON.stringify(paramForm));

		//	return;

			// 控制按钮为禁用
			$.disableButton("btn_save");
			var successstr = "修改成功";

			var url_to = $.getSitePath() + "/front/contract/${contract._id_m}/update";
			var url_success = $.getSitePath() + "/front/contract/list";

			$.ajax({
				type : 'POST',
				url : url_to,
				data : $.extend({
					ts : new Date().getTime()
				}, paramForm),
				type : 'POST',
				dataType : 'json',
				success : function(data) {

					if (data['success'] == 'n') {
						if (data['brErrors']) {
							$.alertBRErrorMask(data['brErrors']);
							$.showBRErrors_mou_abs(data['brErrors'],
									$("#add_div"));
						} else {
							$.alertErrorMask(data['message']);
						}
					} else {
						$.alertSuccessNewPage("成功", successstr, url_success, [
								0.5, '#000' ]);
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