package bxw.modules.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.mou.common.DateUtil;
import org.mou.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.BaseModel;
import com.mou.mongodb.base.domain.PageVO;
import com.mou.mongodb.base.springdb.dao.IBaseDaoMongo;
import com.mou.mongodb.base.util.PageSearchResultUtil;

import bxw.common.cash.context.Contexkeys;
import bxw.modules.user.model.User;
import mou.web.webbase.cash.context.ThreadContextManager;
import mou.web.webbase.domain.ValidResult;
import mou.web.webbase.util.ValidateUtil;

public class BaseService {

	@Autowired
	private Validator validator;

	/****
	 * 基于JSR301校验对象<br>
	 * 
	 * 样例：<br>
	 * 
	 * <PRE>
	 * ValidResult validResult = this.validate(XXX);
	 * if (validResult.hasErrors()) {
	 * 	return ErrorHandler.getRequestResultFromValidResult(validResult);
	 * }
	 * </PRE>
	 * 
	 * @param source
	 * @return
	 */
	public ValidResult validate(Object source) {

		ValidResult validresult = new ValidResult();

		Set<ConstraintViolation<Object>> violations = validator.validate(source);

		if (violations != null && violations.size() > 0) {

			Map<String, String> errors = new HashMap<String, String>();

			for (ConstraintViolation<Object> violation : violations) {
				// 这部分当然是获取验证的出错的字段名
				String field = violation.getPropertyPath().toString();
				String message = violation.getMessage();

				errors.put(field, message);
			}

			validresult.setErrors(errors);
		}

		return validresult;
	}

	/****
	 * 判断是否合法的objectId
	 * 
	 * @param _id
	 * @return
	 */
	public boolean isValidObjId(String _id) {
		return ValidateUtil.isValidObjId(_id);
	}

	/****
	 * 取当前登陆用户
	 *
	 * @return
	 */
	public User getUser() {
		return (User) ThreadContextManager.get(Contexkeys.USER);

	}

	/****
	 * 取当前登陆用户id
	 * 
	 * @return
	 */
	public String getUserId() {
		return (String) ThreadContextManager.get(Contexkeys.USERID);

	}

	/****
	 * 取当前登陆用户姓名
	 * 
	 * @return
	 */
	public String getUsername() {
		return (String) ThreadContextManager.get(Contexkeys.USERNAME);
	}

	/****
	 * 设置对象创建信息
	 * 
	 * @param model
	 */
	public void setCreateInfo(BaseModel model) {

		String date = DateUtil.getCurdate();
		String time = DateUtil.getCurrentTimsmp();
		String userid = this.getUserId();
		String username = this.getUsername();

		model.setC_user_id(userid);
		model.setC_user_name(username);
		model.setC_time(time);
		model.setC_date(date);
		model.setDel_flg(false);// 未删除

		model.setLast_op_user_id(userid);
		model.setLast_op_user_name(username);
		model.setLast_op_date(date);
		model.setLast_op_time(time);
	}

	/****
	 * 设置对象创建信息
	 * 
	 * @param model
	 */
	public void setCreateInfo(BaseModel model, String time) {
		String userid = this.getUserId();
		String username = this.getUsername();

		model.setC_user_id(userid);
		model.setC_user_name(username);
		model.setC_time(time);
		model.setC_date(time.substring(0, 10));
		model.setDel_flg(false);// 未删除

		model.setLast_op_user_id(userid);
		model.setLast_op_user_name(username);
		model.setLast_op_date(time.substring(0, 10));
		model.setLast_op_time(time);
	}

	/****
	 * 设置更新信息
	 */
	public void setModifyInfo(DBObject dbObject) {

		dbObject.put("last_op_user_id", this.getUserId());
		dbObject.put("last_op_user_name", this.getUsername());
		dbObject.put("last_op_date", DateUtil.getCurdate());
		dbObject.put("last_op_time", DateUtil.getCurrentTimsmp());
	}

	/****
	 * 设置更新信息
	 */
	public void setModifyInfo(DBObject dbObject, String time) {

		dbObject.put("last_op_user_id", this.getUserId());
		dbObject.put("last_op_user_name", this.getUsername());
		dbObject.put("last_op_date", DateUtil.getCurdate());
		if (StringUtil.isEmpty(time)) {
			dbObject.put("last_op_time", DateUtil.getCurrentTimsmp());
		} else {
			dbObject.put("last_op_time", time);
		}

	}

	/****
	 * 设置更新信息
	 */
	public void setModifyInfoWithUserId(DBObject dbObject, String user_id) {

		dbObject.put("last_op_user_id", user_id);
		dbObject.put("last_op_user_name", this.getUsername());
		dbObject.put("last_op_date", DateUtil.getCurdate());
		dbObject.put("last_op_time", DateUtil.getCurrentTimsmp());
	}

	/****
	 * 设置对象创建信息
	 * 
	 * @param model
	 */
	public void setCreateInfoWithUser(BaseModel model, String user_id, String username) {
		String date = DateUtil.getCurdate();
		String time = DateUtil.getCurrentTimsmp();

		model.setC_user_id(user_id);
		model.setC_user_name(username);
		model.setC_time(time);
		model.setC_date(date);
		model.setDel_flg(false);// 未删除

		model.setLast_op_user_id(user_id);
		model.setLast_op_user_name(username);
		model.setLast_op_date(date);
		model.setLast_op_time(time);
	}

	/****
	 * 设置对象创建信息
	 * 
	 * @param model
	 */
	public void setCreateInfoWithUser(BaseModel model, String time, String user_id, String username) {

		model.setC_user_id(user_id);
		model.setC_user_name(username);
		model.setC_time(time);
		model.setC_date(time.substring(0, 10));
		model.setDel_flg(false);// 未删除

		model.setLast_op_user_id(user_id);
		model.setLast_op_user_name(username);
		model.setLast_op_date(time.substring(0, 10));
		model.setLast_op_time(time);
	}

	/****
	 * 取查询中的分页参数
	 * 
	 * @return
	 */
	public PageVO getParamPageVO() {

		return (PageVO) ThreadContextManager.get(Contexkeys.REQUEST_PAGE_PARAM);
	}

	public <T> PageVO handleDBObjList(IBaseDaoMongo commonDaoMongo, Class<T> entityClass, DBObject queryCondition,
			List<DBObject> list, PageVO pageVO) {

		if (pageVO.getTotal() == -1) {
			long count = commonDaoMongo.count(entityClass, queryCondition);
			pageVO.setTotal(count);
		}

		return PageSearchResultUtil.handleDBObjList(list, pageVO);
	}

	public <T extends BaseModel> PageVO handleBaseModelList(IBaseDaoMongo commonDaoMongo, Class<T> entityClass,
			DBObject queryCondition, List<T> list, PageVO pageVO) {

		if (pageVO.getTotal() == -1) {
			long count = commonDaoMongo.count(entityClass, queryCondition);
			pageVO.setTotal(count);
		}

		return PageSearchResultUtil.handleBaseModelList(list, pageVO);
	}

	public PageVO handleDBObjListOnePage(List<DBObject> list, PageVO pageVO) {
		return PageSearchResultUtil.handleDBObjListOnePage(list, pageVO);
	}

	public <T extends BaseModel> PageVO handleBaseModelListOnePage(List<T> list, PageVO pageVO) {
		return PageSearchResultUtil.handleBaseModelListOnePage(list, pageVO);
	}
}
