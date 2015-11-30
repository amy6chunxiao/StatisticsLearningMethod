package com.slm.framework.interfaces;

import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.model.DataSplitController;
import com.slm.framework.model.RealVector;

public interface DataFactory<T extends RealVector> {

	public DataSet<T> getTrainSet();

	public DataSet<T> getValidSet();

	public void splitDataSet();

	public void splitDataSet(DataSplitController dsc);

	public DataSet<T> getData(String sc) throws ParseErrorException;

}
