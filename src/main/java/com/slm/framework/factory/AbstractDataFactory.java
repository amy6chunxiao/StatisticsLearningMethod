package com.slm.framework.factory;

import org.apache.log4j.Logger;

import com.slm.framework.core.DataSpliterImpl;
import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.interfaces.DataFactory;
import com.slm.framework.interfaces.DataParser;
import com.slm.framework.interfaces.DataSet;
import com.slm.framework.interfaces.DataSpliter;
import com.slm.framework.io.FileReader;
import com.slm.framework.model.DataSplitController;
import com.slm.framework.model.RealVector;

public abstract class AbstractDataFactory<T extends RealVector> implements
		DataFactory<T> {

	private final Logger log = Logger.getLogger(AbstractDataFactory.class);
	protected DataSet<T> trainSet;
	protected DataSet<T> validSet;
	protected DataSet<T> data;

	private DataParser<T> dataParser;
	private DataSpliter<T> dataSpliter;
	private FileReader fileReader = new FileReader();

	public AbstractDataFactory() {
	}

	public DataSet<T> getData(String src) throws ParseErrorException {
		return data = dataParser.parse(fileReader.readFile(src));
	}

	public void splitDataSet(DataSplitController dsc) {
		if (data == null)
			log.error("data not found");
		dataSpliter = new DataSpliterImpl<T>(data);
		dataSpliter.split(dsc);
		trainSet = dataSpliter.getTrainSet();
		validSet = dataSpliter.getValidSet();
	}

	public void splitDataSet() {
		if (data == null)
			log.error("data not found");
		dataSpliter = new DataSpliterImpl<T>(data);
		dataSpliter.split();
		trainSet = dataSpliter.getTrainSet();
		validSet = dataSpliter.getValidSet();
	}

	public DataSpliter<T> getDataSpliter() {
		return dataSpliter;
	}

	public void setDataSpliter(DataSpliter<T> dataSpliter) {
		this.dataSpliter = dataSpliter;
	}

	public void setDataParser(DataParser<T> dataParser) {
		this.dataParser = dataParser;
	}

	@Override
	public DataSet<T> getTrainSet() {
		return trainSet;
	}

	@Override
	public DataSet<T> getValidSet() {
		return validSet;
	}
}
