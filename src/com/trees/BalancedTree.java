package com.trees;



public class BalancedTree {
	 public static boolean isBalanced(TreeNode root) {
	        
	        if(root == null){
	            return true;
	        }

	        
	        
	        int x = getHeightOfTree(root.left);
	        
	        System.out.println("Left Side: "+x);
	        
	        
	        int y = getHeightOfTree(root.right);
	        
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
	        return 1 + TreeSize(node.left,count) + TreeSize(node.right,count);
	    }
	    
	    
	    public static int getHeightOfTree(TreeNode node) {
	        if (node == null) {
	          return -1;
	        }
	        
	        return Math.max(getHeightOfTree(node.left), getHeightOfTree(node.right)) + 1;
	      }
	    
	    
	    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(null,null,1);
		root.left = new TreeNode(null,null,2);
		root.left.left = new TreeNode(null,null,4);
		root.left.right = new TreeNode(null,null,5);
		root.left.right.left = new TreeNode(null,null,9);
		root.left.right.left.left = new TreeNode(null,null,10);
		
		
		root.right = new TreeNode(null,null,3);
		root.right.right = new TreeNode(null,null,6);
		root.right.right.left = new TreeNode(null,null,7);
		
		isBalanced(root);
		
	}

}
