package bxw.modules.exhibition.enums;

import org.mou.common.StringUtil;

public enum AccomplishFlg {

	ACCOMPLISHED("01", "已完成"), //
	NOT_ACCOMPLISHED("02", "未完成"); //

	private String code;
	private String name;

	private AccomplishFlg(String code, String name) {
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

	public static AccomplishFlg getByCode(String code) {

		if (StringUtil.isEmpty(code)) {
			return null;
		}

		AccomplishFlg[] enums = AccomplishFlg.values();

		for (AccomplishFlg eNum : enums) {
			if (eNum.getCode().equals(code)) {
				return eNum;
			}
		}

		return null;
	}
}
