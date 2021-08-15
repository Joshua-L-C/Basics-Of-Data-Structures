package com.sortAlgorithms;

public class countingSortExample {

	public static void main(String[] args) {
		int[] intArray = new int[7];
		
		intArray[0] = 5;
		intArray[1] = 6;
		intArray[2] = 5;
		intArray[3] = 4;
		intArray[4] = 3;
		intArray[5] = 1;
		intArray[6] = 1;
		
		for(int i = 0; i < intArray.length;i++) {
			System.out.println(intArray[i]);
		}
		
		countingSort(intArray,1,6);
		
		System.out.println();
		System.out.println();
		
		
		for(int i = 0; i < intArray.length;i++) {
			System.out.println(intArray[i]);
		}
	}
	
	public static void countingSort(int[] input, int min, int max) {
		
		int[] countArray = new int[(max - min) + 1];
		
		for(int run = 0; run < input.length; run++) {
			countArray[input[run] - min]++;
		}
		
		
		int j = 0;
		for(int i = min; i <= max; i++) {
			while(countArray[i - min] > 0) {
				input[j++] = i;
				countArray[i - min]--;
			}
		}
		
	}

}
