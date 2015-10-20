package bxw.modules.exhibition.service;

import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.PageVO;

import bxw.modules.exhibition.enums.ExhibitionState;
import bxw.modules.exhibition.model.Exhibition;

/****
 * 展业服务
 * 
 * @author NBQ
 *
 */
public interface IExhibitionService {

	/****
	 * 插入对象，返回插入后的生成的ObjectId
	 * 
	 * @param exhibition
	 * @return
	 */
	public String add(Exhibition exhibition);

	/****
	 * 根据_id获取展业信息
	 * 
	 * @param _id
	 * @return
	 */
	public Exhibition findExhibitionInfById(String _id);

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
	 * 更新展业状态
	 * 
	 * @param _id
	 * @param userState
	 * @return
	 */
	public DBObject updateStatus(String _id, ExhibitionState state);

	/****
	 * 更新一条记录，返回更新后的结果，根据对象的主键ObjectId
	 * 
	 * @param returnFields
	 * @param sysconst
	 * @return
	 */
	public DBObject updatePart(DBObject returnFields, Exhibition exhibition);

	/****
	 * 查询并删除一条记录
	 * 
	 * @param _id
	 * @return
	 */
	public int RemoveOneById(String _id);

}
