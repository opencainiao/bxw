package bxw.modules.client.model;

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
import bxw.modules.client.model.partinfo.ClientBaseInfo;

@Document(collection = "client")
public class Client extends BaseModel {

	private String owner_user_id; // 归属用户id
	private String client_name; // 姓名
	private String sex; // 性别
	private String id_number; // 身份证号
	private String birth_date; // 生日
	private int age; // 年龄

	private List<Address> address_info; // 客户的地址信息
	private List<Phone> phone_info; // 客户的电话信息
	// private List<Email> email_info; // 客户的邮箱信息
	private String email_info;

	private String region_code; // 地区码
	private String region_name; // 地区名
	private String region_type; // 地区分类
	private String education_type; // 教育程度分类

	private List<String> name_card_ids; // 名片id
	private List<String> id_card_ids; // 身份证照片id
	private List<String> file_ids; // 客户附件id

	private String company; // 工作单位
	private String company_nature; // 企业性质
	private String trade_type; // 行业类型
	private String career_type; // 职业类型
	private String job_position; // 职位
	private String job_level; // 职级
	private String marital_status; // 婚姻状况
	private String wedding_date; // 结婚日期
	private int boy_num; // 男孩数
	private int girl_num; // 女孩数
	private int children_num; // 子女数
	private double annual_income_personal; // 个人年收入
	private String annual_income_personal_type; // （个人）年收入分类码
	private double annual_income_family; // （家庭）年收入
	private String annual_income_family_type; // （家庭）年收入分类码
	private String family_income_feature; // 家庭收入特点
	private String family_financial_standing; // 财务状况码
	private String source_type; // 客户来源码
	private String introducer_name; // 介绍人
	private String introducer_relationship; // 与介绍人关系
	private String introducer_closeness; // 与介绍人亲密度
	private String introducer_evaluation; // 介绍人评价
	private String contact_type; // 可接触度
	private String contact_attention; // 联系注意问题
	private String birth_ages; // 出生年代
	private String age_group; // 年龄段
	private String constellation; // 星座
	private String blood_group; // 血型
	private List<String> temperament_type; // 性格特点
	private String pdp_type; // PDP类型
	private String hobbies; // 兴趣爱好
	private String status; // 状态

	private List<String> interesting_service; // 关注的服务
	private String service_served; // 已提供的服务

	private String sex_name;
	private String phone_info_name;
	private String address_info_name;

	private String region_type_name; // 地区分类

	private String education_type_name; // 教育程度
	private String marital_status_name; // 婚姻状况

	private String company_nature_name; // 企业性质
	private String trade_type_name; // 行业类型
	private String career_type_name; // 职业类型
	private String job_position_name; // 职位
	private String job_level_name; // 职级

	private String annual_income_personal_type_name; // （个人）年收入分类
	private String annual_income_family_type_name; // （家庭）年收入分类
	private String family_income_feature_name; // 家庭收入特点
	private String family_financial_standing_name; // 财务状况

	private String source_type_name; // 客户来源码
	private String introducer_relationship_name; // 与介绍人关系
	private String introducer_closeness_name; // 与介绍人亲密度

	private String contact_type_name; // 可接触度

	private String birth_ages_name;// 出生年代
	private String age_group_name; // 年龄段
	private String constellation_name; // 星座
	private String blood_group_name; // 血型
	private String temperament_type_name; // 性格特点
	private String pdp_type_name; // PDP类型

	private String interesting_service_name; // 关注的服务

	private String pinyin_name;// 姓名拼音， 比如：ZHANGSAN
	private String first_char_header;// 姓名拼音第一个首字母， 比如：Z
	private String all_char_header;// 姓名拼音首字母， 比如：ZS

	public String getContact_type_name() {
		return contact_type_name;
	}

	public void setContact_type_name(String contact_type_name) {
		this.contact_type_name = contact_type_name;
	}

	@NotEmpty(message = "归属用户_id不能为空")
	public String getOwner_user_id() {
		return owner_user_id;
	}

	public String getSource_type_name() {
		return source_type_name;
	}

	public void setSource_type_name(String source_type_name) {
		this.source_type_name = source_type_name;
	}

	public String getIntroducer_relationship_name() {
		return introducer_relationship_name;
	}

	public void setIntroducer_relationship_name(String introducer_relationship_name) {
		this.introducer_relationship_name = introducer_relationship_name;
	}

	public String getIntroducer_closeness_name() {
		return introducer_closeness_name;
	}

	public void setIntroducer_closeness_name(String introducer_closeness_name) {
		this.introducer_closeness_name = introducer_closeness_name;
	}

