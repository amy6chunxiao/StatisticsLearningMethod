package com.slm.framework.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.slm.framework.interfaces.DataSet;
import com.slm.framework.model.AttributeExample;

public class LabelMaps {
	public static Map<String, List<AttributeExample>> sortByLabel(
			DataSet<AttributeExample> data) {

		Map<String, List<AttributeExample>> map = new HashMap<>();
		for (AttributeExample example : data.getData()) {
			String label = example.getLabel();
			List<AttributeExample> attributes;
			if (map.containsKey(label))
				attributes = new ArrayList<>();
			else
				attributes = map.get(label);
			attributes.add(example);
			map.put(label, attributes);
		}
		return map;
	}
}