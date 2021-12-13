package com.stack;

import java.util.Stack;

public class MaxNestingDepth {
	
	
	/**
	 * Find the greatest nested depth of () parenthesis
	 * () = 1
	 * (()) = 2
	 * ((2 * (2 * 3))) = 3
	 * 
	 * @param s
	 * @return
	 */
	public static int maxDepth(String s) {
		
		Stack<String> stack = new Stack<String>();
		int greatest = 0;
		
		
		for(int runner = 0; runner < s.length(); runner++) {
			
			
			if(s.charAt(runner) == '(') {
				stack.push("(");
				
				if(stack.size() > greatest) {
					greatest = stack.size();
				}
			}else if(s.charAt(runner) == ')') {
				stack.pop();
			}
			
			
		}
		
		
		return greatest;
	}
	
	public static void main(String[] args) {
		System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));

	}

}
