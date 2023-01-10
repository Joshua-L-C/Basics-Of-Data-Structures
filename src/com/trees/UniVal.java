package com.trees;

import java.util.LinkedList;
import java.util.Queue;

public class UniVal {
	
	 boolean uniVal = true;
	 
	 public boolean isUnivalTreeInter(TreeNode root) {

	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        int val = root.val;
	        
	        if(root.left != null){
	            queue.add(root.left);
	        }

	        if(root.left != null){
	            queue.add(root.right);
	        }

	        for(;queue.peek() != null;){

	            if(queue.peek().val != val){
	                return false;
	            }

	            if(root.left != null){
	                queue.add(root.left);
	            }

	            if(root.left != null){
	                queue.add(root.right);
	            }

	            queue.poll();
	        }



	        return true;
	    }

	    public boolean isUnivalTree(TreeNode root) {
	        
	        recur(root, root.val);

	        return uniVal;
	    }


	    public void recur(TreeNode root, int val){

	        if(root == null){
	            return;
	        }

	        if(root.val != val){
	            uniVal = false;
	        }

	        if(!uniVal){
	            return;
	        }

	        recur(root.left,val);
	        recur(root.right,val);

	    }
	    
	    StringBuilder builder = new StringBuilder();

	    public boolean isUnivalTree2(TreeNode root) {
	        
	        recur(root);

	        StringBuilder x = new StringBuilder();
	        
	        for(int indx = 0; indx < builder.length()/(root.val+"").toString().length(); indx++){
	            x.append(root.val+"");
	        }

	        //System.out.println("Builder "+builder.toString().hashCode()+ " "+builder.toString());

	        if(x.toString().hashCode() == builder.toString().hashCode()){
	            return true;
	        }

	        return false;
	    }


	    public void recur(TreeNode root){

	        if(root == null){
	            return;
	        }
	        
	        
	        builder.append(root.val);
	        
	        

	        // if(root.val != val){
	        //     uniVal = false;
	        // }

	        // if(!uniVal){
	        //     return;
	        // }

	        recur(root.left);
	        recur(root.right);

	    }
	    
	    static int nCr(int n, int r)
	    {
	    	return fact(n) / (fact(r) *
	    				fact(n - r));
	    }

	    // Returns factorial of n
	    static int fact(int n)
	    {
	    	if(n==0)
	    	return 1;
	    	int res = 1;
	    	for (int i = 2; i <= n; i++)
	    		res = res * i;
	    	return res;
	    }

	public static void main(String[] args) {
		System.out.println(nCr(40,2));

	}

}
