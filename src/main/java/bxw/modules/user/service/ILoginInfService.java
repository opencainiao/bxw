package bxw.modules.user.service;

import bxw.modules.user.model.LoginInf;
import bxw.modules.user.model.LoginLogInf;

/****
 * 系统级缓存服务<br>
 * 存储所有用户的登陆信息
 * 
 * @author NBQ
 *
 */
public interface ILoginInfService {

//	/****
//	 * 根据用户名查找登陆信息
//	 * 
//	 * @param loginUserInf
//	 */
//	public LoginUserInf getLoginInf(String username);

	/****
	 * 登记用户登陆信息至全局登陆信息表
	 * 
	 * @param loginUserInf
	 */
	public void saveLoginlog(LoginLogInf loginlog);

	/****
	 * 登记用户登陆日志信息至全局登陆信息表
	 * 
	 * @param loginUserInf
	 */
	public void saveLoginInf(LoginInf loginInf, boolean isLogin) ;

}
