package com.arrays;

public class CountThePrefixes {

	public int countPrefixes(String[] words, String s) {

		int number = 0;

		for (int runner = 0; runner < words.length; runner++) {

			if (s.length() >= words[runner].length() && recur(s, words[runner], 0)) {
				number++;
			}

		}

		return number;

	}

	public boolean recur(String mainString, String checkerString, int index) {

		if (index == checkerString.length()) {
			return true;
		}

		if (mainString.charAt(index) != checkerString.charAt(index)) {
			return false;
		}

		boolean toReturn = recur(mainString, checkerString, index + 1);

		return toReturn;

	}

	public int countPrefixes1(String[] words, String s) {

		int number = 0;

		for (int runner = 0; runner < words.length; runner++) {
			if (s.length() >= words[runner].length() && s.substring(0, words[runner].length()).equals(words[runner])) {
				number++;
			}
		}

		return number;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
