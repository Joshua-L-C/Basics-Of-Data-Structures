package com.trees;

public class MaximumDepth {

	public int maxDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int left = maxDepth(root.left) + 1;
		int right = maxDepth(root.right) + 1;

		if (left > right) {
			return left;
		}

		return right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
