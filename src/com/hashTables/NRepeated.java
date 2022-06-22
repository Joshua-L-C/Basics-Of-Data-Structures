package com.hashTables;

import java.util.HashSet;

public class NRepeated {

	 public static int repeatedNTimes(int[] nums) {
	        
	        int val = recur(nums,new HashSet<Integer>(),0);
	        
	        return val;
	        
	    }
	    
	    
	    public static int recur(int[] nums,HashSet<Integer> set,int index){
	        
	        if(set.contains(nums[index])){
	            return nums[index];
	        }
	        
	        set.add(nums[index]);
	        index += 1;
	        return recur(nums,set,index);
	        
	    }
	    
	    public static int repeatedNTimes2(int[] nums) {
			int[] array = new int[20000];

			for (int runner = 0; runner < nums.length; runner++) {
				if (array[nums[runner]] != 0) {
					return nums[runner];
				} else {
					array[nums[runner]] = 1;
				}
			}

			return 0;
		}
	    
	    
	    public int repeatedNTimes1(int[] nums) {
	        
	        HashSet<Integer> set = new HashSet<Integer>();
	        
	        for(int runner = 0; runner < nums.length; runner++){
	            if(set.contains(nums[runner])){
	                return nums[runner];
	            }else{
	                set.add(nums[runner]);
	            }
	        }
	        
	        
	        return 0;
	    }

	public static void main(String[] args) {
		//[1,2,3,3]
		//[2,1,2,5,3,2]
		//[5,1,5,2,5,3,5,4]
		
			int[] array = new int[]{1,2,3,3};
//			int[] array = new int[]{5,3,6,1,12};
//			int[] array = new int[]{5,3,6,1,12};
			
			
			System.out.println(repeatedNTimes(array));

	}

}
