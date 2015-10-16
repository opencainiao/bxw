package bxw.modules.user.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mou.mongodb.base.domain.BaseModel;

import bxw.modules.user.enums.LoginState;

/****
 * 用户全局登陆信息
 * 
 * @author NBQ
 *
 */
@Document(collection = "login_info")
public class LoginInf extends BaseModel {

	private String user_id; // 用户id
	private String username; // 用户名
	private String status;// 状态
	private String status_name;// 状态名称
	private String last_login_time; // 最近登录时间
	private String last_login_ip;// 最近登录ip
	private String last_logout_time; // 最近退出时间

	public String getUser_id() {
		return user_id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(LoginState status) {
		this.status = status.getCode();
	}

	public String getStatus_name() {
		return status_name;
	}

	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}

	public String getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(String last_login_time) {
		this.last_login_time = last_login_time;
	}

	public String getLast_login_ip() {
		return last_login_ip;
	}

	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}

	public String getLast_logout_time() {
		return last_logout_time;
	}

	public void setLast_logout_time(String last_logout_time) {
		this.last_logout_time = last_logout_time;
	}

}
