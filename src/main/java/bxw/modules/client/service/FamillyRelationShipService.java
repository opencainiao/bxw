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
import bxw.modules.infrustructure.model.ClientRelationShip;

/****
 * 地址服务实现
 * 
 * @author NBQ
 *
 */
@Service("famillyRelationShipService")
public class FamillyRelationShipService extends BaseService implements IFamillyRelationShip {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	private static final Logger logger = LogManager.getLogger(FamillyRelationShipService.class);

	@Override
	public ClientRelationShip findOneByIdObject(String _id) {

		return this.commonDaoMongo.findOneById(_id, ClientRelationShip.class);
	}

	@Override
	public PageVO batchSearchPage(DBObject queryCondition, DBObject sort, DBObject returnFields) {

		PageVO pageVO = this.getParamPageVO();

		List<DBObject> clientrelationships = this.commonDaoMongo.findBatchPagePartDBObject(ClientRelationShip.class,
				queryCondition, sort, returnFields, pageVO);

		return this.handleDBObjList(commonDaoMongo, ClientRelationShip.class, queryCondition, clientrelationships,
				pageVO);
	}

	@Override
	public PageVO batchSearchOnePage(DBObject query, DBObject sort, DBObject returnFields) {

		PageVO pageVO = this.getParamPageVO();

		List<DBObject> clientrelationships = this.commonDaoMongo.findBatchPagePartDBObject(ClientRelationShip.class,
				query, sort, returnFields, pageVO);

		return this.handleDBObjListOnePage(clientrelationships, pageVO);

	}

	@Override
	public DBObject updatePart(DBObject returnFields, ClientRelationShip clientRelationShip) {

		DBObject toUpdate = makeUpdate(clientRelationShip);
		return this.commonDaoMongo.updateOneById(clientRelationShip.get_id_m(), returnFields, toUpdate,
				ClientRelationShip.class);
	}

	/****
	 * 转化对象为要更新的部分字段
	 * 
	 * @param update
	 * @return
	 */
	private DBObject makeUpdate(ClientRelationShip clientRelationShip) {

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("f_id", clientRelationShip.getF_id());
		updateSet.put("f_name", clientRelationShip.getF_name());
		updateSet.put("f_sex", clientRelationShip.getF_sex());
		updateSet.put("s_id", clientRelationShip.getS_id());
		updateSet.put("s_name", clientRelationShip.getS_name());
		updateSet.put("s_sex", clientRelationShip.getS_sex());
		updateSet.put("relationship", clientRelationShip.getRelationship());
		updateSet.put("relationship_cmt", clientRelationShip.getRelationship_cmt());

		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		logger.debug("更新的对象信息\n{}", update);
		return update;
	}

	@Override
	public int RemoveOneById(String _id) {

		ClientRelationShip clientRelationShip = this.commonDaoMongo.findOnePartById(_id, null,
				ClientRelationShip.class);

		String f_id = clientRelationShip.getF_id();
		String s_id = clientRelationShip.getS_id();

		DBObject dboQuery = new BasicDBObject();
		dboQuery.put("f_id", s_id);
		dboQuery.put("s_id", f_id);

		int deletedNum = this.commonDaoMongo.removeByCondition(dboQuery, ClientRelationShip.class);
		logger.debug("deleted-num[{}]",deletedNum);

		return this.commonDaoMongo.removeById(_id, ClientRelationShip.class);
	}

	@Override
	public int RemoveOneByIdLogic(String _id) {

		DBObject updateSet = new BasicDBObject();
		this.setModifyInfo(updateSet);

		return this.commonDaoMongo.removeByIdLogic(_id, ClientRelationShip.class, updateSet);
	}

	/****
	 * 添加关系
	 */
	@Override
	public String add(ClientRelationShip clientrelationship) {
		return this.commonDaoMongo.insertOne(clientrelationship);
	}

}
