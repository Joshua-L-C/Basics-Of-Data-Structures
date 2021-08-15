package com.sortAlgorithms;

public class shellSortExample {

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
		 * Shell Sort
		 * - Variation of Insertion Sort
		 * - Insertion sort chooses which element to insert using a gap of 1
		 * - Shell Sort starts out using a larger gap value
		 * - As the algorithm runs the gap is reduced
		 * - Goal is to reduce the amount of shifting required.
		 * - As the algorithm progresses the gap is reduced.
		 * - The last gap value is always 1
		 * - A gap value of 1 is equivalent to insertion sort
		 * - So the algorithm does some preliminary work (using gap value greater
		 * 	 than 1) and then becomes insertion sort.
		 * - By the time we get to insertion sort the array has been partially
		 *   sorted so there's less shifting required.
		 * 
		 * Knuth Sequence
		 * - Gap is calculated using (3^K - 1)/2
		 * - We set k based on the length of the array.
		 * - We want the gap to be as close as possible to the length of the 
		 *   array we want to sort without being greater than the length.
		 *   
		 * - In place algorithm
		 * - Time complexity dependent on the selected Gap.
		 * - does not require as much shifting as insertion sort.
		 * - unstable algorithm 
		 * 
		 */
		
		
		for(int gap = intArray.length/2 ; gap > 0; gap /= 2) {
			
			for(int i = gap; i < intArray.length; i++) {
				int newElement = intArray[i];
				
				int j = i;
				
				while(j >= gap && intArray[j - gap] > newElement) {
					intArray[j] = intArray[j - gap];  
					j -= gap;
				}
				
				intArray[j] = newElement;
			}
			
			
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		for(int i = 0; i < intArray.length;i++) {
			System.out.println(intArray[i]);
		}
		

	}

}
