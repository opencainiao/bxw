package bxw.modules.exhibition.enums;

import org.mou.common.StringUtil;

public enum PlanState {

	NOT_COMPLISHED("01", "未完成"), //
	COMPLISHED("02", "已完成"), //
	FAILED("03", "失败"); //

	private String code;
	private String name;

	private PlanState(String code, String name) {
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

	public static PlanState getByCode(String code) {

		if (StringUtil.isEmpty(code)) {
			return null;
		}

		PlanState[] enums = PlanState.values();

		for (PlanState eNum : enums) {
			if (eNum.getCode().equals(code)) {
				return eNum;
			}
		}

		return null;
	}
}
