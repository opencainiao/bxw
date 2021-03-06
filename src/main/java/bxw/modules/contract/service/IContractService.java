package bxw.modules.contract.service;

import java.util.List;
import java.util.Map;

import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.PageVO;

import bxw.modules.contract.model.Contract;

/****
 * 合同服务
 * 
 * @author NBQ
 *
 */
public interface IContractService {

	/****
	 * 插入对象，返回插入后的生成的ObjectId
	 * 
	 * @param contract
	 * @return
	 */
	public String add(Contract contract);

	/****
	 * 根据_id获取合同信息
	 * 
	 * @param _id
	 * @return
	 */
	public Contract findContractInfById(String _id);

	/****
	 * 根据条件，查询一个
	 * 
	 * @param query
	 * @param isRedisplay
	 * @return
	 */
	public Contract findOneByCondition(DBObject query);

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
	public DBObject updatePart(DBObject returnFields, Contract contract);

	/****
	 * 查询并删除一条记录
	 * 
	 * @param _id
	 * @return
	 */
	public int RemoveOneById(String _id);
	
	/****
	 * 给合同添加一个文件
	 * 
	 * @param client_id
	 * @param visitingCardId
	 * @return
	 */
	public DBObject addFile(String contract_id, String attachId);

	/****
	 * 查询合同的所有文件
	 * 
	 * @param contract_id
	 * @return
	 */
	public List<Map<String,String>> getFiles(String contract_id);

	/*****
	 * 删除合同的一个文件
	 * 
	 * @param contract_id
	 * @param card_id
	 */
	public void deleteFile(String contract_id, String attachId);

}
