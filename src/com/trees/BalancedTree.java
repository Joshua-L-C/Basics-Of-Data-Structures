package com.trees;

import java.util.Stack;



public class BalancedTree {
	 public static boolean isBalanced(TreeNode root) {
	        
	        if(root == null){
	            return true;
	        }

	        
	        
	        int x = getHeightOfTree(root.leftChild);
	        
	        System.out.println("Left Side: "+x);
	        
	        
	        int y = getHeightOfTree(root.rightChild);
	        
	        System.out.println("Left Side: "+y);
	        return false;
//	         while(rootLeft != null){
//	             left.push(rootLeft);
//	             rootLeft = rootLeft.left;
//	         }
	        
//	         while(rootRight != null){
//	             right.push(rootRight);
//	             rootRight = rootRight.right;
//	         }
	        
//	         return !(Math.abs(left.size() - right.size()) > 1);
	    }
	    
	    public static  int TreeSize(TreeNode node, int count){
	        
	    	
	    	
	    	
	    	if(node == null) {
	    		return 0;
	    	}
	    	
	        
	        //return num;
	        return 1 + TreeSize(node.leftChild,count) + TreeSize(node.rightChild,count);
	    }
	    
	    
	    public static int getHeightOfTree(TreeNode node) {
	        if (node == null) {
	          return -1;
	        }
	        
	        return Math.max(getHeightOfTree(node.leftChild), getHeightOfTree(node.rightChild)) + 1;
	      }
	    
	    
	    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(null,null,1);
		root.leftChild = new TreeNode(null,null,2);
		root.leftChild.leftChild = new TreeNode(null,null,4);
		root.leftChild.rightChild = new TreeNode(null,null,5);
		root.leftChild.rightChild.leftChild = new TreeNode(null,null,9);
		root.leftChild.rightChild.leftChild.leftChild = new TreeNode(null,null,10);
		
		
		root.rightChild = new TreeNode(null,null,3);
		root.rightChild.rightChild = new TreeNode(null,null,6);
		root.rightChild.rightChild.leftChild = new TreeNode(null,null,7);
		
		isBalanced(root);
		
	}

}
