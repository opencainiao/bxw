package bxw.modules.exhibition.enums;

import org.mou.common.StringUtil;

/****
 * 展业阶段
 * 
 * @author NBQ
 *
 */
public enum ExhibitionGlobalState {
	
	STARTED("01", "展业中"), //
	FINISHED("02", "结束"); //

	private String code;
	private String name;

	private ExhibitionGlobalState(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static ExhibitionGlobalState getByCode(String code) {

		if (StringUtil.isEmpty(code)) {
			return null;
		}

		ExhibitionGlobalState[] enums = ExhibitionGlobalState.values();

		for (ExhibitionGlobalState exhibitionstage : enums) {
			if (exhibitionstage.getCode().equals(code)) {
				return exhibitionstage;
			}
		}

		return null;
	}

}
