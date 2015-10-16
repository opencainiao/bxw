package bxw.modules.user.service;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mou.common.DateUtil;
import org.mou.common.StringUtil;
import org.mou.common.security.EncryptMou;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mou.mongodb.base.springdb.dao.IBaseDaoMongo;

import bxw.modules.base.BaseService;
import bxw.modules.global.service.IAttachmentService;
import bxw.modules.user.enums.ResetpwdResult;
import bxw.modules.user.enums.UserState;
import bxw.modules.user.model.User;

/****
 * 用户服务
 * 
 * @author NBQ
 *
 */
@Service("userService")
public class UserService extends BaseService implements IUserService {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	private final Logger logger = LogManager.getLogger(UserService.class);

	@Resource(name = "attachmentService")
	private IAttachmentService attachmentService;

	/****
	 * 根据id获取用户信息
	 * 
	 * @param userid
	 * @return
	 */
	public User getUserInfById(String userid) {

		if (!this.isValidObjId(userid)) {
			return null;
		}

		return this.commonDaoMongo.findOneById(userid, User.class);
	}

	/****
	 * 根据用户名获取用户信息
	 * 
	 * @param username
	 * @return
	 */
	public User getUserInfByUsername(String username) {

		if (StringUtil.isEmpty(username)) {
			return null;
		}

		DBObject query = new BasicDBObject();
		query.put("username", username);

		return this.commonDaoMongo.findOnePart(User.class, query, null);

	}

	/****
	 * 根据用户邮箱获取用户信息
	 * 
	 * @param username
	 * @return
	 */
	public User getUserInfByUserEmail(String email) {

		if (StringUtil.isEmpty(email)) {
			return null;
		}

		DBObject query = new BasicDBObject();
		query.put("email", email);

		return this.commonDaoMongo.findOnePart(User.class, query, null);
	}

	/****
	 * 根据用户名或者邮箱获取用户信息
	 * 
	 * @param ure
	 * @return
	 */
	public User getUserInfByUserNameOrEmail(String ure) {

		if (StringUtil.isEmpty(ure)) {
			return null;
		}

		if (ure.indexOf("@") >= 0) {
			return getUserInfByUserEmail(ure);
		} else {
			return getUserInfByUsername(ure);
		}
	}

	/****
	 * 更新用户状态
	 * 
	 * @param userid
	 * @param statuscod
	 * @return
	 */
	public DBObject updatestatus(String userid, UserState userState) {

		if (userState == null || !isValidObjId(userid)) {
			return null;
		}

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("userstate", userState.getCode());
		this.setModifyInfo(updateSet);

		update.put("$set", updateSet);

		DBObject result = this.commonDaoMongo.updateOneById(userid, null, update, User.class);

		return result;
	}

	/****
	 * 更新用户状态
	 * 
	 * @param userid
	 * @param statuscod
	 * @return
	 */
	public DBObject updatestatus(String userid, UserState userState, String time) {

		if (userState == null || StringUtil.isEmpty(userid)) {
			return null;
		}

		if (!isValidObjId(userid)) {
			return null;
		}

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("userstate", userState.getCode());
		this.setModifyInfo(updateSet, time);

		update.put("$set", updateSet);

		DBObject result = this.commonDaoMongo.updateOneById(userid, null, update, User.class);

		return result;
	}

	/****
	 * 更新用户激活码
	 * 
	 * @param email
	 * @param activecode
	 * @return
	 */
	public void updateactivecode(String email, String activecode) {

		if (StringUtil.isEmpty(email) || StringUtil.isEmpty(activecode)) {
			return;
		}

		DBObject query = new BasicDBObject();
		query.put("email", email);

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();
		updateSet.put("activecode", activecode.toString());
		this.setModifyInfo(updateSet);

		update.put("$set", updateSet);

		this.commonDaoMongo.updateOneByCondition(query, null, update, false, User.class);
	}

