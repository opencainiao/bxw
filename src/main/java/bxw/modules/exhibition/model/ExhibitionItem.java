package bxw.modules.exhibition.model;

import java.util.List;

import org.mou.common.StringUtil;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mou.mongodb.base.domain.BaseModel;

import bxw.common.util.PinyinUtil;
import bxw.modules.exhibition.enums.ExhibitionStage;
import bxw.modules.exhibition.enums.ExhibitionState;

/****
 * 展业项目信息
 * 
 * @author NBQ
 *
 */
@Document(collection = "exhibition_item")
public class ExhibitionItem extends BaseModel {

	private String user_id; // 用户id
	private String username; // 用户名
	private String remark; // 说明

	private String type; // 类型
	private String type_name; // 类型名

	private String character; // 性质
	private String character_name;// 性质名

	private String title; // 标题
	private String content; // 内容

	private String address; // 地点
	private String gift; // 随手礼

	private String start_date;
	private String end_date;
	private String start_time; // 开始时间
	private String end_time; // 结束时间

	private String stage; // 展业阶段
	private String state; // 展业状态
	private String stage_name; // 阶段名称
	private String state_name; // 状态名称

	private String pinyin_name;
	private String first_char_header;// 姓名拼音第一个首字母， 比如：Z
	private String all_char_header;// 姓名拼音首字母， 比如：ZS

	private List<String> attentions; // 注意事项

	public List<String> getAttentions() {
		return attentions;
	}

	public void setAttentions(List<String> attentions) {
		this.attentions = attentions;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getStage_name() {
		return stage_name;
	}

	public String getState_name() {
		return state_name;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(ExhibitionStage stage) {
		this.stage = stage.getCode();
		this.stage_name = stage.getName();
	}

	public String getState() {
		return state;
	}

	public void setState(ExhibitionState state) {
		this.state = state.getCode();
		this.state_name = state.getName();
	}

	public void setPinYin() {

		if (!StringUtil.isEmpty(this.username)) {
			// 关键字的全拼
			String nameFullPy = PinyinUtil.str2Pinyin(this.username, null);
			this.pinyin_name = nameFullPy;
		}

		if (!StringUtil.isEmpty(this.username)) {
			// 关键字的简拼
			String nameShortPy = PinyinUtil.strFirst2Pinyin(this.username);
			this.all_char_header = nameShortPy;
		}

		if (!StringUtil.isEmpty(this.username)) {

			String headerFirst = PinyinUtil.str2PinyinHeaderFirst(this.username);
			this.first_char_header = headerFirst;
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getCharacter_name() {
		return character_name;
	}

	public void setCharacter_name(String character_name) {
		this.character_name = character_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getFirst_char_header() {
		return first_char_header;
	}

	public void setFirst_char_header(String first_char_header) {
		this.first_char_header = first_char_header;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGift() {
		return gift;
	}

	public void setGift(String gift) {
		this.gift = gift;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

}
