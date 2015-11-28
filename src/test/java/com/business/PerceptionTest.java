package com.business;

import com.slm.business.algorithm.PerceptronAlgorithm;
import com.slm.framework.exceptions.ParseErrorException;

public class PerceptionTest {
	public static void main(String[] args) {
		PerceptronAlgorithm pa=new PerceptronAlgorithm();
		try {
			pa.getData("G:\\laboratory\\algorithm\\dataset\\centers.txt");
		} catch (ParseErrorException e) {
			e.printStackTrace();
		}
	}
}
