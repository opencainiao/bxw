package bxw.modules.exhibition.enums;

/****
 * 展业阶段
 * 
 * @author NBQ
 *
 */
public enum ExhibitionStage {

	CONTACT("01", "接触阶段"), //
	COMMUNICATION("02", "信息阶段"), //
	PRESENT("03", "呈现阶段"), //
	DECISION("04", "决定阶段"), //
	FINISHED("05", "结束"); //

	private String code;
	private String name;

	private ExhibitionStage(String code, String name) {
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
