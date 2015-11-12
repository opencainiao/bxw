package bxw.modules.global.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mou.mongodb.base.domain.BaseModel;

/****
 * 笔记（评论）
 * 
 * @author NBQ
 *
 */
@Document(collection = "note")
public class Note extends BaseModel {

	private String user_id;
	private String target_type;// 目标类型
	private String target_id;
	private String title;//
	private String content;//
	private int note_count;// 记录数
	private List<String> attaches;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getTarget_id() {
		return target_id;
	}

	public void setTarget_id(String target_id) {
		this.target_id = target_id;
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

	public String getTarget_type() {
		return target_type;
	}

	public void setTarget_type(String target_type) {
		this.target_type = target_type;
	}

	public int getNote_count() {
		return note_count;
	}

	public void setNote_count(int note_count) {
		this.note_count = note_count;
	}

	public List<String> getAttaches() {
		return attaches;
	}

	public void setAttaches(List<String> attaches) {
		this.attaches = attaches;
	}

}
