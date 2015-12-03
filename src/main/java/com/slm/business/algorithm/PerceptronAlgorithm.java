package com.slm.business.algorithm;

import org.apache.log4j.Logger;

import com.slm.framework.core.AbstractAlgorithm;
import com.slm.framework.exceptions.DataErrorFormatException;
import com.slm.framework.interfaces.DataSet;
import com.slm.framework.model.Example;
import com.slm.framework.model.RealVector;

public class PerceptronAlgorithm extends AbstractAlgorithm {

	private final Logger log = Logger.getLogger(PerceptronAlgorithm.class);
	private RealVector w;
	private double b;
	private DataSet<Example> data;

	public PerceptronAlgorithm(DataSet<Example> data) {
		this(data, 1);
	}

	public PerceptronAlgorithm(DataSet<Example> data, double η) {
		this.data = data;
		w = new RealVector(data.getColNum());
		b = 0;
		try {
			train(η);
		} catch (DataErrorFormatException e) {
			log.error("俩向量长度不一样啊啊啊");
			e.printStackTrace();
		}
	}

	private void train(double η) throws DataErrorFormatException {

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
		}
	}

	private double mapYiToNum(String label) {
		return Double.parseDouble(label);
	}

	public String predict(RealVector realVector)
			throws DataErrorFormatException {
		double result = realVector.product(w) + b;
		return result >= 0 ? "1" : "-1";
	}
}