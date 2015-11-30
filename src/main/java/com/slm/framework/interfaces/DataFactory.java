package com.slm.framework.interfaces;

import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.model.DataSplitController;

public interface DataFactory {

	public DataSet getTrainSet();

	public DataSet getValidSet();

	public void splitDataSet();

	public void splitDataSet(DataSplitController dsc);

	public DataSet getData(String sc) throws ParseErrorException;

}
