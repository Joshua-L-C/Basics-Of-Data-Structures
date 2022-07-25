package com.hashTables;

import java.util.HashMap;
import java.util.Map;

public class DigitCount {

	public static boolean digitCount(String num) {

		int[] card = new int[11];

		char[] nums = num.toCharArray();

		for (int runner = 0; runner < nums.length; runner++) {
			card[nums[runner] - '0'] += 1;
		}

		for (int runner = 0; runner < nums.length; runner++) {
			if (card[runner] != (nums[runner] - '0')) {
				return false;
			}
		}

		return true;
	}

	public static boolean digitCount2(String num) {
		return recur(num.toCharArray(), new int[11], 0, true);

	}

	public static boolean recur(char[] nums, int[] card, int index, boolean value) {

		if (index == nums.length) {
			return value;
		}

		card[nums[index] - '0'] += 1;
		index += 1;

		value = recur(nums, card, index, value);

		if (index - 1 == -1) {

			if ((nums[0] - '0') != card[nums[0] - '0']) {
				value = false;
			}

		} else if ((nums[index - 1] - '0') != card[(index - 1)]) {
			value = false;
		}

		return value;
	}

	public boolean digitCount1(String num) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		char[] nums = num.toCharArray();

		for (int runner = 0; runner < nums.length; runner++) {
			map.put((nums[runner] - '0'), map.getOrDefault((nums[runner] - '0'), 0) + 1);
		}

		// for(Map.Entry<Integer,Integer> entry : map.entrySet()){
		// System.out.println(entry.getKey()+": "+entry.getValue());
		// }

		for (int runner = 0; runner < nums.length; runner++) {
			if ((nums[runner] - '0') != map.getOrDefault(runner, 0)) {
				return false;
			}
		}

		return true;
	}


	public static void main(String[] args) {
		int[] nm = new int[] {};
		String nums = "1210";
		// nums = "030";

		System.out.println(digitCount(nums));
	}

}
