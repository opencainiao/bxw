package bxw.modules.user.service;

import com.mongodb.DBObject;

import bxw.modules.user.enums.UserState;
import bxw.modules.user.model.User;

/****
 * 用户服务
 * 
 * @author NBQ
 *
 */
public interface IUserService {

	/****
	 * 根据id获取用户信息
	 * 
	 * @param userid
	 * @return
	 */
	public User getUserInfById(String userid);

	/****
	 * 根据用户名获取用户信息
	 * 
	 * @param username
	 * @return
	 */
	public User getUserInfByUsername(String username);

	/****
	 * 根据用户邮箱获取用户信息
	 * 
	 * @param username
	 * @return
	 */
	public User getUserInfByUserEmail(String email);

	/****
	 * 根据用户名或者邮箱获取用户信息
	 * 
	 * @param ure
	 * @return
	 */
	public User getUserInfByUserNameOrEmail(String ure);

	/****
	 * 更新用户状态
	 * 
	 * @param userid
	 * @param statuscod
	 * @return
	 */
	public DBObject updatestatus(String userid, UserState userState);

	/****
	 * 更新用户状态
	 * 
	 * @param userid
	 * @param statuscod
	 * @return
	 */
	public DBObject updatestatus(String userid, UserState userstate, String time);

	/****
	 * 更新用户激活码
	 * 
	 * @param email
	 * @param activecode
	 * @return
	 */
	public void updateactivecode(String email, String activecode);

	/****
	 * 更新重置密码的重置码
	 * 
	 * @param receiver
	 * @param resetpwdcode
	 * @return
	 */
	public void updateresetpwdcode(String email, String resetpwdcode);

	/****
	 * 校验重置密码<br>
	 * 
	 * @param email
	 * @param resetpwdcode
	 * @return
	 */
	public String validateResetPassword(String email, String resetpwdcode);

	/****
	 * 重置密码
	 * 
	 * @param email
	 * @param password
	 * @param resetpwdcode
	 * @return
	 */
	public void updateresetpwdcode(String email, String password, String resetpwdcode);

	/****
	 * 更新个人信息
	 * 
	 * @param object
	 * @param user
	 * @return
	 */
	public DBObject updateProfile(Object object, User user);

	/****
	 * 更新个人头像
	 * 
	 * @param _id
	 * @param headImgAttachId
	 * @return
	 * @throws Exception
	 */
	public DBObject updateHeadImage(String _id, String headImgAttachId) throws Exception;
}
