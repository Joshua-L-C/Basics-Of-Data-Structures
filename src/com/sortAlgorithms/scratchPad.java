package com.sortAlgorithms;

public class scratchPad {
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
		System.out.println();
		System.out.println();
		System.out.println();
		
		int[] intArray2 = new int[7];
		
		intArray2[0] = 99;
		intArray2[1] = 98;
		intArray2[2] = 97;
		intArray2[3] = 96;
		intArray2[4] = 95;
		intArray2[5] = 94;
		intArray2[6] = 93;
		
		for(int i = 0; i < intArray2.length;i++) {
			System.out.println(intArray2[i]);
		}
		
		
		System.out.println();
		System.out.println();
		
		System.arraycopy(intArray, 3, intArray2, 4, 2);
		
		
		for(int i = 0; i < intArray2.length;i++) {
			System.out.println(intArray2[i]);
		}
	}
}
