package com.slm.framework.factory;

import org.apache.log4j.Logger;

import com.slm.framework.core.DataSpliterImpl;
import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.interfaces.DataFactory;
import com.slm.framework.interfaces.DataParser;
import com.slm.framework.interfaces.DataSpliter;
import com.slm.framework.io.FileReader;
import com.slm.framework.model.DataSet;
import com.slm.framework.model.DataSplitController;

public abstract class AbstractDataFactory implements DataFactory {

	private final Logger log = Logger.getLogger(AbstractDataFactory.class);
	protected DataSet trainSet;
	protected DataSet validSet;
	protected DataSet data;

	private DataParser dataParser;
	private DataSpliter dataSpliter;
	private FileReader fileReader = new FileReader();

	public AbstractDataFactory() {
	}

	public DataSet getData(String src) throws ParseErrorException {
		return data = dataParser.parse(fileReader.readFile(src));
	}

	public void splitDataSet(DataSplitController dsc) {
		if (data == null)
			log.error("data not found");
		dataSpliter = new DataSpliterImpl(data);
		dataSpliter.split(dsc);
		trainSet = dataSpliter.getTrainSet();
		validSet = dataSpliter.getValidSet();
	}

	public void splitDataSet() {
		if (data == null)
			log.error("data not found");
		dataSpliter = new DataSpliterImpl(data);
		dataSpliter.split();
		trainSet = dataSpliter.getTrainSet();
		validSet = dataSpliter.getValidSet();
	}

	public DataSpliter getDataSpliter() {
		return dataSpliter;
	}

	public void setDataSpliter(DataSpliter dataSpliter) {
		this.dataSpliter = dataSpliter;
	}

	public void setDataParser(DataParser dataParser) {
		this.dataParser = dataParser;
	}

	public abstract DataSet getTrainSet();

	public abstract DataSet getValidSet();

	public abstract DataSet getData();

}
