package com.hashTables;

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
    
	public static void main(String[] args) {
		//System.out.println(numJewelsInStones("aA", "aAAbbbb"));
		smallerNumbersThanCurrent(new int[] {8,1,2,2,3});
		
		
		System.out.println(countConsistentStrings("ab", new String[] {"ad","bd","aaab","baa","badab"}));
		System.out.println(longestCommonPrefix(new String[] {"Flower","Flow","Flight"}));
		System.out.println(searchInsert(new int[] {1,3,5,6},2));
		System.out.println(lengthOfLastWord("Hello World   "));
		
	}

}
