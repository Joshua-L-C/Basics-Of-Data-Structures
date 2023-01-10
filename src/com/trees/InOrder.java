package com.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {
	
	static List<Integer> list;
	
    public static List<Integer> inorderTraversal(TreeNode root) {
        
        list = new ArrayList<Integer>();
        
        recur(root);
        
        return list;
    }
    
    
    public static void recur(TreeNode root){
        
        if(root == null){
            return;
        }
        
        recur(root.left);
        
        list.add(root.val);
        
        recur(root.right);
        
        return;
    }
	
	public static void inOrderIterative(TreeNode node) {
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(node);
		
		TreeNode current = null;
		TreeNode leftNodes = null;
		TreeNode rightNodes = null;
		
		boolean popped = false;
		
		
		while(!stack.isEmpty()) {
			
			current = stack.peek();
			
			System.out.println(current.val);
			
			if(!popped) {
				traverseLeft(current,stack);
			}
			
			
			current = stack.peek();
			
			
			
			if(current.right != null) {
				stack.pop();
				stack.push(current.right);
				popped = false;
			}
			
			if(current.right == null) {
				stack.pop();
				popped = true;
			}
			
			
		}
		
		
		return;
		
		
	}
	
	public static void traverseLeft(TreeNode node, Stack<TreeNode> stack) {
		
		TreeNode current = node;
		TreeNode first = current;
		
		while(current != null) {
			//System.out.println(current.val);
			
			if(current != first) {
				stack.push(current);
			}
			
			current = current.left;
		}
		
		
		
		return;
	}
	
	public static void main(String[] args) {
	
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(7);
		TreeNode h = new TreeNode(8);
		TreeNode i = new TreeNode(9);
		TreeNode j = new TreeNode(10);
		TreeNode l = new TreeNode(11);
		TreeNode m = new TreeNode(12);
		
		
		a.left = b;
		a.right = c;
		
		b.left = d;
		b.right = e;
		
		c.left = f;
		c.right = g;
		
		d.left = h;
		
		e.right = i;
		
		f.left = j;
		
		g.right = l;
		
		h.right = m;
		
		List<Integer> list = new ArrayList<Integer>();
		
		list = inorderTraversal(a);
		
		System.out.println("InOrder Traversal Recursive");
		
		for(int runner = 0; runner < list.size(); runner++) {
			System.out.println(list.get(runner));
		}
		System.out.println();
		
		
		System.out.println("InOrder Traversal Iterative");
		inOrderIterative(a);
		

	}

}
