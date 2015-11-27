package com.slm.framework.interfaces;

import com.slm.framework.exceptions.ParseErrorException;
import com.slm.framework.model.DataSet;
import com.slm.framework.model.DataSplitController;

public interface DataFactory {

	public DataSet getData(String sc) throws ParseErrorException;

	public DataSet[] getTrainSetAndValidSet();

	public DataSet[] getTrainSetAndValidSet(DataSplitController dsc);

}
