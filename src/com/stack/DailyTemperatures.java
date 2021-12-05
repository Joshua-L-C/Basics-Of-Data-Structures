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
	
	
	public static  int[] dailyTemperaturesBroken(int[] temperatures) {
		
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
	 * 	- Start with a pointer at the end of the array
	 *  - If its the first value simply push the value onto the stack.
	 *  - Increment the pointer.
	 *  - If the stack is not empty check the value at the top of the stack against the value at
	 *    current index of the array.
	 *  - if the value at the top of the stack is greater subtract its index vs the current positions index.
	 *  - if the value at the top of the stack is lesser pop and item off the top of the stack until there is
	 *    greater item. do the subtraction and push the current item on to the top of the stack.
	 *    
	 *   
	 * 
	 * @param temperatures
	 * @return
	 * 
	 */
    public static int[] dailyTemperaturesBackwards(int[] temperatures) {
	    Stack<Temps> stack = new Stack<Temps>();
		int[] days = new int[temperatures.length];
		
		
		for(int runner = temperatures.length - 1; runner >= 0; runner--) {
			
			//if this is the first day 
			if(runner == temperatures.length - 1) {
				stack.push(new Temps(runner,temperatures[runner]));
			
			}else {
				
				
				// if the current days temp is less than whats on top of the stack
				if(temperatures[runner] < stack.peek().value) {
					
					days[runner] = stack.peek().index - runner;
					stack.push(new Temps(runner,temperatures[runner]));
					
				// if the current days temp is greater than whats on top of the stack
				}else if(temperatures[runner] >= stack.peek().value) {
					
					//pop the item at the top of the stack until its empty or there is a greater value
					while(!stack.isEmpty() && temperatures[runner] >= stack.peek().value) {
						stack.pop();
					}
					
					
					//if the stack is not empty we have found a greater day so we subtract the current index
					// and add it to days. Other wise we have a new highest day.
					if(!stack.isEmpty()) {
						
						days[runner] = stack.peek().index - runner;
						stack.push(new Temps(runner,temperatures[runner]));
						
					
					}else if(stack.isEmpty()) {
						stack.push(new Temps(runner,temperatures[runner]));
					
					}
				}
				
				
				
			}
			
			
			
			
			
		}
		
		
		return days;
	}
    
    
    /**
     * Given an array of integers temperatures represents the daily temperatures, return an 
	 * array answer such that answer[i] is the number of days you have to wait after the 
	 * ith day to get a warmer temperature. If there is no future day for 
	 * which this is possible, keep answer[i] == 0 instead.
	 * 
	 * Steps:
	 * 
	 * 	- Start with a pointer at the front of the array.
	 *  - If its the first value of the array push it onto the stack
	 *  - If it is not create a value called holder that will hold the current value from the array
	 *  - If the stack is not empty and the holder value is greater than the value at the top of 
	 *    the stack.
	 *     
	 *    	 - Update the days array using the top of the stacks index to update the value with 
	 *    	   the holders index value - the stacks top index value.
	 *    
	 *  - do this until the stack is empty or the top of the stacks value is greater than holder.
	 *  - when that loop is complete push the current holder value onto the stack.
	 *    
	 *  - if the holder value is greater than the top of the stack push the holder value onto the top 
	 *    of the stack.
	 *    
	 * 
	 * 
     * @param temperatures
     * @return
     */
    public static  int[] dailyTemperatures(int[] temperatures) {
    	
    	Stack<Temps> stack = new Stack<Temps>();
    	int days[] = new int[temperatures.length];
    	
    	Temps holder;
    	
    	for(int runner = 0; runner < temperatures.length; runner++) {
    		
    		holder = new Temps(runner, temperatures[runner]);
    		
    		if(runner == 0) {
    			stack.push(holder);
    		}else {
    			
    			if(!stack.isEmpty() && stack.peek().value < holder.value) {
    				
    				while(!stack.isEmpty() && stack.peek().value < holder.value) {
    					days[stack.peek().index] = holder.index - stack.peek().index;
        				stack.pop();
    				}
    				
    				
    				stack.push(holder);	
    				
    				
    				
    			}else {
    				stack.push(holder);
    			}
    			
    			
    			
    		}
    		
    	}
    	
    	return days;
    }
	
	public static void main(String[] args) {
		int[] values = new int[]{89,62,70,58,47,47,46,76,100,70};
		//values = new int[]{30,40,50,60};73,74,75,71,69,72,76,73
		//values = new int[]{73,74,75,71,69,72,76,73};
		int[] result = dailyTemperatures(values);
		
		for(int i: result) {
			System.out.println(i);
		}
	}

}
