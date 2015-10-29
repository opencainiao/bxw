package bxw.modules.global.model;

import com.mou.mongodb.base.domain.BaseModel;

/****
 * 笔记（评论）
 * 
 * @author NBQ
 *
 */
public class Note extends BaseModel {

	private String user_id;
	private String target_id;
	private String title;//
	private String content;//

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

}