package com.hashTables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Jewels {
	
    public static int numJewelsInStones(String J, String S) {
        HashSet<Character> set = new HashSet<Character>();
        int counter = 0;
        for(int i = 0; i < J.length(); i++)
            set.add(J.charAt(i));
        for(int i = 0; i < S.length(); i++)
            if(set.contains(S.charAt(i)))
                counter++;
        return counter;
    }
    
    
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        
        int[] nums2 = nums.clone();
        Arrays.sort(nums2);
        
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        int holder = 0;
        
        for(int runner = 0; runner <= nums.length -1; runner++){
            for(int second = runner-1; second >= 0; second--){
                if(nums2[runner] > nums2[second]){
                    holder++;
                }
            }
            
            map.put(nums2[runner],holder);
            
            holder = 0;
        }
        
        
        for(int runner = 0; runner <= nums.length -1; runner++){
            System.out.println("Map Index: " +nums2[runner] + " value "+map.get(nums2[runner]));
        }
        return nums2;
        
    }
    
    public static int countConsistentStrings(String allowed, String[] words) {
        
        boolean yes = false;
        int times = 0;
        for(int runner = 0; runner < words.length; runner++){
            for(char n : words[runner].toCharArray()){
                if(!allowed.contains(n+"")){
                    yes = false;
                    break;
                }else{
                    yes = true;
                }
                
            }
            
            if(yes){
                times++;
            }
        }
        
        
        return times;
    }
    
    public static String longestCommonPrefix(String[] strs) {
        
    	 String preFix = "";
         
         for(int outerRunner = 0; outerRunner < strs[0].length();outerRunner++){
             
             String x = strs[0].charAt(outerRunner) +"";
             
             for(int runner = 0; runner < strs.length; runner++){
                 
                 if(outerRunner > strs[runner].length() - 1){
                     return preFix;
                 }
                 
             	String val = strs[runner].charAt(outerRunner) +"";
                 if(!x.equals(val)){
                     return preFix;
                 }
             
             }
             
             preFix += x;
             
         }
         
         
         return preFix;
    }
    
    public static int searchInsert(int[] nums, int target) {
        int index = -1;
        
        for(int runner = 0; runner < nums.length; runner++){
            
          if(nums[runner] == target){
              return runner;
          }
           
          if(nums[runner] > target && index == -1){
              index = runner;
          }
           
          if(runner == nums.length - 1 && nums[runner] < target && index == -1) {
        	  index = runner + 1;
          }
            
            
        }
        
        return index;
    }
    
    public static int lengthOfLastWord(String s) {
        
        String str = s.trim();
          
          for(int runner = str.length() - 1; runner >= 0; runner--){
              if(str.charAt(runner) == ' '){
                  return str.length() - runner - 1;
              }
          }
      
          return 0;
      }
    
    public static String reverseVowels(String s) {
    	
    	char[] word = s.toCharArray();
    	
        for(int leftRunner = 0, rightRunner = word.length - 1; leftRunner < rightRunner;){
            
            if(leftRunner < word.length && !isVowel(word[leftRunner]) && !isVowel(word[rightRunner])){
                leftRunner++;
                rightRunner--;
            }
            
            if(leftRunner < word.length && isVowel(word[leftRunner]) && isVowel(word[rightRunner])){
                
                char holder = word[leftRunner];
                word[leftRunner] = word[rightRunner];
                word[rightRunner] = holder;
                
                leftRunner++;
                rightRunner--;
            }
            
            if(leftRunner < word.length && !isVowel(word[leftRunner]) && isVowel(word[rightRunner])){
                
                while(!isVowel(word[leftRunner])){
                    leftRunner++;
                }
                
                char holder = word[leftRunner];
                word[leftRunner] = word[rightRunner];
                word[rightRunner] = holder;
                
                leftRunner++;
                rightRunner--;
                
            }
            
             if(leftRunner < word.length && isVowel(word[leftRunner]) && !isVowel(word[rightRunner])){
                
                while(!isVowel(word[rightRunner])){
                    rightRunner--;
                }
                
                char holder = word[leftRunner];
                word[leftRunner] = word[rightRunner];
                word[rightRunner] = holder;
                
                leftRunner++;
                rightRunner--;
                
            }
        }
    	
    	
    	return "";
    }
    
    public static boolean isVowel(char v){
        
        if(v == 'a'||v == 'A' || v == 'e' || v == 'E' || v == 'i' ||v == 'I' || v == 'o' || v == 'O' || v == 'u' || v == 'U'){
            return true;
        }
        
        return false;
    }
    
    public static boolean check2(int[] nums) {
        
        int lowestIndex = Integer.MAX_VALUE;
        int lowestNumber = Integer.MAX_VALUE;
        
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        
        for(int runner = 0 ; runner < nums.length; runner++){
            if(nums[runner] <=  lowestNumber){
            	
            	indexes.add(runner);
            	
                lowestIndex = runner;
                lowestNumber = nums[runner];
            }
            
   
        }
        
        System.out.println("Lowest Index: " + lowestIndex);
        
        int []newNums = new int[nums.length];
        
        for(Integer x: indexes) {
        	for(int runner = 0 ; runner < nums.length; runner++){
                newNums[runner] = nums[(runner + x) % nums.length];
                
//                if(runner > 0 && runner + 1 < nums.length){
//                    if(newNums[runner] > newNums[runner + 1]){
//                        return false;
//                    }
//                }
            }
        	
        	boolean isValid = true;
        	 for(int runner = 0, forward = 1; forward < nums.length; runner++,forward++){
               if(newNums[runner] > newNums[forward]) {
              	 isValid = false;
               }
          	 
//          	 System.out.println(newNums[runner]);
        	 }
        	 
        	 if(isValid == true) {
        		 return true;
        	 }
        	 
        }
        
        
        
            
        return false;
    }
    
    
    public static boolean check(int[] nums) {   
        
    	 
    	        int decDetectionCount = 0;
    	        
    	        // count each time the previous value is greater than the current value
    	        for (int i = 1; i < nums.length; i++)
    	            if (nums[i-1] > nums[i]) decDetectionCount++;
    	        
    	        // if we only detect one decrease, compare first and last value
    	        // return true if first value is greator than or equal to the last, otherwise, false
    	        if (decDetectionCount == 1) return nums[0] >= nums[nums.length-1];
    	        
    	        // if decDetectionCount == 0 return true
    	        // if decDetectionCount > 1  return false
    	        // Or
    	        return decDetectionCount < 2;
    	 
    }
    
	public static void main(String[] args) {
		//System.out.println(numJewelsInStones("aA", "aAAbbbb"));
		//smallerNumbersThanCurrent(new int[] {8,1,2,2,3});
		
		
//		System.out.println(countConsistentStrings("ab", new String[] {"ad","bd","aaab","baa","badab"}));
//		System.out.println(longestCommonPrefix(new String[] {"Flower","Flow","Flight"}));
//		System.out.println(searchInsert(new int[] {1,3,5,6},2));
//		System.out.println(lengthOfLastWord("Hello World   "));
//		System.out.println(reverseVowels("a."));
		
//		System.out.println(check(new int[] {7,9,1,1,1,3}));
//		System.out.println(check(new int[] {6,10,6}));
//		System.out.println(check(new int[] {7,9,10,2,2,3}));
//		System.out.println(check(new int[] {1,2,1,1}));
//		System.out.println(check(new int[] {2,1,3,4}));
		
	}

}
