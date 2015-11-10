package bxw.modules.exhibition.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mou.common.DateUtil;
import org.mou.common.JsonUtil;
import org.mou.common.StringUtil;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.PageVO;
import com.mou.mongodb.base.springdb.dao.IBaseDaoMongo;

import bxw.modules.base.BaseService;
import bxw.modules.exhibition.enums.AccomplishFlg;
import bxw.modules.exhibition.enums.ExhibitionGlobalState;
import bxw.modules.exhibition.enums.ExhibitionStage;
import bxw.modules.exhibition.enums.ExhibitionState;
import bxw.modules.exhibition.model.Exhibition;
import bxw.modules.exhibition.model.ExhibitionItem;
import bxw.modules.infrustructure.enums.SysConstTypeEnum;
import bxw.modules.infrustructure.service.ISysConstService;

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

	@Resource(name = "sysConstService")
	private ISysConstService sysConstService;

	@Resource(name = "exhibitionService")
	private IExhibitionService exhibitionService;

	private final Logger logger = LogManager.getLogger(ExhibitionItemService.class);

	private void setNames(ExhibitionItem exhibitionItem) {

		String client_exhibiton_state = exhibitionItem.getClient_exhibiton_state();
		if (StringUtil.isNotEmpty(client_exhibiton_state)) {
			String client_exhibiton_state_name = sysConstService
					.findDispValByTypecodAndVal(SysConstTypeEnum.EXHIBITION_STATE.getCode(), client_exhibiton_state);

			exhibitionItem.setClient_exhibiton_state_name(client_exhibiton_state_name);
		}

		String next_action = exhibitionItem.getNext_action();
		if (StringUtil.isNotEmpty(next_action)) {
			String next_action_name = sysConstService
					.findDispValByTypecodAndVal(SysConstTypeEnum.EXHIBITION_CHARACTER.getCode(), next_action);

			exhibitionItem.setNext_action_name(next_action_name);
		}

		String stage = exhibitionItem.getStage();
		ExhibitionStage eStage = ExhibitionStage.getByCode(stage);
		if (eStage != null) {
			exhibitionItem.setStage(eStage);
		}

		String state = exhibitionItem.getState();
		ExhibitionState eState = ExhibitionState.getByCode(state);
		if (eState != null) {
			exhibitionItem.setState(eState);
		}
	}

	@Override
	public String add(ExhibitionItem exhibitionItem) {

		String user_id = exhibitionItem.getUser_id();

		if (StringUtil.isNotEmpty(user_id)) {

			String[] user_ids = user_id.split(";");
			String[] user_names = exhibitionItem.getUsername().split(";");

			for (int i = 0; i < user_ids.length; ++i) {

				String user_id_this = user_ids[i];
				String user_name_this = user_names[i];

				if (this.isValidObjId(user_id_this)) {

					DBObject query = new BasicDBObject();
					query.put("user_id", user_id_this);
					query.put("global_state", ExhibitionGlobalState.STARTED.getCode());

					Exhibition exhibition = exhibitionService.findOneByCondition(query);
					String exhibition_id = null;

					// 判断是否有一个已经开启的展业，如果有，则设置为该展业项目的id
					// 如果没有，则开启一个展业，并设置为该展业项目的id
					if (exhibition == null) {

						exhibition = new Exhibition();
						exhibition.setUser_id(user_id);
						exhibition.setUsername(user_name_this);

						exhibition_id = this.exhibitionService.add(exhibition);
					} else {
						exhibition_id = exhibition.get_id_m();
					}

					// 对于多个人的情况，不设置exhibition_id
					if (user_ids.length == 1) {
						exhibitionItem.setExhibition_id(exhibition_id);
					}
				}
			}
		}

		setNames(exhibitionItem);
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
		setNames(exhibitionItem);

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

		updateSet.put("next_action", exhibitionItem.getNext_action());
		updateSet.put("next_action_name", exhibitionItem.getNext_action_name());
		updateSet.put("next_action_cmt", exhibitionItem.getNext_action_cmt());

		updateSet.put("client_exhibiton_state", exhibitionItem.getClient_exhibiton_state());
		updateSet.put("client_exhibiton_state_name", exhibitionItem.getClient_exhibiton_state_name());
		updateSet.put("client_exhibiton_state_cmt", exhibitionItem.getClient_exhibiton_state_cmt());

		updateSet.put("acclaim_points", exhibitionItem.getAcclaim_points());
		updateSet.put("grateful_points", exhibitionItem.getGrateful_points());
		updateSet.put("client_questions", exhibitionItem.getClient_questions());

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

	@Override
	public int findExhibitionItemNoteCount(String _id) {

		DBObject returnFields = new BasicDBObject();
		returnFields.put("note_count", 1);

		ExhibitionItem exhibitionItem = this.commonDaoMongo.findOnePartById(_id, returnFields, ExhibitionItem.class);

		if (exhibitionItem == null) {
			return 0;
		}

		return exhibitionItem.getNote_count();
	}

	public static void main(String[] args) {

		String user_id = "aa";
		String[] user_ids = user_id.split(";");

		System.out.println(JsonUtil.toJsonStr(user_ids));
	}

	@Override
	public void accomplish(String exhibitionItemId, boolean flg) {

		AccomplishFlg accomplishFlg = null;

		if (flg) {
			accomplishFlg = AccomplishFlg.ACCOMPLISHED;
		} else {
			accomplishFlg = AccomplishFlg.NOT_ACCOMPLISHED;
		}

		DBObject toUpdate = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("accomplish_flg", accomplishFlg.getCode());
		updateSet.put("accomplish_flg_name", accomplishFlg.getName());
		updateSet.put("accomplish_time", DateUtil.getCurrentTimsmp());

		this.setModifyInfo(updateSet);
		toUpdate.put("$set", updateSet);

		this.commonDaoMongo.updateOneById(exhibitionItemId, null, toUpdate, ExhibitionItem.class);
	}
}
