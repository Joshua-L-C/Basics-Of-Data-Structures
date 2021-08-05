package com.arrays;

public class Test {

	public static void main(String[] args) {
		
		int[] intArray = new int[7];
		
		intArray[0] = 20;
		intArray[1] = 35;
		intArray[2] = -15;
		intArray[3] = 7;
		intArray[4] = 55;
		intArray[5] = 1;
		intArray[6] = 22;
		
		for(int i = 0; i < intArray.length;i++) {
			System.out.println(intArray[i]);
		}
		
		//Calculation of Arrays memory address
		/*
		 * If an array starts at memory address x and the size of each 
		 * element in the array is y, we can calculate the memory address of the 
		 * ith element by using the following expression x + i * y;
		 */
		
		
	}

}
