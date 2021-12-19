package com.stack;

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
	                
	                	buildIsland(grid, row, col);
	                
	                }
	                
	                
	                
	            }
	            
	            
	        }
	        
	        return numberOfIslands;
	    }
	 
	 
	 public static void buildIsland(char [][] grid, int row, int col) {
		 
		 
		 if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {
			 return;
		 }
		 
		 grid[row][col] = '0';
		 
		 buildIsland(grid, row + 1, col);
		 buildIsland(grid, row, col + 1);
		 buildIsland(grid, row - 1, col);
		 buildIsland(grid, row, col - 1);
	 }
	
	
	public static void main(String[] args) {
		
		char[][] array = {{'1','1','1','1','0'},
				  {'1','1','0','1','0'},
				  {'1','1','0','0','0'},
				  {'0','0','0','0','0'}};

System.out.println("Number Of Islands: " + numIslands(array));

	}

}
