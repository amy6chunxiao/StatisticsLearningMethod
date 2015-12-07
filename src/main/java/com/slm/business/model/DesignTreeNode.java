package com.slm.business.model;

import java.util.Map;

public class DesignTreeNode {
	// 子节点列表，结构是<特征类别，子节点>
	private Map<String, DesignTreeNode> children;
	// 当前选取的特征是第几维数据
	private int index;
	// 当前节点的特征
	private String attribute;
	private String label;

	public Map<String, DesignTreeNode> getChildren() {
		return children;
	}

	public void setChildren(Map<String, DesignTreeNode> children) {
		this.children = children;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
