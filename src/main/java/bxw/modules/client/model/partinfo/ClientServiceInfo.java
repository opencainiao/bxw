package bxw.modules.client.model.partinfo;

import java.util.ArrayList;
import java.util.List;

import com.mou.mongodb.base.domain.BaseModel;

public class ClientServiceInfo extends BaseModel {

	public static List<String> getTitles() {
		List<String> titles = new ArrayList<String>();

		titles.add("interesting_service_name");

		return titles;
	}

	public static List<String> getTitleNames() {
		List<String> titleNames = new ArrayList<String>();
		titleNames.add("关注的服务");
		return titleNames;
	}
}
