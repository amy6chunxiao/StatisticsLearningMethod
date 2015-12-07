package com.slm.business.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.slm.business.service.InfoGain;
import com.slm.framework.common.LabelMaps;
import com.slm.framework.interfaces.DataSet;
import com.slm.framework.model.AttributeExample;
import com.slm.framework.model.DesignTreeNode;

public class DesignTreeAlgorithm {
	private DataSet<AttributeExample> data;

	public DesignTreeAlgorithm(DataSet<AttributeExample> data) {
		this.data = data;
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
		InfoGain infoGain = new InfoGain(examples);
		for (int i = 0; i < examples.getData().size(); i++) {
			Map<String, Map<String, Integer>> map = LabelMaps
					.sortByKthAttribute(examples, i);

			double entropy = infoGain.countEntropy();
			double mutualInfo = infoGain.countMutualInfo(map);
			attributeInfoGain.add(entropy - mutualInfo);
		}

		double maxNum = 0;
		for (Double d : attributeInfoGain) {
			if (d > maxNum)
				maxNum = d;
		}
	}

}
