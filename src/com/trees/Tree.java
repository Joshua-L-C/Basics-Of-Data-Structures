package com.trees;

public class Tree {
	
	private TreeNode root;
	
	public void insert(int val) {
		if(root == null) {
			root = new TreeNode(val);
		}else {
			root.insert(val);
		}
	}
	
	public void taverseInOrder() {
		if(root != null) {
			root.traverseInOrder();
		}
	}
	
	public TreeNode get(int value) {
		if(root != null) {
			return root.get(value);
		}
		
		return null;
	}
	
	public int min() {
		if(root != null) {
			return root.min();
		}
		
		return -1;
	}
	
	public int max() {
		if(root != null) {
			return root.max();
		}
		
		return -1;
	}
	
	
	public void delete(int value) {
		root = delete(root,value);
	}
	
	private TreeNode delete(TreeNode subTreeRoot, int value) {
		if(subTreeRoot == null) {
			return subTreeRoot;
		}
		
		
		if(value < subTreeRoot.getVal()) {
			subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(),value));
		}else if(value > subTreeRoot.getVal()) {
			subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(),value));
		}else {
			if(subTreeRoot.getLeftChild() == null) {
				return subTreeRoot.getRightChild();
			}
			else if(subTreeRoot.getRightChild() == null) {
				return subTreeRoot.getLeftChild();
			}
			
			
			subTreeRoot.setVal(subTreeRoot.getRightChild().min());
			subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(),subTreeRoot.getVal()));
			
			
		}
		
		
		
		return subTreeRoot;
	}
}
