package bxw.common.util;

import bxw.common.Constant;
import bxw.modules.infrustructure.model.SysMenu;

public class MenuUtil {

	public static SysMenu createRootMenu() {
		
		SysMenu rootMnu = new SysMenu();
		rootMnu.setMenu_name(Constant.SYSNAM);
		rootMnu.setMenu_code("ROOT");
		rootMnu.setMenu_level(0);
		rootMnu.setUse_flg(true);
		rootMnu.setLeaf_flg(false);

		return rootMnu;
	}
}
