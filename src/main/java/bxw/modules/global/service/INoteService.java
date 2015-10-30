package bxw.modules.global.service;

import java.util.List;

import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.PageVO;

import bxw.modules.global.model.Note;

/****
 * 记录接口
 * 
 * @author NBQ
 *
 */
public interface INoteService {

	/****
	 * 根据id，查询一个对象
	 * 
	 * @param _id
	 * @return
	 */
	public Note findOneByIdObject(String _id);

	/****
	 * 条件查询，分页
	 * 
	 * @param query
	 * @param sort
	 * @param returnFields
	 * @return
	 */
	public PageVO batchSearchPage(DBObject queryCondition, DBObject sort, DBObject returnFields);

	public List<Note> batchSearch(DBObject queryCondition, DBObject sort, DBObject returnFields);

	/****
	 * 插入对象，返回插入后的生成的ObjectId
	 * 
	 * @param note
	 * @return
	 */
	public String add(Note note);

	/****
	 * 更新一条记录，返回更新后的结果，根据对象的主键ObjectId
	 * 
	 * @param returnFields
	 * @param note
	 * @return
	 */
	public DBObject updatePart(DBObject returnFields, Note note);

	/****
	 * 查询并删除一条记录
	 * 
	 * @param _id
	 * @return
	 */
	public int RemoveOneById(String _id);

	/****
	 * 查询节点的所有直接子节点
	 * 
	 * @param sort
	 * @param returnFields
	 * @param parentId
	 * @return
	 */
	public List<DBObject> findChildrenByPId(DBObject sort, DBObject returnFields, Integer parentId);

}
