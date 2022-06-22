package com.hashTables;

import java.util.Arrays;
import java.util.HashSet;

public class KeepMultiplyingBy2 {
	
	public static int findFinalValue(int[] nums, int original) {
        
        Arrays.sort(nums);
        int value = recur(nums,0,original);
        
        return value;
    }
    
	public static int recur(int[] nums,int index ,int original){
        
        if(index >= nums.length){
            return original;
        }
        
        
        
        if(nums[index] == original){
            original = 2 * original;
            //index = 0;
            
            return recur(nums,index,original);
        }else{
            index += 1;
            return recur(nums,index,original);
        }
        
    }
    
    
    
	public static int findFinalValue4(int[] nums, int original) {
        
        int value = recur(nums,0,original);
        
        return value;
    }
    
	public static int recur1(int[] nums,int index ,int original){
        
        if(index >= nums.length){
            return original;
        }
        
        
        
        if(nums[index] == original){
            original = 2 * original;
            index = 0;
            
            return recur(nums,index,original);
        }else{
            index += 1;
            return recur(nums,index,original);
        }
        
    }
    
    
	public static int findFinalValue3(int[] nums, int original) {
        int[] otherNums = new int[2002];
        
        
        for(int runner = 0; runner < nums.length; runner++){
            otherNums[nums[runner]] = 1;
        }
        
        
        while(original <= 2002 && otherNums[original] != 0){
            original = 2 * original;
        }
        
        
        return original;
    }
    
	public static int findFinalValue2(int[] nums, int original) {
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        
        for(int x: nums){
            set.add(x);    
        }
        
        while(set.contains(original)){
            original = 2 * original;
        }
        
        
        return original;
    }
    
	public static int findFinalValue1(int[] nums, int original) {
    
        Arrays.sort(nums);
        
        for(int runner = 0; runner < nums.length; runner++){
            
            if(nums[runner] == original){
                original = 2 * original;
            }else if(nums[runner] > (original * 2)){
                return original;
            }
            
        }
        
        
        return original;
        
    }

	public static void main(String[] args) {
		
		int[] array = new int[]{5,3,6,1,12};
		int val = 3;
		
//		int[] array = new int[]{2,7,9};
//		int val = 4;
		
		System.out.println(findFinalValue(array, val));
	}

}
