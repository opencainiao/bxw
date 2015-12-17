package bxw.modules.exhibition.service;

import java.util.ArrayList;
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
import bxw.modules.global.service.IAttachmentService;

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
	
	@Resource(name = "attachmentService")
	private IAttachmentService attachmentService;

	private final Logger logger = LogManager.getLogger(PlanService.class);

	@Override
	public String add(Plan plan) {

		List<String> attachesNew = new ArrayList<String>();
		List<String> attaches = plan.getAttaches();
		if (attaches != null && attaches.size() > 0) {
			String content = plan.getContent();
			for (String attachId : attaches) {
				if (content.contains(attachId)) {
					attachesNew.add(attachId);
				}
			}
		}
		plan.setAttaches(attachesNew);
		plan.setPlanName();
		// 1.插入一条
		this.setCreateInfo(plan);
		String planId = this.commonDaoMongo.insertOne(plan);

		// 3.对附件，设置附件的归属id
		if (attaches != null && attaches.size() > 0) {

			String content = plan.getContent();
			for (String attachId : attaches) {
				if (content.contains(attachId)) {
					// 更新附件的归属id
					this.attachmentService.updateAttachOwnerIdById(attachId, planId);
				} else {
					// 删除附件(因为没有使用，所以删除)
					this.attachmentService.deleteOneAttachment(attachId);
					logger.debug("\n删除附件【{}】完毕！", attachId);
				}
			}
		}

		return planId;
		
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

		plan.setPlanName();
		
		List<String> attachesNew = new ArrayList<String>();
		List<String> attaches = plan.getAttaches();
		if (attaches != null && attaches.size() > 0) {

			String content = plan.getContent();
			for (String attachId : attaches) {
				if (content.contains(attachId)) {
					attachesNew.add(attachId);
					// 更新附件的归属id
					this.attachmentService.updateAttachOwnerIdById(attachId, plan.get_id_m());
				} else {
					// 删除附件(因为note没有使用，所以删除)
					this.attachmentService.deleteOneAttachment(attachId);
					logger.debug("\n删除附件【{}】完毕！", attachId);
				}
			}
		}

		plan.setAttaches(attachesNew);
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

		updateSet.put("content", plan.getContent());
		updateSet.put("remark", plan.getRemark());
		updateSet.put("start_date", plan.getStart_date());
		updateSet.put("end_date", plan.getEnd_date());
		updateSet.put("attaches", plan.getAttaches());
		updateSet.put("plan_name", plan.getPlan_name());

		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		logger.debug("更新的对象信息\n{}", update);
		return update;
	}

	@Override
	public int RemoveOneById(String _id) {

		Plan plan = this.findPlanInfById(_id);

		// 删除记录的所有附件
		List<String> attaches = plan.getAttaches();
		if (attaches != null && attaches.size() > 0) {
			for (String attachId : attaches) {
				this.attachmentService.deleteOneAttachment(attachId);
			}
		}
		
		return this.commonDaoMongo.removeById(_id, Plan.class);
	}

	@Override
	public Plan findOneByCondition(DBObject query) {

		query.put("del_flg", "0");

		Plan plan = this.commonDaoMongo.findOnePart(Plan.class, query, null);

		return plan;
	}
}
