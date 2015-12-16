package bxw.modules.exhibition.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mou.common.StringUtil;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.PageVO;
import com.mou.mongodb.base.springdb.dao.IBaseDaoMongo;

import bxw.modules.base.BaseService;
import bxw.modules.exhibition.enums.PlanState;
import bxw.modules.exhibition.model.Plan;

/****
 * 计划服务
 * 
 * @author NBQ
 *
 */
@Service("planService")
public class PlanService extends BaseService implements IPlanService {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	private final Logger logger = LogManager.getLogger(PlanService.class);

	@Override
	public String add(Plan plan) {

		this.setCreateInfo(plan);

		return this.commonDaoMongo.insertOne(plan);
	}

	@Override
	public Plan findPlanInfById(String _id) {
		return this.commonDaoMongo.findOneById(_id, Plan.class);
	}

	@Override
	public PageVO batchSearchPage(DBObject queryCondition, DBObject sort, DBObject returnFields) {
		PageVO pageVO = this.getParamPageVO();

		List<DBObject> plans = this.commonDaoMongo.findBatchPagePartDBObject(Plan.class, queryCondition, sort,
				returnFields, pageVO);

		return this.handleDBObjList(commonDaoMongo, Plan.class, queryCondition, plans, pageVO);
	}

	@Override
	public DBObject updateStatus(String _id, PlanState state) {

		if (StringUtil.isEmpty(_id) || !this.isValidObjId(_id)) {
			return null;
		}

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("state", state.getCode());
		updateSet.put("state_name", state.getName());
		this.setModifyInfo(updateSet);

		update.put("$set", updateSet);

		return this.commonDaoMongo.updateOneById(_id, null, update, Plan.class);
	}

	@Override
	public DBObject updatePart(DBObject returnFields, Plan plan) {

		DBObject toUpdate = makeUpdate(plan);

		return this.commonDaoMongo.updateOneById(plan.get_id_m(), returnFields, toUpdate, Plan.class);
	}

	/****
	 * 转化对象为要更新的部分字段
	 * 
	 * @param update
	 * @return
	 */
	private DBObject makeUpdate(Plan plan) {

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("contend", plan.getContent());
		updateSet.put("remark", plan.getRemark());

		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		logger.debug("更新的对象信息\n{}", update);
		return update;
	}

	@Override
	public int RemoveOneById(String _id) {

		return this.commonDaoMongo.removeById(_id, Plan.class);
	}

	@Override
	public Plan findOneByCondition(DBObject query) {

		query.put("del_flg", "0");

		Plan plan = this.commonDaoMongo.findOnePart(Plan.class, query, null);

		return plan;
	}
}
