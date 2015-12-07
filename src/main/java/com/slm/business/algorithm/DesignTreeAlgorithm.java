package com.slm.business.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.slm.framework.common.LabelMaps;
import com.slm.framework.interfaces.DataSet;
import com.slm.framework.model.AttributeExample;
import com.slm.framework.model.DesignTreeNode;

public class DesignTreeAlgorithm {
	private DataSet<AttributeExample> data;

	public DesignTreeAlgorithm(DataSet<AttributeExample> data) {
		this.data = data;
	}

	public double countEntropy(DataSet<AttributeExample> examples) {

		Map<String, List<AttributeExample>> labelToAttribute = LabelMaps
				.sortByLabel(examples);
		double entropy = 0;
		for (String str : labelToAttribute.keySet()) {
			double probable = labelToAttribute.get(str).size()
					/ (double) data.getRowNum();
			entropy += -probable * Math.log(probable);
		}
		return entropy;
	}

	/**
	 * 
	 * @description 递归调用决策树
	 * @author liucx
	 * @created 2015年12月4日 下午3:05:52
	 * @param examples
	 */
	public void bulidDesignTree(DataSet<AttributeExample> examples,
			DesignTreeNode root) {

		List<Double> attributeInfoGain = new ArrayList<>();
		for (int i = 0; i < examples.getData().size(); i++) {
			attributeInfoGain.add(countKAttributeInfoGain(examples, i));
		}
		Collections.sort(attributeInfoGain);
		
	}

	public double countKAttributeInfoGain(DataSet<AttributeExample> examples,
			int k) {
		double entropy = countEntropy(examples);
		return entropy - countMutualInfo(classByKAttribute(examples, k));
	}

	/**
	 * 
	 * @description 计算集合map下某一特征A对map的信息增益
	 * @author liucx
	 * @created 2015年12月7日 上午11:41:00
	 * @param 训练数据集
	 *            ，按照第i个特征分类好
	 * @return 互信息
	 */
	public double countMutualInfo(Map<String, Map<String, Integer>> map) {
		double mutualInfo = 0;
		Set<String> attributes = map.keySet();
		for (String attribute : attributes) {
			int attributeNum = map.get(attribute).size();
			for (String label : map.get(attribute).keySet()) {
				int attrLabelNum = map.get(attribute).get(label);
				double prob = (double) attrLabelNum / attributeNum;
				mutualInfo += -prob * Math.log(prob);
			}
			mutualInfo *= (double) attributeNum / map.size();
		}
		return mutualInfo;
	}

	public Map<String, Map<String, Integer>> classByKAttribute(
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
