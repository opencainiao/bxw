package bxw.modules.client.model.propertyeidtor;

import java.beans.PropertyEditorSupport;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mou.common.JsonUtil;

import com.google.gson.reflect.TypeToken;

public class StringListEditor extends PropertyEditorSupport {

	private static final Logger logger = LogManager.getLogger(StringListEditor.class);

	public String getAsText() {
		return getValue().toString();
	}

	public void setAsText(String source) {

		List<String> list = JsonUtil.getGson().fromJson(source, new TypeToken<List<String>>() {
		}.getType());
		
		setValue(list);

		logger.debug("inject--string\n{}\n{}", source, list);
	}
}