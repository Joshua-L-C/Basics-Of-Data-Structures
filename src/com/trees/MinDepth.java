package com.trees;

public class MinDepth {
	
	public static int minDepth(TreeNode root) {
        
        if(root == null){
            return -1;
        }
    
        int left = 0;
        int right = 0;
        
        if(root.left != null){
            left = minDepth(root.left) + 1;
        }
        
        if(root.right != null){
            right = minDepth(root.right) + 1;
        }
        
        
        if(left < right && left != 1){
            return left;
        }else if(right >= 1){
            return right;    
        }
        
        return 1;
        
    }

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(0);
		TreeNode three = new TreeNode(1);
		TreeNode four = new TreeNode(0);
		TreeNode five = new TreeNode(1);
		TreeNode six = new TreeNode(0);
		TreeNode seven = new TreeNode(1);
		
		one.left = two;
		two.left = three;
		three.left = four;
		four.left = five;
		
		System.out.println(minDepth(one));

	}

}
