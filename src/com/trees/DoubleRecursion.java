package com.trees;

public class DoubleRecursion {
	
	
	
	//Broken
	public static int rowRunner(int[][] matrix, int rowIndex,int columnIndex) {
		
		System.out.println("Row: " + rowIndex + " Column: " + columnIndex);
		
		if(rowIndex == matrix.length - 1) {
			
			return columnRunner(matrix,rowIndex,columnIndex);
			
		}
		
		
		int val = rowRunner(matrix,rowIndex + 1,columnIndex);
		val += columnRunner(matrix,rowIndex,columnIndex);
		
	
		
		return val;
	}
	
	//Broken	
	public static int columnRunner(int[][] matrix,int rowIndex, int columnIndex) {
		
		System.out.println("Row: " + rowIndex + " Column: " + columnIndex);
		
		if(columnIndex == matrix[0].length - 1) {
			
			//int val = matrix[rowIndex][columnIndex];
			
			//return val;
			
			return matrix[rowIndex][columnIndex];
		}
		
		
		int val = matrix[rowIndex][columnIndex] +  columnRunner(matrix,rowIndex,columnIndex + 1); 
		
		return val;
	}
	
	
	public static void main(String[] args) {
		
		int[][] array = new int[][] {{1,1,1,1},
									 {0,1,0,1},
									 {1,0,1,1},
									 {1,0,0,1}
									};
		
		System.out.println("Test: "+rowRunner(array,0,0));
		//System.out.println("Test: "+columnRunner(array,0,0));
		
		

	}

}
