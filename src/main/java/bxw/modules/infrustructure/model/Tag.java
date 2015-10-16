package bxw.modules.infrustructure.model;

import com.mou.mongodb.base.domain.BaseModel;

/****
 * 系统标签，标示标签的值信息
 * 
 * @author NBQ
 *
 */
public class Tag extends BaseModel {

	private String tag_type_code; // 标签类型码
	private String tag_type_name;// 标签类型名称
	private String tag_name; // 标签名
	private String tag_type; // 标签类型 1-系统内置 2-用户自定义


	public String getTag_type_code() {
		return tag_type_code;
	}

	public void setTag_type_code(String tag_type_code) {
		this.tag_type_code = tag_type_code;
	}

	public String getTag_type_name() {
		return tag_type_name;
	}

	public void setTag_type_name(String tag_type_name) {
		this.tag_type_name = tag_type_name;
	}

	public String getTag_name() {
		return tag_name;
	}

	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}

	public String getTag_type() {
		return tag_type;
	}

	public void setTag_type(String tag_type) {
		this.tag_type = tag_type;
	}
}
