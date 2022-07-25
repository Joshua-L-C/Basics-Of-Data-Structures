package com.trees;

public class TreeNode {

	int val;
	TreeNode left;

	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(TreeNode left, TreeNode right, int val) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeNode getLeftChild() {
		return left;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.left = leftChild;
	}

	public TreeNode getRightChild() {
		return right;
	}

	public void setRightChild(TreeNode rightChild) {
		this.right = rightChild;
	}
	
	public void insert(int value) {
		if(value == val) {
			return;
		}
		
		
		if(value < val) {
			if(left == null) {
				left = new TreeNode(value);
			}else {
				left.insert(value);
			}
		}else if(value > val) {
			if(right == null) {
				right = new TreeNode(value);
			}else {
				right.insert(value);
			}
		}
	}
	
	public void traverseInOrder() {
		
		if(left != null) {
			left.traverseInOrder();
		}
		
		System.out.println("Data: " + val);
		
		if(right != null) {
			right.traverseInOrder();
		}
		
	}
	
	public TreeNode get(int value) {
		if(value == val) {
			return this;
		}
		
		
		if(value < val) {
			if(left != null) {
				return left.get(value);
			}
		}else if(value > val) {
			if(right != null) {
				return right.get(value);
			}
			
		}else {
			
		}
		
		return null;
	}
	
	public int min() {
		if(left == null) {
			return val;
		}
		
		//int data = leftChild.min(); 
		
		return left.min();
	}
	
	
	public int max() {
		if(right == null) {
			return val;
		}
		
		//int data = rightChild.max();
		
		return right.max();
	}
	
	
	
}
