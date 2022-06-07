package com.arrays;

public class Search2DMatrix {
	
	
	public static boolean searchMatrix(int[][] matrix, int target) {
        
		System.out.println("Height: " + matrix.length);
		System.out.println("Width: " + matrix[0].length);
		int width = matrix[0].length - 1;
		int rowToCheck = -1;
		
		int currentIndex = 0;
		int length = matrix.length - 1;
		
		while(currentIndex <= length) {
			
			int checkingIndex = currentIndex + (length - currentIndex) / 2;
			
			if(matrix[checkingIndex][0] <= target && target <= matrix[checkingIndex][width] ) {
			     System.out.println("Found the row its in: " + checkingIndex);
			     rowToCheck = checkingIndex;
			     break;
			}
			
			
			if(matrix[checkingIndex][width] < target) {
				currentIndex = checkingIndex + 1;
			}
			
			if(matrix[checkingIndex][width] > target) {
				length = checkingIndex - 1;
			}
			
			
//			if(target < matrix[checkingIndex][0]) {
//				length = checkingIndex - 1;
//				
//			}
//			
//			if(target > matrix[checkingIndex][width]) {
//				currentIndex = checkingIndex + 1;
//			}
			
		}
		
		
		if(rowToCheck != -1) {
			
			currentIndex = 0;
			length = matrix[rowToCheck].length - 1;
			
			
			while(currentIndex <= length) {
				
				int checkingIndex = currentIndex + (length - currentIndex) / 2;
				
				if(matrix[rowToCheck][checkingIndex] == target) {
					return true;
				}
				
				if(matrix[rowToCheck][checkingIndex] < target) {
					currentIndex = checkingIndex + 1;
				}
				
				if(matrix[rowToCheck][checkingIndex] > target) {
					length = checkingIndex - 1;
				}
				
			}
			
			
			
		}
		
		
		
		
		return false;
    }
	
	
	public static boolean searchMatrix2(int[][] matrix, int target) {
		
		int southWestCorner = matrix.length - 1;
		int northEastCorner = matrix[southWestCorner].length - 1;
		
		System.out.println("South West Corner: " + southWestCorner);
		System.out.println("North East Corner: " + northEastCorner);
		
		
		int southWestStop = southWestCorner;
		int northEastStop = northEastCorner;
		
		if(southWestCorner == 0 && northEastCorner == 0) {
			return matrix[0][0] == target;
		}
		
		
		if(southWestCorner != 0 && northEastCorner == 0) {
			
			int length = (matrix.length) - 1;
			int startingIndex = 0;
			
			
			while(startingIndex <= length) {
				
				int checkingIndex = startingIndex + (length - startingIndex) / 2;
				
				if(matrix[checkingIndex][0] == target) {
					return true;
				}
				
				if(matrix[checkingIndex][0] < target) {
					startingIndex = checkingIndex + 1;
				}else if(matrix[checkingIndex][0] > target) {
					length = checkingIndex - 1;
				}
			}
			
			return false;
			
		}else if(southWestCorner == 0 && northEastCorner != 0) {
			
			boolean val = false;
			//for(int runner = northEastCorner; runner >= 0;runner--) {
				val = binarySearch(matrix[0],0,target);
			//}
			
			
			return val;
		}
		
		
		
		
		
		
		for(int runnerOne = southWestCorner, runnerTwo = northEastCorner ; runnerOne != 0 || runnerTwo != 0;) {
			
			System.out.println("Corner: " + matrix[runnerOne][runnerTwo]);
			System.out.println("SCorner: " + matrix[southWestCorner][runnerTwo]);
			System.out.println("NCorner: " + matrix[runnerOne][northEastCorner]);
			
			
			if(matrix[runnerOne][runnerTwo] == target) {
				
				return true;
				
			}
			
			if(matrix[runnerOne][runnerTwo] <= target && matrix[southWestCorner][runnerTwo] >= target) {
				
				int length = (matrix.length) - 1;
				//int length = (matrix.length) - runnerTwo;
				int startingIndex = runnerOne;
				
				
				while(startingIndex <= length) {
					
					int checkingIndex = startingIndex + (length - startingIndex) / 2;
					
					if(matrix[checkingIndex][runnerTwo] == target) {
						return true;
					}
					
					if(matrix[checkingIndex][runnerTwo] < target) {
						startingIndex = checkingIndex + 1;
					}else if(matrix[checkingIndex][runnerTwo] > target) {
						length = checkingIndex - 1;
					}
				}
				
			}
			
			if(matrix[runnerOne][runnerTwo] <= target && matrix[runnerOne][northEastCorner] >= target) {
			
				if(binarySearch(matrix[runnerOne],runnerOne, target)) {
					return true;
				}
					
			}
			
			
			
			if(runnerOne - 1 != -1) {
				
				northEastStop = runnerOne;
				runnerOne--;
			}else {
				break;
			}
			
			if(runnerTwo - 1 != -1) {
				southWestStop = runnerTwo;
				runnerTwo--;
			}else {
				break;
			}
			
		}
		
		
		southWestStop--;
		northEastStop--;
		
		System.out.println("SW "+southWestStop);
		System.out.println("NE "+northEastStop);	
		
		if(southWestStop == 0 && northEastStop == 0) {
			
			int length = (matrix.length) - 1;
			int startingIndex = 0;
			
			
			while(startingIndex <= length) {
				
				int checkingIndex = startingIndex + (length - startingIndex) / 2;
				
				if(matrix[checkingIndex][0] == target) {
					return true;
				}
				
				if(matrix[checkingIndex][0] < target) {
					startingIndex = checkingIndex + 1;
				}else if(matrix[checkingIndex][0] > target) {
					length = checkingIndex - 1;
				}
			}
			
		    boolean val = binarySearch(matrix[0],0,target);
			
		    return val;
			
			
			
		}else if(southWestStop != 0 && northEastStop == 0) {
			
			
			
			for(int runner = southWestStop; runner >= 0;runner--) {
				
				int length = (matrix.length) -1;
				int startingIndex = 0;
				
				while(startingIndex <= length) {
					
					int checkingIndex = startingIndex + (length - startingIndex) / 2;
					
					if(matrix[checkingIndex][runner] == target) {
						return true;
					}
					
					if(matrix[checkingIndex][runner] < target) {
						startingIndex = checkingIndex + 1;
					}else if(matrix[checkingIndex][runner] > target) {
						length = checkingIndex - 1;
					}
				}
			}
			
		}else if(southWestStop == 0 && northEastStop != 0) {
			
			boolean val = false;
			for(int runner = northEastStop; runner >= 0;runner--) {
				val = binarySearch(matrix[runner],0,target);
			}
			
			
			return val;
		}
		
		
	
		return false;
	}
	
	
	
