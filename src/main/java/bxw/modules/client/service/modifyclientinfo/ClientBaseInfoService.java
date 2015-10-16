package bxw.modules.client.service.modifyclientinfo;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mou.common.StringUtil;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mou.mongodb.base.springdb.dao.IBaseDaoMongo;

import bxw.common.util.AgeUtil;
import bxw.common.util.MongoUpListUtil;
import bxw.modules.base.BaseService;
import bxw.modules.client.model.Address;
import bxw.modules.client.model.Client;
import bxw.modules.client.model.Phone;
import bxw.modules.client.service.IAddressService;
import bxw.modules.client.service.IEmailService;
import bxw.modules.client.service.IPhoneService;
import bxw.modules.infrustructure.service.ISysConstService;

/****
 * 客户基本信息服务实现
 * 
 * @author NBQ
 *
 */
@Service("clientBaseInfoService")
public class ClientBaseInfoService extends BaseService implements IModifyClientInfoService {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	@Resource(name = "sysConstService")
	private ISysConstService sysConstService;

	@Resource(name = "addressService")
	private IAddressService addressService;

	@Resource(name = "phoneService")
	private IPhoneService phoneService;

	@Resource(name = "emailService")
	private IEmailService emailService;

	private static final Logger logger = LogManager.getLogger(ClientBaseInfoService.class);

	@Override
	public DBObject updatePart(DBObject returnFields, Client client) {

		DBObject toUpdate = makeUpdate(client);
		DBObject updatedResult = this.commonDaoMongo.updateOneById(client.get_id_m(), returnFields, toUpdate,
				Client.class);

		String client_id = client.get_id_m();
		// 地址信息
		List<Address> addresses = client.getAddress_info();
		this.addressService.add(addresses, client_id);

		logger.debug(addresses.toString());

		// 电话信息
		List<Phone> phones = client.getPhone_info();
		this.phoneService.add(phones, client_id);

		// 邮件信息
		// List<Email> emails = client.getEmail_info();
		// this.emailService.add(emails, client_id);

		return updatedResult;
	}

	/****
	 * 转化对象为要更新的部分字段
	 * 
	 * @param update
	 * @return
	 */
	private DBObject makeUpdate(Client client) {

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("client_name", client.getClient_name());
		updateSet.put("sex", client.getSex());
		updateSet.put("id_number", client.getId_number());
		updateSet.put("birth_date", client.getBirth_date());
		updateSet.put("region_code", client.getRegion_code());
		updateSet.put("region_name", client.getRegion_name());
		updateSet.put("region_type", client.getRegion_type());
		updateSet.put("education_type", client.getEducation_type());
		updateSet.put("interesting_service", client.getInteresting_service());

		if (client.getAddress_info() != null) {
			updateSet.put("address_info", MongoUpListUtil.getUpObject(client.getAddress_info()));
		} else {
			updateSet.put("address_info", null);
		}

		if (client.getPhone_info() != null) {
			updateSet.put("phone_info", MongoUpListUtil.getUpObject(client.getPhone_info()));
		} else {
			updateSet.put("phone_info", null);
		}

		if (client.getEmail_info() != null) {
			// updateSet.put("email_info",
			// MongoUpListUtil.getUpObject(client.getEmail_info()));

			updateSet.put("email_info", client.getEmail_info());
		} else {
			updateSet.put("email_info", null);
		}

		// updateSet.put("address_info", client.getAddress_info());
		// updateSet.put("phone_info", client.getPhone_info());
		// updateSet.put("email_info", client.getEmail_info());

		setClientInf(client, updateSet);

		this.setModifyInfoWithUserId(updateSet, client.getOwner_user_id());
		update.put("$set", updateSet);

		logger.debug("更新的对象信息\n{}", update);
		return update;
	}

	private void setClientInf(Client client, DBObject updateSet) {

		client.setPinYin();

		updateSet.put("pinyin_name", client.getPinyin_name());
		updateSet.put("first_char_header", client.getFirst_char_header());
		updateSet.put("all_char_header", client.getAll_char_header());

		String birth_date = client.getBirth_date();
		if (StringUtil.isNotEmpty(birth_date)) {
			try {
				updateSet.put("age", AgeUtil.getAge(birth_date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

}
