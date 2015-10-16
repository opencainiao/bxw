package bxw.modules.client.model.propertyeidtor;

import java.beans.PropertyEditorSupport;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mou.common.JsonUtil;

import com.google.gson.reflect.TypeToken;

import bxw.modules.client.model.Address;

public class AddressListEditor extends PropertyEditorSupport {

	private static final Logger logger = LogManager.getLogger(AddressListEditor.class);

	public String getAsText() {
		return getValue().toString();
	}

	public void setAsText(String source) {

		List<Address> addresses = JsonUtil.getGson().fromJson(source, new TypeToken<List<Address>>() {
		}.getType());

		setValue(addresses);

		logger.debug("inject--address\n{}\n{}", source, addresses);
	}
}