	/****
	 * 更新重置密码的重置码
	 * 
	 * @param receiver
	 * @param resetpwdcode
	 * @return
	 */
	public void updateresetpwdcode(String email, String resetpwdcode) {
		if (StringUtil.isEmpty(email) || StringUtil.isEmpty(resetpwdcode)) {
			return;
		}

		DBObject query = new BasicDBObject();
		query.put("email", email);

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		String time = DateUtil.getCurrentTimsmp();

		updateSet.put("resetpwdapptime", time);
		updateSet.put("resetpwdcode", resetpwdcode.toString());
		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		this.commonDaoMongo.updateOneByCondition(query, null, update, false, User.class);
	}

	/****
	 * 校验重置密码<br>
	 * 
	 * @param email
	 * @param resetpwdcode
	 * @return
	 */
	public String validateResetPassword(String email, String resetpwdcode) {

		if (StringUtil.isEmpty(email) || StringUtil.isEmpty(resetpwdcode)) {
			return ResetpwdResult.TIMEOUT.getCode();
		}

		String time = DateUtil.getCurrentTimsmp();

		User user = getUserInfByUserEmail(email);

		if (user == null) {
			return ResetpwdResult.TIMEOUT.getCode();
		}

		String resetpwdapptime = user.getResetpwdapptime();

		int intervalMinutes = DateUtil.getIntervalTimeStampMinute(time, resetpwdapptime);

		// 间隔大于48小时，返回
		if (intervalMinutes > 48 * 60) {
			return ResetpwdResult.TIMEOUT.getCode();
		}

		// 重置码不一致，返回
		if (!user.getResetpwdcode().equals(resetpwdcode)) {
			return ResetpwdResult.RESETPWDCODEERROR.getCode();
		}

		return ResetpwdResult.VALID.getCode();
	}

	/****
	 * 重置密码
	 * 
	 * @param email
	 * @param password
	 * @param resetpwdcode
	 * @return
	 */
	public void updateresetpwdcode(String email, String password, String resetpwdcode) {
		if (StringUtil.isEmpty(email) || StringUtil.isEmpty(password) || StringUtil.isEmpty(resetpwdcode)) {
			return;
		}

		String validcode = validateResetPassword(email, resetpwdcode);
		if (!validcode.equals(ResetpwdResult.VALID.getCode())) {
			return;
		}

		DBObject query = new BasicDBObject();
		query.put("email", email);

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("resetpwdcode", "-10a@-$1=");
		updateSet.put("password", EncryptMou.encrypt(password));
		this.setModifyInfo(updateSet);

		update.put("$set", updateSet);

		this.commonDaoMongo.updateOneByCondition(query, null, update, false, User.class);

	}

	@Override
	public DBObject updateProfile(Object object, User user) {

		String userId = user.get_id_m();

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("nick", user.getNick());
		updateSet.put("email", user.getEmail());
		updateSet.put("phone", user.getPhone());
		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		DBObject updateResult = this.commonDaoMongo.updateOneById(userId, null, update, User.class);

		logger.debug("更新用户个人信息后,{}", updateResult);

		return updateResult;
	}

	@Override
	public DBObject updateHeadImage(String userId, String headImgAttachId) throws Exception {

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();
		updateSet.put("headImageId", headImgAttachId);
		
		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		// 0.删除原头像附件信息
		User user = this.getUserInfById(userId);
		String oriHeadImg = user.getHeadImageId();
		logger.debug("用户原头像 attach_id[{}]", oriHeadImg);
		if (StringUtil.isNotEmpty(oriHeadImg)) {
			this.attachmentService.deleteOneAttachment(oriHeadImg);
		}

		// 1.更新用户的头像id
		DBObject updateResult = this.commonDaoMongo.updateOneById(userId, null, update, User.class);

		logger.debug("更新用户头像后,{}", updateResult);

		// 2.更新附件的所属id为用户id
		this.attachmentService.updateAttachOwnerIdById(headImgAttachId, userId);

		return updateResult;
	}
}
