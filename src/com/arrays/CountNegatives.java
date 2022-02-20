package com.arrays;

public class CountNegatives {
	public int countNegatives(int[][] grid) {
		
		int negatives = 0;
		for(int runner = 0; runner < grid.length; runner++) {
			for(int endRunner = grid[runner].length - 1; endRunner >= 0; endRunner--) {
				
				if(grid[runner][endRunner] < 0) {
					negatives++;
				}else {
					break;
				}
				
			}
		}
		
		
		return negatives;
	}
	public static void main(String[] args) {
		

	}

}
