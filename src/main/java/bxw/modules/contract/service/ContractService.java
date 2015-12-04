package bxw.modules.contract.service;

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
import bxw.modules.contract.model.Contract;

/****
 * 合同服务
 * 
 * @author NBQ
 *
 */
@Service("contractService")
public class ContractService extends BaseService implements IContractService {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	private final Logger logger = LogManager.getLogger(ContractService.class);

	@Override
	public String add(Contract contract) {

		contract.setPinYin();

		this.setCreateInfo(contract);

		return this.commonDaoMongo.insertOne(contract);
	}

	@Override
	public Contract findContractInfById(String _id) {
		return this.commonDaoMongo.findOneById(_id, Contract.class);
	}

	@Override
	public PageVO batchSearchPage(DBObject queryCondition, DBObject sort, DBObject returnFields) {
		PageVO pageVO = this.getParamPageVO();

		List<DBObject> contracts = this.commonDaoMongo.findBatchPagePartDBObject(Contract.class, queryCondition,
				sort, returnFields, pageVO);

		return this.handleDBObjList(commonDaoMongo, Contract.class, queryCondition, contracts, pageVO);
	}

	// @Override
	// public DBObject updateStatus(String _id, ContractState state) {
	//
	// if (StringUtil.isEmpty(_id) || !this.isValidObjId(_id)) {
	// return null;
	// }
	//
	// DBObject update = new BasicDBObject();
	// DBObject updateSet = new BasicDBObject();
	//
	// updateSet.put("state", state.getCode());
	// updateSet.put("state_name", state.getName());
	// this.setModifyInfo(updateSet);
	//
	// update.put("$set", updateSet);
	//
	// return this.commonDaoMongo.updateOneById(_id, null, update,
	// Contract.class);
	// }

	@Override
	public DBObject updatePart(DBObject returnFields, Contract contract) {

		DBObject toUpdate = makeUpdate(contract);

		return this.commonDaoMongo.updateOneById(contract.get_id_m(), returnFields, toUpdate, Contract.class);
	}

	/****
	 * 转化对象为要更新的部分字段
	 * 
	 * @param update
	 * @return
	 */
	private DBObject makeUpdate(Contract contract) {

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("remark", contract.getRemark());

		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		logger.debug("更新的对象信息\n{}", update);
		return update;
	}

	@Override
	public int RemoveOneById(String _id) {

		return this.commonDaoMongo.removeById(_id, Contract.class);
	}

	@Override
	public Contract findOneByCondition(DBObject query) {

		query.put("del_flg", "0");

		Contract contract = this.commonDaoMongo.findOnePart(Contract.class, query, null);

		return contract;
	}
}
