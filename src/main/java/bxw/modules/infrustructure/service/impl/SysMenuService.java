package bxw.modules.infrustructure.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mou.mongodb.base.domain.PageVO;
import com.mou.mongodb.base.springdb.dao.IBaseDaoMongo;

import bxw.common.util.MenuUtil;
import bxw.common.util.RegexPatternUtil;
import bxw.modules.base.BaseService;
import bxw.modules.infrustructure.enums.AutoIncreaseKeyEnum;
import bxw.modules.infrustructure.model.SysMenu;
import bxw.modules.infrustructure.service.IAutoIncreaserService;
import bxw.modules.infrustructure.service.ISysMenuService;
import mou.web.webbase.domain.ValidResult;
import mou.web.webbase.domain.exception.ValidateException;

@Service("sysMenuService")
@Transactional
@SuppressWarnings({ "rawtypes" })
public class SysMenuService extends BaseService implements ISysMenuService {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	@Autowired(required = true)
	@Qualifier("autoIncreaserService")
	private IAutoIncreaserService autoIncreaserService;

	private static final Logger logger = LogManager.getLogger(SysMenuService.class);

	/****
	 * 根据菜单码，读取菜单信息(不包含该菜单的子菜单)
	 * 
	 * @param menuId
	 * @return
	 */
	public SysMenu findMenuInf(String menu_cod) {

		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("menu_code", menu_cod);

		return this.commonDaoMongo.findOnePart(SysMenu.class, queryCondition, null);
	}

	/****
	 * 根据菜单码，读取该菜单的子菜单
	 * 
	 * @param menuId
	 * @return
	 */
	public List<SysMenu> findChildren(String menu_cod) {

		DBObject queryCondition = new BasicDBObject();
		queryCondition.put("sup_menu_code", menu_cod);

		DBObject order = new BasicDBObject();
		order.put("menu_level", 1);
		order.put("menu_sno", 1);

		return this.commonDaoMongo.findBatch(SysMenu.class, queryCondition, order);
	}

	/****
	 * 添加一个菜单
	 * 
	 * @param map
	 * @throws Exception
	 */
	public String insert(SysMenu sysMenu) throws Exception {

		ValidResult validResult = this.validate(sysMenu);
		if (validResult.hasErrors()) {
			throw new ValidateException(validResult);
		}

		// 校验
		String menuName = sysMenu.getMenu_name().trim();

		DBObject queryName = new BasicDBObject();
		queryName.put("menu_name", menuName);
		boolean isExistSameName = this.commonDaoMongo.isExist(queryName, SysMenu.class);
		if (isExistSameName) {
			throw new ValidateException("菜单【" + menuName + "】已经存在！");
		}

		// 更新父节点
		DBObject query = new BasicDBObject();
		query.put("menu_code", sysMenu.getSup_menu_code());

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();
		updateSet.put("leaf_flg", "0");
		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);
		update.put("$inc", new BasicDBObject("child_num", 1));

		DBObject updateResult = this.commonDaoMongo.updateOneByCondition(query, null, update, true, SysMenu.class);

		int sno = (Integer) updateResult.get("child_num");

		// 新增子节点
		String mnucod = this.autoIncreaserService.getAutoIncreaseString(AutoIncreaseKeyEnum.MENU_CODE.getCode());
		sysMenu.setMenu_code(mnucod);
		sysMenu.setMenu_name(menuName);
		this.setCreateInfo(sysMenu);
		sysMenu.setUse_flg(true);
		sysMenu.setLeaf_flg(true);
		sysMenu.setMenu_sno(sno);

		String _id = this.commonDaoMongo.insertOne(sysMenu);

