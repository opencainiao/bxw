package bxw.common.globalhandler;

import javax.servlet.http.HttpServletRequest;

import com.mou.mongodb.base.domain.PageVO;

/****
 * 对请求进行分页查询的参数提取
 * 
 * @author NBQ
 *
 */
public class PageSearchRequestUtil {

	private static final int PAGE_COUNT_ONEPAGE = Integer.MAX_VALUE;
	private static final int CUR_PAGENUM_ONEPAGE = 1;

	/****
	 * 提取请求中的分页参数
	 * 
	 * @param request
	 * @return
	 */
	public static PageVO getPageInfoFromRequest(HttpServletRequest request) {

		PageVO pageVO = new PageVO();

		int curPageNum = CUR_PAGENUM_ONEPAGE;
		int pageCount = PAGE_COUNT_ONEPAGE;

		if (request.getParameter("page") != null) {
			try {
				curPageNum = Integer.parseInt(request.getParameter("page"));
			} catch (Exception e) {
				curPageNum = CUR_PAGENUM_ONEPAGE;
			}
		}

		if (request.getParameter("rp") != null) {
			try {
				pageCount = Integer.parseInt(request.getParameter("rp"));
			} catch (Exception e) {
				pageCount = PAGE_COUNT_ONEPAGE;
			}
		}

		int total = 0;

		if (request.getParameter("total") != null) {

			try {
				total = Integer.parseInt(request.getParameter("total"));

				if (total == -1) {
					total = -1;
				}
			} catch (Exception e) {
			}
		}

		pageVO.setPage(curPageNum);
		pageVO.setPageCount(pageCount);
		pageVO.setTotal(total);

		return pageVO;
	}

}
