package bxw.modules.infrustructure.service.impl;

import javax.annotation.Resource;

import org.mou.common.StringUtil;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mou.mongodb.base.springdb.dao.IBaseDaoMongo;

import bxw.modules.infrustructure.service.IAutoIncreaserService;

@Service("autoIncreaserService")
public class AutoIncreaserService implements IAutoIncreaserService {

	private static final String COLLECTION_AUTO_INCREASER = "auto_increaser";

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	@Override
	public int getAutoIncreasedInteger(String mainkey) {

		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("mainkey", mainkey);// 自增标识

		DBObject returnFields = new BasicDBObject();
		returnFields.put("val", 1);// 自增值

		DBObject update = new BasicDBObject();
		update.put("$inc", new BasicDBObject("val", 1));

		DBObject result = commonDaoMongo.updateOneByCondition(queryCondition, returnFields, update, true,
				COLLECTION_AUTO_INCREASER);

		return (Integer) (result.get("val"));
	}

	@Override
	public String getAutoIncreaseString(String mainkey) {

		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("mainkey", mainkey);// 自增标识

		DBObject returnFields = new BasicDBObject();
		returnFields.put("val", 1);// 自增值
		returnFields.put("length", 1);// 自增值

		DBObject update = new BasicDBObject();
		update.put("$inc", new BasicDBObject("val", 1));

		DBObject result = commonDaoMongo.updateOneByCondition(queryCondition, returnFields, update, true,
				COLLECTION_AUTO_INCREASER);

		int value = (Integer) (result.get("val"));
		int length = result.get("length") == null ? 8 : (Integer) (result.get("length"));

		return StringUtil.addCharL(value, length, "0");
	}

}
