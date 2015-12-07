package com.slm.framework.model;

import java.util.List;

public class DesignTreeNode {
	private List<DesignTreeNode> children;
	private int index;
	private String attribute;

	public List<DesignTreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<DesignTreeNode> children) {
		this.children = children;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
