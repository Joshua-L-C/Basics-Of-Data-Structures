package com.trees;

public class HeightBalancedSearchTree {
	
	TreeNode root = new TreeNode();
	
	public TreeNode sortedArrayToBST(int[] nums) {

        int half = nums.length / 2;

        System.out.println("half way "+ half);
        System.out.println("left half way "+ half / 2);
        System.out.println("right half way "+ ((half / 2) + half) );

        

         root = recur(nums,new boolean[nums.length],0,nums.length,root);

        return root;
    }
	
	   public TreeNode recur(int[] nums, boolean[] beenTo , int leftIndex , int rightIndex,TreeNode currentNode){
		   

	        int mid = leftIndex + (rightIndex - leftIndex) /2;
	        
	        if(leftIndex == rightIndex || rightIndex == mid) {
	        	return null;
	        }
	        

	        currentNode = new TreeNode(nums[mid]);
	        
	        
	        
	        currentNode.left = recur(nums, beenTo,leftIndex,mid,currentNode.left);
	        currentNode.right = recur(nums, beenTo,mid + 1,rightIndex,currentNode.right);
	        
	        return currentNode;
	    }

    public void recur1(int[] nums, boolean[] beenTo , int leftIndex , int currentIndex, int rightIndex,TreeNode currentNode){

        if(beenTo[currentIndex]){
            return;
        }

       beenTo[currentIndex] = true;

       currentNode.setVal(nums[currentIndex]);
       
       if(!beenTo[leftIndex]) {
    	   currentNode.left = new TreeNode(nums[leftIndex]);
    	   beenTo[leftIndex] = true;
       }
       
       
       if(!beenTo[rightIndex]) {
    	   currentNode.right = new TreeNode(nums[rightIndex]);
    	   beenTo[rightIndex] = true;
       }
       //currentNode.right = new TreeNode(nums[rightIndex]);

       recur1(nums,beenTo, (leftIndex - 0) / 2, leftIndex, ((leftIndex - 0) / 2) + leftIndex,currentNode.left);
       recur1(nums,beenTo, (rightIndex - currentIndex) / 2, rightIndex,((rightIndex - currentIndex) / 2) + rightIndex ,currentNode.right);


    }

	public static void main(String[] args) {
		
		HeightBalancedSearchTree x = new HeightBalancedSearchTree();
		TreeNode node = x.sortedArrayToBST(new int[]{-10,-3,0,5,9});

	}

}
