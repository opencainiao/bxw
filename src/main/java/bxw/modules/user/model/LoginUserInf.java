package bxw.modules.user.model;

import com.mou.mongodb.base.domain.BaseModel;

/****
 * 用户登陆信息(缓存)
 * 
 * @author NBQ
 *
 */
public class LoginUserInf extends BaseModel {

	// 用户信息
	private User user;

	// 登陆信息
	private LoginInf loginInf;
	

	public String getUser_id() {
		return this.getUser().get_id_m();
	}

	public String getUsername() {
		return this.user.getUsername();
	}

	public String getLoginStatus() {
		return this.getLoginInf().getStatus();
	}

	public String getLoginStatusName() {
		return this.getLoginInf().getStatus_name();
	}

	public String getEmail() {
		return this.getUser().getEmail();
	}

	public String getPhone() {
		return this.getUser().getPhone();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {

		this.user = user;
	}

	public LoginInf getLoginInf() {
		return loginInf;
	}

	public void setLoginInf(LoginInf loginInf) {
		this.loginInf = loginInf;
	}

}
