package com.slm.framework.interfaces;

import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.model.DataSplitController;

public interface DataFactory<T> {

	public DataSet<T> getTrainSet();

	public DataSet<T> getValidSet();

	public void splitDataSet();

	public void splitDataSet(DataSplitController dsc);

	public DataSet<T> getData(String sc) throws ParseErrorException;

}
