package bxw.modules.infrustructure.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mou.mongodb.base.domain.BaseModelWithUseFlg;

/****
 * 系统的常量类型
 * 
 * @author NBQ
 *
 */
@Document(collection="sys_const_type")
public class SysConstType extends BaseModelWithUseFlg {

	private String typecode; // 常量类型码
	private String typename; // 常量类型名

	@NotEmpty(message = "常量类型不能为空")
	public String getTypecode() {
		return typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	@NotEmpty(message = "常量类型名称不能为空")
	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

}
