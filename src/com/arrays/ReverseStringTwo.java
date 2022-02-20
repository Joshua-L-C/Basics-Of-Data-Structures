package com.arrays;

public class ReverseStringTwo {
	
	
	/*
	 * Steps:
	 * - Get the string and convert it to a charArray
	 * - call a sub routine reverse that starts at 0 to k - 1
	 * - reverse the string in the subroutine.
	 */
    public static String reverseStr(String s, int k) {
    	
    	char[] word = s.toCharArray();
    	
    	for(int runner = 0; runner < word.length; runner += (2 * k)) {
    		reverse(word,runner,(runner + k) - 1);
    	}
    	
    	for(char x: word) {
    		System.out.print(x);
    	}
    	
    	return "";
        //return new String(word);
    }
    
    private static void reverse(char[] word, int start, int end) {
    	
    	if(end > word.length - 1) {
    		end = word.length - 1;
    	}
    	
    	while(start < end) {
    		char x = word[start];
    		word[start] = word[end];
    		word[end] = x;
    		
    		
    		start++;
    		end--;
    	}
    	
    	return;
    }
	
	public static void main(String[] args) {
		
		System.out.println(reverseStr("abcdefgh",2));

	}

}
