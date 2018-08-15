package zad3_3;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

import com.google.common.base.Splitter;

public class Glowny {

	public static void main(String[] args) {

		String napis = "Ala ma kota";
		String napis2 = "abcd";
//		String napis = null;
//		String napis2 = null;
		int dlugosc = 3;
		int dlugosc2 = 2;

		// pamietaj ze funkcja pociete rzuci wyjatek IllegalArgumentException gdy
		// napis=null
		// natomiast pociete2 i pociete3 rzuci NullPointerException gdy napis = null
		List<String> pociete = potnijBezNonNull(napis, dlugosc);
		List<String> pociete2 = potnijNonNull(napis2, dlugosc2);
		List<String> pociete3 = potnijSplitterGuava(napis, dlugosc);
		
		System.out.println("potnijBezNonNull: ");
		System.out.println();

		for (String wyswietl : pociete) {
			System.out.println(wyswietl);
		}

		System.out.println();
		System.out.println("potnijNonNull: ");
		System.out.println();

		for (String wyswietl : pociete2) {
			System.out.println(wyswietl);
		}

		System.out.println();
		System.out.println("potnijSplitterGuava ");
		System.out.println();

		for (String wyswietl : pociete3) {
			System.out.println(wyswietl);
		}

	}

	// ciecie bez adnotacji @NonNull
	public static List<String> potnijBezNonNull(String s, int length) {

		if (s == null || length <= 0) {
			throw new IllegalArgumentException();
		}

		List<String> pociete = new ArrayList<>();
		int dlugoscS = s.length();
		int warunek = dlugoscS % length;

		int skok = 0;

		if (warunek == 0) {
			for (int i = 0; i < dlugoscS; i += length) {
				skok = i + length;
				pociete.add(s.substring(i, skok));
			}
		} else {
			int i;
			for (i = 0; i < dlugoscS - warunek; i += length) {
				skok = i + length;
				pociete.add(s.substring(i, skok));
			}

			pociete.add(s.substring(i, skok + warunek));
		}

		return pociete;
	}

	// ciecie z dnotacja @NonNull
	public static List<String> potnijNonNull(@NonNull String s, int length) {

		if (length <= 0) {
			throw new IllegalArgumentException();
		}

		List<String> pociete = new ArrayList<>();
		int dlugoscS = s.length();
		int warunek = dlugoscS % length;

		int skok = 0;

		if (warunek == 0) {
			for (int i = 0; i < dlugoscS; i += length) {
				skok = i + length;
				pociete.add(s.substring(i, skok));
			}
		} else {
			int i;
			for (i = 0; i < dlugoscS - warunek; i += length) {
				skok = i + length;
				pociete.add(s.substring(i, skok));
			}

			pociete.add(s.substring(i, skok + warunek));
		}

		return pociete;
	}

	// ciecie z biblioteka Guava
	public static List<String> potnijSplitterGuava(String s, int length) {

		List<String> pociete = (List<String>) Splitter.fixedLength(length).splitToList(s);

		return pociete;
	}

}