	public static boolean searchMatrix3(int[][] matrix, int target) {
		
		int southWestCorner = matrix.length - 1;
		int northEastCorner = matrix[southWestCorner].length - 1;
		
		System.out.println("South West Corner: " + southWestCorner);
		System.out.println("North East Corner: " + northEastCorner);
		
		
		int southWestStop = southWestCorner;
		int northEastStop = northEastCorner;
		
		if(southWestCorner == 0 && northEastCorner == 0) {
			return matrix[0][0] == target;
		}
		
		
		if(southWestCorner != 0 && northEastCorner == 0) {
			
			int length = (matrix.length) - 1;
			int startingIndex = 0;
			
			
			while(startingIndex <= length) {
				
				int checkingIndex = startingIndex + (length - startingIndex) / 2;
				
				if(matrix[checkingIndex][0] == target) {
					return true;
				}
				
				if(matrix[checkingIndex][0] < target) {
					startingIndex = checkingIndex + 1;
				}else if(matrix[checkingIndex][0] > target) {
					length = checkingIndex - 1;
				}
			}
			
			return false;
			
		}else if(southWestCorner == 0 && northEastCorner != 0) {
			
			boolean val = false;
			//for(int runner = northEastCorner; runner >= 0;runner--) {
				val = binarySearch(matrix[0],0,target);
			//}
			
			
			return val;
		}
		
		
		for(int runner = 0; runner < matrix.length; runner++) {
			if(binarySearch(matrix[runner],0,target)) {
				return true;
			}
		}
		
		
		
		
		
		return false;
	}
	
	
	
	public static boolean binarySearch(int[] array, int startingIndex, int target) {
		
		int length = array.length - 1;
		
		while(startingIndex <= length) {
			
			int checkingIndex = startingIndex + (length - startingIndex) / 2;
			
			if(array[checkingIndex] == target) {
				return true;
			}
			
			if(array[checkingIndex] < target) {
				startingIndex = checkingIndex + 1;
			}else if(array[checkingIndex] > target) {
				length = checkingIndex - 1;
			}
		}
		
		
		return false;
	}
	
	public static void main(String[] args) {
		
		//int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		//int[][] matrix = new int[][]{{1,3},{10,11},{23,30},{40,50}};
		//int[][] matrix = new int[][] {{-5,-2,-1}};
		//int[][] matrix = new int[][] {{-5},{-2},{-1}};
		//int[][] matrix = new int[][] {{}};
		//int[][] matrix = new int[][] {{1,1}};
		//int[][] matrix = new int[][] {{1},{1}};
		//int[][] matrix = new int[][] {{1,3,5}};
		//int[][] matrix = new int[][] {{1},{3},{5}};
		//int[][] matrix = new int[][]{{1,4},{2,5}};
		
//		int[][] matrix = new int[][]
//				{
//					{1,3,5,7,9},
//					{2,4,6,8,10},
//					{11,13,15,17,19},
//					{12,14,16,18,20},
//					{21,22,23,24,25},
//				};
		
//		int[][] matrix = new int[][]
//				{
//					{2,3,8,11,15,19,20,20},
//					{4,8,12,15,18,21,25,28},
//					{5,8,17,20,22,23,30,34},
//					{6,12,18,20,25,25,34,34},
//					{9,14,21,24,25,29,39,40},
//				};
		
				int[][] matrix = new int[][]
						{
							{3,5,9,9,14},
							{7,8,11,15,15},
							{8,10,16,16,17}
						
						};
				
				
		System.out.println(searchMatrix2(matrix,12));

	}

}
