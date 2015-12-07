package com.slm.business.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.slm.framework.common.LabelMaps;
import com.slm.framework.interfaces.DataSet;
import com.slm.framework.model.AttributeExample;

/**
 * 
 * Title: InfoGain.java
 * 
 * @description:计算信息增益的类
 * @author liucx
 * @created 2015年12月7日 下午7:21:22
 */
public class InfoGain {
	private Map<String, List<AttributeExample>> label2Example;

	public InfoGain(DataSet<AttributeExample> examples) {
		this.label2Example = LabelMaps.sortByLabel(examples);
	}

	public double countEntropy() {
		double entropy = 0;
		for (String str : label2Example.keySet()) {
			double probable = (double) label2Example.get(str).size()
					/ label2Example.size();
			entropy += -probable * Math.log(probable);
		}
		return entropy;
	}

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

	public Map<String, List<AttributeExample>> getLabel2Example() {
		return label2Example;
	}

	public void setLabel2Example(
			Map<String, List<AttributeExample>> label2Example) {
		this.label2Example = label2Example;
	}

}
