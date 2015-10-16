package bxw.modules.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mou.common.DateUtil;
import org.mou.common.JsonUtil;
import org.mou.common.StringUtil;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mou.mongodb.base.springdb.dao.IBaseDaoMongo;

import bxw.modules.base.BaseService;
import bxw.modules.user.model.LoginInf;
import bxw.modules.user.model.LoginLogInf;
import bxw.modules.user.model.LoginUserInf;

/****
 * 系统级缓存服务<br>
 * 存储所有用户的登陆信息
 * 
 * @author NBQ
 *
 */
@Service("loginInfService")
public class LoginInfService extends BaseService implements ILoginInfService {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	private Map<String, LoginLogInf> toLog;
	private List<String> logids;
	private int messageNumSum;// 当日接受处理的总消息条数(消息计数器)
	private final int MAXVAL = 200000000;// 重置值，当总数超过该值时，重置为0，从新计数
	private String SYNFLGLOG = "0";
	private String SYNFLGSAVETODB = "1";
	public final int CASH_SIZE_TO_DB = 2;
	private final Logger logger = LogManager.getLogger(LoginInfService.class);

	public LoginInfService() {
		toLog = new HashMap<String, LoginLogInf>();
		logids = new LinkedList<String>();
	}

	/****
	 * 根据用户名查找登陆信息
	 * 
	 * @param loginUserInf
	 */
	// @Override
	public LoginUserInf getLoginInf(String username) {

		return null;

		// if (StringUtil.isEmpty(username)) {
		// return null;
		// }
		//
		// DBObject queryCondition = new BasicDBObject();
		// queryCondition.put("username", username);
		//
		// return this.commonDaoMongo.findOnePart(LoginUserInf.class,
		// queryCondition, null);
	}

	/****
	 * 登记用户登陆信息至全局登陆信息表
	 * 
	 * @param loginUserInf
	 */
	public void saveLoginInf(LoginInf loginInf, boolean isLogin) {

		if (loginInf == null) {
			return;
		}

		String userId = loginInf.getUser_id();

		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("user_id", userId);

		DBObject toUpDate = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();
		updateSet.put("status", loginInf.getStatus());
		updateSet.put("status_name", loginInf.getStatus_name());

		if (isLogin) {
			updateSet.put("last_login_time", DateUtil.getCurrentTimsmp());
			updateSet.put("last_login_ip", loginInf.getLast_login_ip());
		} else {
			updateSet.put("last_logout_time", DateUtil.getCurrentTimsmp());
		}

		this.setModifyInfo(updateSet);
		toUpDate.put("$set", updateSet);

		this.commonDaoMongo.updateOneByCondition(queryCondition, null, toUpDate, true, LoginInf.class);
	}

	/****
	 * 登记用户登陆日志信息至登录日志表
	 * 
	 * @param loginUserInf
	 */
	public void saveLoginlog(LoginLogInf loginlog) {

		if (loginlog == null) {
			return;
		}

		synchronized (SYNFLGLOG) {
			messageNumSum = messageNumSum + 1;

			if (messageNumSum >= MAXVAL) {
				messageNumSum = 0;
			}
		}

		String logId = DateUtil.getHourNowStr() + messageNumSum;
		loginlog.setLogId(logId);

		toLog.put(logId, loginlog);
		logids.add(logId);

		if (toLog.size() >= CASH_SIZE_TO_DB) {
			synchronized (SYNFLGSAVETODB) {
				logger.debug("写入日志到数据库前");
				printCashInf();

				saveLoginLog2Db();

				logger.debug("写入日志到数据库后");
				printCashInf();
			}
		}
	}

	private void printCashInf() {
		logger.debug("缓存情况：");
		logger.debug("toLog条数[" + toLog.size() + "]");
		logger.debug("logids条数[" + logids.size() + "]");
		logger.debug("logids\n" + JsonUtil.toJsonStr(logids) + "");

		logger.debug("toLog\n" + JsonUtil.toJsonStr(toLog) + "");
	}

	/****
	 * 写入日志并清理
	 */
	private void saveLoginLog2Db() {
		if (logids.size() < CASH_SIZE_TO_DB) {
			return;
		}

		logger.debug("插入数据库前,缓存登陆日志数据条数[" + toLog.size() + "]");

		List<LoginLogInf> logs = new ArrayList<LoginLogInf>();
		List<String> toDel = new ArrayList<String>();
		for (int i = 0; i < CASH_SIZE_TO_DB; ++i) {

			String key = logids.get(i);

			LoginLogInf data = toLog.get(key);
			logs.add(data);
			toDel.add(key);
		}

		logger.debug(toDel);

		try {
			// 写入数据库
			this.commonDaoMongo.insertAll(logs);

			// 删除缓存Map中数据
			for (String key : toDel) {
				toLog.remove(key);
			}

			// 删除list中id数据
			for (int i = 0; i < CASH_SIZE_TO_DB; ++i) {
				logids.remove(0);
			}

			logger.debug("写入数据并清理缓存日志后, 缓存登陆日志数据条数[" + toLog.size() + "]");
		} catch (Exception e) {
			logger.error("写入登陆日志失败");
			logger.error("待写入的日志信息如下");
			logger.error(JsonUtil.toJsonStr(logs));
			logger.error(StringUtil.getStackTrace(e));
		}
	}
}
