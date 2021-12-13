package com.stack;

import java.util.Hashtable;
import java.util.Stack;

public class NextGreaterElement {
	
	/**
	 * Function: for all the given values in nums1 the position of each value in num2
	 * and return the value that is greater than it to the right of the value in num2 
	 * if there is no greater value return -1
	 * 
	 * Steps:
	 * 	- pick the first element of nums1.
	 *  - loop through nums2 until you find it. 
	 *  - when you do create a new loop that will go to the end of the array searching for 
	 *    a greater value.
	 *  - if it finds a greater value update the value in answers to the greater value found.
	 *  - if it does not find a greater value update it to -1
	 *  - break out of this loop and continue to the next number.
	 * 	
	 * 
	 * Cases:
	 * 
	 * 
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	
    public static int[] nextGreaterElement2Loops(int[] nums1, int[] nums2) {
        
    	int[] ans = new int[nums1.length];
    	
    	
    	for(int runner = 0; runner < nums1.length; runner++) {
    		
    		for(int runner2 = 0; runner2 < nums2.length ; runner2++) {
    			
    			
    			if(nums1[runner] == nums2[runner2]) {
    				
    				
    				for(int find = runner2 + 1; find < nums2.length; find++) {
    					if(nums1[runner] < nums2[find]) {
    						ans[runner] = nums2[find];
    						break;
    					}
    				}
    				
    			}
    			
    			if(ans[runner] == 0) {
    				ans[runner] = -1;
    			}else {
    				break;
    			}
    			
    		}
    		
    	}
    	
    	return ans;
    	
    }
    
    
    /*
     * Function: for all the given values in nums1 the position of each value in num2
	 * and return the value that is greater than it to the right of the value in num2 
	 * if there is no greater value return -1
     * 
     * 
     * Steps:
     * 	- Create a Hash Table
     *  - Create a double for loops to cycle through the nums2 array
     *  - The inner for loop with start at +1 the outer value
     *  - When you find a number that is greater than the current number or outer for 
     *    loop number put it on the hash table.
     *  - If you dont find a greater number put -1;
     *  - then for all the numbers in nums1 look it up in the hash table.
     * 
     */
    
    
    public static int[] nextGreaterElementHashTable(int[] nums1, int[] nums2) {
    	
    	Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
    	
    	for(int runner = 0; runner < nums2.length; runner++) {
    		
    		int numb = -1;
    		
    		for(int runner2 = runner + 1; runner2 < nums2.length;runner2++) {
    			
    			if(nums2[runner] < nums2[runner2]) {
    				numb = nums2[runner2];
    				break;
    			}
    			
    		}
    		
    		table.put(nums2[runner], numb);
    	}
    
    	int[] ans = new int[nums1.length];
    	
    	for(int run = 0; run < ans.length; run++) {
    		ans[run] = table.get(nums1[run]);
    	}
    	
    	return ans;
    	
    }
    
    
    /**
     * Function: for all the given values in nums1 the position of each value in num2
	 * and return the value that is greater than it to the right of the value in num2 
	 * if there is no greater value return -1
     * 
     * Steps:
     * 	- Create a stack object
     *  - Start a loop for the first element in the second array nums2
     *  - If the first number in the loop push it onto the stack.
     *  - If the number is greater than the number at the top of the stack keep poping elements off 
     *    until they are not greater.
     *  - for each element that is being popped off check it against the elements in num1 and if they are the same
     *   up date the current element with what we are pushing onto the stack 
     * 
     * 
     * @param args
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	int[] ans = new int[nums1.length];
    	for(int indx = 0; indx < nums2.length; indx++) {
    		
    		if(indx == 0) {
    			stack.push(nums2[indx]);
    		}else {
    			
    			if(!stack.isEmpty() && stack.peek() < nums2[indx]) {
    				
    				while(!stack.isEmpty() && stack.peek() < nums2[indx]) {
    					
    					int val = stack.pop();
    					
    					for(int runner = 0; runner < nums1.length; runner++) {
    						if(val == nums1[runner]) {
    							ans[runner] = nums2[indx];
    						}
    					}
    					
    				}
    				
    				stack.push(nums2[indx]);
    			}else {
    				stack.push(nums2[indx]);
    			}
    			
    		}
    		
    	}
    	
    	
    	for(int runner = 0 ; runner < nums1.length; runner++) {
			if(ans[runner] == 0) {
				ans[runner] = -1;
			}
		}
    	
    	
    	return ans;
    }
    
    
	
	public static void main(String[] args) {
		int[] nums1 = new int[]{4,1,2};
				 
		int[] nums2 = new int[] {1,3,4,2};

		
		int[] ans = nextGreaterElement(nums1,nums2);
		
		for(int i: ans) {
			System.out.println(i);
		}
	}

}
