package bxw.modules.client.controller.app;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kopitubruk.util.json.JSONParser;
import org.mou.common.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import bxw.common.util.WebContextUtil;
import bxw.modules.base.BaseController;
import bxw.modules.client.enums.PartFlgEnum;
import bxw.modules.client.model.Client;
import bxw.modules.client.service.IClientService;
import bxw.modules.client.service.modifyclientinfo.IModifyClientInfoService;
import mou.web.webbase.domain.RequestResult;
import mou.web.webbase.domain.RequestResultForMobi;
import mou.web.webbase.domain.ValidResult;
import mou.web.webbase.handler.ErrorHandler;
import mou.web.webbase.util.HttpServletRequestUtil;

/****
 * 用户管理Controller
 * 
 * @author NBQ
 *
 */
@Controller("mclientcontroller")
@RequestMapping("/app/client")
public class ClientController extends BaseController {

	private static final Logger logger = LogManager
			.getLogger(ClientController.class);

	@Resource(name = "clientService")
	private IClientService clientService;

	/****
	 * 添加客户信息<br>
	 * 返回生成的主键，如果有错误，返回错误
	 * 
	 * @param client
	 * @return
	 */
	private RequestResult addClient(Client client) {

		ValidResult validResult = this.validate(client);
		if (validResult.hasErrors()) {
			return ErrorHandler.getRequestResultFromValidResult(validResult);
		}

		RequestResult rr = new RequestResult();
		try {
			// 1.新增
			String _id = this.clientService.add(client);

			rr.setSuccess(true);
			rr.setMessage(_id);

			logger.debug("插入结果[{}]", rr);
			return rr;
		} catch (Exception e) {
			return this.handleException(e);
		}
	}

	/****
	 * 添加一组客户<br>
	 * 返回生成的主键，如果有错误，返回错误
	 * 
	 * @param clients
	 * @return
	 */
	private RequestResult addBatch(Client[] clients, String user_id) {

		RequestResultForMobi rr = new RequestResultForMobi();

		RequestResult[] addResults = new RequestResult[clients.length];

		int falseTimes = 0;
		int successTimes = 0;
		for (int i = 0; i < clients.length; ++i) {
			Client client = clients[i];

			RequestResult addResult = addClient(client);

			if (addResult.getSuccess().equals("n")) {
				falseTimes++;
			} else {
				successTimes++;
			}

			addResults[i] = addResult;
		}

		rr.setObjects(Arrays.asList(addResults));

		if (falseTimes > 0) {
			rr.setSuccess(false);
		} else {
			rr.setSuccess(true);
		}

		rr.setFailure_num(falseTimes);
		rr.setSuccess_num(successTimes);

		return rr;
	}

	/****
	 * 添加
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(HttpServletRequest request, String data, String user_id) {

		HttpServletRequestUtil.debugParams(request);

		if (StringUtil.isEmpty(user_id)) {
			return this.handleValidateFalse("user_id不能为空");
		}

		try {
			Client[] clients = (Client[]) JSONParser.parseJSON(data);
					
			return addBatch(clients, user_id);
		} catch (Exception e) {
			return this.handleException(e);
		}
	}

	/****
	 * 查询系统所有客户信息
	 * 
	 * @param model
	 * @param request
	 * @param user_id
	 * @param last_op_time
	 *            最后操作时间
	 * @return
	 */
	@RequestMapping(value = "/list_by_userid", method = RequestMethod.GET)
	@ResponseBody
	public Object list_by_userid(Model model, HttpServletRequest request,
			String user_id, String last_op_time) {

		if (StringUtil.isEmpty(user_id)) {
			return this.handleValidateFalse("user_id不能为空");
		}

		RequestResultForMobi rr = new RequestResultForMobi();

		try {

			List<DBObject> clients = this.clientService.findAllClientsByUserId(
					user_id, last_op_time);

			rr.setObjects(clients);
			rr.setSuccess(true);
			rr.setSuccess_num(clients != null ? clients.size() : 0);

			return rr;

		} catch (Exception e) {
			return this.handleException(e);
		}
	}

	/****
	 * 查看单个用户 信息
	 * 
	 * @param _id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{_id}", method = RequestMethod.GET)
	@ResponseBody
	public Object detail(@PathVariable String _id, Model model, String user_id) {

		if (StringUtil.isEmpty(user_id)) {
			return this.handleValidateFalse("user_id不能为空");
		}

		if (!this.isValidObjId(_id)) {
			return this.handleValidateFalse("非法的客户主键");
		}

		if (!this.isValidObjId(user_id)) {
			return this.handleValidateFalse("非法的用户");
		}

		RequestResult rr = new RequestResult();

		try {
			DBObject query = new BasicDBObject();
			query.put("owner_user_id", user_id);
			query.put("_id", _id);
			query.put("delflg", "0");

			DBObject client = this.clientService.findOneByConditionDBObj(query);

			rr.setObject(client);
			rr.setSuccess(true);

			return rr;

		} catch (Exception e) {
			return this.handleException(e);
		}

	}

	/****
	 * 删除一条记录
	 * 
	 * @param zzdhid
	 * @return
	 */
	@RequestMapping(value = "/{_id}/delete", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@PathVariable String _id, HttpServletRequest request,
			String user_id) {

		if (!this.isValidObjId(_id)) {
			return this.handleValidateFalse("非法的客户主键");
		}

		if (!this.isValidObjId(user_id)) {
			return this.handleValidateFalse("非法的用户");
		}

		try {

			int num = this.clientService.RemoveOneByIdLogic(_id);
			RequestResult rr = new RequestResult();
			if (num == 0) {
				rr.setSuccess(false);
				rr.setMessage("用户" + user_id + "不存在id为" + _id + "的客户");
				return rr;
			} else {
				rr.setSuccess(true);
				return rr;
			}
		} catch (Exception e) {
			return this.handleException(e);
		}
	}

