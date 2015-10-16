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
import bxw.modules.client.model.Address;

/****
 * 地址服务实现
 * 
 * @author NBQ
 *
 */
@Service("addressService")
public class AddressService extends BaseService implements IAddressService {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	private static final Logger logger = LogManager.getLogger(AddressService.class);

	@Override
	public Address findOneByIdObject(String _id) {

		return this.commonDaoMongo.findOneById(_id, Address.class);
	}

	@Override
	public PageVO batchSearchPage(DBObject queryCondition, DBObject sort, DBObject returnFields) {

		PageVO pageVO = this.getParamPageVO();

		List<DBObject> addresses = this.commonDaoMongo.findBatchPagePartDBObject(Address.class, queryCondition, sort,
				returnFields, pageVO);

		return this.handleDBObjList(commonDaoMongo, Address.class, queryCondition, addresses, pageVO);
	}

	@Override
	public PageVO batchSearchOnePage(DBObject query, DBObject sort, DBObject returnFields) {
		PageVO pageVO = this.getParamPageVO();

		List<DBObject> addresses = this.commonDaoMongo.findBatchPagePartDBObject(Address.class, query, sort, returnFields,
				pageVO);

		return this.handleDBObjListOnePage(addresses, pageVO);
	}

	@Override
	public String add(Address address) {
		this.setCreateInfo(address);
		return this.commonDaoMongo.insertOne(address);
	}

	@Override
	public DBObject updatePart(DBObject returnFields, Address address) {

		DBObject toUpdate = makeUpdate(address);
		return this.commonDaoMongo.updateOneById(address.get_id_m(), returnFields, toUpdate, Address.class);
	}

	/****
	 * 转化对象为要更新的部分字段
	 * 
	 * @param update
	 * @return
	 */
	private DBObject makeUpdate(Address address) {

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("type_value", address.getType_value());
		updateSet.put("type_name", address.getType_name());
		updateSet.put("province", address.getProvince());
		updateSet.put("city", address.getCity());
		updateSet.put("district", address.getDistrict());
		updateSet.put("detail_address", address.getDetail_address());
		updateSet.put("mainflg", address.getMainflg());

		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		logger.debug("更新的对象信息\n{}", update);
		return update;
	}

	@Override
	public int RemoveOneById(String _id) {
		return this.commonDaoMongo.removeById(_id, Address.class);
	}

	@Override
	public int RemoveOneByIdLogic(String _id) {

		DBObject updateSet = new BasicDBObject();
		this.setModifyInfo(updateSet);
		return this.commonDaoMongo.removeByIdLogic(_id, Address.class, updateSet);
	}

	@Override
	public List<DBObject> findAllByOwnerId(String ownerId) {

		DBObject queryCondition = new BasicDBObject();

		queryCondition.put("owner_id", ownerId);

		// 2.设置返回结果

		List<DBObject> allAddress = this.commonDaoMongo.findBatchDBObject(queryCondition, null, Address.class);

		return allAddress;
	}

	@Override
	public PageVO findAllOnePageByOwnerId(String ownerId) {

		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("owner_id", ownerId);

		DBObject sort = new BasicDBObject();
		sort.put("type_value", 1);

		return batchSearchOnePage(queryCondition, sort, null);
	}

	@Override
	public List<String> add(List<Address> addresses, String ownerId) {

		// 1.删除已有的
		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("owner_id", ownerId);
		this.commonDaoMongo.removeByCondition(queryCondition, Address.class);

		// 2.添加
		List<String> ids = new ArrayList<String>();

		for (Address address : addresses) {
			address.setOwner_id(ownerId);
			String addressid = this.add(address);

			ids.add(addressid);
		}

		return ids;
	}
}
