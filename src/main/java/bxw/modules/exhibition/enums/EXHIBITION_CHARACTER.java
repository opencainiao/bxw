package bxw.modules.exhibition.enums;

/****
 * 展业性质
 * 
 * @author NBQ
 *
 */
public enum EXHIBITION_CHARACTER {

	INITIAL_CONTACT("01", "初步接触"), //
	CONTACT("02", "沟通了解"), //
	HQXQ("03", "获取需求"), //
	GJFA("04", "构建方案"), //
	FAGT("05", "方案沟通"), //
	QD("06", "签单"), //
	HB("07", "核保"), //
	OTHER("08", "其他"); //

	private String code;
	private String name;

	private EXHIBITION_CHARACTER(String code, String name) {
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
