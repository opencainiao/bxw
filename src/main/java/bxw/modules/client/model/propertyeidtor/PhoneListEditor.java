package bxw.modules.client.model.propertyeidtor;

import java.beans.PropertyEditorSupport;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mou.common.JsonUtil;

import com.google.gson.reflect.TypeToken;

import bxw.modules.client.model.Phone;

public class PhoneListEditor extends PropertyEditorSupport {

	private static final Logger logger = LogManager.getLogger(PhoneListEditor.class);

	public String getAsText() {
		return getValue().toString();
	}

	public void setAsText(String source) {
		List<Phone> phones = JsonUtil.getGson().fromJson(source, new TypeToken<List<Phone>>() {
		}.getType());
		setValue(phones);
		
		logger.debug("inject--phones\n{}\n{}", source, phones);

	}
}