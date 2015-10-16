package bxw.modules.client.service;

import java.util.ArrayList;
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
import bxw.modules.client.model.Phone;

/****
 * 电话服务实现
 * 
 * @author NBQ
 *
 */
@Service("phoneService")
public class PhoneService extends BaseService implements IPhoneService {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	private static final Logger logger = LogManager.getLogger(PhoneService.class);

	@Override
	public Phone findOneByIdObject(String _id) {

		return this.commonDaoMongo.findOneById(_id, Phone.class);
	}

	@Override
	public PageVO batchSearchPage(DBObject queryCondition, DBObject sort, DBObject returnFields) {

		PageVO pageVO = this.getParamPageVO();

		List<DBObject> phones = this.commonDaoMongo.findBatchPagePartDBObject(Phone.class, queryCondition, sort,
				returnFields, pageVO);

		return this.handleDBObjList(commonDaoMongo, Phone.class, queryCondition, phones, pageVO);

	}

	@Override
	public PageVO batchSearchOnePage(DBObject query, DBObject sort, DBObject returnFields) {

		PageVO pageVO = this.getParamPageVO();

		List<DBObject> phones = this.commonDaoMongo.findBatchPagePartDBObject(Phone.class, query, sort, returnFields,
				pageVO);

		return this.handleDBObjListOnePage(phones, pageVO);

	}

	@Override
	public String add(Phone phone) {
		this.setCreateInfo(phone);
		return this.commonDaoMongo.insertOne(phone);
	}

	@Override
	public DBObject updatePart(DBObject returnFields, Phone phone) {

		DBObject toUpdate = makeUpdate(phone);
		return this.commonDaoMongo.updateOneById(phone.get_id_m(), returnFields, toUpdate, Phone.class);
	}

	/****
	 * 转化对象为要更新的部分字段
	 * 
	 * @param update
	 * @return
	 */
	private DBObject makeUpdate(Phone phone) {

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("type_value", phone.getType_value());
		updateSet.put("type_name", phone.getType_name());
		updateSet.put("phone_number", phone.getPhone_number());
		updateSet.put("mainflg", phone.getMainflg());

		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		logger.debug("更新的对象信息\n{}", update);
		return update;
	}

	@Override
	public int RemoveOneById(String _id) {
		return this.commonDaoMongo.removeById(_id, Phone.class);
	}

	@Override
	public int RemoveOneByIdLogic(String _id) {

		DBObject updateSet = new BasicDBObject();
		this.setModifyInfo(updateSet);
		return this.commonDaoMongo.removeByIdLogic(_id, Phone.class, updateSet);
	}

	@Override
	public Object findAllOnePageByOwnerId(String owner_id) {
		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("owner_id", owner_id);

		DBObject sort = new BasicDBObject();
		sort.put("phone_type_value", 1);

		return batchSearchOnePage(queryCondition, sort, null);
	}

	@Override
	public List<String> add(List<Phone> phones, String client_id) {

		// 1.删除已有的
		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("owner_id", client_id);
		this.commonDaoMongo.removeByCondition(queryCondition, Phone.class);

		List<String> ids = new ArrayList<String>();

		for (Phone phone : phones) {
			phone.setOwner_id(client_id);
			String addressid = this.add(phone);

			ids.add(addressid);
		}

		return ids;
	}

}
