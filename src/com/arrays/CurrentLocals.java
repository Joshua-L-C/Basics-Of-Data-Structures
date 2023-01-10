package com.arrays;

import java.util.ArrayList;

public class CurrentLocals {
	public static int[][] largestLocal(int[][] grid) {
        int[][] maxLocal = new int[grid.length - 2][grid.length - 2];
        
        int side = grid.length - 2;
        
        int currentGreatest = 0;
        
        int curRow = 0;
        int curCol = 0;
        
        
       
        
        for(int row = 0; row < side; row++){
            for(int col = 0; col < side; col++){
                
                curRow = row + 1;
                curCol = col + 1;
                
                currentGreatest = -1;
                

                currentGreatest = rowRunner(grid,row + 2,row,col); 
                
                System.out.println("Row: "+row+ " Col: "+col);
                System.out.println("Greatest in Row: "+currentGreatest);
                
                
                maxLocal[row][col] = currentGreatest;
            }
            
            //System.out.println();
        }
        
        
        
        return maxLocal;
    }
	
	public static int rowRunner(int [][] array, int stopper, int indexRowRunner,int indexColRunner){
		
		int val = -1;
		int val2 = -1;
		if(indexRowRunner == stopper) {
			
			
			val = colRunner(array,indexColRunner + 2,indexRowRunner,indexColRunner);
			return Math.max(val,array[indexRowRunner][indexColRunner]);
		}
		
		
		
		val = rowRunner(array,stopper,indexRowRunner + 1,indexColRunner);
		val2 = colRunner(array,indexColRunner + 2,indexRowRunner,indexColRunner);
		
		
//		System.out.println("Row: "+indexRowRunner+ " Col: "+indexColRunner);
//        System.out.println("Val: " + val);
//        System.out.println("Val2: " + val2);
//        System.out.println("Current: " + array[indexRowRunner][indexColRunner]);
		
		//return Math.max(val,Math.max(val2,array[indexRowRunner][indexColRunner]));
		return Math.max(val,Math.max(val2,array[indexRowRunner][indexColRunner]));
	}
	
	public static int colRunner(int [][] array, int stopper, int indexRowRunner,int indexColRunner) {
		if(indexColRunner == stopper) {
			return array[indexRowRunner][indexColRunner];
		}
		
		int val = colRunner(array,stopper,indexRowRunner,indexColRunner + 1);
		
		return Math.max(val, array[indexRowRunner][indexColRunner]);
	}
	
	
	
	public static int[][] largestLocal2(int[][] grid) {
        int[][] maxLocal = new int[grid.length - 2][grid.length - 2];
        
        int side = grid.length - 2;
        
        int currentGreatest = 0;
        
        int curRow = 0;
        int curCol = 0;
        
        
       
        
        for(int row = 0; row < side; row++){
            for(int col = 0; col < side; col++){
                
                curRow = row + 1;
                curCol = col + 1;
                
                currentGreatest = maxLocal[row][col];
                
                //System.out.print(grid[curRow][curCol] + " ");
                
                
                if(col == 0) {
                	currentGreatest = zeroIndexChecker(curRow, curCol, grid);
                }else {
                	
                	currentGreatest = maxLocal[row][col - 1];
                	
                	if(currentGreatest < grid[curRow - 1][ curCol + 1]) {
                    	currentGreatest = grid[curRow - 1][ curCol + 1];
                    }
                    
                    if(currentGreatest < grid[curRow][ curCol + 1]) {
                    	currentGreatest = grid[curRow][ curCol + 1];
                    }
                    
                    if(currentGreatest < grid[curRow + 1][ curCol + 1]) {
                    	currentGreatest = grid[curRow + 1][ curCol + 1];
                    }
                    
                    
                	
                }
                
                
                
                
                
                maxLocal[row][col] = currentGreatest;
            }
            
            //System.out.println();
        }
        
        
        
        return maxLocal;
    }
	
    public static int[][] largestLocal4(int[][] grid) {
        int[][] maxLocal = new int[grid.length - 2][grid.length - 2];
        
        int side = grid.length - 2;
        
        int currentGreatest = 0;
        
        int curRow = 0;
        int curCol = 0;
        
        
       
        
        for(int row = 0; row < side; row++){
            for(int col = 0; col < side; col++){
                
                curRow = row + 1;
                curCol = col + 1;
                
                currentGreatest = Math.max(currentGreatest,grid[curRow][curCol]);
                currentGreatest = Math.max(currentGreatest,grid[curRow - 1][curCol - 1]);
                currentGreatest = Math.max(currentGreatest,grid[curRow - 1][curCol]);
                currentGreatest = Math.max(currentGreatest,grid[curRow - 1][curCol + 1]);
                currentGreatest = Math.max(currentGreatest,grid[curRow][curCol - 1]);
                currentGreatest = Math.max(currentGreatest,grid[curRow][curCol + 1]);
                currentGreatest = Math.max(currentGreatest,grid[curRow + 1][curCol - 1]);
                currentGreatest = Math.max(currentGreatest,grid[curRow + 1][curCol]);
                currentGreatest = Math.max(currentGreatest,grid[curRow + 1][curCol + 1]);

                
                maxLocal[row][col] = currentGreatest;
                currentGreatest = -1;
            }
            
        }
        
        
        
        return maxLocal;
    }
	
