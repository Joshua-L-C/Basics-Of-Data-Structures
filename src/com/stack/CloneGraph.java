package com.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CloneGraph {
		
	
	   public static Node cloneGraph(Node node) {
	        
	        
	        System.out.println(node.val);
	        HashSet<Node> set = new HashSet<Node>();
	        Node total = dfsClone(node,set);
	        
	        return total;
	    }
	    
	    
	    public static Node dfsClone(Node node, HashSet<Node> set){
	        
            if(node == null || set.contains(node)){
	            return null;
	        }
            
            
	        
	        Node next = new Node(node.val);
	        Node current = null;
	        set.add(node);
            
	        for(Node n : node.neighbors){
                if(!set.contains(n)){
                    current = dfsClone(n , set);    
                }
	 
	        }
            
            if(current != null)
	        next.neighbors = new ArrayList<Node>(Arrays.asList(current));
	        
	        return next;
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
		
	}

}
