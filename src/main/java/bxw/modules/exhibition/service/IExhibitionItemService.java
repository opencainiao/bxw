package bxw.modules.exhibition.service;

import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.PageVO;

import bxw.modules.exhibition.model.ExhibitionItem;

/****
 * 展业项目服务
 * 
 * @author NBQ
 *
 */
public interface IExhibitionItemService {

	/****
	 * 根据_id获取展业信息
	 * 
	 * @param _id
	 * @return
	 */
	public int findExhibitionItemNoteCount(String _id);

	/****
	 * 插入对象，返回插入后的生成的ObjectId
	 * 
	 * @param exhibitionItem
	 * @return
	 */
	public String add(ExhibitionItem exhibitionItem);

	/****
	 * 根据_id获取展业信息
	 * 
	 * @param _id
	 * @return
	 */
	public ExhibitionItem findExhibitionItemInfById(String _id);

	/****
	 * 条件查询，分页
	 * 
	 * @param query
	 * @param sort
	 * @param returnFields
	 * @return
	 */
	public PageVO batchSearchPage(DBObject queryCondition, DBObject sort, DBObject returnFields);

	/****
	 * 更新一条记录，返回更新后的结果，根据对象的主键ObjectId
	 * 
	 * @param returnFields
	 * @param sysconst
	 * @return
	 */
	public DBObject updatePart(DBObject returnFields, ExhibitionItem exhibitionItem);

	/****
	 * 查询并删除一条记录
	 * 
	 * @param _id
	 * @return
	 */
	public int RemoveOneById(String _id);

	/****
	 * 设定完成情况
	 * 
	 * @param exhibitionItemId
	 * @param flg
	 *            - true-完成 false-未完成
	 */
	public void accomplish(String exhibitionItemId, boolean flg);

}
