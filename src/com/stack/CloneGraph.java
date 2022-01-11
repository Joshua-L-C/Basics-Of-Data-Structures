package com.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
		
	
	   public static Node cloneGraph(Node node) {
	        
	        
	        System.out.println(node.val);
	        HashSet<Node> set = new HashSet<Node>();
	        Node total = dfsClone(node,set);
	        //Node total = clone(node,new HashMap<Integer,Node>());
	        return total;
	    }
	    
	    
	    public static Node dfsClone(Node node, HashSet<Node> set){
	        
            if(node == null){
	            return null;
	        }
            
            if(set.contains(node)) {
            	
            	Iterator<Node> iter = set.iterator();
            	Node x = null;
            	
            	while(iter.hasNext()) {
            		x = iter.next();
            		if(x == node) {
            			break; 
            		}
            	}
            	
            	
            	return x;
            }
	        
	        Node next = new Node(node.val);
	        Node current = null;
	        set.add(node);
            
	        for(Node n : node.neighbors){
                    current = dfsClone(n , set);   
                    next.neighbors.add(current);
	        }
            
            
	        
	        
	        return next;
	    }
	    
	    private static Node clone(Node node, Map<Integer, Node> map) {
	        if (node == null) return null;
	        if (map.containsKey(node.val)) return map.get(node.val);
	        
	        Node newNode = new Node(node.val);
	        map.put(node.val, newNode);
	        
	        for (Node n: node.neighbors) {
	            newNode.neighbors.add(clone(n, map));
	        }
	        
	        return newNode;
	    }
	    
	    
	    
	    
	    
	    public static int findTargetSumWays(int[] nums, int target) {
	        
	    	
	    	int total = target(nums,0,0,target,0);
	    	
	    	return total;
	    }
	    
	    
	    public static int target(int[] nums,int index,int runningSum, int target, int occurrences){
	        
	        if(runningSum == target){
	            occurrences++;
	            return occurrences;
	        }
	        
	        if(index == nums.length) {
            	index--;
            	return index;
            }
	        
	        if( index < nums.length && index >= 0){
	            runningSum = runningSum + (-1*nums[index]);
	            //index++;
	            target(nums,index + 1,runningSum,target,occurrences);
	            
	
	            //index--;
	            runningSum = runningSum + (1*nums[index]);
	            target(nums,index-1,runningSum,target,occurrences);
	        }
	        
	        
	        return occurrences;
	        
	    }
	    
	public static void main(String[] args) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		
		
		one.neighbors = new ArrayList<Node>(Arrays.asList(two, four));
		two.neighbors = new ArrayList<Node>(Arrays.asList(one, three));
		three.neighbors = new ArrayList<Node>(Arrays.asList(two, four));
		four.neighbors = new ArrayList<Node>(Arrays.asList(one, three));
		
		
		Node x = cloneGraph(one);
		
		for(Node n: x.neighbors) {
			System.out.println(n.val);
		}
		
		System.out.println("Test");
		//System.out.println(validPath(6,new int[][]{{0,1},{1,2},{2,3},{0,5},{2,4}}, 1, 4));
		
		
		findTargetSumWays(new int[] {1,1,1,1,1},3);
	}

}
