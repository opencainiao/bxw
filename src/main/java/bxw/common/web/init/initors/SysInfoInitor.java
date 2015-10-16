package bxw.common.web.init.initors;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import bxw.common.web.init.Initializable;
import bxw.common.web.interceptors.PriviInteceptor;

/****
 * 初始化系统环境变量数据（如：系统名称、全局上下文路径）
 * 
 * @author NBQ
 *
 */
@Component("sysInfoInitor")
public class SysInfoInitor implements Initializable {

	/****
	 * 初始化系统内存数据，避免硬编码
	 */
	public void init(ServletContext servletContext) {

		// 系统名称
		String sysnam = servletContext.getInitParameter("sysnam");
		servletContext.setAttribute("sysnam", sysnam);

		// 全局上下文路径
		servletContext.setAttribute("ctx", servletContext.getContextPath());

		// DBManager.initDB("bxb");

		PriviInteceptor.setNeedLoginFlag(false);
		// MongoClientManager.init("182.92.114.61", "bxb");
	}
}
