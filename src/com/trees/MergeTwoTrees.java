package com.trees;

public class MergeTwoTrees {
	
	  public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
	        
	        if(root1.left == null && root1.right == null && root2.left == null && root2.right == null){
	            return new TreeNode(root1.val + root2.val);
	        }
	        
	        TreeNode currentNode = new TreeNode();
	        
	        currentNode.val = (root1.val + root2.val);
	        
	        
	        if(root1.left != null && root2.left != null){
	            
	            
	            
	            currentNode.left = mergeTrees(root1.left,root2.left);
	            
	            
	        }
	        
	        if(root1.right != null && root2.right != null){
	            
	            //currentNode.val = (root1.val + root2.val);    
	            currentNode.right = mergeTrees(root1.right,root2.right);
	            
	        }
	        
	        
	        if(root1.left != null && root2.left == null){
	            
	            //currentNode.val = (root1.val);
	            currentNode.left = mergeTrees(root1.left,new TreeNode(0));
	            
	        }
	        
	        if(root1.right != null && root2.right == null){
	            
	            //rrentNode.val = (root1.val);
	            currentNode.right = mergeTrees(root1.right,new TreeNode(0));
	            
	        }
	        
	        if(root1.left == null && root2.left != null){
	            
	            //rrentNode.val = (root1.val);
	            currentNode.left = mergeTrees(new TreeNode(0),root2.left);
	            
	        }
	        
	        if(root1.right == null && root2.right != null){
	            
	            //currentNode.val = (root1.val);
	            currentNode.right = mergeTrees(new TreeNode(0),root2.right);
	            
	        }
	        
	        return currentNode;
	        
	        
	    }

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(3);
		root1.left.left = new TreeNode(5);
		root1.right = new TreeNode(2);
		
		
		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(1);
		root2.left.right = new TreeNode(4);
		root2.right = new TreeNode(3);
		root2.right.right = new TreeNode(7);
		
		TreeNode x = mergeTrees(root1, root2);

	}

}
