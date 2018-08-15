package zad2_1;

import java.util.HashMap;
import java.util.Map;

public class Levenshtein {

	static double levenshtein(String napis1, String napis2) {

		Map<Character, String> tmap = new HashMap<Character, String>();

		tmap.put('q', "w");
		tmap.put('w', "qe");
		tmap.put('e', "wr");
		tmap.put('r', "et");
		tmap.put('t', "ry");
		tmap.put('y', "tu");
		tmap.put('u', "yi");
		tmap.put('i', "uo");
		tmap.put('o', "ip");
		tmap.put('p', "o");
		tmap.put('a', "s");
		tmap.put('s', "ad");
		tmap.put('d', "sf");
		tmap.put('f', "dg");
		tmap.put('g', "fh");
		tmap.put('h', "gj");
		tmap.put('j', "hk");
		tmap.put('k', "jl");
		tmap.put('l', "k");
		tmap.put('z', "x");
		tmap.put('x', "zc");
		tmap.put('c', "xv");
		tmap.put('v', "cb");
		tmap.put('b', "vn");
		tmap.put('n', "bm");
		tmap.put('m', "n");

		int i, j, m, n;
		double cost;

		double d[][];

		m = napis1.length();
		n = napis2.length();

		d = new double[m + 1][n + 1];

		for (i = 0; i <= m; i++)
			d[i][0] = i;
		for (j = 1; j <= n; j++)
			d[0][j] = j;

		for (i = 1; i <= m; i++) {
			for (j = 1; j <= n; j++) {
				// jesli odpowiadajace litery sa takie same koszt = 0
				if (napis1.charAt(i - 1) == napis2.charAt(j - 1)) {
					cost = 0;
				} else {
					boolean warunek = false;
					// pobranie wartosci z tmap dla klucza odpowiadajacego
					// literze z drugiego slowa, ktora bedziemy zamieniac
					String wartosc = tmap.get(napis2.charAt(j - 1));
					for (int ii = 0; ii < wartosc.length(); ii++) {
						// jesli litera na ktora bedziemy zamieniac (ta z
						// pierwszego slowa)
						// znajduje sie w zbiorze wartosci klucza (klucza litery
						// z drugiego slowa)
						// zmieniamy warunek na prawdziwy
						if (wartosc.charAt(ii) == napis1.charAt(i - 1)) {
							warunek = true;
						}

					}
					if (warunek == true)
						cost = 0.5;
					else
						cost = 1;
				}

				d[i][j] = Math.min(d[i - 1][j] + 1, /* usuwanie */
						Math.min(d[i][j - 1] + 1, /* dodawanie */
								d[i - 1][j - 1] + cost)); /* zamiana */
			}
		}

		return d[m][n];
	}

}
