
public class SortSentence {

	public static String sortSentence(String s) {

		String[] sentence = new String[11];
		char[] array = s.toCharArray();

		StringBuilder word = new StringBuilder();

		for (int runner = 0; runner < array.length; runner++) {

			if (array[runner] - 0 >= 48 && array[runner] - 0 <= 57) {
				sentence[array[runner] - 48] = word.toString();
				word = null;
				word = new StringBuilder();
			} else if (array[runner] - 0 != 32) {
				word.append(array[runner]);
			}
		}

		word = new StringBuilder();

		for (int runner = 0; runner < sentence.length - 1; runner++) {
			// System.out.println(sentence[runner]);
			if (sentence[runner] != null) {
				word.append(sentence[runner] + " ");
			}

		}

		word.deleteCharAt(word.length() - 1);

		// System.out.println(word.toString());
		return word.toString();

	}

	public static String sortSentence1(String s) {

		String[] sentence = new String[11];
		String x = "";
		String y = "";
		int index = 0;

		// System.out.println(s);

		while (s.indexOf(" ") != -1) {

			// System.out.println(s.indexOf(" "));
			y = s.substring(0, s.indexOf(' '));
			s = s.substring(s.indexOf(" ") + 1, s.length());

			// System.out.println(s);
			// System.out.println(y);
			// index = s.indexOf(" ") - 1;
			// x = s.substring(0,s.indexOf(" "));
			sentence[y.charAt(y.length() - 1) - '0'] = y;

		}

		sentence[s.charAt(s.length() - 1) - '0'] = s;

		// System.out.println();
		String ans = "";

		for (int runner = 0; runner < sentence.length; runner++) {
			// System.out.println(sentence[runner]);
			if (sentence[runner] != null) {
				ans += sentence[runner].substring(0, sentence[runner].length() - 1) + " ";
			}

		}

		ans = ans.substring(0, ans.length() - 1);

		return ans;
	}

	public static void main(String[] args) {
		String val = "is2 sentence4 This1 a3";
		
		System.out.println(sortSentence(val));

	}

}
