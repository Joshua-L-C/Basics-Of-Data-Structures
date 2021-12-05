package com.stack;

import java.util.Stack;

public class ValidParentheses{
	
	
	/**
	 * Function: Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid
	 * 
	 *  
     *	Open brackets must be closed by the same type of brackets.
     *	Open brackets must be closed in the correct order.
     *
     * Steps: 
     * - Create a runner for the sting.
     * - If the current charater is either ( [ { push it on to the stack
     * - if the current charater is ) ] } pop the top value off the stack and compare it
     *  
     *
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
		
		String val;
		
		Stack<String> stack = new Stack<String>();
		
		for(int runner = 0; runner < s.length(); runner++) {
			val = s.charAt(runner) + "";
			
			if(val.equals("{") || val.equals("(") || val.equals("[")) {
				stack.push(val);
			}else {
				if(!stack.isEmpty() && stack.peek().equals(compareBrackets(val))) {
					stack.pop();
				}else{
					return false;
				}
				
			}
			
		}
		
		if(stack.isEmpty()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static String compareBrackets(String bracket) {
		
		
		if(bracket.equals("}")) {
			return "{";
		}else if(bracket.equals("]")) {
			return "[";
		}else if(bracket.equals(")")) {
			return "(";
		}
		return "";
		
	}
	

	public static void main(String[] args) {
		System.out.println(isValid("{()[]{}}"));

	}

}
