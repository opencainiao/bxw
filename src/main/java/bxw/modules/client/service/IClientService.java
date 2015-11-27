package bxw.modules.client.service;

import java.util.List;
import java.util.Map;

import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.PageVO;

import bxw.modules.client.model.Client;

/****
 * 用户服务接口
 * 
 * @author NBQ
 *
 */
public interface IClientService {

	/****
	 * 根据条件，查询一个客户
	 * 
	 * @param query
	 * @param isRedisplay
	 * @return
	 */
	public Client findOneByCondition(DBObject query, boolean isRedisplay);

	/****
	 * 根据条件，查询一个客户(不回显)
	 * 
	 * @param query
	 * @return
	 */
	public DBObject findOneByConditionDBObj(DBObject query);

	/****
	 * 根据id，查询一个对象
	 * 
	 * @param _id
	 * @param isRedisplay
	 *            true-进行回显 false-不回显
	 * @return
	 */
	public Client findOneByIdObject(String _id, boolean isRedisplay);

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
	 * 下载用户的所有客户
	 * 
	 * @param userId
	 * @return
	 */
	public List<Client> downLoadAllClientByUserId(String userId);

	/****
	 * 查询用户的所有客户
	 * 
	 * @param userId
	 * @param last_op_time
	 *            最后操作时间 如果为空，则不加条件。否则查询该时间以后的
	 * @return
	 */
	public List<DBObject> findAllClientsByUserId(String userId, String last_op_time);

	/****
	 * 条件查询，1页，查询所有
	 * 
	 * @param query
	 * @param sort
	 * @param returnFields
	 * @return
	 */
	public PageVO batchSearchOnePage(DBObject query, DBObject sort, DBObject returnFields);

	/****
	 * 插入对象，返回插入后的生成的ObjectId
	 * 
	 * @param client
	 * @return
	 */
	public String add(Client client);

	/****
	 * 根据客户名，取客户id
	 * 
	 * @param clientName
	 * @param userId
	 * @return
	 */
	public String getOidByClientName(String clientName, String userId);

	/****
	 * 更新一条记录(全量更新)，返回更新后的结果，根据对象的主键ObjectId
	 * 
	 * @param returnFields
	 * @param client
	 * @return
	 */
	public DBObject updateFull(Client client);

	/****
	 * 更新一条记录，返回更新后的结果，根据对象的主键ObjectId
	 * 
	 * @param returnFields
	 * @param client
	 * @return
	 */
	public DBObject updatePart(DBObject returnFields, Client client);

	public int RemoveOneById(String _id);

	public int RemoveOneByIdLogic(String _id);

	/****
	 * 给客户添加一个名片
	 * 
	 * @param client_id
	 * @param visitingCardId
	 * @return
	 */
	public DBObject addVisitingCard(String client_id, String visitingCardId);

	/****
	 * 查询客户的所有名片
	 * 
	 * @param client_id
	 * @return
	 */
	public List<String> getVisitingCards(String client_id);

	/*****
	 * 删除客户的一张名片
	 * 
	 * @param client_id
	 * @param card_id
	 */
	public void deleteVisitingCard(String client_id, String card_id);

	/****
	 * 给客户添加一个身份证
	 * 
	 * @param client_id
	 * @param visitingCardId
	 * @return
	 */
	public DBObject addIdCard(String client_id, String visitingCardId);

	/****
	 * 查询客户的所有身份证
	 * 
	 * @param client_id
	 * @return
	 */
	public List<String> getIdCards(String client_id);

	/*****
	 * 删除客户的一张名片
	 * 
	 * @param client_id
	 * @param card_id
	 */
	public void deleteIdCard(String client_id, String card_id);

	/****
	 * 给客户添加一个文件
	 * 
	 * @param client_id
	 * @param visitingCardId
	 * @return
	 */
	public DBObject addFile(String client_id, String attachId);

	/****
	 * 查询客户的所有文件
	 * 
	 * @param client_id
	 * @return
	 */
	public List<Map<String,String>> getFiles(String client_id);

	/*****
	 * 删除客户的一个文件
	 * 
	 * @param client_id
	 * @param card_id
	 */
	public void deleteFile(String client_id, String attachId);

}
