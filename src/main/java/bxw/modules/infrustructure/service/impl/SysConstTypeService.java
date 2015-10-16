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
import bxw.modules.infrustructure.model.SysConst;
import bxw.modules.infrustructure.model.SysConstType;
import bxw.modules.infrustructure.service.ISysConstTypeService;

/****
 * 系统常量类型服务实现
 * 
 * @author NBQ
 *
 */
@Service("sysConstTypeService")
public class SysConstTypeService extends BaseService implements ISysConstTypeService {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	@Resource(name = "autoIncreaserService")
	private AutoIncreaserService autoIncreaserService;

	private static final Logger logger = LogManager.getLogger(SysConstTypeService.class);

	@Override
	public SysConstType findOneByIdObject(String _id) {

		return this.commonDaoMongo.findOneById(_id, SysConstType.class);
	}

	@Override
	public PageVO batchSearchPage(DBObject queryCondition, DBObject sort, DBObject returnFields) {

		PageVO pageVO = this.getParamPageVO();

		List<DBObject> cities = this.commonDaoMongo.findBatchPagePartDBObject(SysConstType.class, queryCondition, sort,
				returnFields, pageVO);

		return this.handleDBObjList(commonDaoMongo, SysConstType.class, queryCondition, cities, pageVO);
	}

	@Override
	public PageVO batchSearchOnePage(DBObject queryCondition, DBObject sort, DBObject returnFields) {

		PageVO pageVO = this.getParamPageVO();

		List<DBObject> cities = this.commonDaoMongo.findBatchPagePartDBObject(SysConst.class, queryCondition, sort,
				returnFields, pageVO);

		return this.handleDBObjListOnePage(cities, pageVO);
	}

	@Override
	public String add(SysConstType sysconsttype) {

		sysconsttype.setTypecode(sysconsttype.getTypecode().toUpperCase());
		this.setCreateInfo(sysconsttype);

		return this.commonDaoMongo.insertOne(sysconsttype);
	}

	@Override
	public DBObject updatePart(DBObject returnFields, SysConstType sysconsttype) {

		DBObject toUpdate = makeUpdate(sysconsttype);

		return this.commonDaoMongo.updateOneById(sysconsttype.get_id_m(), returnFields, toUpdate, SysConstType.class);

	}

	/****
	 * 转化对象为要更新的部分字段
	 * 
	 * @param update
	 * @return
	 */
	private DBObject makeUpdate(SysConstType sysconsttype) {

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("typename", sysconsttype.getTypename());

		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		logger.debug("更新的对象信息\n{}", update);
		return update;
	}

	@Override
	public int RemoveOneById(String _id) {

		return this.commonDaoMongo.removeById(_id, SysConstType.class);
	}

	@Override
	public int RemoveOneByIdLogic(String _id) {

		DBObject updateSet = new BasicDBObject();
		this.setModifyInfo(updateSet);
		return this.commonDaoMongo.removeByIdLogic(_id, SysConstType.class, updateSet);
	}

	@Override
	public boolean isExistSameTypecode(String typecode) {

		DBObject returnFields = new BasicDBObject();
		returnFields.put("_id", 1);

		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("typecode", typecode);
		queryCondition.put("use_flg", "1");
		queryCondition.put("del_flg", "0");

		DBObject result = this.commonDaoMongo.findOnePartDBObject(SysConstType.class, queryCondition, returnFields);

		logger.debug("根据类型码查询结果[{}]", result);
		if (result != null && result.get("_id") != null) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isExistSameTypename(String typename) {

		DBObject returnFields = new BasicDBObject();
		returnFields.put("_id", 1);

		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("typename", typename);
		queryCondition.put("use_flg", "1");

		DBObject result = this.commonDaoMongo.findOnePartDBObject(SysConstType.class, queryCondition, returnFields);

		logger.debug("根据类型名查询结果[{}]", result);

		if (result != null && result.get("_id") != null) {
			return true;
		}

		return false;
	}

	@Override
	public SysConstType findOneByTypecode(String typecode) {

		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("typecode", typecode);
		queryCondition.put("use_flg", "1");

		SysConstType sysconsttype = this.commonDaoMongo.findOnePart(SysConstType.class, queryCondition, null);

		return sysconsttype;
	}

}
