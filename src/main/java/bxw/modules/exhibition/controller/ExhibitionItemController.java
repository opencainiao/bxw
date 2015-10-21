package bxw.modules.exhibition.controller;

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
import bxw.modules.exhibition.enums.ExhibitionItemType;
import bxw.modules.exhibition.model.Exhibition;
import bxw.modules.exhibition.model.ExhibitionItem;
import bxw.modules.exhibition.service.IExhibitionService;
import mou.web.webbase.domain.RequestResult;
import mou.web.webbase.util.HttpServletRequestUtil;

/****
 * 展业项管理Controller
 * 
 * @author NBQ
 *
 */
@Controller
@RequestMapping("/front/exhibition_item")
public class ExhibitionItemController extends BaseController {

	private static final Logger logger = LogManager.getLogger(ExhibitionItemController.class);

	@Resource(name = "exhibitionService")
	private IExhibitionService exhibitionService;

	/****
	 * 进入添加展业项页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(@ModelAttribute("exhibitionitem") ExhibitionItem exhibitionitem, HttpServletRequest request,
			String user_id, String type) {

		String path = "";
		if (StringUtil.isNotEmpty(type)) {

			if (type.equals(ExhibitionItemType.PLAN_PHONE.getCode())) {
				path = "plan_phone";
			} else if (type.equals(ExhibitionItemType.PLAN_MEET.getCode())) {
				path = "plan_meet";
			} else if (type.equals(ExhibitionItemType.RECORD_PHONE.getCode())) {
				path = "record_phone";
			} else if (type.equals(ExhibitionItemType.RECORD_MEET.getCode())) {
				path = "record_meet";
			} else if (type.equals(ExhibitionItemType.ACTION.getCode())) {
				path = "action";
			} else if (type.equals(ExhibitionItemType.OTHER.getCode())) {
				path = "other";
			}
		}

		// 开启modelDriven
		return "front/exhibition/item/" + path + "/add";
	}

	/****
	 * 查看所有系统展业项 信息
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {

		return "front/exhibition/item/list";
	}

	/****
	 * 查询系统展业项信息（条件查询，查询多笔，按照系统展业项码或名称）
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(Model model, HttpServletRequest request, String username, String exhibition_stage,
			String exhibition_state) {

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

			if (StringUtil.isNotEmpty(exhibition_stage)) {

				if (!exhibition_stage.equals("-1")) {
					query.put("stage", exhibition_stage);
				}
			}

			if (StringUtil.isNotEmpty(exhibition_state)) {

				if (!exhibition_state.equals("-1")) {
					query.put("state", exhibition_state);
				}
			}

			DBObject sort = new BasicDBObject();
			sort.put("pinyin_name", 1);

			DBObject returnFields = null;

			return this.exhibitionService.batchSearchPage(query, sort, returnFields);

		} catch (Exception e) {
			return this.handleException(e);
		}
	}

	/****
	 * 查看单个展业项 信息
	 * 
	 * @param _id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{_id}", method = RequestMethod.GET)
	public String detail(@PathVariable String _id, Model model) {

		Exhibition exhibition = this.exhibitionService.findExhibitionInfById(_id);

		model.addAttribute("exhibition", exhibition);

		return "front/exhibition/item/detail";
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

		Exhibition exhibition = this.exhibitionService.findExhibitionInfById(_id);

		model.addAttribute("exhibition", exhibition);

		model.addAttribute("_id", _id);

		return "front/exhibition/item/update";
	}

	/****
	 * 更新系统展业项 信息，返回json给客户端
	 * 
	 * @param _id
	 * @param exhibition
	 * @param br
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/{_id}/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@PathVariable String _id, @Validated Exhibition exhibition, BindingResult br,
			HttpServletRequest request) {

		if (br.hasErrors()) {
			return this.handleValidateFalse(br);
		}

		try {
			exhibition.set_id_m(_id);
			DBObject updateResult = this.exhibitionService.updatePart(null, exhibition);

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
			// 删除展业项
			int removedCount = this.exhibitionService.RemoveOneById(_id);
			logger.debug("deleted--[{}]", removedCount);

			RequestResult rr = new RequestResult();
			rr.setSuccess(true);
			rr.setMessage(_id);
			return rr;
		} catch (Exception e) {
			return this.handleException(e);
		}
	}
}
