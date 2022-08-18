package com.arrays;

public class OddLengths {
	public static int sumOddLengthSubarrays(int[] arr) {

		int[] prefixArray = new int[arr.length];
		int sum = 0;
		for (int runner = 0; runner < prefixArray.length; runner++) {
			sum += arr[runner];
			prefixArray[runner] = sum;
		}

		System.out.println("Sum: " + sum);
		System.out.println();

		int subtractingValue = 0;

		for (int span = 2; span <= arr.length; span += 2) {

			System.out.println("Span Length: " + span);
			sum += prefixArray[span];

			for (int runner = 1; runner + span < arr.length; runner++) {

				// System.out.println("");
				System.out.println("Prefix Point: " + prefixArray[runner + span]);
				System.out.println("Prefix past: " + prefixArray[runner - 1]);
				sum += prefixArray[runner + span] - prefixArray[runner - 1];

			}
		}

		return sum;

	}

	public static void main(String[] args) {
		
		System.out.println(sumOddLengthSubarrays(new int[]{1,4,2,5,3}));

	}

}
