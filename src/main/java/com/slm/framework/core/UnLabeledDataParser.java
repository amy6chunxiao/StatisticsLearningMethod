package com.slm.framework.core;

import java.util.ArrayList;
import java.util.List;

import com.slm.framework.common.NumberFormatConverter;
import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.interfaces.DataParser;
import com.slm.framework.interfaces.DataSet;
import com.slm.framework.io.Data;
import com.slm.framework.model.RealDataSet;
import com.slm.framework.model.RealVector;

public class UnLabeledDataParser implements DataParser<RealVector> {

	private DataSet<RealVector> dataSet;

	@Override
	public DataSet<RealVector> parse(String[] data) throws ParseErrorException {
		List<RealVector> realVectors = new ArrayList<>();
		for (String strData : data) {
			String[] datas = strData.split(Data.dataSeparator);

			if (datas == null)
				throw new ParseErrorException();

			double[] doubleD = NumberFormatConverter.StringArrayToDouble(datas);
			RealVector realVector = new RealVector(doubleD);
			realVectors.add(realVector);
		}
		dataSet = new RealDataSet<RealVector>(realVectors);
		return dataSet;
	}

}
