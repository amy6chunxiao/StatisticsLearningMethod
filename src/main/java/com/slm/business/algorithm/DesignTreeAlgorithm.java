package com.slm.business.algorithm;

import java.util.List;
import java.util.Map;

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
		
	}

	public double countInfoGain(int dimension) {
		return 0;
	}
}
