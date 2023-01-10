package com.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeBuilder {

	public TreeNode root = new TreeNode();
	Integer[] leavesArray;

	public TreeBuilder() {

	}

	public TreeBuilder(Integer rootValue, Integer[] array) {
		this.leavesArray = array;
		this.root.val = rootValue;
	}

	public void buildTree(TreeNode node, int indx, Integer[] leavesArray) {

		if (node != null) {

			if (2 * indx + 1 < leavesArray.length) {
				if (leavesArray[2 * indx + 1] == null) {
					node.left = null;
				} else {

					node.left = new TreeNode(leavesArray[2 * indx + 1]);
					buildTree(node.left, (2 * indx + 1), leavesArray);
				}

			}

			if (2 * indx + 2 < leavesArray.length) {
				if (leavesArray[2 * indx + 2] == null) {
					node.right = null;
				} else {

					node.right = new TreeNode(leavesArray[2 * indx + 2]);
					buildTree(node.right, (2 * indx + 2), leavesArray);
				}

			}

		}

	}

//	public void buildTree() {
//		
//		Queue<Integer> queue = new LinkedList<Integer>();
//		Stack
//		
//		if(leavesArray.length > 2) {
//			int currentIndex = 0;
//			root = new TreeNode(leavesArray[currentIndex]);
//			
//			
//			TreeNode currentNode = root;
//			TreeNode leftEdge;
//			TreeNode rightEdge;
//			
//			
//			queue.add(currentIndex);
//			
//			while(!queue.isEmpty()) {
//				
//				currentIndex = queue.peek();
//				
//				if(leavesArray[(2 * currentIndex + 1)] != null) {
//					
//				}
//				
//				if(leavesArray[(2 * currentIndex + 2)] != null) {
//					
//				}
//				
//				
//			}
//			
//			
//			
//			
//		}

	public void inOrder(TreeNode root) {

		if (root == null) {
			return;
		}

		inOrder(root.left);

		System.out.println(root.val);

		inOrder(root.right);

		return;
	}

	public void inOrderIterative(TreeNode node) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(node);

		TreeNode current = null;
		TreeNode leftNodes = null;
		TreeNode rightNodes = null;

		boolean popped = false;

		while (!stack.isEmpty()) {

			current = stack.peek();

			System.out.println(current.val);

			if (!popped) {
				traverseLeft(current, stack);
			}

			current = stack.peek();

			if (current.right != null) {
				stack.pop();
				stack.push(current.right);
				popped = false;
			}

			if (current.right == null) {
				stack.pop();
				popped = true;
			}

		}

		return;

	}

	public void traverseLeft(TreeNode node, Stack<TreeNode> stack) {

		TreeNode current = node;
		TreeNode first = current;

		while (current != null) {
			// System.out.println(current.val);

			if (current != first) {
				stack.push(current);
			}

			current = current.left;
		}

		return;
	}

	public void preOrder(TreeNode root) {

		if (root == null) {
			return;
		}

		System.out.println(root.val);

		preOrder(root.left);

		preOrder(root.right);

		return;
	}

	public void preOrderIterative(TreeNode root) {

		Stack<TreeNode> stack = new Stack<TreeNode>();

		if (root != null) {
			System.out.println(root.val);
			stack.push(root);
		}

		TreeNode forwardLeft = null;

		if (root.left != null) {
			forwardLeft = root.left;
		}

		while (!stack.isEmpty()) {

			while (forwardLeft != null) {
				System.out.println(forwardLeft.val);
				stack.push(forwardLeft);
				forwardLeft = forwardLeft.left;
			}

			if (stack.peek().right != null) {
				TreeNode holder = stack.peek();
				stack.pop();
				stack.push(holder.right);

				forwardLeft = holder.right.left;

				System.out.println(stack.peek().val);
			} else if (stack.peek().right == null) {
				stack.pop();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Integer[] array = { 2, 1, 3, null, 4, null, 7 };
		// Integer[] array = {8,9,10,11,12,13,14};
		// Integer[] array = { 5, 4, 7, 3, null, 6, 8 };
		TreeBuilder test = new TreeBuilder(array[0], array);
		test.buildTree(test.root, 0, array);

		TreeNode rootNode = test.root;

		Integer x = null;

		// System.out.println(test.root.val);
		test.inOrder(test.root);

		System.out.println();

		test.preOrder(test.root);

		System.out.println();

		test.preOrderIterative(test.root);

	}



}
