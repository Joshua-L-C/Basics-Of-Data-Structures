package com.sortAlgorithms;

public class insertionSortExample {
	
	public static void main(String [] args) {
		
		/*
		 * Sort Stability: the preservation of the relative 
		 * position of duplicate items. 
		 */
		
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
		 * Insertion Sort
		 * 
		 * - In-place algorithm
		 * - O(n^2) time complexity - quadratic 
		 * - Stable algorithm
		 */
		
		
		for(int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
			int newElement = intArray[firstUnsortedIndex];
			
			int i;
			
			for(i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
				intArray[i] = intArray[i - 1];
			}
			
			intArray[i] = newElement;
		}
		
		System.out.println();
		
		for(int i = 0; i < intArray.length;i++) {
			System.out.println(intArray[i]);
		}
	}
}
