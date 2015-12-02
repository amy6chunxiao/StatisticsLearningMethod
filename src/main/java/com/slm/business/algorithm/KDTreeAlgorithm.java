package com.slm.business.algorithm;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.log4j.Logger;

import com.slm.business.model.KDTree;
import com.slm.business.service.KDTreeComparator;
import com.slm.framework.core.AbstractAlgorithm;
import com.slm.framework.interfaces.DataSet;
import com.slm.framework.model.BinaryTreeNode;
import com.slm.framework.model.RealDataSet;
import com.slm.framework.model.RealVector;

public class KDTreeAlgorithm extends AbstractAlgorithm {
	private final Logger log = Logger.getLogger(KDTreeAlgorithm.class);
	public KDTree tree;
	private int dimension;
	private BinaryTreeNode<RealVector> root;
	private ArrayList<KDTreeComparator> cp;

	public KDTreeAlgorithm(RealDataSet<RealVector> data) {
		dimension = data.getColNum();
		cp = new ArrayList<>();
		for (int i = 0; i < dimension; i++) {
			KDTreeComparator comparator = new KDTreeComparator(i);
			cp.add(comparator);
		}
		root = buildTree(data, 0);
		tree = new KDTree(root);
	}

	public BinaryTreeNode<RealVector> buildTree(DataSet<RealVector> data,
			int depth) {
		if (data.getRowNum() == 0)
			return null;
		if (data.getRowNum() == 1) {
			return new BinaryTreeNode<RealVector>(data.get(0));
		}

		// 按照KDTreeComparator的规则排序，cp第i个元素表示对realvector第i列元素比较的comparator
		Collections.sort(data.getData(), cp.get(depth));

		depth = depth++ % dimension;
		int index = data.getRowNum() / 2;
		DataSet<RealVector> leftData = data.subDataSet(0, index);
		DataSet<RealVector> rightData = data.subDataSet(index + 1,
				data.getRowNum());

		BinaryTreeNode<RealVector> root = new BinaryTreeNode<RealVector>(
				data.get(index));
		root.setLeftChild(buildTree(leftData, depth));
		root.setRightChild(buildTree(rightData, depth));
		return root;
	}

	public KDTree getTree() {
		return tree;
	}

	public void setTree(KDTree tree) {
		this.tree = tree;
	}

}
