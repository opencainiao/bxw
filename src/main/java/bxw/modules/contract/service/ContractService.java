package bxw.modules.contract.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.PageVO;
import com.mou.mongodb.base.springdb.dao.IBaseDaoMongo;

import bxw.modules.base.BaseService;
import bxw.modules.contract.model.Contract;
import bxw.modules.global.model.Attachment;
import bxw.modules.global.service.IAttachmentService;

/****
 * 合同服务
 * 
 * @author NBQ
 *
 */
@Service("contractService")
public class ContractService extends BaseService implements IContractService {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	@Resource(name = "attachmentService")
	private IAttachmentService attachmentService;

	private final Logger logger = LogManager.getLogger(ContractService.class);

	@Override
	public String add(Contract contract) {

		contract.setPinYin();

		this.setCreateInfo(contract);

		return this.commonDaoMongo.insertOne(contract);
	}

	@Override
	public Contract findContractInfById(String _id) {
		return this.commonDaoMongo.findOneById(_id, Contract.class);
	}

	@Override
	public PageVO batchSearchPage(DBObject queryCondition, DBObject sort, DBObject returnFields) {
		PageVO pageVO = this.getParamPageVO();

		List<DBObject> contracts = this.commonDaoMongo.findBatchPagePartDBObject(Contract.class, queryCondition, sort,
				returnFields, pageVO);

		return this.handleDBObjList(commonDaoMongo, Contract.class, queryCondition, contracts, pageVO);
	}

	// @Override
	// public DBObject updateStatus(String _id, ContractState state) {
	//
	// if (StringUtil.isEmpty(_id) || !this.isValidObjId(_id)) {
	// return null;
	// }
	//
	// DBObject update = new BasicDBObject();
	// DBObject updateSet = new BasicDBObject();
	//
	// updateSet.put("state", state.getCode());
	// updateSet.put("state_name", state.getName());
	// this.setModifyInfo(updateSet);
	//
	// update.put("$set", updateSet);
	//
	// return this.commonDaoMongo.updateOneById(_id, null, update,
	// Contract.class);
	// }

	@Override
	public DBObject updatePart(DBObject returnFields, Contract contract) {

		DBObject toUpdate = makeUpdate(contract);

		return this.commonDaoMongo.updateOneById(contract.get_id_m(), returnFields, toUpdate, Contract.class);
	}

	/****
	 * 转化对象为要更新的部分字段
	 * 
	 * @param update
	 * @return
	 */
	private DBObject makeUpdate(Contract contract) {

		contract.setPinYin();

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("identifier_num", contract.getIdentifier_num());
		updateSet.put("effective_date", contract.getEffective_date());
		updateSet.put("applicant_id", contract.getApplicant_id());
		updateSet.put("applicant_name", contract.getApplicant_name());
		updateSet.put("applicant_id_card", contract.getApplicant_id_card());
		updateSet.put("assured_id", contract.getAssured_id());
		updateSet.put("assured_name", contract.getAssured_name());
		updateSet.put("assured_id_card", contract.getAssured_id_card());
		updateSet.put("assured_birth_date", contract.getAssured_birth_date());
		updateSet.put("assured_sex", contract.getAssured_sex());
		updateSet.put("assured_age", contract.getAssured_age());
		updateSet.put("insurance_character", contract.getInsurance_character());
		updateSet.put("insurance_type", contract.getInsurance_type());
		updateSet.put("insurance_amt", contract.getInsurance_amt());
		updateSet.put("insurance_time_type", contract.getInsurance_time_type());
		updateSet.put("insurance_time_type_name", contract.getInsurance_time_type_name());
		updateSet.put("payment_period", contract.getPayment_period());
		updateSet.put("afyp", contract.getAfyp());
		updateSet.put("afyc", contract.getAfyc());
		updateSet.put("payment_characher", contract.getPayment_characher());
		updateSet.put("payment_type", contract.getPayment_type());
		updateSet.put("bank_type", contract.getBank_type());
		updateSet.put("bank_type_name", contract.getBank_type_name());
		updateSet.put("bank_number", contract.getBank_number());
		updateSet.put("death_beneficiary", contract.getDeath_beneficiary());
		updateSet.put("death_beneficiary_id_card", contract.getDeath_beneficiary_id_card());
		updateSet.put("relation_ship", contract.getRelation_ship());
		updateSet.put("beneficiary_percent", contract.getBeneficiary_percent());
		updateSet.put("is_physical_examination", contract.getIs_physical_examination());
		updateSet.put("physical_examination_items", contract.getPhysical_examination_items());
		updateSet.put("remark", contract.getRemark());

		updateSet.put("applicant_pinyin_name", contract.getApplicant_pinyin_name());
		updateSet.put("applicant_first_char_header", contract.getApplicant_first_char_header());
		updateSet.put("applicant_all_char_header", contract.getApplicant_all_char_header());
		updateSet.put("assured_pinyin_name", contract.getAssured_pinyin_name());
		updateSet.put("assured_first_char_header", contract.getAssured_first_char_header());
		updateSet.put("assured_all_char_header", contract.getAssured_all_char_header());

		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		logger.debug("更新的对象信息\n{}", update);
		return update;
	}

