package com.slm.business.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.slm.framework.interfaces.DataSet;
import com.slm.framework.model.AttributeExample;
import com.slm.framework.model.AttributeVector;
import com.slm.framework.model.DesignTreeNode;

public class DesignTreeAlgorithm {
	private DataSet<AttributeExample> data;
	private Map<String, List<AttributeVector>> labelToVector;
	private double entropy;

	public DesignTreeAlgorithm(DataSet<AttributeExample> data) {
		this.data = data;
		labelToVector = new HashMap<>();
		for (AttributeExample example : data.getData()) {
			String label = example.getLabel();
			List<AttributeVector> list = labelToVector.get(label);
			if (list == null)
				list = new ArrayList<>();
			list.add(example);
			labelToVector.put(example.getLabel(), list);
		}
		countEntropy();
	}

	public void countEntropy() {
		for (String str : labelToVector.keySet()) {
			double probable = labelToVector.get(str).size()
					/ (double) data.getRowNum();
			entropy += -probable * Math.log(probable);
		}
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