	public static int zeroIndexChecker(int curRow, int curCol, int [][] grid) {
		int currentGreatest = -1;
		
		 if(grid[curRow - 1][curCol - 1] > currentGreatest){
	            
	            currentGreatest = grid[curRow - 1][curCol - 1]; 
	                                               
	         }
	         
	         if(grid[curRow - 1][curCol] > currentGreatest){
	             
	            currentGreatest = grid[curRow - 1][curCol]; 
	             
	         }
	         
	         if(grid[curRow - 1][curCol + 1] > currentGreatest){
	             
	            currentGreatest = grid[curRow - 1][curCol + 1];  
	             
	         }
	         
	         if(grid[curRow][curCol - 1] > currentGreatest){
	             
	            currentGreatest = grid[curRow][curCol - 1];  
	             
	         }
	         
	         if(grid[curRow][curCol + 1] > currentGreatest){
	             
	            currentGreatest = grid[curRow][curCol + 1];
	             
	         }
	         
	         if(grid[curRow + 1][curCol - 1] > currentGreatest){
	             
	            currentGreatest = grid[curRow + 1][curCol - 1];
	                
	         }
	         
	         if(grid[curRow + 1][curCol] > currentGreatest){
	             
	            currentGreatest = grid[curRow + 1][curCol];
	             
	         }
	         
	         if(grid[curRow + 1][curCol + 1] > currentGreatest){
	             
	            currentGreatest = grid[curRow + 1][curCol + 1];  
	             
	         }
	         
	         return currentGreatest;
	}
	
	public static int[][] largestLocal1(int[][] grid) {
        int[][] maxLocal = new int[grid.length - 2][grid.length - 2];
        
        int side = grid.length - 2;
        
        int currentGreatest = 0;
        
        int curRow = 0;
        int curCol = 0;
        
        
        for(int row = 0; row < side; row++){
            for(int col = 0; col < side; col++){
                
                curRow = row + 1;
                curCol = col + 1;
                
                currentGreatest = grid[curRow][curCol];
                
                System.out.print(grid[curRow][curCol] + " ");
                
                
                if(grid[curRow - 1][curCol - 1] > currentGreatest){
                    
                   currentGreatest = grid[curRow - 1][curCol - 1]; 
                                                      
                }
                
                if(grid[curRow - 1][curCol] > currentGreatest){
                    
                   currentGreatest = grid[curRow - 1][curCol]; 
                    
                }
                
                if(grid[curRow - 1][curCol + 1] > currentGreatest){
                    
                   currentGreatest = grid[curRow - 1][curCol + 1];  
                    
                }
                
                if(grid[curRow][curCol - 1] > currentGreatest){
                    
                   currentGreatest = grid[curRow][curCol - 1];  
                    
                }
                
                if(grid[curRow][curCol + 1] > currentGreatest){
                    
                   currentGreatest = grid[curRow][curCol + 1];
                    
                }
                
                if(grid[curRow + 1][curCol - 1] > currentGreatest){
                    
                   currentGreatest = grid[curRow + 1][curCol - 1];
                       
                }
                
                if(grid[curRow + 1][curCol] > currentGreatest){
                    
                   currentGreatest = grid[curRow + 1][curCol];
                    
                }
                
                if(grid[curRow + 1][curCol + 1] > currentGreatest){
                    
                   currentGreatest = grid[curRow + 1][curCol + 1];  
                    
                }
                                                      
                maxLocal[row][col] = currentGreatest;
                
            }
            
            System.out.println();
        }
        
        
        
        return maxLocal;
    }

	public static void main(String[] args) {
		
		
		int[][] array = new int[][]{
			{9,9,10,1},
			{5,6,2,6},
			{8,2,6,4},
			{6,2,2,2}
		};
		
		array = new int[][]{
			{1,1,1,1,1},
			{1,1,1,1,1},
			{1,1,2,1,1},
			{1,1,1,1,1},
			{1,1,1,1,1}
		};
		
		
		array = largestLocal(array);

		
		for(int runner = 0; runner < array.length; runner++) {
			for(int runner1 = 0; runner1 < array.length; runner1++) {
				System.out.print(array[runner][runner1]+" ");
			}
			
			System.out.println();
		}
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.get(0);
		list.add(0, 100);
		
	}

}
