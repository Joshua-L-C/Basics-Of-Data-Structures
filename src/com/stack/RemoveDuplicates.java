package com.stack;

import java.util.Stack;

public class RemoveDuplicates {
	
	public class Index {
		public int indx;
		public String letter;
		
		public Index(int i, String l) {
			indx = i;
			letter = l;
		}
	}
	
	/**
	 * A duplicate removal consists of choosing two adjacent and equal letters and removing them.
	 * Return the final string after all such duplicate removals have been made.
	 * 
	 * Steps
	 *  - create a loop to go thorugh the stack starting at the second element. push the first element onto the stack
	 *  - if the stack is not empty and the element to be pushed onto the stack is the same as the element that is at the top of the stack pop it off
	 *  - otherwise push the element onto the stack. 
	 * @param s
	 * @return
	 */
    public static String removeDuplicates(String s) {
        Stack<String> stack = new Stack<String>();
        stack.push(s.charAt(0)+"");
        
        for(int runner = 1; runner < s.length(); runner++) {
        	if(!stack.isEmpty() && stack.peek().equals(s.charAt(runner)+"")) {
        		stack.pop();
        	}else {
        		stack.push(s.charAt(runner)+"");
        	}
        	
        }
        
        return stack.toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
    }
	
    /**
     * 
     * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
	 * Note that after backspacing an empty text, the text will continue empty.
     *
     * Steps
     * 	- create two stacks
     *  - create two loops to run through the two strings provided
     *  - for both strings if the stack is not empty and the character is # delete it off the stack
     *  - if the character is not equal to # push it onto the stack.
     *  - compare the two stacks at the end by using the toString method for each and if they are equal return true
     *  else return false.
     * 
     * @param s
     * @param t
     * @return
     */
    
    public static boolean backspaceCompare(String s, String t) {
        
    	Stack<Character> first = new Stack<Character>();
    	Stack<Character> second = new Stack<Character>();
    	
    	for(int runner = 0; runner < s.length(); runner++) {
    		if(!first.isEmpty() && s.charAt(runner) == '#') {
    			first.pop();
    		}else if(s.charAt(runner) != '#'){
    			first.push(s.charAt(runner));
    		}
    	}
    	
    	for(int runner = 0; runner < t.length(); runner++) {
    		if(!second.isEmpty() && t.charAt(runner) == '#') {
    			second.pop();
    		}else if(t.charAt(runner) != '#'){
    			second.push(t.charAt(runner));
    		}
    	}
    	
    	
    	return first.toString().equals(second.toString());
    }
    
    /**
     * The Leetcode file system keeps a log each time some user performs a change folder operation.
		The operations are described below:

    	"../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
    	"./" : Remain in the same folder.
    	"x/" : Move to the child folder named x (This folder is guaranteed to always exist).

		You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.
		The file system starts in the main folder, then the operations in logs are performed.
		Return the minimum number of operations needed to go back to the main folder after the change folder operations.
		
		
		Steps:
		- create a loop to go through the log variable 
		- if the current element is ../ pop the folder name off the stack 
		- if the current element is X/ push the folder name onto the stack
		- if the current element is ./ do notthing
		- return the size of the stack
     * @param logs
     * @return
     */
    public static int minOperations(String[] logs) {
    	
    	Stack<String> stack = new Stack<String>();
    	
    	for(int runner = 0; runner < logs.length; runner++) {
    		
    		if(!stack.isEmpty() && logs[runner].equals("../")) {
    			stack.pop();
    		}else if(!stack.isEmpty() && logs[runner].equals("./")) {
    			
    		}else if(!logs[runner].equals("./")  && !logs[runner].equals("../")) {
    			stack.push(logs[runner].toString());
    		}
    	}
    	
    	return stack.size();
    }
    
	public static void main(String[] args) {
		System.out.println(removeDuplicates("abbaca"));
		System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
		//["./","../","./"]

		String[] logs = new String[]{"./","../","./"};
		System.out.println(minOperations(logs));

	}

}