	public void setOwner_user_id(String owner_user_id) {
		this.owner_user_id = owner_user_id;
	}

	public String getPhone_info_name() {
		return phone_info_name;
	}

	public void setPhone_info_name(String phone_info_name) {
		this.phone_info_name = phone_info_name;
	}

	public String getAddress_info_name() {
		return address_info_name;
	}

	public void setAddress_info_name(String address_info_name) {
		this.address_info_name = address_info_name;
	}

	@NotEmpty(message = "姓名不能为空")
	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	@NotEmpty(message = "姓别不能为空")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getId_number() {
		return id_number;
	}

	public void setId_number(String id_number) {
		this.id_number = id_number;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public List<Address> getAddress_info() {
		return address_info;
	}

	public void setAddress_info(List<Address> address_info) {
		this.address_info = address_info;
	}

	public List<Phone> getPhone_info() {
		return phone_info;
	}

	public void setPhone_info(List<Phone> phone_info) {
		this.phone_info = phone_info;
	}

	// public List<Email> getEmail_info() {
	// return email_info;
	// }
	//
	// public void setEmail_info(List<Email> email_info) {
	// this.email_info = email_info;
	// }

	public String getSex_name() {
		return sex_name;
	}

	public void setSex_name(String sex_name) {
		this.sex_name = sex_name;
	}

	public String getRegion_type_name() {
		return region_type_name;
	}

	public void setRegion_type_name(String region_type_name) {
		this.region_type_name = region_type_name;
	}

	public String getRegion_code() {
		return region_code;
	}

	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	public String getRegion_type() {
		return region_type;
	}

	public void setRegion_type(String region_type) {
		this.region_type = region_type;
	}

	public String getEducation_type() {
		return education_type;
	}

	public void setEducation_type(String education_type) {
		this.education_type = education_type;
	}

	public List<String> getName_card_ids() {
		return name_card_ids;
	}

	public void setName_card_ids(List<String> name_card_ids) {
		this.name_card_ids = name_card_ids;
	}

	public List<String> getFile_ids() {
		return file_ids;
	}

	public void setFile_ids(List<String> file_ids) {
		this.file_ids = file_ids;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompany_nature() {
		return company_nature;
	}

	public void setCompany_nature(String company_nature) {
		this.company_nature = company_nature;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getCareer_type() {
		return career_type;
	}

	public void setCareer_type(String career_type) {
		this.career_type = career_type;
	}

	public String getJob_position() {
		return job_position;
	}

	public void setJob_position(String job_position) {
		this.job_position = job_position;
	}

	public String getJob_level() {
		return job_level;
	}

	public void setJob_level(String job_level) {
		this.job_level = job_level;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	public String getWedding_date() {
		return wedding_date;
	}

	public void setWedding_date(String wedding_date) {
		this.wedding_date = wedding_date;
	}

	public String getAnnual_income_personal_type() {
		return annual_income_personal_type;
	}

	public void setAnnual_income_personal_type(String annual_income_personal_type) {
		this.annual_income_personal_type = annual_income_personal_type;
	}

	public String getAnnual_income_family_type() {
		return annual_income_family_type;
	}

	public void setAnnual_income_family_type(String annual_income_family_type) {
		this.annual_income_family_type = annual_income_family_type;
	}

	public String getFamily_income_feature() {
		return family_income_feature;
	}

	public void setFamily_income_feature(String family_income_feature) {
		this.family_income_feature = family_income_feature;
	}

	public String getFamily_financial_standing() {
		return family_financial_standing;
	}

	public void setFamily_financial_standing(String family_financial_standing) {
		this.family_financial_standing = family_financial_standing;
	}

	public String getSource_type() {
		return source_type;
	}

	public void setSource_type(String source_type) {
		this.source_type = source_type;
	}

	public String getIntroducer_name() {
		return introducer_name;
	}

	public void setIntroducer_name(String introducer_name) {
		this.introducer_name = introducer_name;
	}

	public String getIntroducer_relationship() {
		return introducer_relationship;
	}

	public void setIntroducer_relationship(String introducer_relationship) {
		this.introducer_relationship = introducer_relationship;
	}

	public String getIntroducer_closeness() {
		return introducer_closeness;
	}

	public void setIntroducer_closeness(String introducer_closeness) {
		this.introducer_closeness = introducer_closeness;
	}

	public String getIntroducer_evaluation() {
		return introducer_evaluation;
	}

	public void setIntroducer_evaluation(String introducer_evaluation) {
		this.introducer_evaluation = introducer_evaluation;
	}

	public String getContact_type() {
		return contact_type;
	}

	public void setContact_type(String contact_type) {
		this.contact_type = contact_type;
	}

	public String getContact_attention() {
		return contact_attention;
	}

	public void setContact_attention(String contact_attention) {
		this.contact_attention = contact_attention;
	}

	public String getBirth_ages() {
		return birth_ages;
	}

	public void setBirth_ages(String birth_ages) {
		this.birth_ages = birth_ages;
	}

	public String getAge_group() {
		return age_group;
	}

	public void setAge_group(String age_group) {
		this.age_group = age_group;
	}

	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public String getBlood_group() {
		return blood_group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}

	public List<String> getTemperament_type() {
		return temperament_type;
	}

	public void setTemperament_type(List<String> temperament_type) {
		this.temperament_type = temperament_type;
	}

	public String getPdp_type() {
		return pdp_type;
	}

	public void setPdp_type(String pdp_type) {
		this.pdp_type = pdp_type;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getInteresting_service() {
		return interesting_service;
	}

	public void setInteresting_service(List<String> interesting_service) {
		this.interesting_service = interesting_service;
	}

	public String getService_served() {
		return service_served;
	}

	public void setService_served(String service_served) {
		this.service_served = service_served;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getBoy_num() {
		return boy_num;
	}

	public void setBoy_num(int boy_num) {
		this.boy_num = boy_num;
	}

	public int getGirl_num() {
		return girl_num;
	}

	public void setGirl_num(int girl_num) {
		this.girl_num = girl_num;
	}

	public int getChildren_num() {
		return children_num;
	}

	public void setChildren_num(int children_num) {
		this.children_num = children_num;
	}

	public double getAnnual_income_personal() {
		return annual_income_personal;
	}

	public void setAnnual_income_personal(double annual_income_personal) {
		this.annual_income_personal = annual_income_personal;
	}

	public double getAnnual_income_family() {
		return annual_income_family;
	}

	public void setAnnual_income_family(double annual_income_family) {
		this.annual_income_family = annual_income_family;
	}

	public String getEducation_type_name() {
		return education_type_name;
	}

	public void setEducation_type_name(String education_type_name) {
		this.education_type_name = education_type_name;
	}

	public String getPinyin_name() {
		return pinyin_name;
	}

	public void setPinyin_name(String pinyin_name) {
		this.pinyin_name = pinyin_name;
	}

	public String getFirst_char_header() {
		return first_char_header;
	}

	public void setFirst_char_header(String first_char_header) {
		this.first_char_header = first_char_header;
	}

	public String getAll_char_header() {
		return all_char_header;
	}

	public void setAll_char_header(String all_char_header) {
		this.all_char_header = all_char_header;
	}

	public String getMarital_status_name() {
		return marital_status_name;
	}

	public void setMarital_status_name(String marital_status_name) {
		this.marital_status_name = marital_status_name;
	}

	public String getCompany_nature_name() {
		return company_nature_name;
	}

	public void setCompany_nature_name(String company_nature_name) {
		this.company_nature_name = company_nature_name;
	}

	public String getTrade_type_name() {
		return trade_type_name;
	}

	public void setTrade_type_name(String trade_type_name) {
		this.trade_type_name = trade_type_name;
	}

	public String getCareer_type_name() {
		return career_type_name;
	}

	public void setCareer_type_name(String career_type_name) {
		this.career_type_name = career_type_name;
	}

	public String getJob_position_name() {
		return job_position_name;
	}

	public void setJob_position_name(String job_position_name) {
		this.job_position_name = job_position_name;
	}

	public String getJob_level_name() {
		return job_level_name;
	}

	public void setJob_level_name(String job_level_name) {
		this.job_level_name = job_level_name;
	}

	public String getAnnual_income_personal_type_name() {
		return annual_income_personal_type_name;
	}

	public void setAnnual_income_personal_type_name(String annual_income_personal_type_name) {
		this.annual_income_personal_type_name = annual_income_personal_type_name;
	}

	public String getAnnual_income_family_type_name() {
		return annual_income_family_type_name;
	}

	public void setAnnual_income_family_type_name(String annual_income_family_type_name) {
		this.annual_income_family_type_name = annual_income_family_type_name;
	}

	public String getFamily_financial_standing_name() {
		return family_financial_standing_name;
	}

	public void setFamily_financial_standing_name(String family_financial_standing_name) {
		this.family_financial_standing_name = family_financial_standing_name;
	}

	public void setEmail_info(String email_info) {
		this.email_info = email_info;
	}

	public String getFamily_income_feature_name() {
		return family_income_feature_name;
	}

	public void setFamily_income_feature_name(String family_income_feature_name) {
		this.family_income_feature_name = family_income_feature_name;
	}

	public String getBirth_ages_name() {
		return birth_ages_name;
	}

	public void setBirth_ages_name(String birth_ages_name) {
		this.birth_ages_name = birth_ages_name;
	}

	public String getAge_group_name() {
		return age_group_name;
	}

	public void setAge_group_name(String age_group_name) {
		this.age_group_name = age_group_name;
	}

	public String getConstellation_name() {
		return constellation_name;
	}

	public void setConstellation_name(String constellation_name) {
		this.constellation_name = constellation_name;
	}

	public String getBlood_group_name() {
		return blood_group_name;
	}

	public void setBlood_group_name(String blood_group_name) {
		this.blood_group_name = blood_group_name;
	}

	public String getTemperament_type_name() {
		return temperament_type_name;
	}

	public void setTemperament_type_name(String temperament_type_name) {
		this.temperament_type_name = temperament_type_name;
	}

	public String getPdp_type_name() {
		return pdp_type_name;
	}

	public void setPdp_type_name(String pdp_type_name) {
		this.pdp_type_name = pdp_type_name;
	}

	public String getInteresting_service_name() {
		return interesting_service_name;
	}

	public void setInteresting_service_name(String interesting_service_name) {
		this.interesting_service_name = interesting_service_name;
	}

	public void setPinYin() {

		if (StringUtil.isEmpty(this.pinyin_name)) {
			// 关键字的全拼
			String nameFullPy = PinyinUtil.str2Pinyin(client_name, null);
			setPinyin_name(nameFullPy);
		}

		if (StringUtil.isEmpty(this.all_char_header)) {
			// 关键字的简拼
			String nameShortPy = PinyinUtil.strFirst2Pinyin(client_name);
			setAll_char_header(nameShortPy);
		}

		if (StringUtil.isEmpty(this.first_char_header)) {
			// 首字母
			if (StringUtil.isNotEmpty(this.pinyin_name)) {
				setFirst_char_header(this.pinyin_name.substring(0, 1));
			} else {
				String headerFirst = PinyinUtil.str2PinyinHeaderFirst(client_name);
				setFirst_char_header(headerFirst);
			}
		}
	}

	public void setPhoneString() {

		StringBuffer sb = new StringBuffer();

		if (this.phone_info != null && !this.phone_info.isEmpty()) {
			for (Phone phone : this.phone_info) {
				sb.append(phone.getString()).append("<br>");
			}
		}

		if (sb.length() > 0) {
			this.setPhone_info_name(sb.substring(0, sb.lastIndexOf("<br>")));
		} else {
			this.setPhone_info_name("");
		}
	}

	public void setAddressString() {

		StringBuffer sb = new StringBuffer();

		if (this.address_info != null && !this.address_info.isEmpty()) {
			for (Address address : this.address_info) {
				sb.append(address.getString()).append("<br>");
			}
		}

		if (sb.length() > 0) {
			this.setAddress_info_name(sb.substring(0, sb.lastIndexOf("<br>")));
		} else {
			this.setAddress_info_name("");
		}
	}

	public String getEmail_info() {
		return email_info;
	}

	public List<String> getId_card_ids() {
		return id_card_ids;
	}

	public void setId_card_ids(List<String> id_card_ids) {
		this.id_card_ids = id_card_ids;
	}

	public ClientBaseInfo getBaseInf() {

		ClientBaseInfo clientBaseInfo = new ClientBaseInfo();

		clientBaseInfo.set_id(this.get_id());
		clientBaseInfo.setOwner_user_id(this.getOwner_user_id());
		clientBaseInfo.setClient_name(this.getClient_name());

		clientBaseInfo.setSex(this.getSex());
		clientBaseInfo.setId_number(this.getId_number());
		clientBaseInfo.setBirth_date(birth_date);
		clientBaseInfo.setEmail_info(email_info);
		clientBaseInfo.setAddress_info(address_info);
		clientBaseInfo.setPhone_info(phone_info);
		clientBaseInfo.setRegion_code(region_code);
		clientBaseInfo.setRegion_name(region_name);
		clientBaseInfo.setRegion_type(region_type);
		clientBaseInfo.setEducation_type(education_type);
		clientBaseInfo.setEducation_type_name(education_type_name);

		return clientBaseInfo;
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
		System.out.println(JsonUtil.toJsonStr(Client.getTitlesForDownLoad()));
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
