package com.slm.framework.factory;

import com.slm.framework.core.UnLabeledDataParser;
import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.interfaces.DataFactory;
import com.slm.framework.interfaces.DataParser;
import com.slm.framework.io.FileReader;
import com.slm.framework.model.DataSet;
import com.slm.framework.model.LabeledDataSet;
import com.slm.framework.model.UnLabeledDataSet;

public class UnLabeledDataFactory implements DataFactory {

	private FileReader fileReader;
	private DataParser dataParser;

	public UnLabeledDataFactory() {
		fileReader = new FileReader();
		dataParser = new UnLabeledDataParser();
	}

	@Override
	public UnLabeledDataSet getData(String src) throws ParseErrorException {
		String[] strData = fileReader.readFile(src);
		DataSet dataset = dataParser.parse(strData);
		if(dataset instanceof LabeledDataSet){
			return (UnLabeledDataSet)dataset;
		}else{
			throw new ParseErrorException();
		}
	}
}
