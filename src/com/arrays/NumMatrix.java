package com.arrays;

public class NumMatrix {
	 	int[][] dp;
	 	
	    public NumMatrix(int[][] matrix) {
	        int m = matrix.length;
	        int n = matrix[0].length;
	        dp = new int[m + 1][n + 1];
	        
	        for (int i = 0; i < m; ++i) {
	            for (int j = 0; j < n; ++j) {
	                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] + matrix[i][j] - dp[i][j];
	            }
	        }
	    }
	    
	    public int sumRegion(int row1, int col1, int row2, int col2) {
	    	
	    	/*
	    	 * 1 1 1 1 1 
			   1 1 1 1 1 
			   1 1 1 1 1 
			   1 1 1 1 1 
			   1 1 1 1 1 
	    	 * 
	    	 * 0 0 0 0 0 0 
			   0 1 2 3 4 5 
			   0 2 4 6 8 10 
			   0 3 6 9 12 15 
			   0 4 8 12 16 20 
			   0 5 10 15 20 25 
	    	 * 
	    	 * Example from (0, 0, 1, 1)
	    	 * dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
	    	 * dp[2][2] - dp[0][2] - dp[2][0] + dp[0][0]
	    	 * 4  -  0  -  0  -  0 = 4  
	    	 * 
	    	 * 
	    	 * Example from (1, 0, 2, 3)
	    	 * dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
	    	 * dp[3][4] - dp[1][4] - dp[3][0] + dp[1][0]
	    	 * 12  -  4  -  0  -  0  = 8
	    	 */
	    	
	    	
	    	
	    	
	        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
	    }
	    
	    public void printOut() {
	    	for(int runner = 0 ; runner < dp.length; runner++) {
	    		for(int runnerTwo = 0 ; runnerTwo < dp[0].length; runnerTwo++) {
	    			System.out.print(dp[runner][runnerTwo] + " ");
	    		}
	    		System.out.println();
	    	
	    	}
	    }
	    
	public static void main(String[] args) {
		
//		int[][] matrix = new int[][]{{3, 0, 1, 4, 2},
//					      {5, 6, 3, 2, 1},
//					      {1, 2, 0, 1, 5},
//					      {4, 1, 0, 1, 7},
//					      {1, 0, 3, 0, 5}};
					      
		int[][] matrix = new int[][]{{1, 1, 1, 1, 1},
									 {1, 1, 1, 1, 1},
						             {1, 1, 1, 1, 1},
						             {1, 1, 1, 1, 1},
						             {1, 1, 1, 1, 1}};
						             
		for(int runner = 0 ; runner < matrix.length; runner++) {
			
			for(int runnerTwo = 0 ; runnerTwo < matrix[0].length; runnerTwo++) {
					System.out.print(matrix[runner][runnerTwo] + " ");
			}
			
			System.out.println();
		}
						      
		
		System.out.println();
	   NumMatrix mat = new NumMatrix(matrix);

		mat.printOut();
		System.out.println();
		
		System.out.println(mat.sumRegion(0, 0, 1, 1));
		System.out.println(mat.sumRegion(0, 1, 2, 3));
	}

}
