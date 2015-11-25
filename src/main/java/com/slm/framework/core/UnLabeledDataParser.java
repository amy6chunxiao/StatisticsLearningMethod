package com.slm.framework.core;

import java.util.ArrayList;
import java.util.List;

import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.interfaces.DataParser;
import com.slm.framework.io.Data;
import com.slm.framework.model.RealVector;
import com.slm.framework.model.UnLabeledDataSet;
import com.slm.framework.util.NumberFormatConverter;

public class UnLabeledDataParser implements DataParser {

	@Override
	public UnLabeledDataSet parse(String[] data) throws ParseErrorException {
		List<RealVector> realVectors = new ArrayList<>();
		for (String strData : data) {
			String[] datas = strData.split(Data.dataSeparator);

			if (datas == null)
				throw new ParseErrorException();

			double[] doubleD = NumberFormatConverter.StringArrayToDouble(datas);
			RealVector realVector = new RealVector(doubleD);
			realVectors.add(realVector);
		}
		UnLabeledDataSet lds = new UnLabeledDataSet(realVectors);
		return lds;
	}

}
