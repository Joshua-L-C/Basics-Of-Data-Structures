package com.trees;

public class GetTargetCopy {
	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        if(original == null || cloned == null){
            return null;
        }
        
        
        if(original.left == null && original.right == null){
            
            if(original.val == target.val && cloned.val == target.val){
                TreeNode toReturn = cloned;
                return toReturn;
            }
            
            return null;
        }
        
        if(original.val == target.val && cloned.val == target.val){
            TreeNode toReturn = cloned;
            return toReturn;
        }
        
        
        TreeNode toReturn;
        
        toReturn = getTargetCopy(original.left,cloned.left,target);
        
        if(toReturn != null){
            return toReturn;
        }
        
        toReturn = getTargetCopy(original.right,cloned.right,target);
        
        
        
        
        return toReturn;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
