package bxw.modules.contract.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import bxw.common.util.RegexPatternUtil;
import bxw.modules.base.BaseController;
import bxw.modules.contract.model.Contract;
import bxw.modules.contract.service.IContractService;
import bxw.modules.global.model.Attachment;
import bxw.modules.global.service.IAttachmentService;
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

	@Resource(name = "attachmentService")
	private IAttachmentService attachmentService;

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
	public String list(Model model, HttpServletRequest request) {

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
		model.addAttribute("applicant_id",contract.getApplicant_id());

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
	public String chooseApplicant(HttpServletRequest request, Model model, String user_id, String user_name,
			String user_sex) {

		// 开启modelDriven
		return "front/contract/contract/choose_applicant";
	}

	/****
	 * 进入选择投保人页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/choose_assured", method = RequestMethod.GET)
	public String chooseAssured(HttpServletRequest request, Model model, String user_id, String user_name,
			String user_sex) {

		// 开启modelDriven
		return "front/contract/contract/choose_assured";
	}

	// ------------------------------------------------------------------------------------------
	// 上传附件

	/****
	 * 进入上传附件页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/to_upload_file", method = RequestMethod.GET)
	public String to_upload_file(Model model, String contract_id) {

		model.addAttribute("contract_id", contract_id);

		return "front/contract/contract/file_upload/up_file";
	}

	/****
	 * 上传用户附件,上传一个文件到mongo数据库。 如果是图片，只存储裁剪后的图片
	 * 
	 * @param _id
	 * @param request
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param w
	 * @param h
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value = "/{contract_id}/upload_file", method = RequestMethod.POST)
	@ResponseBody
	public Object uploadFile(@PathVariable String contract_id, HttpServletRequest request, String x1, String y1,
			String x2, String y2, String w, String h) throws UnsupportedEncodingException {

		if (StringUtil.isEmpty(contract_id)) {
			return this.handleValidateFalse("contract_id不能为空");
		}

		HttpServletRequestUtil.debugParams(request);

		Attachment attach = null;
		Map<String, Object> result = new HashMap<String, Object>();

		try {

			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

			// 上传文件
			for (Iterator it = multipartRequest.getFileNames(); it.hasNext();) {
				String key = (String) it.next();
				MultipartFile fileIn = multipartRequest.getFile(key);

				logger.debug("\nmultifile的key\n{}", key);

				attach = this.attachmentService.uploadOneAttachmentToMongo(fileIn, multipartRequest, false, null);
			}

			// 添加用户的文件信息
			String fileId = attach.get_id_m();
			DBObject updateResult = this.contractService.addFile(contract_id, fileId);

			result.put("success", "y");
			result.put("attach_id", fileId);

			logger.debug("上传文件完毕，上传结果\n{}", attach);
		} catch (Exception e) {
			return this.handleException(e);
		}

		return result;
	}

	/****
	 * 查询所有附件
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/get_files", method = RequestMethod.POST)
	@ResponseBody
	public Object get_files(Model model, HttpServletRequest request, String contract_id) {

		if (StringUtil.isEmpty(contract_id)) {
			return this.handleValidateFalse("contract_id不能为空");
		}

		HttpServletRequestUtil.debugParams(request);

		try {
			List<Map<String, String>> files = this.contractService.getFiles(contract_id);

			RequestResult rr = new RequestResult();
			rr.setSuccess(true);
			rr.setObject(files);
			return rr;
		} catch (Exception e) {
			return this.handleException(e);
		}
	}

	/****
	 * 删除一个附件
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete_file", method = RequestMethod.POST)
	@ResponseBody
	public Object delete_file(Model model, HttpServletRequest request, String contract_id, String file_id) {

		if (StringUtil.isEmpty(contract_id)) {
			return this.handleValidateFalse("contract_id不能为空");
		}
		if (StringUtil.isEmpty(file_id)) {
			return this.handleValidateFalse("file_id不能为空");
		}

		HttpServletRequestUtil.debugParams(request);

		try {
			this.contractService.deleteFile(contract_id, file_id);

			RequestResult rr = new RequestResult();
			rr.setSuccess(true);
			return rr;
		} catch (Exception e) {
			return this.handleException(e);
		}
	}
}
