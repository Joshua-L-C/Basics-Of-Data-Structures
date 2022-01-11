package com.queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class ValidPath {
	
	public static boolean validPath(int n, int[][] edges, int start, int end) {
    	
    	Queue<Integer> queue = new LinkedList<Integer>();
    	HashSet<int []> set = new HashSet<int []>();
    	
    	
    	queue.add(start);
    	
    	
    	while(!queue.isEmpty()){
    		
    		int size = queue.size();
    		
    		for(int runner = 0; runner < size; runner++) {
    			
    			int currentVertex = queue.poll();
    			
    			for(int edgeRunner = 0; edgeRunner < edges.length; edgeRunner++) {
    				if(!set.contains(edges[edgeRunner])) {
    					if(edges[edgeRunner][0] == currentVertex) {
	    					
    						
    						if(edges[edgeRunner][1] == end) {
    							return true;
    						}
	    					
	    					queue.add(edges[edgeRunner][1]);
	    					set.add(edges[edgeRunner]);
	    					
	    					
	    					
	    					
	    					
	    				}else if(edges[edgeRunner][1] == currentVertex ) {
	    					
	    					if(edges[edgeRunner][1] == end) {
	    						return true;
    						}
	    					
	    					queue.add(edges[edgeRunner][0]);
	    					set.add(edges[edgeRunner]);
	    					//System.out.println("test");
	    				}
    				}
    				
    			}
    			
    		}
    	}
    	
    	return false;
    }
	
	public static void main(String[] args) {
		
		
		System.out.println("Test");
		System.out.println(validPath(6,new int[][]{{0,1},{1,2},{2,3},{0,5},{2,4}}, 1, 4));

	}

}
