package com.arrays;

public class ReversePrefix {

	public String reversePrefix(String word, char ch) {

		int endingIndex = word.indexOf(ch);

		if (endingIndex == -1) {
			return word;
		}

		char[] wordArray = word.toCharArray();

		recur(wordArray, endingIndex, endingIndex, 0);

		return new String(wordArray);

	}

	public void recur(char[] wordArray, int backIndex, int endingIndex, int frontIndex) {

		if (frontIndex >= endingIndex / 2) {

			char x = wordArray[frontIndex];
			wordArray[frontIndex] = wordArray[backIndex];
			wordArray[backIndex] = x;

			return;
		}

		char x = wordArray[frontIndex];
		wordArray[frontIndex] = wordArray[backIndex];
		wordArray[backIndex] = x;

		recur(wordArray, backIndex - 1, endingIndex, frontIndex + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
