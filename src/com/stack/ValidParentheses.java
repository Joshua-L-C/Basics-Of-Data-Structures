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
	
	public static String removeOuterParentheses(String s) {
        
        int leftBrack = 0;
        int rightBrack = 0;
        int stringStartIndex = 0;
        String decomp = "";
        
        
        for(int runner = 0; runner < s.length(); runner++){
            
            
            if((s.charAt(runner)+"").equals("(")){
               leftBrack += 1;
            }else if((s.charAt(runner)+"").equals(")")){
               rightBrack += 1;
                
                if(leftBrack == rightBrack){
                    decomp += s.substring(stringStartIndex + 1,runner);
                    leftBrack = 0;
                    rightBrack = 0;
                    stringStartIndex = runner + 1;
                    
                }
                
                
            }
            
        }
        
        
        
        return decomp;
    }
	
	
    public static int strStr(String haystack, String needle) {
        
        if(haystack.equals("") && needle.equals("")){
            return 0;
        }
        
        if(haystack.length() < needle.length()){
            return -1;
        }
        
        if(needle.equals("")){
            return 0;
        }
        
        for(int runner = 0,needleIndex = 0 ; runner <= haystack.length() - 1; runner++){
            
            if(haystack.length() - runner < needle.length()){
                return -1;
            }
            
            if(haystack.charAt(runner) == needle.charAt(needleIndex)){
                int start = runner;
                for(int checker = runner ; needleIndex <= needle.length() - 1 ; checker++,needleIndex++){
                	
                    if(haystack.charAt(checker) != needle.charAt(needleIndex)){
                        
                        needleIndex = 0;
                        break;
                    }
                }
                
                if(needleIndex != 0)
                return start;
            }
            
        }
        
        return -1;
        
    }
    
	    /*  
	    Steps
	    - Find the first index of the needle by using index of
	    - if not found return -1
	    - If found start a pointer to index of haystack and first index of the needle
	    - If the needle is larger than the haystack return -1
	    - loop through to the end of the needle and if there were no values that difference return 
	      the index you started at.
	    - else break out of the loop and cut the haystack from the index that you found the diference to the end of the haystack
	     */
    
	public static int strStrSecond(String haystack, String needle) {
	    
	    if(haystack.equals("") && needle.equals("")){
	        return 0;
	    }
	    
	    if(haystack.length() < needle.length()){
	        return -1;
	    }
	    
	    if(needle.equals("")){
	        return 0;
	    }
	    
	    int start = -1;
	    int holder  = 0;
	    for(int runner = 0,needleIndex = 0 ; runner <= haystack.length() - 1; runner++){
            
            
            
            if(haystack.charAt(runner) == needle.charAt(needleIndex)){
            	
            	if(runner + (needle.length() - 1) + 1 > haystack.length()) {
            		return -1;
            	}
            	
            	String check = haystack.substring(runner, runner + (needle.length() - 1) + 1);
            	
            	if(check.equals(needle)) {
            		start = runner;
            		return start;
            	}
            	
            }
            
         
            
            
            
        }
        
        return start;
	    
	
	    
	}

	public static void main(String[] args) {
		//System.out.println(isValid("{()[]{}}"));
		
		System.out.println(removeOuterParentheses("(()()())(())"));
		
		//System.out.println(strStr("mississippi","issip"));
		//System.out.println(strStrSecond("mississippi","issip"));
				
		
		
		

		
	}

}
