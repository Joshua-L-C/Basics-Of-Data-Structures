package com.stack;

import java.util.Stack;

public class NumberOfIslands {

	
	/**Function: Finds all the conected  and unique '1's this form an Island
	 * Steps:
	 *   - Cycle through the 2d array until you find a 1.
	 *   - If you find a 1 increment number of islands and call the buildIsland function 
	 *   - this is a recursive function that will change all adjacent 1's to 0 thus erasing the island
	 *   
	 *   BuildIsland
	 *   	- If the current index is out of bounds on the row or column or if the current grid position
	 *        doesnt hold a 1 we just return notthing.
	 *      - Else we do a recursive call for 
	 *      		1 space right
	 *              1 space left
	 *              1 space up 
	 *              1 space down.
	 *   
	 * 
	 * @param grid
	 * @return
	 */
	
	 public static  int numIslands(char[][] grid) {
	        
	    	int numberOfIslands = 0;
	    	
	        for(int row = 0; row < grid.length; row++){
	            for(int col = 0; col < grid[row].length; col++){
	                //System.out.print(grid[row][col]);
	                
	               
	                if(grid[row][col] == '1') {
	                	numberOfIslands++;
	                
	                	buildIslandDFS(grid, row, col);
	                
	                }
	                
	                
	                
	            }
	            
	            
	        }
	        
	        return numberOfIslands;
	    }
	 

	    public static void buildIslandDFS(char [][] grid, int row, int col) {
	        
	       Stack<int[]> stack = new Stack<int[]>(); 
	       
	        stack.push(new int[]{row,col});
	        
	        
	        while(!stack.isEmpty()){
	            
	        	int[] currentPoint = stack.pop();
	        	
	        	grid[currentPoint[0]][currentPoint[1]] = '0';
	        	
	        	
	        	if(currentPoint[0] - 1 >= 0 && grid[currentPoint[0] - 1][currentPoint[1]] == '1') {
	        		stack.push(new int[] {currentPoint[0] - 1, currentPoint[1]});
	        	}
	        	
	        	if(currentPoint[0] + 1 < grid.length && grid[currentPoint[0] + 1][currentPoint[1]] == '1') {
	        		stack.push(new int[] {currentPoint[0] + 1, currentPoint[1]});
	        	}
	        	
	        	if(currentPoint[1] - 1 >= 0 && grid[currentPoint[0] ][currentPoint[1] - 1] == '1') {
	        		stack.push(new int[] {currentPoint[0], currentPoint[1] - 1});
	        	}
	        	
	        	if(currentPoint[1] + 1 < grid[0].length  && grid[currentPoint[0]][currentPoint[1] + 1] == '1') {
	        		stack.push(new int[] {currentPoint[0], currentPoint[1] + 1});
	        	}
	        	
	        }
	        
	        
	    }
	 
	 public static void buildIslandDFSRecursive(char [][] grid, int row, int col) {
		 
		 
		 if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {
			 return;
		 }
		 
		 grid[row][col] = '0';
		 
		 buildIslandDFSRecursive(grid, row + 1, col);
		 buildIslandDFSRecursive(grid, row, col + 1);
		 buildIslandDFSRecursive(grid, row - 1, col);
		 buildIslandDFSRecursive(grid, row, col - 1);
	 }
	
	
	public static void main(String[] args) {
		
		char[][] array = {{'1','1','1','1','0'},
				  		  {'1','1','0','1','0'},
				  		  {'1','1','0','0','0'},
				  		  {'0','0','0','0','0'}};

		System.out.println("Number Of Islands: " + numIslands(array));

	}

}
