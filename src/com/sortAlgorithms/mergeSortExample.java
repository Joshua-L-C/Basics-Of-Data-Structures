package com.sortAlgorithms;

public class mergeSortExample {

	
	
	public static void main(String[] args) {
		
		
		/*
		 * Merge Sort
		 * 
		 * - Divide and conqure algorithm
		 * - recursive algorithm
		 * - two phase: Splitting and Merging
		 * - Splitting phase leads to faster sorting during the Merging
		 *   phase
		 * - Splitting is logical. We don't create new arrays.
		 * - O(n log2 n) 
		 */
		
		/* 
		 * Splitting Phase
		 * 
		 * - Start with an unsorted array.
		 * - Divide the array into two arrays which are unsorted.
		 * - The first array is the left array and the second array is the right array.
		 * - Split the left and right arrays into two arrays each.
		 * - Keep splitting until all the arrays have only one value in them  
		 *
		 */
		
		/* Merging Phase
		 * 
		 * - Merge every left/right pair of sibling arrays into a sorted array.
		 * - After the first merge, we'll have a bunch of 2 element sorted arrays.
		 * - Then merge those sorted arrays (left/right siblings) to end up with a 
		 *   bunch of 4 element sorted array
		 * - Not in place uses temporary arrays.
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
		
		mergeSortExample x = new mergeSortExample();
		
		x.mergeSort(intArray,0, intArray.length);
		
		System.out.println();
		System.out.println();
		
		for(int i = 0; i < intArray.length;i++) {
			System.out.println(intArray[i]);
		}
	}
	
	
	
	public void mergeSort(int [] input, int start, int end) {
		
		if(end - start < 2) {
			return;
		}
		
		int mid = (start  + end) / 2;
		
		mergeSort(input, start, mid);
		mergeSort(input, mid, end);
		
		
		merge(input, start, mid, end);		
	}
	
	
	public void merge(int [] input, int start, int mid, int end) {
		
		
//		if(input[mid - 1] <= input[mid]) {
//			return;
//		}
		
		int i = start;
		int j = mid;
		
		int tempIndex = 0;
		
		int[] temp = new int[end - start]; 
		
		while(i < mid && j < end) {
			//temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
			
			if(input[i] >= input[j]) {
				temp[tempIndex++] = input[i++];
			}else {
				temp[tempIndex++] = input[j++];
			}
		}
		

		System.arraycopy(input, i, input, start + tempIndex,mid - i);
		System.arraycopy(temp, 0, input, start, tempIndex);
		
		/*
		 * public static void arraycopy(Object source_arr, int sourcePos,
                            Object dest_arr, int destPos, int len)
		Parameters : 
		source_arr : array to be copied from
		sourcePos : starting position in source array from where to copy
		dest_arr : array to be copied in
		destPos : starting position in destination array, where to copy in
		len : total no. of components to be copied.
		 */
		
	}
}

