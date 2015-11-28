package com.slm.business.algorithm;

import org.apache.log4j.Logger;

import com.slm.framework.exceptions.DataErrorFormatException;
import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.factory.LabeledDataFactory;
import com.slm.framework.interfaces.Algorithm;
import com.slm.framework.interfaces.DataFactory;
import com.slm.framework.model.DataSet;
import com.slm.framework.model.DataSplitController;
import com.slm.framework.model.Example;
import com.slm.framework.model.RealVector;

public class PerceptronAlgorithm implements Algorithm {

	private final Logger log = Logger.getLogger(PerceptronAlgorithm.class);
	private DataFactory factory = new LabeledDataFactory();

	@Override
	public DataSet getData(String sc) throws ParseErrorException {
		return factory.getData(sc);
	}

	@Override
	public DataSet[] getTrainSetAndValidSet() {
		return factory.getTrainSetAndValidSet();
	}

	@Override
	public DataSet[] getTrainSetAndValidSet(DataSplitController dsc) {
		return factory.getTrainSetAndValidSet(dsc);
	}

	public void run(DataSet data, double... args)
			throws DataErrorFormatException {
		if (args.length != 1)
			throw new DataErrorFormatException("please input three parameters");

		double b = 0;
		double η = args[0];
		RealVector w = new RealVector(data.getColNum());
		int count = 0;
		while (true) {
			for (RealVector tmpX : data.getData()) {
				String tmpLabel = null;
				if (tmpX instanceof Example) {
					tmpLabel = ((Example) tmpX).getLabel();
				} else
					log.error("the format of data is wrong");

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