package bxw.modules.global.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bxw.modules.base.BaseController;

/****
 * 全局参照控制器Controller
 * 
 * @author NBQ
 *
 */
@Controller
@RequestMapping("/reference")
public class ReferenceController extends BaseController {

	private static final Logger logger = LogManager.getLogger(ReferenceController.class);

	/****
	 * 进入选择客户页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/choose_client", method = RequestMethod.GET)
	public String chooseClient(HttpServletRequest request, Model model, String user_id, String user_name,
			String user_sex, String single_flg) {
		model.addAttribute("f_id", user_id);
		model.addAttribute("f_name", user_name);
		model.addAttribute("f_sex", user_sex);
		model.addAttribute("single_flg", single_flg);

		logger.debug("single_flg\n{}",single_flg);
		// 开启modelDriven
		return "reference/choose_client";
	}
}
