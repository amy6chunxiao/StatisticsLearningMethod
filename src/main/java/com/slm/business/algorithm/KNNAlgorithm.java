package com.slm.business.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.business.model.KNNNode;
import com.slm.framework.common.Distance;
import com.slm.framework.core.AbstractAlgorithm;
import com.slm.framework.exceptions.DataErrorFormatException;
import com.slm.framework.interfaces.DataSet;
import com.slm.framework.model.Example;
import com.slm.framework.model.RealVector;

public class KNNAlgorithm extends AbstractAlgorithm {
	private double k;
	private List<KNNNode> points;
	private Map<String, List<KNNNode>> nearstPoints;

	public void init(double k) {
		this.k = k;
		nearstPoints = new HashMap<>();
	}

	public void run(RealVector realVector, double... args)
			throws DataErrorFormatException {
		init(args[0]);
		for (KNNNode knnNode : points) {
			double distance = Distance.EuclideanDistance(knnNode, realVector);
			knnNode.setDistance(distance);
		}
		getKNearestNode();
	}

	public void getKNearestNode() {
		Collections.sort(points);
	}

	public String run(DataSet<Example> trainSet, DataSet<Example> validSet,
			double... args) {
		for (int i = 0; i < k; i++) {
			KNNNode tmp = points.get(i);
			List<KNNNode> mapList;
			if (!nearstPoints.containsKey(tmp.getLabel()))
				mapList = new ArrayList<>();
			mapList = nearstPoints.get(tmp.getLabel());
			mapList.add(tmp);
			nearstPoints.put(tmp.getLabel(), mapList);
		}

		Set<String> keys = nearstPoints.keySet();
		int maxNum = 0;
		String maxNumKey = null;
		for (String key : keys) {
			if (nearstPoints.get(key).size() > maxNum) {
				maxNumKey = key;
				maxNum = nearstPoints.get(key).size();
			}
		}
		return maxNumKey;
	}
}