	@Override
	public int RemoveOneById(String _id) {

		return this.commonDaoMongo.removeById(_id, Contract.class);
	}

	@Override
	public Contract findOneByCondition(DBObject query) {

		query.put("del_flg", "0");

		Contract contract = this.commonDaoMongo.findOnePart(Contract.class, query, null);

		return contract;
	}

	@Override
	public DBObject addFile(String contract_id, String attachId) {

		DBObject returnFilds = new BasicDBObject();
		returnFilds.put("file_ids", 1);

		Contract contract = this.commonDaoMongo.findOnePartById(contract_id, returnFilds, Contract.class);

		List<String> file_ids = contract.getFile_ids();

		if (file_ids == null) {
			file_ids = new ArrayList<String>();
		}
		file_ids.add(attachId);

		// 设置身份证属性
		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();
		updateSet.put("file_ids", file_ids);
		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		return this.commonDaoMongo.updateOneById(contract_id, null, update, Contract.class);
	}

	@Override
	public List<Map<String, String>> getFiles(String contract_id) {

		Contract contract = this.commonDaoMongo.findOnePartById(contract_id, null, Contract.class);

		List<String> file_ids = contract.getFile_ids();

		List<Map<String, String>> files = new ArrayList<Map<String, String>>();

		if (file_ids != null) {

			for (String file_id : file_ids) {
				String id = file_id;
				Attachment attach = this.attachmentService.getAttachMent(id);
				String name = attach.getOriName();
				Map<String, String> map = new HashMap<String, String>();
				map.put("id", id);
				map.put("name", name);
				map.put("suffix", attach.getSuffix());
				
				files.add(map);
			}
		}

		return files;
	}

	@Override
	public void deleteFile(String contract_id, String attachId) {

		DBObject returnFilds = new BasicDBObject();
		returnFilds.put("file_ids", 1);

		Contract contract = this.commonDaoMongo.findOnePartById(contract_id, returnFilds, Contract.class);

		List<String> file_ids_ori = contract.getFile_ids();

		List<String> file_ids_new = new ArrayList<String>();

		if (file_ids_ori != null) {
			for (String file_id : file_ids_ori) {
				if (!file_id.equals(attachId)) {
					file_ids_new.add(file_id);
				}
			}
		}
		// 设置文件属性
		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();
		updateSet.put("file_ids", file_ids_new);
		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		this.commonDaoMongo.updateOneById(contract_id, null, update, Contract.class);

		// 删除card_id对应的附件
		this.attachmentService.deleteOneAttachment(attachId);

	}
}
