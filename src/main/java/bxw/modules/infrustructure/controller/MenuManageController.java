package bxw.modules.infrustructure.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import bxw.common.util.MenuUtil;
import bxw.common.util.RequestUtil;
import bxw.common.util.ZTreeUtil;
import bxw.modules.base.BaseController;
import bxw.modules.infrustructure.model.SysMenu;
import bxw.modules.infrustructure.service.ISysMenuService;
import mou.web.webbase.domain.RequestResult;
import mou.web.webbase.handler.PageSearchResultHandler;

/****
 * 菜单管理
 * 
 * @author NBQ
 * @date 2012-4-19
 */
@Controller
@RequestMapping("/backend/menu")
@SuppressWarnings("rawtypes")
public class MenuManageController extends BaseController {

	@Autowired(required = true)
	@Qualifier("sysMenuService")
	private ISysMenuService sysMenuService;

	private static final Logger logger = LogManager
			.getLogger(MenuManageController.class);

	/****
	 * 菜单管理入口--进入菜单管理页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/toManage")
	public ModelAndView manage(HttpServletRequest request,
			HttpServletResponse response) {

		return new ModelAndView("admin/infrastructure/menu/menu_manage");
	}

	/****
	 * 编辑菜单入口--进入菜单编辑页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(String menu_code, HttpServletRequest request,
			HttpServletResponse response) {

		SysMenu menuInf = this.sysMenuService.findMenuInf(menu_code);

		logger.debug(JSON.serialize(menuInf));

		request.setAttribute("menu", menuInf);

		return new ModelAndView("admin/infrastructure/menu/menu_edit");
	}

	/****
	 * 添加菜单入口--进入菜单添加页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView toAdd(HttpServletRequest request,
			HttpServletResponse response) {

		logger.debug("-- into add page --");

		Map dataIn = RequestUtil.ToLowerMap(request);

		int lvl = Integer.parseInt(dataIn.get("supmnulvl").toString()) + 1;
		request.setAttribute("SUPMNUCOD", dataIn.get("sup_menu_code"));
		request.setAttribute("SUPMNUCODNAM", dataIn.get("sup_menu_name"));
		request.setAttribute("THISMNULVL", lvl);

		return new ModelAndView("admin/infrastructure/menu/menu_add");
	}

	/****
	 * 添加菜单
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(@Validated SysMenu sysmenu, BindingResult br,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {

		if (br.hasErrors()) {
			return this.handleValidateFalse(br);
		}

		logger.debug("sysmenu\n{}", sysmenu);

		try {
			RequestResult rr = new RequestResult();
			// 新增
			String _id = this.sysMenuService.insert(sysmenu);

			rr = new RequestResult();
			rr.setSuccess(true);
			rr.setMessage(_id);

			return rr;
		} catch (Exception e) {
			return this.handleException(e);
		}
	}

	/****
	 * 菜单详细信息入口--查询菜单信息，并进入菜单信息页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/toDetail")
	public ModelAndView toDetail(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		ModelAndView successM_V = new ModelAndView(
				"admin/infrastructure/menu/menu_detail");

		Map dataIn = RequestUtil.ToLowerMap(request);

		String menuCode = (String) dataIn.get("menu_code");
		if (request.getAttribute("menu_code") != null) {
			menuCode = (String) request.getAttribute("menu_code");
		}

		logger.debug(menuCode);

		model.addAttribute("menu_code", menuCode);

		SysMenu menuInf = null;
		SysMenu parentMenuInf = null;
		// 1. 查询该菜单信息及父菜单信息
		if (menuCode.equals("ROOT")) {
			menuInf = MenuUtil.createRootMenu();
		} else {
			menuInf = this.sysMenuService.findMenuInf(menuCode);
			if (menuInf.getSup_menu_code().equals("ROOT")) {
				parentMenuInf = MenuUtil.createRootMenu();
			} else {
				parentMenuInf = this.sysMenuService.findMenuInf(menuInf
						.getSup_menu_code());
			}

			request.setAttribute("parentMenu", parentMenuInf);
		}

		if (menuInf == null) {
			return successM_V;
		}
		
		model.addAttribute("_id", menuInf.get_id_m());
		// 2. 查询动作或子菜单
		if (!menuInf.isLeaf()) {
			// 有子菜单，查询下一级子菜单
			List<SysMenu> menuChildrens = this.sysMenuService
					.findChildren(menuCode);
			menuInf.setChild_menu_List(menuChildrens);

			if (menuChildrens != null && !menuChildrens.isEmpty()) {
				menuInf.setLeaf_flg(false);
			} else {
				menuInf.setLeaf_flg(true);
			}

			request.setAttribute("menuchildren", menuChildrens);
		}

		request.setAttribute("menu", menuInf);

		return successM_V;
	}

	/****
	 * 查询菜单的子菜单列表
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/sub_menus")
	@ResponseBody
	public Object findSubMnus(HttpServletRequest request,
			HttpServletResponse response, String menu_code) {

		List<SysMenu> children = this.sysMenuService.findChildren(menu_code);

		return PageSearchResultHandler.handleBaseModelListNoPage(children);
	}

	/****
	 * 更新系统常量 信息，返回json给客户端
	 * 
	 * @param _id
	 * @param sysconsttype
	 * @param br
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/{_id}/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@PathVariable String _id, @Validated SysMenu sysmenu,
			BindingResult br, HttpServletRequest request) {

		if (br.hasErrors()) {
			return this.handleValidateFalse(br);
		}

		sysmenu.set_id_m(_id);

		logger.debug("传入的对象\n{}", sysmenu);

		try {
			DBObject updateResult = this.sysMenuService.update(sysmenu);

			logger.debug("更新后的结果[{}]", updateResult);
			RequestResult rr = new RequestResult();
			rr = new RequestResult();
			rr.setSuccess(true);
			rr.setMessage(_id);
			return rr;
		} catch (Exception e) {
			return this.handleException(e);
		}
	}

	@RequestMapping("/upMenu")
	public ModelAndView upMenu(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		logger.debug("-- into create page --");
		Map dataIn = RequestUtil.ToLowerMap(request);

		this.sysMenuService.moveMenu(dataIn, true);

		// 进入父节点信息页面 ，同时刷新菜单
		request.setAttribute("menu_code", dataIn.get("supmnucod"));
		request.setAttribute("refreshTree", "true");

		return this.toDetail(request, response, model);
	}

	@RequestMapping("/downMenu")
	public ModelAndView downMenu(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		logger.debug("-- into create page --");
		Map dataIn = RequestUtil.ToLowerMap(request);

		this.sysMenuService.moveMenu(dataIn, false);

		// 进入父节点信息页面 ，同时刷新菜单
		request.setAttribute("menu_code", dataIn.get("supmnucod"));
		request.setAttribute("refreshTree", "true");

		return this.toDetail(request, response, model);
	}

	/****
	 * 删除菜单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{_id}/delete", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@PathVariable String _id, HttpServletRequest request) {

		try {

			this.sysMenuService.delMenu(_id);
			;

			RequestResult rr = new RequestResult();
			rr.setSuccess(true);
			rr.setMessage(_id);
			return rr;
		} catch (Exception e) {
			return this.handleException(e);
		}
	}

	/****
	 * 取所有菜单
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/loadallmenu")
	@ResponseBody
	public Object menu(HttpServletRequest request, HttpServletResponse response) {

		SysMenu sysmnu = sysMenuService.getRootMenuTree();

		return ZTreeUtil.transToZtreeMnuList(sysmnu);
	}

	/****
	 * <pre>
	 * <li><a> <i class="fa fa-home"></i> 
	 * 				Home 
	 * 			    <span class="fa fa-chevron-down"></span>
	 * 			</a>
	 * 			<ul class="nav child_menu" style="display: none">
	 * 				<li><a href="index.html">Dashboard</a></li>
	 * 				<li><a href="index2.html">Dashboard2</a></li>
	 * 				<li><a href="index3.html">Dashboard3</a></li>
	 * 			</ul>
	 * 		</li>
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/load_sys_menu_admin_home")
	@ResponseBody
	public Object sysAdminMenuHomePage(HttpServletRequest request,
			HttpServletResponse response) {

		RequestResult rr = new RequestResult();

		SysMenu root = MenuUtil.createRootMenu();

		try {
			List<SysMenu> sysmnus = sysMenuService.findMenuTreeBySupMnuCod(root
					.getMenu_code());

			String result = transToMenuStrAdminHome(sysmnus);
			rr.setSuccess(true);
			rr.setMessage(result);
		} catch (Exception e) {
			return this.handleException(e);
		}

		return rr;
	}

	/****
	 * <pre>
	 * <li>
	 *     <a> 
	 * 		  <i class="fa fa-home"></i> 
	 *  			  Home 
	 *  		      <span class="fa fa-chevron-down"></span>
	 *     	   </a>
	 * 		   <ul class="nav child_menu" style="display: none">
	 *  			  <li><a href="index.html">Dashboard</a></li>
	 *  			  <li><a href="index2.html">Dashboard2</a></li>
	 *  			  <li><a href="index3.html">Dashboard3</a></li>
	 *  		   </ul>
	 *    	   </li>
	 * </pre>
	 * 
	 * @param sysmnus
	 * @return
	 */
	private String transToMenuStrAdminHome(List<SysMenu> sysmnus) {

		if (sysmnus == null || sysmnus.isEmpty()) {
			return "";
		}

		StringBuffer sb = new StringBuffer();

		for (SysMenu sysmnu : sysmnus) {

			sb.append("<li><a> <i class=\"" + sysmnu.getIclass() + "\"></i>");
			sb.append(sysmnu.getMenu_name());
			if (!sysmnu.isLeaf()) {
				sb.append("<span class=\"fa fa-chevron-down\"></span>");
			}
			sb.append("</a>");

			if (!sysmnu.isLeaf()) {
				sb.append("<ul class=\"nav child_menu\" style=\"display: none\">");

				List<SysMenu> children_this = sysmnu.getChild_menu_List();

				for (SysMenu menu_tmp : children_this) {
					sb.append("<li><a data-link=\"" + menu_tmp.getPath()
							+ "\">" + menu_tmp.getMenu_name() + "</a></li>");

				}

				sb.append("</ul>");
			}

			sb.append("</li>");
		}

		return sb.toString();
	}
}
