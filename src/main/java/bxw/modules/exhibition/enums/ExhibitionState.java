package bxw.modules.exhibition.enums;

import org.mou.common.StringUtil;

public enum ExhibitionState {

	CONTACT("01", "沟通了解"), //
	HQXQ("02", "获取需求"), //
	GJFA("03", "构建方案"), //
	FAGT("04", "方案沟通"), //
	QD("05", "签单"), //
	HB("06", "核保"), //
	HBBTG("07", "核保不通过"), //
	JB("08", "拒保"), //
	YCB("09", "已承保"), //
	TB("10", "退保"), //
	TZ("11", "停滞"), //
	LS("12", "流失"); //

	private String code;
	private String name;

	private ExhibitionState(String code, String name) {
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
	

	public static ExhibitionState getByCode(String code) {

		if (StringUtil.isEmpty(code)) {
			return null;
		}

		ExhibitionState[] enums = ExhibitionState.values();

		for (ExhibitionState eNum : enums) {
			if (eNum.getCode().equals(code)) {
				return eNum;
			}
		}

		return null;
	}
}
