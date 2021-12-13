package com.stack;

import java.util.Stack;

public class ReversePolishNotation {
	
	
	public static int evalRPN(String[] tokens) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int first = 0;
		int second = 0;
		
		for(int runner = 0; runner < tokens.length; runner++) {
			String val = tokens[runner];
			
			if(val.matches("-?\\d+(\\.\\d+)?")) {
				stack.push(Integer.parseInt(val));
			}else if(val.equals("+")) {
				
				first = stack.pop();
				second = stack.pop();
				
				stack.push(first + second);
				
			}else if(val.equals("-")) {
				
				first = stack.pop();
				second = stack.pop();
				
				stack.push(first - second);
				
			}else if(val.equals("/")) {
				
				first = stack.pop();
				second = stack.pop();
				
				stack.push(second / first);
				
			}else if(val.equals("*")) {
				
				
				first = stack.pop();
				second = stack.pop();
				
				stack.push(first * second);
			}
			
		}
		
		
		
		return stack.peek();
		
		
		
	}
	
	public static void main(String[] args) {
		String[] vals = new String[]{"2","1","+","3","*"};
		//vals = new String[]{"4","13","5","/","+"};
		System.out.println(evalRPN(vals));
	}

}
