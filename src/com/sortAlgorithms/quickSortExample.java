package com.sortAlgorithms;

public class quickSortExample {

	public static void main(String[] args) {
		
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
		 * Quick Sort 
		 * - divide and conquer algorithm
		 * - recursive algorithm
		 * - uses a pivot element to partition the array into 
		 * 	 two parts
		 * - elements < pivot to its left and > to its right
		 * - pivot will then be in its correct sorted position.
		 * - process is now repeated for the left array and right array
		 * - Eventually every element has ben the pivot so every element
		 *   will be in its correct sorted position
		 * - As with merge sort we'll end up partitioning the array 
		 *   into a series of 1 element arrays
		 * - does this in-place.
		 * - O(n log2 n)
		 */
		System.out.println();
		System.out.println();
		
		quickSort(intArray,0,intArray.length);
		
		
		for(int i = 0; i < intArray.length;i++) {
			System.out.println(intArray[i]);
		}
	}
	
	public static void quickSort(int [] input, int start, int end) {
		
		if(end - start < 2) {
			return;
		}
		
		int pivotIndex = partition(input,start,end);
		
		quickSort(input,start, pivotIndex);
		quickSort(input,pivotIndex + 1, end);
		
	}
	
	public static int partition(int [] input, int start, int end) {
		
		int pivot = input[start];
		
		int leftPointer = start;
		int rightPointer = end;
		
		while(leftPointer < rightPointer) {
			
			//Loop used to decrement rightPointer until a great leftPointer value
			//is found or until the rightPointer crosses over leftPointer
			while(leftPointer < rightPointer && input[--rightPointer] >= pivot) {}
			
			if(leftPointer < rightPointer) {
				input[leftPointer] = input[rightPointer];
			}
			
			//Loop used to increment leftPointer until a lesser rightPointer value
			//is found or until the leftPointer crosses over rightPointer
			while(leftPointer < rightPointer && input[++leftPointer] <= pivot) {}
			
			if(leftPointer < rightPointer) {
				input[rightPointer] = input[leftPointer];
			}
		}
		
		
		
		input[rightPointer] = pivot;
		return rightPointer;
	}

}
