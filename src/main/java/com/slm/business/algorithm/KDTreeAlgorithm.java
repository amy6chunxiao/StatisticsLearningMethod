package com.slm.business.algorithm;

import java.util.ArrayList;
import java.util.Collections;

import com.slm.business.model.BinaryTreeNode;
import com.slm.business.model.KDTree;
import com.slm.business.service.KDTreeComparator;
import com.slm.framework.interfaces.DataSet;
import com.slm.framework.model.RealDataSet;
import com.slm.framework.model.RealVector;

public class KDTreeAlgorithm {
	private RealDataSet<RealVector> data;
	private KDTree tree;
	private BinaryTreeNode<RealVector> root;
	// 数据集特征数
	private int dimension;
	private ArrayList<KDTreeComparator> cp;

	public KDTreeAlgorithm(RealDataSet<RealVector> data) {
		this.data = data;
		dimension = data.getColNum();
		cp = new ArrayList<>();
		for (int i = 0; i < dimension; i++) {
			KDTreeComparator comparator = new KDTreeComparator(i);
			cp.add(comparator);
		}
		buildTree(root, data, 0);
		tree = new KDTree(root);
	}

	public void buildTree(BinaryTreeNode<RealVector> root,
			DataSet<RealVector> data, int depth) {
		if (data.getRowNum() == 0)
			return;
		if (data.getRowNum() == 1) {
			root = new BinaryTreeNode<RealVector>(data.get(0));
			return;
		}

		// 按照KDTreeComparator的规则排序，cp第i个元素表示对realvector第i列元素比较的comparator
		Collections.sort(data.getData(), cp.get(depth));

		depth = depth++ % dimension;
		int index = data.getColNum() / 2;
		DataSet<RealVector> leftData = data.subDataSet(0, index);
		DataSet<RealVector> rightData = data.subDataSet(index + 1,
				data.getRowNum());

		root = new BinaryTreeNode<RealVector>(data.get(index));
		buildTree(root.getLeftChild(), leftData, depth);
		buildTree(root.getRightChild(), rightData, depth);

	}
}
