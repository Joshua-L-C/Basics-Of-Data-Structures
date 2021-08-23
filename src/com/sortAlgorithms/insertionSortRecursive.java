package com.sortAlgorithms;

public class insertionSortRecursive {

	
	public static void insertionSort(int [] intArray) {
		
		for(int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
			int newElement = intArray[firstUnsortedIndex];
			
			int i;
			
			for(i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
				intArray[i] = intArray[i - 1];
			}
			
			intArray[i] = newElement;
		}
	}
	
	public static void sort(int [] array,int x, int y) {
			
		
		
		if(x == -1) {
			System.out.println();
			
			y++;
			
			
			if(y == array.length - 1) {
				return;
			}
			
			x = array.length - 1;
		}
		 
		
		System.out.print(array[x]+ " ");
		System.out.println(y);
	
		
		
		
		x--;
		
		
		
		sort(array,x,y);
		
		
	}
	
	
	public static void main(String[] args) {
		
		int[] intArray = new int[7];
		
		intArray[0] = 20;
		intArray[1] = 35;
		intArray[2] = -15;
		intArray[3] = 7;
		intArray[4] = 55;
		intArray[5] = 1;
		intArray[6] = -22;

//		for(int i = 0; i < intArray.length;i++) {
//			System.out.println(intArray[i]);
//		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		sort(intArray,6,0);
		
//		for(int i = 0; i < intArray.length;i++) {
//			System.out.println(intArray[i]);
//		}

	}

}
