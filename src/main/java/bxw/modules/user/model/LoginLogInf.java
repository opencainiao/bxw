package bxw.modules.user.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mou.mongodb.base.domain.BaseModel;

/****
 * 登陆日志信息
 * 
 * @author NBQ
 *
 */
@Document(collection = "login_log")
public class LoginLogInf extends BaseModel {

	private String logId;

	private String user_id; // 用户名
	private String username;// 用户名
	private String action_code;// 操作码
	private String action_name;// 操作名
	private String ip;// ip地址
	private String opTime;// 操作时间

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOpTime() {
		return opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getAction_code() {
		return action_code;
	}

	public void setAction_code(String action_code) {
		this.action_code = action_code;
	}

	public String getAction_name() {
		return action_name;
	}

	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}

	public String getIp() {
		return ip;
	}

}
