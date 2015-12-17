package bxw.modules.exhibition.model;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mou.mongodb.base.domain.BaseModel;

/****
 * 计划
 * 
 * @author NBQ
 *
 */
@Document(collection = "plan")
public class Plan extends BaseModel {

	protected String user_id; // 用户id
	protected String user_name; // 用户名
	protected String type; // 计划类型(1-年度计划,2-月计划,3-其他计划)
	protected String plan_name;

	protected String content; // 计划内容
	protected String remark; // 说明

	private String year;
	private int month;
	protected String start_date; // 开始日期
	protected String end_date; // 结束日期

	private List<String> attaches;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@NotEmpty(message = "内容不能为空")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@NotEmpty(message = "计划类型不能为空")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public List<String> getAttaches() {
		return attaches;
	}

	public void setAttaches(List<String> attaches) {
		this.attaches = attaches;
	}

	public String getPlan_name() {
		return plan_name;
	}

	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}

	public void setPlanName() {
		if (this.type.contains("PLAN_YEAR")) {
			this.plan_name = "年计划【" + this.year + "】";
		} else if (this.type.contains("PLAN_MONTH")) {
			this.plan_name = "月计划【" + this.year + "-" + this.month + "】";
		}else{
			this.plan_name = "其他";
		}
	}
}
