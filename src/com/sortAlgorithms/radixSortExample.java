package com.sortAlgorithms;

public class radixSortExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] radixArray = {4725 ,4586 ,1330 ,8792, 1594, 5729};
		
		
		for(int i = 0; i < radixArray.length;i++) {
			System.out.println(radixArray[i]);
		}
		
		/*
		 * Radix Sort
		 * - Makes assumptions about the data
		 * - Data must have the same radix and width
		 * 
		 * 	Radix: the number of unique digits or values (eg charaters)
		 *  that a numbering system or an alphabet has. 
		 *  
		 *  Binary Radix: 2;
		 *  English Radix: 26;
		 *  
		 *  Width: how long the data is. 1234 = 4 
		 *  hello = 5 
		 *  
		 * - Because of the data must be integers or strings
		 * - Sort based on each individual digit or letter 
		 *   position
		 * - Start at the rightmost position (arr.length - 1)
		 * - Must use a stable sort algorithm at each stage (insertion sort)
		 * 
		 * - Counting sort is often used as the sort algorithm for radix sort
		 * - must be stable counting sort
		 * 
		 * - O(n) can achieve, thisbecause we are making assumptions abot the
		 *   data we're sorting.
		 * - Usually runs at O ( n log2 n) 
		 */
		
		
		radixSort(radixArray,10,4);
		
		System.out.println();
		System.out.println();
		
		for(int i = 0; i < radixArray.length;i++) {
			System.out.println(radixArray[i]);
		}
	}
	
	public static void radixSort(int[] input, int radix, int width) {
		
		for(int i = 0; i < width; i++) {
			radixSingleSort(input,i,radix);
		}
	}
	
	public static void radixSingleSort(int [] input,int position, int radix) {
		
		int numItems = input.length;
		
		int[] countArray = new int[radix];
		
		for(int value: input) {
			countArray[getDigit(position,value,radix)]++;
		}
		
		
		for(int j = 1; j < radix; j++) {
			countArray[j] += countArray[j - 1];
		}
		
		
		int[] temp = new int[numItems];
		
		for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
			temp[--countArray[getDigit(position,input[tempIndex],radix)]] = input[tempIndex];
		}
		
		for(int tempIndex = 0; tempIndex < numItems; tempIndex++) {
			input[tempIndex] = temp[tempIndex]; 
		}
	}
	
	public static int getDigit(int position, int value, int radix) {
		return value / (int) Math.pow(radix, position) % radix;
	}
}
