package com.sortAlgorithms;

public class bubbleSortExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		 * Bubble Sort
		 * 
		 * In - Place Algorithm 
		 * O(n^2) time complexity 
		 * Algorithm degrades quickly
		 */
		
		System.out.println();
		System.out.println("After Sort");
		System.out.println();
		
		for(int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			for(int i = 0; i < lastUnsortedIndex; i++) {
				
				if(intArray[i] > intArray[i + 1]) {
					swap(intArray, i, i+1);
				}
				
			}
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
