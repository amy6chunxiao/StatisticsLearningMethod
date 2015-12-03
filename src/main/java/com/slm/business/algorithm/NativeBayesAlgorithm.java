package com.slm.business.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.slm.framework.core.AbstractAlgorithm;
import com.slm.framework.interfaces.DataSet;
import com.slm.framework.model.AttributeExample;
import com.slm.framework.model.AttributeVector;

public class NativeBayesAlgorithm extends AbstractAlgorithm {
	private DataSet<AttributeExample> data;

	// 类别的边缘概率
	private Map<String, Double> marginPro;
	// 条件概率，即P(X(j)=x(j)|Y=ck)
	private Map<String, List<Double>> conditionPro;
	// 后验概率
	private Map<String, Double> posteriorPro;
	private Map<String, List<AttributeExample>> labelOfExample;

	public NativeBayesAlgorithm(DataSet<AttributeExample> data) {
		this.data = data;
		labelOfExample = new HashMap<>();
		marginPro = new HashMap<>();
		posteriorPro = new TreeMap<>();
		init(data);
		countPrioProb();
	}

	/**
	 * 
	 * @description 将输入数据按照类别整理好
	 * @author liucx
	 * @created 2015年12月3日 上午11:33:28
	 * @param data
	 */
	private void init(DataSet<AttributeExample> data) {
		for (AttributeExample example : data.getData()) {
			String label = example.getLabel();
			List<AttributeExample> list = labelOfExample.get(label);
			if (list == null)
				list = new ArrayList<>();
			list.add(example);
			labelOfExample.put(example.getLabel(), list);
		}
	}

	private void countPrioProb() {
		Set<String> labels = labelOfExample.keySet();
		for (String str : labels) {
			int num = labelOfExample.get(str).size();
			marginPro.put(str, num / (double) data.getRowNum());
		}
	}

	public String predict(AttributeVector predictData) {
		// 计算条件概率
		// 计算条件概率与边缘概率乘积
		conditionPro = new HashMap<>();
		countConditionPro(predictData);
		countPosteriorPro();
		Set<String> labelSets = posteriorPro.keySet();
		return labelSets.iterator().next();
	}

	private void countConditionPro(AttributeVector predictData) {
		for (String str : labelOfExample.keySet()) {
			int attrPositiveCount = 0;
			List<Double> conditionProNum = new ArrayList<>(data.getColNum());
			List<AttributeExample> examplesOfLabel = labelOfExample.get(str);

			for (int i = 0; i < predictData.size(); i++) {
				for (AttributeVector vector : examplesOfLabel) {
					if (predictData.get(i).equals(vector.get(i)))
						attrPositiveCount++;
				}
				conditionProNum.add((double) attrPositiveCount
						/ examplesOfLabel.size());
			}
			conditionPro.put(str, conditionProNum);
		}
	}

	/**
	 * 
	 * @description 计算所有类别后验概率
	 * @author liucx
	 * @created 2015年12月3日 上午11:32:47
	 */
	private void countPosteriorPro() {
		for (String str : labelOfExample.keySet()) {
			double pro = countPosteriorPro(str);
			posteriorPro.put(str, pro);
		}
	}

	/**
	 * 
	 * @description 计算单个类别后验概率
	 * @author liucx
	 * @created 2015年12月3日 上午11:33:00
	 * @param label
	 * @return
	 */
	private double countPosteriorPro(String label) {
		double result = 1;
		for (double d : conditionPro.get(label)) {
			result *= d;
		}
		result *= marginPro.get(label);
		return result;
	}
}
