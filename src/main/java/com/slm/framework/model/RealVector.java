package com.slm.framework.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.slm.framework.exceptions.DataErrorFormatException;
import com.slm.framework.interfaces.Vector;

/**
 * 
 * Title: RealVector.java
 * 
 * @description:纯数字的一行数据
 * @author liucx
 * @created 2015年12月1日 下午3:28:09
 */
public class RealVector implements Vector<Double> {
	private final Logger log = Logger.getLogger(RealVector.class);
	private List<Double> data;
	private int size;

	public RealVector(int size) {
		this.size = size;
		toAllZero();
	}

	public RealVector(List<Double> data) {
		this.data = data;
	}

	public RealVector(double[] data) {
		this.data = new ArrayList<>();
		for (double d : data) {
			this.data.add(d);
		}
		this.size = this.data.size();
	}

	public int size() {
		return size;
	}

	public List<Double> getData() {
		return data;
	}

	public void setData(List<Double> data) {
		this.data = data;
	}

	public void toAllZero() {
		if (data == null) {
			data = new ArrayList<>(size);
			for (int i = 0; i < size; i++) {
				data.add(0.0);
			}
		} else
			for (int i = 0; i < size; i++) {
				data.set(i, 0.0);
			}
	}

	public void toAllOnes() {
		if (data == null)
			data = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			data.set(i, 1.0);
		}
	}

	public RealVector productByElements(RealVector realVector)
			throws DataErrorFormatException {
		if (realVector.size() != size) {
			throw new DataErrorFormatException(
					"two realvectors size are not equal");
		}

		List<Double> data2 = realVector.getData();
		List<Double> resultData = new ArrayList<>();
		RealVector result = new RealVector(resultData);
		for (int i = 0; i < size; i++) {
			resultData.add(data.get(i) * data2.get(i));
		}
		return result;
	}

	public RealVector productByElements(double num) {

		List<Double> resultData = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			resultData.add(num * data.get(i));
		}
		return new RealVector(resultData);
	}

	public double product(RealVector realVector)
			throws DataErrorFormatException {
		if (realVector.size() != size) {
			throw new DataErrorFormatException(
					"two realvectors size are not equal");
		}
		double result = 0;
		List<Double> data2 = realVector.getData();
		for (int i = 0; i < size; i++) {
			result += data.get(i) * data2.get(i);
		}
		return result;
	}

	public RealVector addByElements(RealVector realVector)
			throws DataErrorFormatException {
		if (realVector.size() != size) {
			throw new DataErrorFormatException(
					"two realvectors size are not equal");
		}
		List<Double> data2 = realVector.getData();
		List<Double> resultData = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			resultData.add(data.get(i) + data2.get(i));
		}
		return new RealVector(resultData);
	}

	@Override
	public String toString() {
		return "RealVector [data=" + data + "]";
	}

}