		return _id;
	}

	/****
	 * 修改菜单
	 */
	public DBObject update(SysMenu sysmenu) {

		String _id = sysmenu.get_id_m();
		if (!this.isValidObjId(_id)) {
			throw new IllegalArgumentException("菜单的_id不合法！");
		}

		DBObject toUpdate = makeUpdate(sysmenu);

		return this.commonDaoMongo.updateOneById(_id, null, toUpdate, SysMenu.class);
	}

	/****
	 * 转化对象为要更新的部分字段
	 * 
	 * @param update
	 * @return
	 */
	private DBObject makeUpdate(SysMenu sysMenu) {

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("menu_name", sysMenu.getMenu_name());
		updateSet.put("path", sysMenu.getPath());
		updateSet.put("remark", sysMenu.getRemark());
		updateSet.put("module_code", sysMenu.getModule_code());

		this.setModifyInfo(updateSet);
		update.put("$set", updateSet);

		logger.debug("更新的对象信息\n{}", update);
		return update;
	}

	public void moveMenu(Map dataIn, boolean isMoveUp) {

		SysMenu thisMenu = this.findMenuInf((String) dataIn.get("mnucod"));

		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("sup_menu_code", thisMenu.getSup_menu_code());
		paraMap.put("menu_sno", thisMenu.getMenu_sno());

		// SysMenu neibMenu = null;
		// if (isMoveUp) {
		// // 找到相邻的上一个菜单
		// paraMap.put("fun", "max");
		// paraMap.put("symbol", "<");
		// } else {
		// // 找到相邻的下一个菜单
		// paraMap.put("fun", "min");
		// paraMap.put("symbol", ">");
		// }
		//
		// SysMenuMapper mapper =
		// this.sqlSession.getMapper(SysMenuMapper.class);
		// neibMenu = mapper.getNeibMenu(paraMap);
		//
		// if (neibMenu != null) { // 有相邻菜单交换order
		//
		// int thisLvlNum = thisMenu.getSamlvlmnusno();
		// int neibLvlNum = neibMenu.getSamlvlmnusno();
		//
		// thisMenu.setSamlvlmnusno(neibLvlNum);
		// neibMenu.setSamlvlmnusno(thisLvlNum);
		//
		// // 更新序号
		// mapper.updateByPK(thisMenu);
		// mapper.updateByPK(neibMenu);
		// }
	}

	/****
	 * 删除菜单
	 * 
	 * @param menuId
	 * @param type
	 * @throws SQLException
	 */
	public void delMenu(String _id) {

		SysMenu thisMenu = this.commonDaoMongo.findOneById(_id, SysMenu.class);

		// 删除子菜单
		if (!thisMenu.isLeaf()) {
			// 获得子菜单列表, 递归删除
			List<SysMenu> menuList = findChildren(thisMenu.getMenu_code());
			Map<String, String> paramMap = new HashMap<String, String>();
			for (SysMenu menu : menuList) {
				paramMap.put("menu_code", menu.getMenu_code());
				delMenu(menu.get_id_m());
			}
		}

		// 1.从菜单表中删除 本菜单
		this.commonDaoMongo.removeById(_id, SysMenu.class);
	}

	@Override
	public PageVO findBatch(Map map) {

		// 1.设置查询条件
		DBObject queryCondition = new BasicDBObject();
		// OR查询(名称、全拼或是首字母包含term的)
		queryCondition = new BasicDBObject();
		BasicDBList values = new BasicDBList();
		Pattern valuePattern = RegexPatternUtil.getLikePattern((String) map.get("search_condition"));
		values.add(new BasicDBObject("menu_name", valuePattern));
		values.add(new BasicDBObject("menu_code", valuePattern));
		queryCondition.put("$or", values);

		DBObject sort = new BasicDBObject();
		sort.put("menu_level", 1);
		sort.put("menu_sno", 1);

		PageVO pageVO = this.getParamPageVO();

		List<DBObject> menus = this.commonDaoMongo.findBatchPagePartDBObject(SysMenu.class, queryCondition, sort, null,
				pageVO);

		return this.handleDBObjList(commonDaoMongo, SysMenu.class, queryCondition, menus, pageVO);
	}

	@Override
	public SysMenu getRootMenuTree() {

		SysMenu root = MenuUtil.createRootMenu();

		List<SysMenu> childs = findMenuTreeBySupMnuCod(root.getMenu_code());

		root.setChild_menu_List(childs);

		return root;
	}

	public void setMenuTreeBySupMnuCod(SysMenu sysMenu) {

		String supMnuCod = sysMenu.getMenu_code();
		List<SysMenu> menuList = this.findChildren(supMnuCod);
		sysMenu.setChild_menu_List(menuList);
		
		if (menuList != null && !menuList.isEmpty()) {

			for (SysMenu sysMenuTemp : menuList) {

				if (!sysMenuTemp.isLeaf()) {
					// 不是叶子节点，则递归查询
					setMenuTreeBySupMnuCod(sysMenuTemp);
				}
			}
		}
	}

	/****
	 * 根据上级菜单码和角色列表，读取该菜单的菜单树
	 * 
	 * 改成最多5层查找
	 * 
	 * @param supMnuCod
	 * @return
	 */
	public List<SysMenu> findMenuTreeBySupMnuCod(String supMnuCod) {

		List<SysMenu> menuList = this.findChildren(supMnuCod);

		if (menuList == null || menuList.isEmpty()) {
			return null;
		}

		for (SysMenu sysMenu : menuList) {

			if (!sysMenu.isLeaf()) {
				// 不是叶子节点，则递归查询
				setMenuTreeBySupMnuCod(sysMenu);
			}
		}

		return menuList;
	}

	private List<SysMenu> testMenuTree() {

		List<SysMenu> menus = new ArrayList<SysMenu>();

		SysMenu m1 = new SysMenu();
		m1.setMenu_name("Home");
		m1.setIclass("fa fa-home");
		List<SysMenu> menu1s = new ArrayList<SysMenu>();

		for (int i = 0; i < 3; ++i) {
			SysMenu mt = new SysMenu();
			mt.setMenu_name("1_" + i);
			mt.setPath("index_" + i + ".html");
			mt.setLeaf_flg(true);

			menu1s.add(mt);
		}
		m1.setChild_menu_List(menu1s);

		SysMenu m2 = new SysMenu();
		m2.setMenu_name("Forms");
		m2.setIclass("fa fa-edit");
		List<SysMenu> menu2s = new ArrayList<SysMenu>();

		for (int i = 0; i < 3; ++i) {
			SysMenu mt = new SysMenu();
			mt.setMenu_name("2_" + i);
			mt.setPath("index_" + i + ".html");
			mt.setLeaf_flg(true);

			menu2s.add(mt);
		}
		m2.setChild_menu_List(menu2s);

		menus.add(m1);
		menus.add(m2);

		return menus;
	}
}
