package com.trees;

import java.util.ArrayList;

public class MinimumDepth {

	// ArrayList<Integer> list = new ArrayList<Integer>();
	int low = Integer.MAX_VALUE;

	public int minDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		recur(root, 1);

//         int lowest =  Integer.MAX_VALUE;

//         for(int x: list){
//             if(x < lowest){
//                 lowest = x;
//             }
//         }

		// System.out.println("Low: " + low);

		return low;

	}

	public void recur1(TreeNode root, int val) {

		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			// list.add(val);

			if (val < low) {
				low = val;
			}

			return;
		}

		recur1(root.left, val + 1);
		recur1(root.right, val + 1);

		return;
	}

	ArrayList<Integer> list = new ArrayList<Integer>();

	public int minDepth3(TreeNode root) {

		if (root == null) {
			return 0;
		}

		recur(root, 1);

		int lowest = Integer.MAX_VALUE;

		for (int x : list) {
			if (x < lowest) {
				lowest = x;
			}
		}

		// System.out.println();

		return lowest;

	}

	public void recur(TreeNode root, int val) {

		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			list.add(val);
			return;
		}

		recur(root.left, val + 1);
		recur(root.right, val + 1);

		return;
	}

	public int minDepth2(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int lef = minDepth2(root.left) + 1;
		int rig = minDepth2(root.right) + 1;

		if (lef < rig && lef > 1) {
			return lef;
		} else if (rig < lef && rig > 1) {
			return rig;
		} else if (rig == 1) {
			return lef;
		} else if (lef == 1) {
			return rig;
		}

		return rig;

	}

	public int minDepth1(TreeNode root) {

		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		int left = 1000000;
		int right = 1000000;

		if (root.left != null) {
			left = minDepth(root.left) + 1;
		}

		if (root.right != null) {
			right = minDepth(root.right) + 1;
		}

		if (left < right && left != 0) {
			return left;
		} else if (right < left && right != 0) {
			return right;
		}

		return right;

	}

	public static void main(String[] args) {

	}

}
