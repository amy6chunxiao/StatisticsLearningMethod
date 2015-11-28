package com.framework;

import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.factory.LabeledDataFactory;
import com.slm.framework.factory.UnLabeledDataFactory;

public class DataSetReadTest {
	public static void main(String[] args) {
		LabeledDataFactory factory1 = new LabeledDataFactory();
		try {
			factory1.getData("G:\\laboratory\\algorithm\\dataset\\centers.txt");
			factory1.getTrainSet();
			factory1.getValidSet();
		} catch (ParseErrorException e) {
			e.printStackTrace();
		}

		UnLabeledDataFactory factory2 = new UnLabeledDataFactory();
		try {
			factory2.getData("G:\\laboratory\\algorithm\\dataset\\wine.txt");
		} catch (ParseErrorException e) {
			e.printStackTrace();
		}
	}
}
