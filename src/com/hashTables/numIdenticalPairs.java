package com.hashTables;

import java.util.Arrays;
import java.util.HashMap;

public class numIdenticalPairs {
	
	public static int numIdenticalPairs(int[] nums) {
        Arrays.sort(nums);
        
        
        int count = 0;
        int number = nums[0];
        int result = 0;
        
        for(int backIndex = 0,frontIndex = 1; backIndex < nums.length; frontIndex++,backIndex++){
            
            System.out.println(nums[backIndex]);
            
            if(number != nums[backIndex]) {
            	
            	result += (count * (count - 1)/2);
            	System.out.println("Plus "+ (count * (count - 1)/2));
            	
            	
            	count = 1;
            	number = nums[backIndex];
            }else{
            	
            	count++;
            }
            
            
            
//             if(nums[backIndex] == nums[frontIndex]){
//                 count++;
//             }else{
//            	 
//            	 
//            	 
//                 count++;
//                 
//                 System.out.println("Count: "+count);
//                 
//                 result += (count * ((count - 1)/2));    
//                 count = 0;
//             }
            
            
        }
        
        result += (count * (count - 1)/2);
        
        //System.out.println();
        
        return result;
    }
    
    
    
    
	public static int numIdenticalPairs2(int[] nums) {
        int result = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int runner = 0; runner < nums.length; runner++){
            
            if(map.containsKey(nums[runner])){
                map.put(nums[runner] , map.get(nums[runner]) + 1);
            }else{
                map.put(nums[runner] ,1);
            }
            
        }
        
        
        for(int key: map.keySet()){
            
            result += (map.get(key) * (map.get(key) - 1)/2);
            
        }
        
        
        return result;
    }
    
    
    
    
    
	public static int numIdenticalPairs1(int[] nums) {
        
        int numberOfPairs = 0;
        
        for(int runner = 0; runner < nums.length;runner++){ 
            for(int runnerTwo = runner + 1; runnerTwo < nums.length;runnerTwo++){
             
                if(nums[runner]==nums[runnerTwo]){
                    numberOfPairs++;
                }
            }
        }
        
        return numberOfPairs;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,1,1,3};
		//int[] nums = new int[] {1,1,1,1};
		//int[] nums = new int[] {1,2,3};
		
		System.out.println(numIdenticalPairs(nums));

	}

}
