package com.stack;

import java.util.HashSet;

public class Provinces {
    public static int findCircleNum(int[][] isConnected) {
        
        
        HashSet<Integer> visited = new HashSet<Integer>();
        
  
        int prov = 0;
        for(int runner = 0 ; runner < isConnected.length; runner++) {
        	if(!visited.contains(runner)) {
        		prov++;
        		cityHelper(isConnected,runner,0,visited);
        	}
        	
        }
        
        return prov;
    }
    
    public static void cityHelper(int[][] isConnected, int i, int j,HashSet<Integer> visited){

        
        
       for(int runner = 0 ; runner < isConnected[i].length;runner++) {
    	   if(runner != i && !visited.contains(runner) && isConnected[i][runner] == 1) {
    		   visited.add(runner);
    		   cityHelper(isConnected, runner, 0,  visited);
    	   }
       }
        
    }
    
    
	public static void main(String[] args) {
		int [][] connections = new int[][]{{1,0,0,0},{0,1,0,0},{0,0,1,1},{0,0,1,1}};
		
		System.out.println(findCircleNum(connections));

	}

}
