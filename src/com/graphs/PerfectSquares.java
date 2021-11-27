package com.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {

	
	
	/*	Function: Given an integer n, return the least number of perfect square numbers that sum to n.
	 * 
	 * 	Steps:
	 *  
	 * 	- Initialize a list and create a loop starting at 1.
	 *  - Each time in the list multiply the running number by itself.
	 *  - If n mod the running number is 0 
	 *  	- divide n by the running number and retun the answer
	 *  - If n mod the running number is not 0 and the running number is less than n 
	 *   	- add it to the list.
	 *  - If the running number is greater than n break out of the loop
	 *  
	 *  - initialize a result variable
	 * 	- Starting from the end of the list in a loop with a counter counting down from the end. 
	 * 	- Take the value at the counter and divide it by n
	 *  - Take the value at the counter and mod it by n
	 * 	
	 * 	- If modding is zero 
	 * 		- return the n divided by the counter plus the result variable. 
	 * 
	 *  - If modding is not zero
	 *  	- asign the modded result to n.
	 *  	- add 1 to a result variable
	 *  
	 *  - if the modding result is between 1 - 3 
	 *		- add 1 - 3 to the result variable respectively and return it.  	 
	 *  
	 *  - decrease the counter until the value is less than n and repeat the above steps.
	 * 
	 * 
	 * 	Cases:
	 *  14 = 9 + 4 + 1
	 * 	76 = 36 + 36 + 4
	 * 
	 * 
	 * 
	 */
	
	
	
	public static int numSquaresFirstAttempt(int n) {
		
		//Queue<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		int potentialResult = -1;
		
		for(int runner = 1; runner * runner <= n; runner++) {
			
			//This doesnt work because what happens if you have a smaller multiple
			if(n % (runner * runner) == 0 && runner != 1) {
				 potentialResult = n / (runner * runner);
			}
			
			list.add(runner * runner);
			
		}
		
		//list.forEach((numb) -> System.out.println(numb));
		
		int result = 0;
		int workingNumber = n;
		
		System.out.println("Working Number: " + workingNumber);
		for(int runner = list.size() - 1; runner >= 0; runner--) {
			
			if(list.get(runner) <= workingNumber) {
				
				System.out.println("Number: " + list.get(runner));
				
				
				//No need for this because finding the multiple of 1 takes care of the remaining ends
				
//				if((workingNumber % list.get(runner)) < 4 && (workingNumber % list.get(runner)) > 0) {
//					return result += (workingNumber % list.get(runner));
//				}
				
				result += (workingNumber / list.get(runner) );
				
				System.out.println("Result: " + result);
				
				workingNumber = workingNumber % list.get(runner);
				System.out.println("Working Number: " + workingNumber);
				System.out.println();
			}
			 
			
			
			
		}
		
		
		if(potentialResult != -1 && potentialResult <= result) {
			System.out.println("Returned Potential: " + potentialResult);
			return potentialResult;
		}
		
        return result;
    }
	
	public static void main(String[] args) {
		
		System.out.println(numSquaresFirstAttempt(19));
	}

}
