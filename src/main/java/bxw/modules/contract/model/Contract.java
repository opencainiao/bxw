package bxw.modules.contract.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.validator.constraints.NotEmpty;
import org.mou.common.JsonUtil;
import org.mou.common.StringUtil;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mou.mongodb.base.domain.BaseModel;

import bxw.common.util.PinyinUtil;

@Document(collection = "contract")
public class Contract extends BaseModel {

	private String owner_user_id; // 归属用户id
	private String owner_user_name; // 归属用户姓名

	private String identifier_num;// 合同编号
	private String effective_date;// 保险合同生效日
	private String source_type; // 客户来源码;//市场类型
	private String source_type_name; // 客户来源码
	private String applicant_id;// 投保人
	private String applicant_name;// 投保人
	private String applicant_id_card;// 身份证号（投保人）
	private String assured_id;// 被保险人
	private String assured_name;// 被保险人
	private String assured_id_card;// 身份证号（被保险人）
	private String assured_birth_date;// 出生日期（被保险人）
	private String assured_sex;// 性别（被保险人）
	private String assured_age;// 投保年龄（被保险人）
	private String insurance_character;// 险种
	private String insurance_type;// 类别
	private String insurance_amt;// 保额
	private String insurance_time_type;// 保险期间
	private String insurance_time_type_name;// 保险期间
	private String payment_period;// 缴费期间
	private String afyp;// AFYP
	private String afyc;// AFYC
	private String payment_characher;// 缴法
	private String payment_type;// 缴费方式
	private String bank_type;// 银行
	private String bank_type_name;// 银行
	private String bank_number;// 银行卡号
	private String death_beneficiary;// 身故受益人
	private String death_beneficiary_id_card;// 身故受益人
	private String relation_ship;// 关系
	private String beneficiary_percent;// 受益比例
	private String is_physical_examination;// 是否体检
	private String physical_examination_items;// 体检项目
	private String remark;// 其他

	private String applicant_pinyin_name;// 姓名拼音， 比如：ZHANGSAN
	private String applicant_first_char_header;// 姓名拼音第一个首字母， 比如：Z
	private String applicant_all_char_header;// 姓名拼音首字母， 比如：ZS

	private String assured_pinyin_name;// 姓名拼音， 比如：ZHANGSAN
	private String assured_first_char_header;// 姓名拼音第一个首字母， 比如：Z
	private String assured_all_char_header;// 姓名拼音首字母， 比如：ZS

	@NotEmpty(message = "归属用户_id不能为空")
	public String getOwner_user_id() {
		return owner_user_id;
	}

	public void setOwner_user_id(String owner_user_id) {
		this.owner_user_id = owner_user_id;
	}

	private void setApplicantPinYin() {

		if (StringUtil.isNotEmpty(this.applicant_name)) {
			// 关键字的全拼
			String nameFullPy = PinyinUtil.str2Pinyin(applicant_name, null);
			setApplicant_pinyin_name(nameFullPy);
		}

		if (StringUtil.isNotEmpty(this.applicant_name)) {
			// 关键字的简拼
			String nameShortPy = PinyinUtil.strFirst2Pinyin(applicant_name);
			setApplicant_all_char_header(nameShortPy);
		}

		if (StringUtil.isNotEmpty(this.applicant_name)) {
			// 首字母
			String headerFirst = PinyinUtil.str2PinyinHeaderFirst(applicant_name);
			setApplicant_first_char_header(headerFirst);
		}
	}

	private void setAssuredPinYin() {

		if (StringUtil.isNotEmpty(this.assured_name)) {
			// 关键字的全拼
			String nameFullPy = PinyinUtil.str2Pinyin(assured_name, null);
			setAssured_pinyin_name(nameFullPy);
		}

		if (StringUtil.isNotEmpty(this.assured_name)) {
			// 关键字的简拼
			String nameShortPy = PinyinUtil.strFirst2Pinyin(assured_name);
			setAssured_all_char_header(nameShortPy);
		}

		if (StringUtil.isNotEmpty(this.assured_name)) {
			String headerFirst = PinyinUtil.str2PinyinHeaderFirst(assured_name);
			setAssured_first_char_header(headerFirst);
		}
	}

