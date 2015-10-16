package bxw.modules.client.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mou.common.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.DBObject;

import bxw.modules.base.BaseController;
import bxw.modules.client.model.Client;
import bxw.modules.client.service.IClientService;
import bxw.modules.client.service.modifyclientinfo.IModifyClientInfoService;
import mou.web.webbase.domain.RequestResult;
import mou.web.webbase.handler.ErrorHandler;

/****
 * 客户基本信息管理Controller
 * 
 * @author NBQ
 *
 */
@Controller
@RequestMapping("/clientbaseinfo")
public class ClientBaseInfoController extends BaseController {

	private static final Logger logger = LogManager
			.getLogger(ClientBaseInfoController.class);

	@Resource(name = "clientBaseInfoService")
	private IModifyClientInfoService clientBaseInfoService;

	@Resource(name = "clientService")
	private IClientService clientService;

	/****
	 * 查看单个客户基本信息 信息
	 * 
	 * @param _id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{_id}", method = RequestMethod.GET)
	public String detail(@PathVariable String _id, Model model) {

		Client client = this.clientService.findOneByIdObject(_id, true);

		model.addAttribute("clientbaseinfo", client);
		model.addAttribute("interesting_service",
				JsonUtil.toJsonStr(client.getInteresting_service()));

		return "front/client/client_info/base/detail";
	}

	/****
	 * 查看单个客户基本信息 信息
	 * 
	 * @param _id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{_id}", method = RequestMethod.POST)
	@ResponseBody
	public Object detail(@PathVariable String _id) {

		Client client = this.clientService.findOneByIdObject(_id, true);
		
		return client;
	}

	/****
	 * 进入更新页面
	 * 
	 * @param zzdhid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{_id}/update", method = RequestMethod.GET)
	public String update(@PathVariable String _id, Model model) {

		Client client = this.clientService.findOneByIdObject(_id, true);

		model.addAttribute("clientbaseinfo", client);

		model.addAttribute("_id", _id);

		model.addAttribute("owner_user_id", client.getOwner_user_id());
		model.addAttribute("interesting_service",
				JsonUtil.toJsonStr(client.getInteresting_service()));

		return "front/client/client_info/base/update";
	}

	/****
	 * 更新系统客户基本信息 信息，返回json给客户端
	 * 
	 * @param _id
	 * @param clientbaseinfo
	 * @param br
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/{_id}/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@PathVariable String _id, @Validated Client client,
			BindingResult br, HttpServletRequest request) {

		if (br.hasErrors()) {
			return ErrorHandler.getRequestResultFromBindingResult(br);
		}

		try {
			client.set_id_m(_id);
			DBObject updateResult = this.clientBaseInfoService.updatePart(null,
					client);

			logger.debug("更新后的结果[{}]", updateResult);

			RequestResult rr = new RequestResult();
			rr.setSuccess(true);
			rr.setMessage(_id);
			return rr;
		} catch (Exception e) {
			return this.handleException(e);
		}
	}
}
