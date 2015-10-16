package bxw.modules.client.service.modifyclientinfo;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mou.mongodb.base.springdb.dao.IBaseDaoMongo;

import bxw.modules.base.BaseService;
import bxw.modules.client.model.Client;

/****
 * 客户家庭信息服务实现
 * 
 * @author NBQ
 *
 */
@Service("clientFamilyInfoService")
public class ClientFamilyInfoService extends BaseService implements
		IModifyClientInfoService {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	private static final Logger logger = LogManager
			.getLogger(ClientFamilyInfoService.class);

	@Override
	public DBObject updatePart(DBObject returnFields, Client client) {

		DBObject toUpdate = makeUpdate(client);
		
		DBObject updatedResult = this.commonDaoMongo.updateOneById(client.get_id_m(), returnFields, toUpdate,
				Client.class);

		return updatedResult;
	}

	/****
	 * 转化对象为要更新的部分字段
	 * 
	 * @param update
	 * @return
	 */
	private DBObject makeUpdate(Client client) {

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		int boy_num = client.getBoy_num() < 0 ? 0 : client.getBoy_num();
		int girl_num = client.getGirl_num() < 0 ? 0 : client.getGirl_num();

		int children_num = boy_num + girl_num;

		updateSet.put("marital_status", client.getMarital_status());
		updateSet.put("wedding_date", client.getWedding_date());
		updateSet.put("boy_num", boy_num);
		updateSet.put("girl_num", girl_num);
		updateSet.put("children_num", children_num);

		this.setModifyInfoWithUserId(updateSet, client.getOwner_user_id());
		update.put("$set", updateSet);

		logger.debug("更新的对象信息\n{}", update);
		return update;
	}
}
