package com.slm.framework.factory;

import com.slm.framework.core.LabeledDataParser;
import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.interfaces.DataFactory;
import com.slm.framework.interfaces.DataParser;
import com.slm.framework.io.FileReader;
import com.slm.framework.model.DataSet;
import com.slm.framework.model.LabeledDataSet;

public class LabeledDataFactory implements DataFactory{
	
	private FileReader fileReader;
	private DataParser dataParser;
	
	public LabeledDataFactory() {
		fileReader=new FileReader();
		dataParser=new LabeledDataParser();
	}
	public LabeledDataSet getData(String src) throws ParseErrorException{
		String[] strData = fileReader.readFile(src);
		DataSet dataset = dataParser.parse(strData);
		if(dataset instanceof LabeledDataSet){
			return (LabeledDataSet)dataset;
		}else{
			throw new ParseErrorException();
		}
		
	}
}
