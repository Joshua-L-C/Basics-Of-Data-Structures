package com.stack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Stack;

public class MonotonicExamples {
	
	public static String monotonicIncreasingForward(int[] values) {
		
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int counter = 0; counter < values.length; counter++) {
			
			if(counter == 0) {
				stack.push(values[counter]);
			}else {
				
				if(!stack.isEmpty() && stack.peek() > values[counter]) {
					
					while(!stack.isEmpty() && stack.peek() >= values[counter]) {
						stack.pop();
					}
					
					stack.push(values[counter]);
				}else {
					stack.push(values[counter]);
				}
				
				
				
				
			}
			
		}
		
		
		return stack.toString();
		
	}
	
	
	public static String monotonicDecreasingForward(int[] values) {
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int counter = 0; counter < values.length; counter++) {
			
			if(counter == 0) {
				stack.push(values[counter]);
			}else {
				
				if(!stack.isEmpty() && stack.peek() < values[counter]) {
					
					while(!stack.isEmpty() && stack.peek() <= values[counter]) {
						stack.pop();
					}
					
					stack.push(values[counter]);
				}else {
					stack.push(values[counter]);
				}
				
				
				
				
			}
			
		}
		
		
		return stack.toString();
	}
	
	public static String monotonicIncreasingBackward(int[] values) {
		
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int counter = values.length - 1; counter >= 0; counter--) {
			
			if(counter == values.length - 1) {
				stack.push(values[counter]);
			}else {
				
				if(!stack.isEmpty() && stack.peek() > values[counter]) {
					
					while(!stack.isEmpty() && stack.peek() >= values[counter]) {
						stack.pop();
					}
					
					stack.push(values[counter]);
				}else {
					stack.push(values[counter]);
				}
				
				
				
				
			}
			
		}
		
		
		return stack.toString();
		
	}
	
	
	public static String monotonicDecreasingBackward(int[] values) {
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int counter = values.length - 1; counter >= 0; counter--) {
			
			if(counter == values.length - 1) {
				stack.push(values[counter]);
			}else {
				
				if(!stack.isEmpty() && stack.peek() < values[counter]) {
					
					while(!stack.isEmpty() && stack.peek() <= values[counter]) {
						stack.pop();
					}
					
					stack.push(values[counter]);
				}else {
					stack.push(values[counter]);
				}
				
				
				
				
			}
			
		}
		
		
		return stack.toString();
	}

	public static void main(String[] args) {
		 try {
		     
		      
		      Random rand = new Random();
		      
		      File file = new File("C:\\Users\\Reginald\\eclipse-workspace\\Basics-Of-Data-Structures\\src\\com\\stack\\MonotonicArrays.txt");
		      FileWriter fr = new FileWriter(file, true);
		      BufferedWriter br = new BufferedWriter(fr);
		      
		      br.write("\n");
		      br.write("\n");
		      int[] testing = new int[10];
		      for(int runner = 0; runner < 10; runner++) {
		    	  testing[runner] = rand.nextInt((100 - 0) + 1) + 0;
		    	  br.write(testing[runner] + " ");
		      }
		      
		      //int[] testing = {14, 89, 76, 89, 55, 21, 56, 43, 72, 52 };
		      //int[] testing = {1, 3, 4, 2};
		      
		      br.write("\n");
		      br.write("Monotonic Increasing Forwards: " + monotonicIncreasingForward(testing));
		      br.write("\n");
		      br.write("Monotonic Decreasing Forwards: " + monotonicDecreasingForward(testing));
		      br.write("\n");
		      br.write("Monotonic Increasing Backwards: " + monotonicIncreasingBackward(testing));
		      br.write("\n");
		      br.write("Monotonic Decreasing Backwards: " + monotonicDecreasingBackward(testing));
		      
		      
		      

		      br.close();
		      fr.close();
		      
		      
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		

	}

}

