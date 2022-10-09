package com.trees;

public class InvertBinaryTree {
	
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        
        if(root.left == null && root.right == null){
            return root;
        }
        
        TreeNode holder = null;
        
        holder = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = holder;
        
        
        return root;
    }

	public static void main(String[] args) {
	

	}

}
