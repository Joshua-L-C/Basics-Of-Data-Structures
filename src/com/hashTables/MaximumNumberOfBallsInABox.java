package com.hashTables;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBallsInABox {
	public int countBalls(int lowLimit, int highLimit) {

		int[] tally = new int[46];
		int holder = 0;
		int greatest = 0;

		for (int runner = lowLimit; runner <= highLimit; runner++) {

			holder = total2(runner, 0);
			tally[holder]++;

			if (tally[holder] > greatest) {
				greatest = tally[holder];
			}
		}

//         holder = 0;

//         for(int x: tally){
//             if(x > holder){
//                 holder = x;
//             }
//         }

		return greatest;
	}

	public int countBalls1(int lowLimit, int highLimit) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int holder = 0;

		for (int runner = lowLimit; runner <= highLimit; runner++) {

			holder = total(runner);
			map.put(holder, map.getOrDefault(holder, 0) + 1);
		}

		holder = 0;

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > holder) {
				holder = entry.getValue();
			}
		}

		return holder;
	}

	public int total2(int number, int total) {

		if (number == 0) {
			return total;
		}

		total += number % 10;

		total = total2(number / 10, total);

		return total;

	}

	public int total(int number) {

		int sum = 0;

		while (number > 0) {
			sum += (number % 10);
			number = number / 10;
		}

		return sum;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
