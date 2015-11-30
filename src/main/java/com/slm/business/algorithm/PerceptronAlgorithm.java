package com.slm.business.algorithm;

import org.apache.log4j.Logger;

import com.slm.framework.core.AbstractAlgorithm;
import com.slm.framework.exceptions.DataErrorFormatException;
import com.slm.framework.interfaces.DataSet;
import com.slm.framework.model.Example;
import com.slm.framework.model.RealVector;

public class PerceptronAlgorithm extends AbstractAlgorithm {

	private final Logger log = Logger.getLogger(PerceptronAlgorithm.class);

	public void run(DataSet<Example> data, double... args)
			throws DataErrorFormatException {
		if (args.length != 1)
			throw new DataErrorFormatException("please input three parameters");

		double b = 0;
		double η = args[0];
		RealVector w = new RealVector(data.getColNum());
		int count = 0;
		while (true) {
			for (Example tmpX : data.getData()) {
				String tmpLabel = null;
				tmpLabel = tmpX.getLabel();

				double yi = mapYiToNum(tmpLabel);
				if (yi * (w.product(tmpX) + b) <= 0) {
					double ηyi = η * yi;
					w = w.addByElements(tmpX.productByElements(ηyi));
					b += ηyi;
					count = 0;
					break;
				} else
					count++;
			}
			if (count >= data.getColNum())
				break;
			// break;
			// return runnableModel = new PerceptronModel(w, b);
		}
	}

	private double mapYiToNum(String label) {
		return Double.parseDouble(label);
	}

}