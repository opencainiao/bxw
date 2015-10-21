package bxw.modules.exhibition.enums;

public enum ExhibitionItemType {

	RECORD_PHONE("RECORD_PHONE", "电话约访记录"), //
	RECORD_MEET("RECORD_MEET", "客户拜访记录"), //
	PLAN_PHONE("PLAN_PHONE", "电话约访计划"), //
	PLAN_MEET("PLAN_MEET", "客户拜访计划"), //
	ACTION("ACTION", "活动"), //
	OTHER("OTHER", "其他"); //
	// HBBTG("07", "核保不通过"), //
	// JB("08", "拒保"), //
	// YCB("09", "已承保"), //
	// TB("10", "退保"), //
	// TZ("11", "停滞"), //
	// LS("12", "流失"); //

	private String code;
	private String name;

	private ExhibitionItemType(String code, String name) {
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
}
