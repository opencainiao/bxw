package bxw.modules.client.service.modifyclientinfo;

import com.mongodb.DBObject;

import bxw.modules.client.model.Client;

/****
 * 修改客户信息
 * 
 * @author sks
 *
 */
public interface IModifyClientInfoService {
	/****
	 * 更新一条记录，返回更新后的结果，根据对象的主键ObjectId
	 * 
	 * @param returnFields
	 * @param client
	 * @return
	 */
	public DBObject updatePart(DBObject returnFields, Client client);
}
