package com.slm.framework.common;

import java.util.List;
import com.slm.framework.exceptions.DataErrorFormatException;
import com.slm.framework.model.RealVector;

public class Distance {
	public static double EuclideanDistance(RealVector r1, RealVector r2)
			throws DataErrorFormatException {
		return LpDistance(r1, r2, 2);
	}

	public static double ManhattanDistance(RealVector r1, RealVector r2)
			throws DataErrorFormatException {
		if (r1.size() != r2.size())
			throw new DataErrorFormatException("two realvectors should be equal size!");
		double result = 0;
		List<Double> data1 = r1.getData();
		List<Double> data2 = r2.getData();
		for (int i = 0; i < r1.size(); i++) {
			result += Math.abs(data1.get(i) - data2.get(i));
		}
		return result;
	}

	public static double LpDistance(RealVector r1, RealVector r2, double p)
			throws DataErrorFormatException {
		if (r1.size() != r2.size())
			throw new DataErrorFormatException("two realvectors should be equal size!");
		double result = 0;
		List<Double> data1 = r1.getData();
		List<Double> data2 = r2.getData();
		for (int i = 0; i < r1.size(); i++) {
			result += Math.pow((data1.get(i) - data2.get(i)), p);
		}
		return Math.pow(result, 1 / p);
	}

}
