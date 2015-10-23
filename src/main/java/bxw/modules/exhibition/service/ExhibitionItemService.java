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
import bxw.modules.exhibition.model.ExhibitionItem;

/****
 * 展业项目服务
 * 
 * @author NBQ
 *
 */
@Service("exhibitionItemService")
public class ExhibitionItemService extends BaseService implements IExhibitionItemService {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	private final Logger logger = LogManager.getLogger(ExhibitionItemService.class);

	@Override
	public String add(ExhibitionItem exhibitionItem) {

		exhibitionItem.setStart_date(DateUtil.getCurdate());
		exhibitionItem.setStart_time(DateUtil.getCurrentTimsmp());
		exhibitionItem.setPinYin();
		exhibitionItem.resetTime();

		this.setCreateInfo(exhibitionItem);

		return this.commonDaoMongo.insertOne(exhibitionItem);
	}

	@Override
	public ExhibitionItem findExhibitionItemInfById(String _id) {
		return this.commonDaoMongo.findOneById(_id, ExhibitionItem.class);
	}

	@Override
	public PageVO batchSearchPage(DBObject queryCondition, DBObject sort, DBObject returnFields) {
		PageVO pageVO = this.getParamPageVO();

		List<DBObject> exhibitionItems = this.commonDaoMongo.findBatchPagePartDBObject(ExhibitionItem.class,
				queryCondition, sort, returnFields, pageVO);

		reDisplay(exhibitionItems);

		return this.handleDBObjList(commonDaoMongo, ExhibitionItem.class, queryCondition, exhibitionItems, pageVO);
	}

	/****
	 * 设置回显信息
	 * 
	 * @param client
	 */
	private void reDisplay(List<DBObject> exhibitionItems) {

		for (DBObject exhibitionItem : exhibitionItems) {

			StringBuffer sb = new StringBuffer();

			String start_time = (String) exhibitionItem.get("start_time");
			if (StringUtil.isNotEmpty(start_time)) {
				sb.append("开始：").append(exhibitionItem.get("start_time")).append("&lt;br&gt;");
			}

			String end_time = (String) exhibitionItem.get("end_time");
			if (StringUtil.isNotEmpty(end_time)) {
				sb.append("结束：").append(exhibitionItem.get("end_time"));
			}

			exhibitionItem.put("time_info", sb.toString());
		}
	}

	@Override
	public DBObject updatePart(DBObject returnFields, ExhibitionItem exhibitionItem) {

		DBObject toUpdate = makeUpdate(exhibitionItem);

		return this.commonDaoMongo.updateOneById(exhibitionItem.get_id_m(), returnFields, toUpdate,
				ExhibitionItem.class);
	}

	/****
	 * 转化对象为要更新的部分字段
	 * 
	 * @param update
	 * @return
	 */
	private DBObject makeUpdate(ExhibitionItem exhibitionItem) {

		exhibitionItem.setPinYin();
		exhibitionItem.resetTime();

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("user_id", exhibitionItem.getUser_id());
		updateSet.put("username", exhibitionItem.getUsername());
		updateSet.put("remark", exhibitionItem.getRemark());
		updateSet.put("character", exhibitionItem.getCharacter());
		updateSet.put("character_name", exhibitionItem.getCharacter_name());
		updateSet.put("title", exhibitionItem.getTitle());
		updateSet.put("content", exhibitionItem.getContent());
		updateSet.put("address", exhibitionItem.getAddress());
		updateSet.put("gift", exhibitionItem.getGift());

		updateSet.put("stage", exhibitionItem.getStage());
		updateSet.put("state", exhibitionItem.getState());
		updateSet.put("stage_name", exhibitionItem.getStage_name());
		updateSet.put("state_name", exhibitionItem.getState_name());

		updateSet.put("start_date", exhibitionItem.getStart_date());
		updateSet.put("end_date", exhibitionItem.getEnd_date());
		updateSet.put("start_time", exhibitionItem.getStart_time());
		updateSet.put("end_time", exhibitionItem.getEnd_time());
		
		updateSet.put("attentions", exhibitionItem.getAttentions());
		
		updateSet.put("pinyin_name", exhibitionItem.getPinyin_name());
		updateSet.put("first_char_header", exhibitionItem.getFirst_char_header());
		updateSet.put("all_char_header", exhibitionItem.getAll_char_header());

		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		logger.debug("更新的对象信息\n{}", update);
		return update;
	}

	@Override
	public int RemoveOneById(String _id) {

		return this.commonDaoMongo.removeById(_id, ExhibitionItem.class);
	}
}
