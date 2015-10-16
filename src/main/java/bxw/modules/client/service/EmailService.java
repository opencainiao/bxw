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
import bxw.modules.client.model.Email;

/****
 * 电话服务实现
 * 
 * @author NBQ
 *
 */
@Service("emailService")
public class EmailService extends BaseService implements IEmailService {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	private static final Logger logger = LogManager.getLogger(EmailService.class);

	@Override
	public Email findOneByIdObject(String _id) {

		return this.commonDaoMongo.findOneById(_id, Email.class);
	}

	@Override
	public PageVO batchSearchPage(DBObject queryCondition, DBObject sort, DBObject returnFields) {

		PageVO pageVO = this.getParamPageVO();

		List<DBObject> emails = this.commonDaoMongo.findBatchPagePartDBObject(Email.class, queryCondition, sort,
				returnFields, pageVO);

		return this.handleDBObjList(commonDaoMongo, Email.class, queryCondition, emails, pageVO);

	}

	@Override
	public PageVO batchSearchOnePage(DBObject query, DBObject sort, DBObject returnFields) {

		PageVO pageVO = this.getParamPageVO();

		List<DBObject> emails = this.commonDaoMongo.findBatchPagePartDBObject(Email.class, query, sort, returnFields,
				pageVO);

		return this.handleDBObjListOnePage(emails, pageVO);
	}

	@Override
	public String add(Email email) {
		this.setCreateInfo(email);
		return this.commonDaoMongo.insertOne(email);
	}

	@Override
	public DBObject updatePart(DBObject returnFields, Email email) {

		DBObject toUpdate = makeUpdate(email);
		return this.commonDaoMongo.updateOneById(email.get_id_m(), returnFields, toUpdate, Email.class);

	}

	/****
	 * 转化对象为要更新的部分字段
	 * 
	 * @param update
	 * @return
	 */
	private DBObject makeUpdate(Email email) {

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("type_value", email.getType_value());
		updateSet.put("type_name", email.getType_name());
		updateSet.put("email", email.getEmail());
		updateSet.put("mainflg", email.getMainflg());

		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		logger.debug("更新的对象信息\n{}", update);
		return update;
	}

	@Override
	public int RemoveOneById(String _id) {
		return this.commonDaoMongo.removeById(_id, Email.class);
	}

	@Override
	public int RemoveOneByIdLogic(String _id) {

		DBObject updateSet = new BasicDBObject();
		this.setModifyInfo(updateSet);
		return this.commonDaoMongo.removeByIdLogic(_id, Email.class, updateSet);
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
	public List<String> add(List<Email> emails, String client_id) {

		// 1.删除已有的
		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("owner_id", client_id);
		this.commonDaoMongo.removeByCondition(queryCondition, Email.class);

		List<String> ids = new ArrayList<String>();

		for (Email email : emails) {
			email.setOwner_id(client_id);
			String addressid = this.add(email);

			ids.add(addressid);
		}

		return ids;
	}

}
