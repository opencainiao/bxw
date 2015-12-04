package bxw.modules.contract.controller;

import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mou.common.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import bxw.common.util.RegexPatternUtil;
import bxw.modules.base.BaseController;
import bxw.modules.contract.model.Contract;
import bxw.modules.contract.service.IContractService;
import mou.web.webbase.domain.RequestResult;
import mou.web.webbase.util.HttpServletRequestUtil;

/****
 * 合同管理Controller
 * 
 * @author NBQ
 *
 */
@Controller
@RequestMapping("/front/contract")
public class ContractController extends BaseController {

	private static final Logger logger = LogManager.getLogger(ContractController.class);

	@Resource(name = "contractService")
	private IContractService contractService;

	/****
	 * 进入添加合同页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(@ModelAttribute("contract") Contract contract, HttpServletRequest request) {

		// 开启modelDriven
		return "front/contract/contract/add";
	}

	/****
	 * 添加
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(@Validated Contract contract, BindingResult br, HttpServletRequest request) {

		HttpServletRequestUtil.debugParams(request);

		logger.debug("传入的合同对象\n{}", contract);

		if (br.hasErrors()) {
			return this.handleValidateFalse(br);
		}
		try {

			String user_id = contract.getOwner_user_id();
			if (StringUtil.isEmpty(user_id)) {
				return this.handleValidateFalse("尚未登录系统，请登录!");
			}

			// 2.新增
			String _id = this.contractService.add(contract);

			RequestResult rr = new RequestResult();
			rr.setSuccess(true);
			rr.setMessage(_id);

			return rr;
		} catch (Exception e) {
			return this.handleException(e);
		}
	}

	/****
	 * 查看所有系统合同 信息
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model,HttpServletRequest request) {
		
		request.getSession().setAttribute("source", null);

		return "front/contract/contract/list";
	}

	/****
	 * 查询系统合同信息（条件查询，查询多笔，按照系统合同码或名称）
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(Model model, HttpServletRequest request, String username, String contract_stage,
			String contract_state) {

		HttpServletRequestUtil.debugParams(request);
		try {

			String search_condition = request.getParameter("search_condition");
			if (StringUtil.isNotEmpty(search_condition)) {
				search_condition = search_condition.trim();
			}

			DBObject query = new BasicDBObject();
			query.put("del_flg", "0");
			if (StringUtil.isNotEmpty(username)) {
				String name = username.trim();

				Pattern namePattern = RegexPatternUtil.getLikePattern(name);

				BasicDBList values = new BasicDBList();
				values.add(new BasicDBObject("username", namePattern));
				values.add(new BasicDBObject("pinyin_name", namePattern));
				values.add(new BasicDBObject("first_char_header", namePattern));
				values.add(new BasicDBObject("all_char_header", namePattern));
				query.put("$or", values);
			}

			if (StringUtil.isNotEmpty(contract_stage)) {

				if (!contract_stage.equals("-1")) {
					query.put("stage", contract_stage);
				}
			}

			if (StringUtil.isNotEmpty(contract_state)) {

				if (!contract_state.equals("-1")) {
					query.put("state", contract_state);
				}
			}

			DBObject sort = new BasicDBObject();
			sort.put("pinyin_name", 1);

			DBObject returnFields = null;

			return this.contractService.batchSearchPage(query, sort, returnFields);

		} catch (Exception e) {
			return this.handleException(e);
		}
	}

	/****
	 * 查看单个合同 信息
	 * 
	 * @param _id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{_id}", method = RequestMethod.GET)
	public String detail(@PathVariable String _id, Model model) {

		Contract contract = this.contractService.findContractInfById(_id);

		model.addAttribute("contract", contract);

		return "front/contract/contract/detail";
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

		Contract contract = this.contractService.findContractInfById(_id);

		model.addAttribute("contract", contract);

		model.addAttribute("_id", _id);

		return "front/contract/contract/update";
	}

	/****
	 * 更新系统合同 信息，返回json给客户端
	 * 
	 * @param _id
	 * @param contract
	 * @param br
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/{_id}/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@PathVariable String _id, @Validated Contract contract, BindingResult br,
			HttpServletRequest request) {

		if (br.hasErrors()) {
			return this.handleValidateFalse(br);
		}

		try {
			contract.set_id_m(_id);
			DBObject updateResult = this.contractService.updatePart(null, contract);

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
	 * 删除一条记录
	 * 
	 * @param zzdhid
	 * @return
	 */
	@RequestMapping(value = "/{_id}/delete", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@PathVariable String _id, HttpServletRequest request) {

		try {
			// 删除合同
			int removedCount = this.contractService.RemoveOneById(_id);
			logger.debug("deleted--[{}]", removedCount);

			RequestResult rr = new RequestResult();
			rr.setSuccess(true);
			rr.setMessage(_id);
			return rr;
		} catch (Exception e) {
			return this.handleException(e);
		}
	}
	
	/****
	 * 进入选择投保人页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/choose_applicant", method = RequestMethod.GET)
	public String chooseApplicant(HttpServletRequest request, Model model, String user_id,
			String user_name, String user_sex) {

		// 开启modelDriven
		return "front/contract/contract/choose_applicant";
	}
	
	/****
	 * 进入选择投保人页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/choose_assured", method = RequestMethod.GET)
	public String chooseAssured(HttpServletRequest request, Model model, String user_id,
			String user_name, String user_sex) {

		// 开启modelDriven
		return "front/contract/contract/choose_assured";
	}
}
