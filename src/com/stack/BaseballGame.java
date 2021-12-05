package com.stack;

import java.util.Stack;

public class BaseballGame {
	
	 /*
	  * At the beginning of the game, you start with an empty record. You are given a list of strings ops, where ops[i] is the ith operation you must apply to the record and is one of the following:

    An integer x - Record a new score of x.
    "+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.
    "D" - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.
    "C" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.

Return the sum of all the scores on the record.	
	  */
	
	
	 public static int calPoints(String[] ops) {
		 
		 Stack<Integer> stack = new Stack<Integer>();
		 String val;
		 for(int runner = 0; runner < ops.length; runner++) {
			 val = ops[runner];
			 if(val.matches("-?\\d+(\\.\\d+)?")) {
				 
				 stack.push(Integer.parseInt(val));
				 
			 }else if(val.matches("D")) {
				 int topNumber = 2 * stack.peek(); 
				 stack.push(topNumber);
				 
			 }else if(val.matches("C")) {
				 
				 stack.pop();
				 
			 }else if(val.equals("+")) {
				 
				 int first = stack.pop();
				 int second = stack.pop();
				 
				 stack.push(second);
				 stack.push(first);
				 
				 stack.push(first + second);
			 }
			 
		 }
		 
		 int score = 0;
		 
		 while(!stack.isEmpty()) {
			 score += stack.pop();
		 }
		 
		 return score;
		 
	 }
	
	public static void main(String[] args) {
		String[] val = new String[] {"5","-2","4","C","D","9","+","+"};
		//27
		System.out.println(calPoints(val));

	}

}
