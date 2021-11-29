package com.stack;

import java.util.Stack;

public class DailyTemperatures {
	
	
	/**
	 * 
	 * Given an array of integers temperatures represents the daily temperatures, return an 
	 * array answer such that answer[i] is the number of days you have to wait after the 
	 * ith day to get a warmer temperature. If there is no future day for 
	 * which this is possible, keep answer[i] == 0 instead.
	 * 
	 * 
	 * Steps:
	 * 	
	 * 	- Start with two counters at the begining of the array and increment the lead counter;
	 *  - If the lead counter is less than the holding counter increment a result by 1.
	 *  - When the lead counter is greater than the holding coutner put the result in an array to return. 
	 * 
	 * @param temperatures
	 * @return
	 * 
	 */
	public static  int[] dailyTemperaturesOld(int[] temperatures) {
        
		int[] days = new int[temperatures.length];
		
		int result = 0;
		for(int holdingIndex = 0; holdingIndex < temperatures.length; holdingIndex++) {
			
			result = 0;
			for(int leadingIndex = holdingIndex + 1; leadingIndex < temperatures.length ; leadingIndex++) {
				if(temperatures[holdingIndex] < temperatures[leadingIndex]) {
					result++;
					days[holdingIndex] = result;
					result = 0;
					break;
				}else {
					result++;
					
				}
				
			}
			
		}
		
		return days;
		
    }
	
	
	public static  int[] dailyTemperatures(int[] temperatures) {
		
		Stack<Integer> stack = new Stack<Integer>();
		int[] days = new int[temperatures.length];
		for(int runner = 0 ; runner <= temperatures.length - 1; runner++) {
			
			
			if(runner+1 <= temperatures.length - 1&&temperatures[runner] > temperatures[runner + 1]) {
 			int counter = 0;
			while(!stack.isEmpty()) {
				
				if(temperatures[runner] < stack.peek()) {
					stack.pop();
					counter++;
				}else {
					counter++;
					days[runner] = counter;
					counter = 0;
					stack.pop();
				}
			}
			
			
			int count = runner + 1;
			
			while(count < temperatures.length - 1 && temperatures[runner] > temperatures[count]) {
				stack.push(temperatures[count]);
				count++;
				days[runner] = stack.size( ) + 1;
			}
			
			}else if(runner+1 <= temperatures.length - 1&&temperatures[runner] < temperatures[runner + 1]) {
				
				
					days[runner] = 1;
				
				
			}
			

				
			
		}

		
		return days;
	}
	
	
	public static void main(String[] args) {
		int[] values = new int[]{73,74,75,71,69,72,76,73};
		//values = new int[]{30,40,50,60};
		int[] result = dailyTemperatures(values);
		
		for(int i: result) {
			System.out.println(i);
		}
	}

}
