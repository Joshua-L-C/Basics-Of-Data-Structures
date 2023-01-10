package com.trees;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderAverage {
	
	List<Double> numberOfElementsAtLevel = null;
    List<Double> sumOfElementsAtLevel = null;
    
    public List<Double> averageOfLevels(TreeNode root) {
        
        numberOfElementsAtLevel = new ArrayList<Double>();
        sumOfElementsAtLevel = new ArrayList<Double>();
        
        if(root == null){
            return numberOfElementsAtLevel;
        }
        
        numberOfElementsAtLevel.add(0.0);
        sumOfElementsAtLevel.add(0.0);
        
        recur(0, root);
        
        
        
        System.out.println("Number Of Elements At each Level");
        
        for(int runner = 0; runner < numberOfElementsAtLevel.size();runner++){
            System.out.print(numberOfElementsAtLevel.get(runner) + " ");
        }
        
        System.out.println("");
        System.out.println("Sum Of Elements At each Level");
        
        for(int runner = 0; runner < sumOfElementsAtLevel.size();runner++){
            System.out.print(sumOfElementsAtLevel.get(runner) +" ");
        }
        
        System.out.println("");
        System.out.println("Final Of Elements At each Level");
        
        for(int runner = 0; runner < sumOfElementsAtLevel.size();runner++){
            sumOfElementsAtLevel.set(runner,sumOfElementsAtLevel.get(runner)/numberOfElementsAtLevel.get(runner));
            System.out.print(sumOfElementsAtLevel.get(runner) +" ");
        }
        
        
        return sumOfElementsAtLevel;
    }
    
    
    public void recur(int level, TreeNode root){
        
        if(root.left == null && root.right == null){
            
            numberOfElementsAtLevel.set(level, numberOfElementsAtLevel.get(level) + 1);
            sumOfElementsAtLevel.set(level, sumOfElementsAtLevel.get(level) + root.val);
            
//            System.out.println("Level: "+level);
//            System.out.println("Val: "+root.val);
            
            return;
        }
        
        numberOfElementsAtLevel.set(level, numberOfElementsAtLevel.get(level) + 1);
        sumOfElementsAtLevel.set(level, sumOfElementsAtLevel.get(level) + root.val);
        numberOfElementsAtLevel.add(0.0);
        sumOfElementsAtLevel.add(0.0);
        
//        System.out.println("Level: "+level);
//        System.out.println("Val: "+root.val);
        
        level += 1;
        
        if(root.right != null){
            recur(level,root.right);
        }
        
        
        if(root.left != null){
            recur(level,root.left);
        }
        
        return;
    }

	public static void main(String[] args) {
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(5);
		TreeNode d = new TreeNode(0);
		TreeNode e = new TreeNode(2);
		TreeNode f = new TreeNode(4);
		TreeNode g = new TreeNode(6);
		TreeNode h = new TreeNode(7);
		
		a.left = b;
		a.right = c;
		
		b.left = d;
		b.right = e;
		
		c.left = f;
		c.right = g;
		
		d.left = h;
		
		
		LevelOrderAverage x = new LevelOrderAverage();
		x.averageOfLevels(a);
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println(Integer.bitCount(731) * 10001);
	}

}