	public void setPinYin() {
		setAssuredPinYin();
		setApplicantPinYin();
	}

	public String getOwner_user_name() {
		return owner_user_name;
	}

	public void setOwner_user_name(String owner_user_name) {
		this.owner_user_name = owner_user_name;
	}

	public String getIdentifier_num() {
		return identifier_num;
	}

	public void setIdentifier_num(String identifier_num) {
		this.identifier_num = identifier_num;
	}

	public String getEffective_date() {
		return effective_date;
	}

	public void setEffective_date(String effective_date) {
		this.effective_date = effective_date;
	}

	public String getSource_type() {
		return source_type;
	}

	public void setSource_type(String source_type) {
		this.source_type = source_type;
	}

	public String getSource_type_name() {
		return source_type_name;
	}

	public void setSource_type_name(String source_type_name) {
		this.source_type_name = source_type_name;
	}

	public String getApplicant_id() {
		return applicant_id;
	}

	public void setApplicant_id(String applicant_id) {
		this.applicant_id = applicant_id;
	}

	public String getApplicant_name() {
		return applicant_name;
	}

	public void setApplicant_name(String applicant_name) {
		this.applicant_name = applicant_name;
	}

	public String getApplicant_id_card() {
		return applicant_id_card;
	}

	public void setApplicant_id_card(String applicant_id_card) {
		this.applicant_id_card = applicant_id_card;
	}

	public String getAssured_id() {
		return assured_id;
	}

	public void setAssured_id(String assured_id) {
		this.assured_id = assured_id;
	}

	public String getAssured_name() {
		return assured_name;
	}

	public void setAssured_name(String assured_name) {
		this.assured_name = assured_name;
	}

	public String getAssured_id_card() {
		return assured_id_card;
	}

	public void setAssured_id_card(String assured_id_card) {
		this.assured_id_card = assured_id_card;
	}

	public String getAssured_birth_date() {
		return assured_birth_date;
	}

	public void setAssured_birth_date(String assured_birth_date) {
		this.assured_birth_date = assured_birth_date;
	}

	public String getAssured_sex() {
		return assured_sex;
	}

	public void setAssured_sex(String assured_sex) {
		this.assured_sex = assured_sex;
	}

	public String getAssured_age() {
		return assured_age;
	}

	public void setAssured_age(String assured_age) {
		this.assured_age = assured_age;
	}

	public String getInsurance_character() {
		return insurance_character;
	}

	public void setInsurance_character(String insurance_character) {
		this.insurance_character = insurance_character;
	}

	public String getInsurance_type() {
		return insurance_type;
	}

	public void setInsurance_type(String insurance_type) {
		this.insurance_type = insurance_type;
	}

	public String getInsurance_amt() {
		return insurance_amt;
	}

	public void setInsurance_amt(String insurance_amt) {
		this.insurance_amt = insurance_amt;
	}

	public String getInsurance_time_type() {
		return insurance_time_type;
	}

	public void setInsurance_time_type(String insurance_time_type) {
		this.insurance_time_type = insurance_time_type;
	}

	public String getInsurance_time_type_name() {
		return insurance_time_type_name;
	}

	public void setInsurance_time_type_name(String insurance_time_type_name) {
		this.insurance_time_type_name = insurance_time_type_name;
	}

	public String getPayment_period() {
		return payment_period;
	}

	public void setPayment_period(String payment_period) {
		this.payment_period = payment_period;
	}

	public String getAfyp() {
		return afyp;
	}

	public void setAfyp(String afyp) {
		this.afyp = afyp;
	}

	public String getAfyc() {
		return afyc;
	}

	public void setAfyc(String afyc) {
		this.afyc = afyc;
	}

	public String getPayment_characher() {
		return payment_characher;
	}