	/****
	 * 更新系统客户 信息，返回json给客户端（全量更新）
	 * 
	 * @param _id
	 * @param data
	 * @param user_id
	 * @param request
	 * @param part_flg
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{_id}/update_full", method = RequestMethod.POST)
	@ResponseBody
	public Object update_full(@PathVariable String _id, String data,
			String user_id, HttpServletRequest request, String part_flg) {

		if (!this.isValidObjId(_id)) {
			return this.handleValidateFalse("非法的客户主键");
		}

		if (!this.isValidObjId(user_id)) {
			return this.handleValidateFalse("非法的用户");
		}

		if (!PartFlgEnum.isValidPartFlg(part_flg)) {
			return this.handleValidateFalse("非法的更新参数part_flg");
		}

		Client client;
		try {
			client = (Client)JSONParser.parseJSON(data);
			client.set_id_m(_id);
		} catch (Exception e) {
			return this.handleException(e);
		}

		try {
			DBObject updateResult = this.clientService.updateFull(client);

			logger.debug("更新后的结果[{}]", updateResult);

			RequestResult rr = new RequestResult();
			rr.setSuccess(true);
			rr.setMessage(_id);
			return rr;
		} catch (Exception e) {
			return this.handleException(e);
		}
	}

	/****
	 * 更新系统客户 信息，返回json给客户端
	 * 
	 * @param _id
	 * @param data
	 * @param user_id
	 * @param request
	 * @param part_flg
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{_id}/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@PathVariable String _id, String data, String user_id,
			HttpServletRequest request, String part_flg) {

		if (!this.isValidObjId(_id)) {
			return this.handleValidateFalse("非法的客户主键");
		}

		if (!this.isValidObjId(user_id)) {
			return this.handleValidateFalse("非法的用户");
		}

		if (!PartFlgEnum.isValidPartFlg(part_flg)) {
			return this.handleValidateFalse("非法的更新参数part_flg");
		}

		Client client;
		try {
			
			client = (Client)JSONParser.parseJSON(data);
			client.set_id_m(_id);
		} catch (Exception e) {
			return this.handleException(e);
		}

		try {
			DBObject updateResult = null;

			IModifyClientInfoService modifyClientService = getModifyService(part_flg);
			modifyClientService.updatePart(null, client);

			logger.debug("更新后的结果[{}]", updateResult);

			RequestResult rr = new RequestResult();
			rr.setSuccess(true);
			rr.setMessage(_id);
			return rr;
		} catch (Exception e) {
			return this.handleException(e);
		}
	}

	private IModifyClientInfoService getModifyService(String part_flg) {

		IModifyClientInfoService modifyClientInfoService = null;

		if (part_flg.equals(PartFlgEnum.BASE.getCode())) {
			modifyClientInfoService = (IModifyClientInfoService) WebContextUtil
					.getBean("clientBaseInfoService");

		} else if (part_flg.equals(PartFlgEnum.FAMILLY.getCode())) {
			modifyClientInfoService = (IModifyClientInfoService) WebContextUtil
					.getBean("clientFamilyInfoService");

		} else if (part_flg.equals(PartFlgEnum.WORK.getCode())) {
			modifyClientInfoService = (IModifyClientInfoService) WebContextUtil
					.getBean("clientWorkInfoService");

		} else if (part_flg.equals(PartFlgEnum.INCOME.getCode())) {
			modifyClientInfoService = (IModifyClientInfoService) WebContextUtil
					.getBean("clientIncomeInfoService");

		} else if (part_flg.equals(PartFlgEnum.SOURCE.getCode())) {
			modifyClientInfoService = (IModifyClientInfoService) WebContextUtil
					.getBean("clientSourceInfoService");

		} else if (part_flg.equals(PartFlgEnum.XG.getCode())) {
			modifyClientInfoService = (IModifyClientInfoService) WebContextUtil
					.getBean("clientXgInfoService");

		} else if (part_flg.equals(PartFlgEnum.SERVICE.getCode())) {
			modifyClientInfoService = (IModifyClientInfoService) WebContextUtil
					.getBean("clientServiceInfoService");

		} else if (part_flg.equals(PartFlgEnum.OTHER.getCode())) {
			modifyClientInfoService = (IModifyClientInfoService) WebContextUtil
					.getBean("clientOtherInfoService");
		}

		return modifyClientInfoService;
	}
}
