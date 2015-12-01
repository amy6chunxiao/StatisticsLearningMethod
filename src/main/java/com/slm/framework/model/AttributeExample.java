package com.slm.framework.model;

import java.util.List;

public class AttributeExample extends AttributeVector {

	private String label;

	public AttributeExample(List<String> data) {
		super(data);
	}

	public AttributeExample(List<String> data, String label) {
		super(data);
		setLabel(label);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
