package com.arrays;

public class Words {
	
	/*
	 * Steps:
	 * 1) Begin a counter at the begin of the word called left pointer
	 * 2) Increase another pointer called right pointer until it reaches a space.
	 * 3) When it reaches a space go into a loop that will do the reversal 
	 * 4) Record left and right pointers locations in separate variables. 
	 * 5) Start the loop moving the copyies of the left and right pointer towards each other 
	 *    swapping values in the string.   
	 * 
	 */
	public static String reverseWords(String s) {
        
        char[] word = s.toCharArray();
        
        int currentPoint = 0;
        int endPoint = 0;
        for(int runner = 0; runner < word.length; runner++){
            
            if(runner == word.length - 1 || word[runner] == ' ' ){
                //System.out.println(word[currentPoint]);
            	
            	if(runner  == word.length - 1) {
            		endPoint = runner; 
            	}else {
            		endPoint = runner - 1;
            	}
            	
                
                //System.out.println(word[endPoint]);
                
                
                int leftPointer = currentPoint;
                int rightPointer = endPoint;
                
                while(leftPointer < rightPointer) {
                	char holder = word[leftPointer];
                	word[leftPointer] = word[rightPointer];
                	word[rightPointer] = holder;
                	
                	leftPointer++;
                	rightPointer--;
                }
                
                currentPoint = runner + 1;
                
            }
            
        }
        
//        System.out.println(word[currentPoint]);
//        System.out.println(word[word.length - 1]);
        
        return new String(word);
    }

	public static void main(String[] args) {
		
		System.out.println(reverseWords("Let's take LeetCode contest"));
		//System.out.println(reverseWords("I love u"));

	}

}
