package bxw.modules.exhibition.enums;

import org.mou.common.StringUtil;

public enum ExhibitionItemType {

	RECORD_PHONE("RECORD_PHONE", "（记录）电话约访"), //
	RECORD_MEET("RECORD_MEET", "（记录）客户拜访"), //
	PLAN_PHONE("PLAN_PHONE", "（计划）电话约访"), //
	PLAN_MEET("PLAN_MEET", "（计划）客户拜访"), //
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

	public static ExhibitionItemType getByCode(String code) {
		
		if (StringUtil.isEmpty(code)){
			return ExhibitionItemType.OTHER;
		}

		ExhibitionItemType[] exhibitionItemTypes = ExhibitionItemType.values();

		for (ExhibitionItemType exhibitionItemType : exhibitionItemTypes) {
			if (exhibitionItemType.getCode().equals(code)) {
				return exhibitionItemType;
			}
		}

		return ExhibitionItemType.OTHER;
	}

	public static void main(String[] args) {
		ExhibitionItemType aa = ExhibitionItemType.getByCode("PLAN_MEET");
		System.out.println(aa.getName());
	}
}
