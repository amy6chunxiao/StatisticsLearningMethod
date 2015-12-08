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

		// 找到信息增益最大的特征
		double maxInfoGain = 0;
		Map<String, Map<String, Integer>> maxMap = null;
		InfoGain infoGain = new InfoGain(examples);
		for (int i = 0; i < examples.getData().size(); i++) {
			Map<String, Map<String, Integer>> map = LabelMaps
					.sortByKthAttribute(examples, i);

			double infoGainNum = infoGain.countEntropy()
					- infoGain.countMutualInfo(map);
			if (infoGainNum > maxInfoGain) {
				maxInfoGain = infoGainNum;
				maxMap = map;
			}
		}
		
		
		DesignTreeNode node = new DesignTreeNode();
		node.setIndex(0);

	}
}
