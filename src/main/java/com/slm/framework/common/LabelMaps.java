package com.slm.framework.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.slm.framework.interfaces.DataSet;
import com.slm.framework.model.AttributeExample;

public class LabelMaps {

	/**
	 * 
	 * @description 将数据集按照类别整理
	 * @author liucx
	 * @created 2015年12月7日 下午7:12:37
	 * @param data
	 * @return
	 */
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

	/**
	 * 
	 * @description 根据特征划分数据集，再按照类别统计记录数
	 * @author liucx
	 * @created 2015年12月7日 下午7:31:26
	 * @param examples
	 * @param dimension
	 *            第k个特征
	 * @return
	 */
	public static Map<String, Map<String, Integer>> sortByKthAttribute(
			DataSet<AttributeExample> examples, int dimension) {
		// Map<特征，<类别，一条记录>>
		Map<String, Map<String, Integer>> attribute2label = new HashMap<>();
		for (AttributeExample example : examples.getData()) {
			String label = example.getLabel();
			Map<String, Integer> map;
			if (attribute2label.containsKey(label)) {
				map = attribute2label.get(label);
				int recordNum = map.get(label);
				map.put(label, ++recordNum);
			} else {
				map = new HashMap<>();
				map.put(label, 1);
			}
			attribute2label.put(example.getData().get(dimension), map);
		}
		return attribute2label;
	}
}