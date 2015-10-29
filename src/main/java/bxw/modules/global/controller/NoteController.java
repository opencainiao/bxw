package bxw.modules.global.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bxw.modules.base.BaseController;
import bxw.modules.global.model.Note;

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

	/****
	 * 进入添加Ueditor页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(@ModelAttribute("note") Note note, HttpServletRequest request) {

		this.debugParams(request);
		
		// 开启modelDriven
		return "global/note/add";
	}

}
