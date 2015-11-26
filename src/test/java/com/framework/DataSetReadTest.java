package com.framework;

import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.factory.LabeledDataFactory;

public class DataSetReadTest {
	public static void main(String[] args) {
		LabeledDataFactory factory=new LabeledDataFactory();
		try {
			factory.getData("G:\\laboratory\\algorithm\\dataset\\centers.txt");
		} catch (ParseErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
