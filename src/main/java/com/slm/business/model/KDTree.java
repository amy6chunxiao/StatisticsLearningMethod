package com.slm.business.model;

import com.slm.framework.model.BinaryTree;
import com.slm.framework.model.BinaryTreeNode;
import com.slm.framework.model.RealVector;

public class KDTree extends BinaryTree<RealVector> {

	
	public KDTree(BinaryTreeNode<RealVector> root) {
		super(root);
	}

	@Override
	public BinaryTreeNode<RealVector> find(RealVector k) {
		return null;
	}

}
