package com.hashTables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class divideArray {
	
	public static boolean divideArray(int[] nums) {
        
        int[] index = new int[501];
         
         for(int x:nums){
             index[x] += 1;
         }
         
         for (int runner = 0; runner < index.length; runner++) {
        	 if(index[runner] > 0) {
        		 if(index[runner] % 2 != 0) {
        			 return false;
        		 }
        	 }
        	 
         }
         
         
         return true;
     }

	public static boolean divideArray2(int[] nums) {

		Arrays.sort(nums);

		int prevSame = 1;

		for (int runner = 0, forward = 1; forward < nums.length; runner++, forward++) {

			if (nums[runner] != nums[forward]) {

				if (prevSame % 2 != 0) {
					return false;
				}

				if (forward + 1 >= nums.length) {
					return false;
				} else {

					int counter = 1;
					int ahead = forward + 1;
					while (ahead < nums.length && nums[ahead] == nums[forward]) {
						// forward++;
						ahead++;
						counter++;
					}

					if (counter % 2 != 0) {
						return false;
					}

					forward = ahead;
					runner = forward - 1;
					prevSame = 1;
				}
			} else {
				prevSame++;
			}
		}

		return true;
	}

	public static boolean divideArrayBroken(int[] nums) {

		Arrays.sort(nums);

		for (int runner = 0, forward = 1; forward < nums.length; runner++, forward++) {

			if (nums[runner] != nums[forward]) {
				if (forward + 1 >= nums.length) {
					return false;
				} else {
					int ahead = forward + 1;
					if (nums[ahead] != nums[forward]) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public static boolean divideArray1(int[] nums) {

		HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();

		for (int runner = 0; runner < nums.length; runner++) {

			if (table.containsKey(nums[runner])) {
				table.put(nums[runner], table.get(nums[runner]) + 1);
			} else {
				table.put(nums[runner], 1);
			}

		}

		for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
			if (entry.getValue() % 2 == 1) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		//[15,13,5,20,18,2,20,8,20,17,10,19]

		int[] nums = new int[] { 15,13,5,20,18,2,20,8,20,17,10,19 };
		
		System.out.println(divideArray(nums));
	}

}
