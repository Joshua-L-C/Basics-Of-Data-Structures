package com.trees;

public class TreeNode {

	int val;
	TreeNode leftChild;

	TreeNode rightChild;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(TreeNode left, TreeNode right, int val) {
		this.val = val;
		this.leftChild = left;
		this.rightChild = right;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
	public void insert(int value) {
		if(value == val) {
			return;
		}
		
		
		if(value < val) {
			if(leftChild == null) {
				leftChild = new TreeNode(value);
			}else {
				leftChild.insert(value);
			}
		}else if(value > val) {
			if(rightChild == null) {
				rightChild = new TreeNode(value);
			}else {
				rightChild.insert(value);
			}
		}
	}
	
	public void traverseInOrder() {
		
		if(leftChild != null) {
			leftChild.traverseInOrder();
		}
		
		System.out.println("Data: " + val);
		
		if(rightChild != null) {
			rightChild.traverseInOrder();
		}
		
	}
	
	public TreeNode get(int value) {
		if(value == val) {
			return this;
		}
		
		
		if(value < val) {
			if(leftChild != null) {
				return leftChild.get(value);
			}
		}else if(value > val) {
			if(rightChild != null) {
				return rightChild.get(value);
			}
			
		}else {
			
		}
		
		return null;
	}
	
	public int min() {
		if(leftChild == null) {
			return val;
		}
		
		//int data = leftChild.min(); 
		
		return leftChild.min();
	}
	
	
	public int max() {
		if(rightChild == null) {
			return val;
		}
		
		//int data = rightChild.max();
		
		return rightChild.max();
	}
	
	
	
}
