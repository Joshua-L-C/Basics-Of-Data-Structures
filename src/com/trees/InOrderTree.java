package com.trees;

public class InOrderTree {
	
	public static TreeNode increasingBST(TreeNode root) {
	
		if(root == null) {
			return null;
		}
		
		TreeNode current = new TreeNode(root.val);
		TreeNode left = new TreeNode(-1);
		TreeNode right = new TreeNode(-1);
		
		if(root.left != null) {
			left = increasingBST(root.left);
		}
		
		if(left != null && left.val != -1) {
			TreeNode runner = left;
			
			while(runner.right != null) {
				runner = runner.right;
			}
			
			runner.right = current;
			
			//runner = current;
		}
		
		if(root.right != null) {
			right = increasingBST(root.right);
		}
		
		if(right != null && right.val != -1) {
			
//			TreeNode runner = right;
//			
//			while(runner.rightChild != null) {
//				runner = runner.rightChild;
//			}
//			
//			
//			
//			current = runner;
			
			
			current.right = right;
		}
		
		
		if(left.val == -1 && current.val != -1 && right.val != -1) {
			return current;
		}
		
		if(left.val != -1 && current.val != -1) {
			return left;
		}
		
		
		return current;
	}

	public static void main(String[] args) {
		
		
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		TreeNode eight = new TreeNode(8);
		TreeNode nine = new TreeNode(9);
		
		
		two.setLeftChild(one);
		three.setLeftChild(two);
		three.setRightChild(four);
		five.setLeftChild(three);
		five.setRightChild(six);
		six.setRightChild(eight);
		eight.setLeftChild(seven);
		eight.setRightChild(nine);
		
		TreeNode base = increasingBST(five);
		
		while(base.right != null) {
			System.out.println(base.val);
			base = base.right;
		}
		
		
		
		
		
		
	}

}
