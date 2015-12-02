package com.business;

import com.slm.business.algorithm.PerceptronAlgorithm;
import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.model.Example;
import com.slm.framework.model.RealDataSet;

public class PerceptionTest {
	public static void main(String[] args) {
		PerceptronAlgorithm pa = new PerceptronAlgorithm();
		try {
			RealDataSet<Example> data = (RealDataSet<Example>) pa
					.getData("G:\\laboratory\\algorithm\\dataset\\centers.txt");
			System.out.println(data);
		} catch (ParseErrorException e) {
			e.printStackTrace();
		}
	}
}
