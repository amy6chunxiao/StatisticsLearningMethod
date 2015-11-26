package com.slm.framework.core;

import java.util.ArrayList;
import java.util.List;

import com.slm.framework.common.NumberFormatConverter;
import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.interfaces.DataParser;
import com.slm.framework.io.Data;
import com.slm.framework.model.DataSet;
import com.slm.framework.model.Example;
import com.slm.framework.model.LabeledDataSet;

public class LabeledDataParser implements DataParser {

	private DataSet dataSet;
	@Override
	public DataSet parse(String[] data) throws ParseErrorException {
		List<Example> examples = new ArrayList<>();
		for (String strData : data) {
			String[] datasAndLabel = strData.split(Data.labelSeparator);

			if (datasAndLabel == null || datasAndLabel.length != 2)
				throw new ParseErrorException();

			String[] datas = datasAndLabel[0].split(Data.dataSeparator);
			String label = datasAndLabel[1];
			double[] doubleD = NumberFormatConverter.StringArrayToDouble(datas);
			Example example = new Example(doubleD, label);
			examples.add(example);
		}
		dataSet = new LabeledDataSet(examples);
		return dataSet;
	}
}
