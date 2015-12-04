package com.slm.framework.model;

import java.util.List;

public class DesignTreeNode {
	private List<DesignTreeNode> children;
	private String name;
	private String attribute;

	
	public List<DesignTreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<DesignTreeNode> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

}
