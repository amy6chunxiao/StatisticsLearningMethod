package com.slm.framework.model;

import java.util.ArrayList;
import java.util.List;

import com.slm.framework.interfaces.Vector;

public class AttributeVector implements Vector<String> {
	private List<String> attributes;
	private int size;

	public AttributeVector(List<String> data) {
		this.attributes = data;
		this.size = data.size();
	}

	public AttributeVector(String[] data) {
		attributes = new ArrayList<>();
		for (String str : data) {
			attributes.add(str);
		}
		this.size = attributes.size();
	}

	public List<String> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
	}

	@Override
	public List<String> getData() {
		return attributes;
	}

	@Override
	public void setData(List<String> data) {
		attributes = data;
	}

	@Override
	public int size() {
		return size;
	}

}
