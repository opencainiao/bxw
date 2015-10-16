package bxw.modules.client.service;

import java.util.List;

import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.PageVO;

import bxw.modules.client.model.Address;

/****
 * 地址服务接口
 * 
 * @author NBQ
 *
 */
public interface IAddressService {

	/****
	 * 查询一个人的所有地址信息
	 * 
	 * @param ownerId
	 * @return
	 */
	public List<DBObject> findAllByOwnerId(String ownerId);

	/****
	 * 条件查询，1页，查询所有
	 * 
	 * @param query
	 * @param sort
	 * @param returnFields
	 * @return
	 */
	public PageVO findAllOnePageByOwnerId(String ownerId);

	/****
	 * 根据id，查询一个对象
	 * 
	 * @param _id
	 * @return
	 */
	public Address findOneByIdObject(String _id);

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
	 * @param address
	 * @return
	 */
	public String add(Address address);

	/****
	 * 给用户插入一组地址信息
	 * 
	 * @param addresses
	 * @param ownerId
	 * @return
	 */
	public List<String> add(List<Address> addresses, String ownerId);

	/****
	 * 更新一条记录，返回更新后的结果，根据对象的主键ObjectId
	 * 
	 * @param returnFields
	 * @param address
	 * @return
	 */
	public DBObject updatePart(DBObject returnFields, Address address);

	public int RemoveOneById(String _id);

	public int RemoveOneByIdLogic(String _id);

}
