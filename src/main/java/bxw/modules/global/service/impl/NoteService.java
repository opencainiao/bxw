package bxw.modules.global.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.PageVO;
import com.mou.mongodb.base.springdb.dao.IBaseDaoMongo;

import bxw.modules.base.BaseService;
import bxw.modules.exhibition.model.ExhibitionItem;
import bxw.modules.global.model.Note;
import bxw.modules.global.service.INoteService;

/****
 * Note类型服务实现
 * 
 * @author NBQ
 *
 */
@Service("noteService")
public class NoteService extends BaseService implements INoteService {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	private static final Logger logger = LogManager.getLogger(NoteService.class);

	@Override
	public Note findOneByIdObject(String _id) {

		return this.commonDaoMongo.findOneById(_id, Note.class);
	}

	@Override
	public PageVO batchSearchPage(DBObject queryCondition, DBObject sort, DBObject returnFields) {

		PageVO pageVO = this.getParamPageVO();

		List<DBObject> consts = this.commonDaoMongo.findBatchPagePartDBObject(Note.class, queryCondition, sort,
				returnFields, pageVO);

		return this.handleDBObjList(commonDaoMongo, Note.class, queryCondition, consts, pageVO);

	}
	
	@Override
	public List<Note> batchSearch(DBObject queryCondition, DBObject sort, DBObject returnFields) {

		List<Note> notes = this.commonDaoMongo.findBatchPart(Note.class, queryCondition, sort, returnFields);

		return notes;
	}

	@Override
	public String add(Note note) {

		this.setCreateInfo(note);
		String noteId = this.commonDaoMongo.insertOne(note);

		// 增加目标的记录数
		String target_id = note.getTarget_id();
		String target_type = note.getTarget_type();

		DBObject update = new BasicDBObject();
		update.put("$inc", new BasicDBObject("note_count", 1));

		Class clazz = getClass(target_type);
		DBObject result = commonDaoMongo.updateOneById(target_id, null, update, clazz);
		logger.debug("更新后的记录条数【{}】", result.get("note_count"));
		return noteId;
	}

	/****
	 * 根据目标类型取其所对应的Class
	 * 
	 * @param target_type
	 * @return
	 */
	private Class getClass(String target_type) {

		Class rtnClazz = null;
		if ("exhibitionitem".equals(target_type)) {
			rtnClazz = ExhibitionItem.class;
		}else if ("note".equals(target_type)) {
			rtnClazz = Note.class;
		}
		return rtnClazz;
	}

	@Override
	public DBObject updatePart(DBObject returnFields, Note note) {

		DBObject toUpdate = makeUpdate(note);

		return this.commonDaoMongo.updateOneById(note.get_id_m(), returnFields, toUpdate, Note.class);
	}

	/****
	 * 转化对象为要更新的部分字段
	 * 
	 * @param update
	 * @return
	 */
	private DBObject makeUpdate(Note note) {

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("content", note.getContent());

		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		logger.debug("更新的对象信息\n{}", update);
		return update;
	}

	@Override
	public int RemoveOneById(String _id) {
		
		Note note = this.findOneByIdObject(_id);
		
		DBObject update = new BasicDBObject();
		update.put("$inc", new BasicDBObject("note_count", -1));

		String target_id = note.getTarget_id();
		String target_type = note.getTarget_type();
		Class clazz = getClass(target_type);
		DBObject result = commonDaoMongo.updateOneById(target_id, null, update, clazz);

		return this.commonDaoMongo.removeById(_id, Note.class);
	}

	public static void main(String[] args) {
		boolean aa = ObjectId.isValid("55f134b70b63ed0e78ba2405");
		System.out.println(aa);
	}

	@Override
	public List<DBObject> findChildrenByPId(DBObject sort, DBObject returnFields, Integer parentId) {
		return null;
	}
}
