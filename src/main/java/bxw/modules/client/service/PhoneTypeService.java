package bxw.modules.client.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.PageVO;
import com.mou.mongodb.base.springdb.dao.IBaseDaoMongo;

import bxw.modules.base.BaseService;
import bxw.modules.client.model.CommonType;
import bxw.modules.client.service.util.CommonTypeSearchUtil;

/****
 * 手机类型服务实现
 * 
 * @author NBQ
 *
 */
@Service("phoneTypeService")
public class PhoneTypeService extends BaseService implements IPhoneTypeService {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	private static final Logger logger = LogManager.getLogger(PhoneTypeService.class);

	@Override
	public CommonType findOneByIdObject(String _id) {

		return this.commonDaoMongo.findOneById(_id, CommonType.class);
	}

	@Override
	public PageVO batchSearchPage(DBObject queryCondition, DBObject sort, DBObject returnFields) {

		PageVO pageVO = this.getParamPageVO();

		List<DBObject> types = this.commonDaoMongo.findBatchPagePartDBObject(CommonType.class, queryCondition, sort,
				returnFields, pageVO);

		return this.handleDBObjList(commonDaoMongo, CommonType.class, queryCondition, types, pageVO);

	}

	@Override
	public PageVO batchSearchOnePage(DBObject query, DBObject sort, DBObject returnFields) {

		PageVO pageVO = this.getParamPageVO();

		List<DBObject> types = this.commonDaoMongo.findBatchPagePartDBObject(CommonType.class, query, sort,
				returnFields, pageVO);

		return this.handleDBObjListOnePage(types, pageVO);

	}

	@Override
	public String add(CommonType addresstype) {

		this.setCreateInfo(addresstype);
		return this.commonDaoMongo.insertOne(addresstype);
	}

	@Override
	public DBObject updatePart(DBObject returnFields, CommonType addresstype) {

		DBObject toUpdate = makeUpdate(addresstype);
		return this.commonDaoMongo.updateOneById(addresstype.get_id_m(), returnFields, toUpdate, CommonType.class);

	}

	/****
	 * 转化对象为要更新的部分字段
	 * 
	 * @param update
	 * @return
	 */
	private DBObject makeUpdate(CommonType addresstype) {

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("type_value", addresstype.getType_value());
		updateSet.put("type_name", addresstype.getType_name());

		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		logger.debug("更新的对象信息\n{}", update);
		return update;
	}

	@Override
	public int RemoveOneById(String _id) {
		return this.commonDaoMongo.removeById(_id, CommonType.class);
	}

	@Override
	public int RemoveOneByIdLogic(String _id) {

		DBObject updateSet = new BasicDBObject();
		this.setModifyInfo(updateSet);

		return this.commonDaoMongo.removeByIdLogic(_id, CommonType.class, updateSet);
	}

	@Override
	public boolean isExistSameTypename(String type_name, String owner_user_id, String _id) {

		DBObject queryCondition = CommonTypeSearchUtil.getQuerySameTypeName(type_name, owner_user_id, _id);

		DBObject returnFields = CommonTypeSearchUtil.getReturnFields();

		List<DBObject> types = this.commonDaoMongo.findBatchDBObject(queryCondition, returnFields, CommonType.class);

		if (types == null || types.isEmpty()) {
			return false;
		}

		return true;
	}

	@Override
	public boolean isExistSameTypename(String type_name, String owner_user_id) {

		DBObject queryCondition = CommonTypeSearchUtil.getQuerySameTypeName(type_name, owner_user_id, null);

		DBObject returnFields = CommonTypeSearchUtil.getReturnFields();

		List<DBObject> types = this.commonDaoMongo.findBatchDBObject(queryCondition, returnFields, CommonType.class);

		if (types == null || types.isEmpty()) {
			return false;
		}

		return true;
	}

	@Override
	public boolean isExistSameTypeValue(String type_value, String owner_user_id) {

		DBObject queryCondition = CommonTypeSearchUtil.getQuerySameTypeValue(type_value, owner_user_id, null);

		DBObject returnFields = CommonTypeSearchUtil.getReturnFields();

		List<DBObject> types = this.commonDaoMongo.findBatchDBObject(queryCondition, returnFields, CommonType.class);

		if (types == null || types.isEmpty()) {
			return false;
		}

		return true;
	}

	@Override
	public boolean isExistSameTypeValue(String type_value, String owner_user_id, String _id) {

		DBObject queryCondition = CommonTypeSearchUtil.getQuerySameTypeName(type_value, owner_user_id, _id);

		DBObject returnFields = CommonTypeSearchUtil.getReturnFields();

		List<DBObject> types = this.commonDaoMongo.findBatchDBObject(queryCondition, returnFields, CommonType.class);

		if (types == null || types.isEmpty()) {
			return false;
		}

		return true;
	}

	@Override
	public CommonType findOneByWhere(DBObject query) {

		return this.commonDaoMongo.findOnePart(CommonType.class, query, null);
	}

}
