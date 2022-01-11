package com.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Matrix {
	
	   public static int[][] updateMatrix(int[][] mat) {
	        
	        for(int runner = 0; runner < mat.length;runner++){
	            for(int runnerTwo = 0; runnerTwo < mat.length;runnerTwo++){
	                
	                
	                if(mat[runner][runnerTwo] != 0) {
	                	//mat[runner][runnerTwo]
	                	reColor(mat, runner, runnerTwo);
	                }
	            }
	        }
	        
	        
	        return mat;
	    }
	    
	    
	    public static void reColor(int [][] mat, int x, int y){
	        Set<int[]> visited = new HashSet<int[]>();
	        
	        Stack<int[]> stack = new Stack<int[]>();
	        
	        stack.push(new int[] {x,y});
	        int steps = 0;
	        
	        while(!stack.isEmpty()) {
	        	
	        	
	        	int[] current = stack.pop();
	        	//visited.add(current);
	        	if(mat[current[0]][current[1]] == 0) {
	        		mat[x][y] = steps;
	        		return;
	        	}
	        	
	        	steps++;
	        	
	        	if(current[0] - 1 >= 0 ) {
					
	        		int[] value = new int[]{current[0] - 1,current[1]};
	        		
	        		if(mat[value[0]][value[1]] == 0) {
	        			mat[x][y] = steps;
		        		return;
	        		}
	        		
	        		if(!visited.contains(value)) {
	        			stack.push(value);
	        			visited.add(value);
	        		}
	        		
					
					
				}
				
				if(current[0] + 1 < mat.length  ) {
					
					int[] value = new int[]{current[0] + 1,current[1]};
					
					
					if(mat[value[0]][value[1]] == 0) {
	        			mat[x][y] = steps;
		        		return;
	        		}
					
	        		if(!visited.contains(value)) {
	        			stack.push(value);
	        			visited.add(value);
	        		}
				}
				
				if(current[1] - 1 >= 0  ) {
					
					
					int[] value = new int[]{current[0] ,current[1] - 1};
					
					if(mat[value[0]][value[1]] == 0) {
	        			mat[x][y] = steps;
		        		return;
	        		}
					
	        		if(!visited.contains(value)) {
	        			stack.push(value);
	        			visited.add(value);
	        		}
				}
				
				if(current[1] + 1  < mat[0].length  ) {
					
					
					int[] value = new int[]{current[0],current[1] + 1};
					
					if(mat[value[0]][value[1]] == 0) {
	        			mat[x][y] = steps;
		        		return;
	        		}
					
	        		if(!visited.contains(value)) {
	        			stack.push(value);
	        			visited.add(value);
	        		}
				}
	        	
	        }
	    	
	    	return;
	    	
	    	
	    }
	
	public static void main(String[] args) {
		int[][] image = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
		
		System.out.println(Arrays.deepToString(image));
		
		image = updateMatrix(image);
		
		System.out.println(Arrays.deepToString(image));

	}

}
