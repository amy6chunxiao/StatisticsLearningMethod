package com.slm.framework.common;

public class NumberFormatConverter {
	public static double[] StringArrayToDouble(String[] strs) {
		double[] result = new double[strs.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = Double.parseDouble(strs[i]);
		}
		return result;
	}
}
