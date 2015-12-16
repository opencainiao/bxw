package bxw.modules.exhibition.service;

import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.PageVO;

import bxw.modules.exhibition.enums.PlanState;
import bxw.modules.exhibition.model.Plan;

/****
 * 计划服务
 * 
 * @author NBQ
 *
 */
public interface IPlanService {

	/****
	 * 插入对象，返回插入后的生成的ObjectId
	 * 
	 * @param plan
	 * @return
	 */
	public String add(Plan plan);

	/****
	 * 根据_id获取计划信息
	 * 
	 * @param _id
	 * @return
	 */
	public Plan findPlanInfById(String _id);

	/****
	 * 根据条件，查询一个客户
	 * 
	 * @param query
	 * @param isRedisplay
	 * @return
	 */
	public Plan findOneByCondition(DBObject query);

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
	 * 更新计划状态
	 * 
	 * @param _id
	 * @param userState
	 * @return
	 */
	public DBObject updateStatus(String _id, PlanState state);

	/****
	 * 更新一条记录，返回更新后的结果，根据对象的主键ObjectId
	 * 
	 * @param returnFields
	 * @param sysconst
	 * @return
	 */
	public DBObject updatePart(DBObject returnFields, Plan plan);

	/****
	 * 查询并删除一条记录
	 * 
	 * @param _id
	 * @return
	 */
	public int RemoveOneById(String _id);

}
