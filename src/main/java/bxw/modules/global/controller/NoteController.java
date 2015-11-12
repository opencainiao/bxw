package bxw.modules.global.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mou.common.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import bxw.modules.base.BaseController;
import bxw.modules.client.model.propertyeidtor.AddressListEditor;
import bxw.modules.client.model.propertyeidtor.PhoneListEditor;
import bxw.modules.client.model.propertyeidtor.StringListEditor;
import bxw.modules.exhibition.enums.ExhibitionCharacter;
import bxw.modules.exhibition.model.ExhibitionItem;
import bxw.modules.global.model.Note;
import bxw.modules.global.service.INoteService;
import mou.web.webbase.domain.RequestResult;
import mou.web.webbase.util.HttpServletRequestUtil;

/****
 * 记录（评论）管理Controller
 * 
 * @author NBQ
 *
 */
@Controller
@RequestMapping("/note")
public class NoteController extends BaseController {

	private static final Logger logger = LogManager.getLogger(NoteController.class);

	@Resource(name = "noteService")
	private INoteService noteService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(List.class, "attaches", new StringListEditor());
	}
	/****
	 * 进入添加页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(@ModelAttribute("note") Note note, HttpServletRequest request) {

		this.debugParams(request);

		// 开启modelDriven
		return "global/note/add";
	}

	/****
	 * 添加
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(@Validated Note note, BindingResult br, HttpServletRequest request) {

		HttpServletRequestUtil.debugParams(request);

		logger.debug("传入的note对象\n{}", note);

		if (br.hasErrors()) {
			return this.handleValidateFalse(br);
		}

		try {
			// 新增
			String _id = this.noteService.add(note);

			RequestResult rr = new RequestResult();
			rr.setSuccess(true);
			rr.setMessage(_id);

			return rr;
		} catch (Exception e) {
			return this.handleException(e);
		}
	}

	/****
	 * 查询系统展业项信息（条件查询，查询多笔，按照系统展业项码或名称）
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/notes_of_target", method = RequestMethod.POST)
	@ResponseBody
	public Object notes_of_target(Model model, HttpServletRequest request, String target_id) {

		HttpServletRequestUtil.debugParams(request);
		try {

			String search_condition = request.getParameter("search_condition");
			if (StringUtil.isNotEmpty(search_condition)) {
				search_condition = search_condition.trim();
			}

			DBObject query = new BasicDBObject();
			query.put("del_flg", "0");

			if (!this.isValidObjId(target_id)) {
				this.handleValidateFalse("查询记录的归属id不合法");
			}
			query.put("target_id", target_id);

			DBObject sort = new BasicDBObject();
			sort.put("c_time", 1);

			DBObject returnFields = null;

			List<Note> notes = this.noteService.batchSearch(query, sort, returnFields);

			return this.handleBaseModelListOnePage(notes);
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
			int removedCount = this.noteService.RemoveOneById(_id);
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
	 * 进入更新页面
	 * 
	 * @param zzdhid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{_id}/update", method = RequestMethod.GET)
	public String update(@PathVariable String _id, Model model) {

		Note note = this.noteService.findOneByIdObject(_id);

		model.addAttribute("note", note);

		model.addAttribute("_id", _id);

		return "global/note/update";
	}
	
	/****
	 * 更新系统展业项 信息，返回json给客户端
	 * 
	 * @param _id
	 * @param exhibitionitem
	 * @param br
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/{_id}/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@PathVariable String _id, @Validated Note note , BindingResult br,
			HttpServletRequest request) {

		if (br.hasErrors()) {
			return this.handleValidateFalse(br);
		}

		try {
			note.set_id_m(_id);
			DBObject updateResult = this.noteService.updatePart(null, note);
			
			RequestResult rr = new RequestResult();
			rr.setSuccess(true);
			rr.setObject(updateResult);
			return rr;
		} catch (Exception e) {
			return this.handleException(e);
		}
	}
}
