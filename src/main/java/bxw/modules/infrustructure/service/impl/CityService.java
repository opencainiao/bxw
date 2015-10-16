package bxw.modules.infrustructure.service.impl;

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
import bxw.modules.infrustructure.model.City;
import bxw.modules.infrustructure.service.ICityService;

/****
 * 城市服务实现
 * 
 * @author NBQ
 *
 */
@Service("cityService")
public class CityService extends BaseService implements ICityService {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	private static final Logger logger = LogManager.getLogger(CityService.class);

	@Override
	public City findOneByIdObject(String _id) {

		return this.commonDaoMongo.findOneById(_id, City.class);
	}

	@Override
	public PageVO batchSearchPage(DBObject queryCondition, DBObject sort, DBObject returnFields) {

		PageVO pageVO = this.getParamPageVO();

		List<DBObject> cities = this.commonDaoMongo.findBatchPagePartDBObject(City.class, queryCondition, sort,
				returnFields, pageVO);

		return this.handleDBObjList(commonDaoMongo, City.class, queryCondition, cities, pageVO);
	}

	@Override
	public PageVO batchSearchOnePage(DBObject queryCondition, DBObject sort, DBObject returnFields) {

		PageVO pageVO = this.getParamPageVO();

		List<DBObject> cities = this.commonDaoMongo.findBatchPagePartDBObject(City.class, queryCondition, sort,
				returnFields, pageVO);

		return this.handleDBObjListOnePage(cities, pageVO);
	}

	@Override
	public String add(City city) {
		this.setCreateInfo(city);
		return this.commonDaoMongo.insertOne(city);
	}

	@Override
	public DBObject updatePart(DBObject returnFields, City city) {

		DBObject toUpdate = makeUpdate(city);
		return this.commonDaoMongo.updateOneById(city.get_id_m(), returnFields, toUpdate, City.class);
	}

	/****
	 * 转化对象为要更新的部分字段
	 * 
	 * @param update
	 * @return
	 */
	private DBObject makeUpdate(City city) {

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		// updateSet.put("typename", city.getTypename());

		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		logger.debug("更新的对象信息\n{}", update);
		return update;
	}

	@Override
	public int RemoveOneById(String _id) {
		return this.commonDaoMongo.removeById(_id, City.class);
	}

	@Override
	public int RemoveOneByIdLogic(String _id) {

		DBObject updateSet = new BasicDBObject();
		this.setModifyInfo(updateSet);
		return this.commonDaoMongo.removeByIdLogic(_id, City.class, updateSet);
	}

	@Override
	public PageVO findChildrenByPIdOnePage(DBObject sort, DBObject returnFields, Integer parentId) {

		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("parent_id", parentId);

		return this.batchSearchOnePage(queryCondition, sort, null);
	}

	@Override
	public List<DBObject> findChildrenByPId(DBObject sort, DBObject returnFields, Integer parentId) {

		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("parent_id", parentId);

		return this.commonDaoMongo.findBatchPartDBObject(City.class, queryCondition, sort, returnFields);
	}

	@Override
	public String findNameById(int id) {

		// 1.查缓存

		// 2.查数据库
		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("id", id);

		DBObject returnFields = new BasicDBObject();
		returnFields.put("name", 1);

		DBObject city = this.commonDaoMongo.findOnePartDBObject(City.class, queryCondition, returnFields);

		String name = "";
		if (city != null) {
			name = (String) city.get("name");
		}

		// 3.放缓存

		return name;
	}

}
