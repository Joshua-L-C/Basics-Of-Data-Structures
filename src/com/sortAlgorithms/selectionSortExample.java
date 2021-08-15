package com.sortAlgorithms;

public class selectionSortExample {
	
	public static void main(String [] args) {
		
		int[] intArray = new int[7];
		
		intArray[0] = 20;
		intArray[1] = 35;
		intArray[2] = -15;
		intArray[3] = 7;
		intArray[4] = 55;
		intArray[5] = 1;
		intArray[6] = -22;
		
		for(int i = 0; i < intArray.length;i++) {
			System.out.println(intArray[i]);
		}
		
		/*
		 * Selection Sort
		 * 
		 * - In place algorithm
		 * - O(n^2) time complexity - quadratic
		 * - Doesnt require as much swapping as bubble sort
		 * - Unstable sort algorithm
		 */
		
		System.out.println();
		System.out.println("After Sort");
		System.out.println();
		
		
		for(int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){
			
			int largest = 0;
			
			for(int internalRunner = 1; internalRunner <= lastUnsortedIndex; internalRunner++) {
				
				if(intArray[internalRunner] > intArray[largest]) {
					largest = internalRunner;
				}
			}
			
			swap(intArray, largest,lastUnsortedIndex);
		}
		
		for(int i = 0; i < intArray.length;i++) {
			System.out.println(intArray[i]);
		}
	}
	
	public static void swap(int [] array, int first, int second) {
		
		if(first == second) {
			return;
		}
		
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
		
	}
}