	public void setPayment_characher(String payment_characher) {
		this.payment_characher = payment_characher;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public String getBank_type_name() {
		return bank_type_name;
	}

	public void setBank_type_name(String bank_type_name) {
		this.bank_type_name = bank_type_name;
	}

	public String getBank_number() {
		return bank_number;
	}

	public void setBank_number(String bank_number) {
		this.bank_number = bank_number;
	}

	public String getDeath_beneficiary() {
		return death_beneficiary;
	}

	public void setDeath_beneficiary(String death_beneficiary) {
		this.death_beneficiary = death_beneficiary;
	}

	public String getDeath_beneficiary_id_card() {
		return death_beneficiary_id_card;
	}

	public void setDeath_beneficiary_id_card(String death_beneficiary_id_card) {
		this.death_beneficiary_id_card = death_beneficiary_id_card;
	}

	public String getRelation_ship() {
		return relation_ship;
	}

	public void setRelation_ship(String relation_ship) {
		this.relation_ship = relation_ship;
	}

	public String getBeneficiary_percent() {
		return beneficiary_percent;
	}

	public void setBeneficiary_percent(String beneficiary_percent) {
		this.beneficiary_percent = beneficiary_percent;
	}

	public String getIs_physical_examination() {
		return is_physical_examination;
	}

	public void setIs_physical_examination(String is_physical_examination) {
		this.is_physical_examination = is_physical_examination;
	}

	public String getPhysical_examination_items() {
		return physical_examination_items;
	}

	public void setPhysical_examination_items(String physical_examination_items) {
		this.physical_examination_items = physical_examination_items;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getApplicant_pinyin_name() {
		return applicant_pinyin_name;
	}

	public void setApplicant_pinyin_name(String applicant_pinyin_name) {
		this.applicant_pinyin_name = applicant_pinyin_name;
	}

	public String getApplicant_first_char_header() {
		return applicant_first_char_header;
	}

	public void setApplicant_first_char_header(String applicant_first_char_header) {
		this.applicant_first_char_header = applicant_first_char_header;
	}

	public String getApplicant_all_char_header() {
		return applicant_all_char_header;
	}

	public void setApplicant_all_char_header(String applicant_all_char_header) {
		this.applicant_all_char_header = applicant_all_char_header;
	}

	public String getAssured_pinyin_name() {
		return assured_pinyin_name;
	}

	public void setAssured_pinyin_name(String assured_pinyin_name) {
		this.assured_pinyin_name = assured_pinyin_name;
	}

	public String getAssured_first_char_header() {
		return assured_first_char_header;
	}

	public void setAssured_first_char_header(String assured_first_char_header) {
		this.assured_first_char_header = assured_first_char_header;
	}

	public String getAssured_all_char_header() {
		return assured_all_char_header;
	}

	public void setAssured_all_char_header(String assured_all_char_header) {
		this.assured_all_char_header = assured_all_char_header;
	}

	public static String[] getFieldsForDownLoad() {

		List<String> rtnList = new ArrayList<String>();

		rtnList.add("client_name");
		rtnList.add("id_number");
		rtnList.add("birth_date");
		rtnList.add("age");
		rtnList.add("sex_name");
		rtnList.add("phone_info_name");
		rtnList.add("address_info_name");
		rtnList.add("email_info");
		rtnList.add("region_code");
		rtnList.add("region_name");
		rtnList.add("company");
		rtnList.add("wedding_date");
		rtnList.add("boy_num");
		rtnList.add("girl_num");
		rtnList.add("children_num");
		rtnList.add("annual_income_personal");
		rtnList.add("annual_income_personal_type_name");// （个人）年收入分类
		rtnList.add("annual_income_family");
		rtnList.add("annual_income_family_type_name");// （家庭）年收入分类
		rtnList.add("family_income_feature_name"); // 家庭收入特点
		rtnList.add("family_financial_standing_name");// 财务状况
		rtnList.add("introducer_name");
		rtnList.add("contact_attention");
		rtnList.add("hobbies");
		rtnList.add("interesting_service"); // 关注的服务
		rtnList.add("region_type_name");// 地区分类
		rtnList.add("education_type_name");// 教育程度
		rtnList.add("marital_status_name");// 婚姻状况
		rtnList.add("company_nature_name");// 企业性质
		rtnList.add("trade_type_name");// 行业类型
		rtnList.add("career_type_name");// 职业类型
		rtnList.add("job_position_name");// 职位
		rtnList.add("job_level_name");// 职级
		rtnList.add("source_type_name");// 客户来源码
		rtnList.add("introducer_relationship_name"); // 与介绍人关系
		rtnList.add("introducer_closeness_name");// 与介绍人亲密度
		rtnList.add("contact_type_name"); // 可接触度
		rtnList.add("birth_ages_name");// 出生年代
		rtnList.add("age_group_name"); // 年龄段
		rtnList.add("constellation_name");// 星座
		rtnList.add("blood_group_name");// 血型
		rtnList.add("temperament_type_name"); // 性格特点
		rtnList.add("pdp_type_name");// PDP类型

		return rtnList.toArray(new String[] {});
	}

	public static String[] getTitlesForDownLoad() {
		List<String> rtnList = new ArrayList<String>();

		rtnList.add("姓名");
		rtnList.add("身份证号");
		rtnList.add("出生日期");
		rtnList.add("年龄");
		rtnList.add("性别");
		rtnList.add("电话");
		rtnList.add("地址");
		rtnList.add("邮箱");
		rtnList.add("地区码");
		rtnList.add("地区名");
		rtnList.add("公司");
		rtnList.add("结婚纪念日");
		rtnList.add("男孩");
		rtnList.add("女孩");
		rtnList.add("孩子数");
		rtnList.add("年收入（个人）");
		rtnList.add("年收入分类（个人）");// （个人）
		rtnList.add("年收入（家庭）");
		rtnList.add("年收入分类（家庭）");// （家庭）
		rtnList.add("家庭收入特点"); //
		rtnList.add("财务状况");//
		rtnList.add("介绍人");
		rtnList.add("联系注意事项");
		rtnList.add("兴趣爱好");
		rtnList.add("关注的服务"); //
		rtnList.add("地区分类");//
		rtnList.add("教育程度");//
		rtnList.add(" 婚姻状况");//
		rtnList.add("企业性质");//
		rtnList.add("行业类型");//
		rtnList.add("职业类型");//
		rtnList.add("职位");//
		rtnList.add("职级");//
		rtnList.add("客户来源码");//
		rtnList.add("与介绍人关系"); //
		rtnList.add("与介绍人亲密度");//
		rtnList.add("可接触度"); //
		rtnList.add("出生年代");//
		rtnList.add("年龄段"); //
		rtnList.add("星座");//
		rtnList.add("血型");//
		rtnList.add("性格特点"); //
		rtnList.add("PDP类型");//

		return (String[]) (rtnList.toArray(new String[] {}));
	}

	public static void main(String[] args) {
		System.out.println(JsonUtil.toJsonStr(Contract.getTitlesForDownLoad()));
	}

	/****
	 * 设置列宽
	 * 
	 * @return
	 */
	public static Map<String, Integer> getWidthsForDownLoad() {

		Map<String, Integer> rtnMap = new HashMap<String, Integer>();

		rtnMap.put("address_info_name", 6000);
		rtnMap.put("id_number", 6000);
		rtnMap.put("age", 1900);
		rtnMap.put("boy_num", 1900);
		rtnMap.put("girl_num", 1900);
		rtnMap.put("children_num", 2300);
		rtnMap.put("annual_income_personal", 6000);
		rtnMap.put("annual_income_family", 6000);
		rtnMap.put("annual_income_personal_type_name", 8000);
		rtnMap.put("annual_income_family_type_name", 8000);
		rtnMap.put("source_type", 1900);
		rtnMap.put("sex_name", 1900);

		return rtnMap;
	}
}
