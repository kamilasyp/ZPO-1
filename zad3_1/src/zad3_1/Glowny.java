package zad3_1;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;

public class Glowny {

	// sortowanie babelkowe
	public static void sortStrings(Collator collator, String[] words) {

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length - 1; j++) {
				if (collator.compare(words[j], words[j + 1]) > 0) {
					String temp = words[j + 1];
					words[j + 1] = words[j];
					words[j] = temp;
				}

			}

		}

	}

	// z anonimowym komparatorem
	public static void fastSortStrings(Collator collator, String[] words) {

		// tez zadziala bo Collator implementuje Comparator
		// Arrays.sort(words, collator);

		Arrays.sort(words, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				return collator.compare(s1, s2);
			}

		});

	}

	// z lambda
	public static void fastSortStrings2(Collator collator, String[] words) {

		Arrays.sort(words, (String s1, String s2) -> {
			return collator.compare(s1, s2);
		});

	}

}
