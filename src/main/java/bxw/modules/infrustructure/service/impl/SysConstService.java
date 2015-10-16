package bxw.modules.infrustructure.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.mou.common.StringUtil;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.PageVO;
import com.mou.mongodb.base.springdb.dao.IBaseDaoMongo;

import bxw.modules.base.BaseService;
import bxw.modules.infrustructure.model.SysConst;
import bxw.modules.infrustructure.service.ISysConstService;

/****
 * 系统常量类型服务实现
 * 
 * @author NBQ
 *
 */
@Service("sysConstService")
public class SysConstService extends BaseService implements ISysConstService {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	private static final Logger logger = LogManager.getLogger(SysConstService.class);

	@Override
	public SysConst findOneByIdObject(String _id) {

		return this.commonDaoMongo.findOneById(_id, SysConst.class);
	}

	@Override
	public PageVO batchSearchPage(DBObject queryCondition, DBObject sort, DBObject returnFields) {

		PageVO pageVO = this.getParamPageVO();

		List<DBObject> consts = this.commonDaoMongo.findBatchPagePartDBObject(SysConst.class, queryCondition, sort,
				returnFields, pageVO);

		return this.handleDBObjList(commonDaoMongo, SysConst.class, queryCondition, consts, pageVO);

	}

	@Override
	public PageVO batchSearchOnePage(DBObject queryCondition, DBObject sort, DBObject returnFields) {

		PageVO pageVO = this.getParamPageVO();

		List<DBObject> consts = this.commonDaoMongo.findBatchPagePartDBObject(SysConst.class, queryCondition, sort,
				returnFields, pageVO);

		return this.handleDBObjList(commonDaoMongo, SysConst.class, queryCondition, consts, pageVO);
	}

	@Override
	public String add(SysConst sysconst) {
		this.setCreateInfo(sysconst);
		sysconst.setUse_flg(true); // 默认设置为启用

		return this.commonDaoMongo.insertOne(sysconst);
	}

	@Override
	public DBObject updatePart(DBObject returnFields, SysConst sysconst) {

		DBObject toUpdate = makeUpdate(sysconst);

		return this.commonDaoMongo.updateOneById(sysconst.get_id_m(), returnFields, toUpdate, SysConst.class);
	}

	/****
	 * 转化对象为要更新的部分字段
	 * 
	 * @param update
	 * @return
	 */
	private DBObject makeUpdate(SysConst sysconst) {

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("val", sysconst.getVal());
		updateSet.put("dspval", sysconst.getDspval());
		updateSet.put("valordernum", sysconst.getValordernum());

		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		logger.debug("更新的对象信息\n{}", update);
		return update;
	}

	@Override
	public int RemoveOneById(String _id) {
		return this.commonDaoMongo.removeById(_id, SysConst.class);
	}

	@Override
	public int RemoveOneByIdLogic(String _id) {

		DBObject updateSet = new BasicDBObject();
		this.setModifyInfo(updateSet);
		return this.commonDaoMongo.removeByIdLogic(_id, SysConst.class,updateSet);
	}

	@Override
	public boolean isExistSameConstval(SysConst sysconst) {

		DBObject returnFields = new BasicDBObject();
		returnFields.put("_id", 1);

		DBObject queryCondition = new BasicDBObject();

		queryCondition.put("typecode", sysconst.getTypecode());// 常量类型
		queryCondition.put("val", sysconst.getVal());// 常量值
		queryCondition.put("use_flg", "1");
		String _id = sysconst.get_id_m();
		if (StringUtil.isNotEmpty(_id)) {
			queryCondition.put("_id", new BasicDBObject("$ne", new ObjectId(_id)));
		}

		DBObject result = this.commonDaoMongo.findOnePartDBObject(SysConst.class, queryCondition, returnFields);

		if (result != null && result.get("_id") != null) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isExistSameConstDispval(SysConst sysconst) {

		DBObject returnFields = new BasicDBObject();
		returnFields.put("_id", 1);

		DBObject queryCondition = new BasicDBObject();

		queryCondition.put("typecode", sysconst.getTypecode());// 常量类型
		queryCondition.put("dspval", sysconst.getDspval());// 常量显示值
		queryCondition.put("useflg", "1");
		String _id = sysconst.get_id_m();
		if (StringUtil.isNotEmpty(_id)) {
			queryCondition.put("_id", new BasicDBObject("$ne", new ObjectId(_id)));
		}

		DBObject result = this.commonDaoMongo.findOnePartDBObject(SysConst.class, queryCondition, returnFields);

		if (result != null && result.get("_id") != null) {
			return true;
		}

		return false;
	}

	@Override
	public List<DBObject> findAllConstBySysconstTypecode(String typecode) {

		DBObject queryCondition = new BasicDBObject();

		if (!StringUtil.isEmpty(typecode)) {
			queryCondition.put("typecode", typecode);
		}

		queryCondition.put("use_flg", "1");
		queryCondition.put("del_flg", "0");
		
		DBObject sort = new BasicDBObject();
		sort.put("typecode", 1);
		sort.put("valordernum", 1);
		sort.put("val", 1);

		return this.commonDaoMongo.findBatchDBObject(queryCondition, sort, SysConst.class);
	}

	@Override
	public Object findSysconstByConstTypeOnePage(String typecode, DBObject sort, DBObject returnFields) {

		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("typecode", typecode);
		queryCondition.put("use_flg", "1");
		queryCondition.put("del_flg", "0");

		return this.batchSearchOnePage(queryCondition, sort, returnFields);
	}

	@Override
	public String findDispValByTypecodAndVal(String typecode, String val) {

		// 1.查缓存

		// 2.查数据库
		DBObject returnFields = new BasicDBObject();
		returnFields.put("_id", 0);
		returnFields.put("dspval", 1);

		DBObject queryCondition = new BasicDBObject();

		queryCondition.put("typecode", typecode);// 常量类型
		queryCondition.put("val", val);

		DBObject dbo = this.commonDaoMongo.findOnePartDBObject(SysConst.class, queryCondition, returnFields);

		if (dbo == null) {
			return null;
		}

		return (String) dbo.get("dspval");
	}

	@Override
	public List<DBObject> findSysconstByConstType(String typecode, DBObject sort, DBObject returnFields) {

		typecode = typecode.trim();

		// 1.查缓存

		// 2.查数据库
		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("typecode", typecode);
		queryCondition.put("use_flg", "1");
		queryCondition.put("del_flg", "0");

		return this.commonDaoMongo.findBatchPartDBObject(SysConst.class, queryCondition, sort, returnFields);
	}

	@Override
	public List<DBObject> findAllConstBySysconstTypecode() {

		return this.findAllConstBySysconstTypecode(null);

	}
	
	public static void main(String[] args) {
		boolean aa = ObjectId.isValid("55f134b70b63ed0e78ba2405");
		System.out.println( aa);
	}
}
