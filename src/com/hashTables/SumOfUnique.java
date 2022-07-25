package com.hashTables;

public class SumOfUnique {

	public static int sumOfUnique(int[] nums) {

		int total = recur(nums, new int[101], 0, 0);

		//System.out.println(total);

		return total;

	}

	public static int recur(int[] nums, int[] table, int index, int total) {

		if (index == nums.length) {
			return total;
		}

		table[nums[index]] += 1;

		total = recur(nums, table, index + 1, total);

		if(table[nums[index]] == 1) {
			total += nums[index];
		}

		return total;
	}

	public static int sumOfUnique1(int[] nums) {

		int[] index = new int[101];

		for (int x : nums) {
			index[x] += 1;
		}

		int total = 0;
		for (int runner = 0; runner < index.length; runner++) {
			if (index[runner] == 1) {
				total += runner;
			}
		}

		return total;
	}

	public static void main(String[] args) {
		/*
		 * 
		 * [1,2,3,2] [1,1,1,1,1] [1,2,3,4,5]
		 */
		int[] nums = new int[] { 1, 2, 3, 2 };

		System.out.println(sumOfUnique(nums));
	}

}
