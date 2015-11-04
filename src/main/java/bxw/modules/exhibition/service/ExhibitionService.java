package bxw.modules.exhibition.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mou.common.DateUtil;
import org.mou.common.StringUtil;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.PageVO;
import com.mou.mongodb.base.springdb.dao.IBaseDaoMongo;

import bxw.modules.base.BaseService;
import bxw.modules.exhibition.enums.ExhibitionGlobalState;
import bxw.modules.exhibition.enums.ExhibitionStage;
import bxw.modules.exhibition.enums.ExhibitionState;
import bxw.modules.exhibition.model.Exhibition;

/****
 * 展业服务
 * 
 * @author NBQ
 *
 */
@Service("exhibitionService")
public class ExhibitionService extends BaseService implements IExhibitionService {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	private final Logger logger = LogManager.getLogger(ExhibitionService.class);

	@Override
	public String add(Exhibition exhibition) {

		exhibition.setGlobal_state(ExhibitionGlobalState.STARTED);
		exhibition.setStage(ExhibitionStage.CONTACT);
		exhibition.setState(ExhibitionState.CONTACT);
		exhibition.setStart_date(DateUtil.getCurdate());
		exhibition.setStart_time(DateUtil.getCurrentTimsmp());
		exhibition.setPinYin();

		this.setCreateInfo(exhibition);

		return this.commonDaoMongo.insertOne(exhibition);
	}

	@Override
	public Exhibition findExhibitionInfById(String _id) {
		return this.commonDaoMongo.findOneById(_id, Exhibition.class);
	}

	@Override
	public PageVO batchSearchPage(DBObject queryCondition, DBObject sort, DBObject returnFields) {
		PageVO pageVO = this.getParamPageVO();

		List<DBObject> exhibitions = this.commonDaoMongo.findBatchPagePartDBObject(Exhibition.class, queryCondition,
				sort, returnFields, pageVO);

		return this.handleDBObjList(commonDaoMongo, Exhibition.class, queryCondition, exhibitions, pageVO);
	}

	@Override
	public DBObject updateStatus(String _id, ExhibitionState state) {

		if (StringUtil.isEmpty(_id) || !this.isValidObjId(_id)) {
			return null;
		}

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("state", state.getCode());
		updateSet.put("state_name", state.getName());
		this.setModifyInfo(updateSet);

		update.put("$set", updateSet);

		return this.commonDaoMongo.updateOneById(_id, null, update, Exhibition.class);
	}

	@Override
	public DBObject updatePart(DBObject returnFields, Exhibition exhibition) {

		DBObject toUpdate = makeUpdate(exhibition);

		return this.commonDaoMongo.updateOneById(exhibition.get_id_m(), returnFields, toUpdate, Exhibition.class);
	}

	/****
	 * 转化对象为要更新的部分字段
	 * 
	 * @param update
	 * @return
	 */
	private DBObject makeUpdate(Exhibition exhibition) {

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("remark", exhibition.getRemark());

		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		logger.debug("更新的对象信息\n{}", update);
		return update;
	}

	@Override
	public int RemoveOneById(String _id) {

		return this.commonDaoMongo.removeById(_id, Exhibition.class);
	}

	@Override
	public Exhibition findOneByCondition(DBObject query) {

		query.put("del_flg", "0");

		Exhibition exhibition = this.commonDaoMongo.findOnePart(Exhibition.class, query, null);

		return exhibition;
	}
}
