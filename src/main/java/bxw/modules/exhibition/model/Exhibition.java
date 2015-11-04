package bxw.modules.exhibition.model;

import org.mou.common.StringUtil;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mou.mongodb.base.domain.BaseModel;

import bxw.common.util.PinyinUtil;
import bxw.modules.exhibition.enums.ExhibitionGlobalState;
import bxw.modules.exhibition.enums.ExhibitionStage;
import bxw.modules.exhibition.enums.ExhibitionState;

/****
 * 展业信息（主信息）
 * 
 * @author NBQ
 *
 */
@Document(collection = "exhibition")
public class Exhibition extends BaseModel {

	private String user_id; // 用户id
	private String username; // 用户名
	private String remark; // 说明

	private String global_state; // 总体状态
	private String global_state_name;

	private String stage; // 展业阶段
	private String state; // 展业状态

	private String stage_name; // 阶段名称
	private String state_name; // 状态名称

	private String start_time; // 开始时间
	private String start_date; // 开始日期

	private String pinyin_name;
	private String first_char_header;// 姓名拼音第一个首字母， 比如：Z
	private String all_char_header;// 姓名拼音首字母， 比如：ZS
	

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
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

	public void setGlobal_state(ExhibitionGlobalState state) {
		this.global_state = state.getCode();
		this.global_state_name = state.getName();
	}
	
	public String getGlobal_state() {
		return global_state;
	}

	public void setGlobal_state(String global_state) {
		this.global_state = global_state;
	}

}
