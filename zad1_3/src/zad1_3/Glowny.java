package zad1_3;

import java.util.*;

public class Glowny {

	public static void main(String[] args) {
		Map<Integer, String> jednosci = new HashMap<Integer, String>();

		jednosci.put(0, "zero");
		jednosci.put(1, "jeden");
		jednosci.put(2, "dwa");
		jednosci.put(3, "trzy");
		jednosci.put(4, "cztery");
		jednosci.put(5, "piec");
		jednosci.put(6, "szesc");
		jednosci.put(7, "siedem");
		jednosci.put(8, "osiem");
		jednosci.put(9, "dziewiec");

		Map<Integer, String> nascie = new HashMap<Integer, String>();

		nascie.put(1, "jedenascie");
		nascie.put(2, "dwanascie");
		nascie.put(3, "trzynascie");
		nascie.put(4, "czternascie");
		nascie.put(5, "pietnascie");
		nascie.put(6, "szesnascie");
		nascie.put(7, "siedemnascie");
		nascie.put(8, "osiemnascie");
		nascie.put(9, "dziewietnascie");

		Map<Integer, String> dziesiatki = new HashMap<Integer, String>();
		dziesiatki.put(1, "dziesiec");
		dziesiatki.put(2, "dwadziescia");
		dziesiatki.put(3, "trzydziesci");
		dziesiatki.put(4, "czterdziesci");
		dziesiatki.put(5, "piecdziesiat");
		dziesiatki.put(6, "szescdziesiat");
		dziesiatki.put(7, "siedemdziesiat");
		dziesiatki.put(8, "osiemdziesiat");
		dziesiatki.put(9, "dziewiecdziesiat");

		Map<Integer, String> setki = new HashMap<Integer, String>();
		setki.put(1, "sto");
		setki.put(2, "dwiescie");
		setki.put(3, "trzysta");
		setki.put(4, "czterysta");
		setki.put(5, "piecset");
		setki.put(6, "szescset");
		setki.put(7, "siedemset");
		setki.put(8, "osiemset");
		setki.put(9, "dziewiecset");

		System.out.println("podaj liczbe:");
		Scanner odczyt;

		try {
			odczyt = new Scanner(System.in);
			String liczba = odczyt.nextLine();

			odczyt.close();
			int dlugosc = liczba.length();

			if (dlugosc == 1) {
				int klucz = Integer.parseInt(liczba);
				System.out.println(jednosci.get(klucz));
			}

			else if (dlugosc == 2) {
				String cyf_dziesiatek = liczba.substring(0, 1);
				int klucz_dziesiatek = Integer.parseInt(cyf_dziesiatek);
				String cyf_jednosci = liczba.substring(1, 2);
				int klucz_jednosci = Integer.parseInt(cyf_jednosci);

				if (klucz_dziesiatek == 0) {
					throw new IllegalArgumentException("niezaczynamy liczby od 0! Wpisales: " + liczba);
				}

				else if (klucz_dziesiatek == 1 & klucz_jednosci != 0) {
					System.out.println(nascie.get(klucz_jednosci));
				} else if (klucz_dziesiatek == 1 & klucz_jednosci == 0) {
					System.out.println(dziesiatki.get(klucz_dziesiatek));
				}

				else {
					System.out.println(dziesiatki.get(klucz_dziesiatek) + " " + jednosci.get(klucz_jednosci));
				}

			}

			else if (dlugosc == 3) {
				String cyf_jednosci = liczba.substring(2, 3);
				int klucz_jednosci = Integer.parseInt(cyf_jednosci);
				String cyf_dziesiatek = liczba.substring(1, 2);
				int klucz_dziesiatek = Integer.parseInt(cyf_dziesiatek);
				String cyf_setek = liczba.substring(0, 1);
				int klucz_setek = Integer.parseInt(cyf_setek);

				if (klucz_setek == 0) {

					throw new IllegalArgumentException("niezaczynamy liczby od 0! wpisales: " + liczba);

				}

				else if (klucz_dziesiatek == 1 & klucz_jednosci != 0) {
					System.out.println(setki.get(klucz_setek) + " " + nascie.get(klucz_jednosci));
				} else if (klucz_dziesiatek == 1 & klucz_jednosci == 0) {
					System.out.println(setki.get(klucz_setek) + " " + dziesiatki.get(klucz_dziesiatek));
				}

				else if (klucz_dziesiatek == 0 & klucz_jednosci == 0) {
					System.out.println(setki.get(klucz_setek));
				} else if (klucz_dziesiatek == 0) {
					System.out.println(setki.get(klucz_setek) + " " + jednosci.get(klucz_jednosci));
				} else {
					System.out.println(setki.get(klucz_setek) + " " + dziesiatki.get(klucz_dziesiatek) + " "
							+ jednosci.get(klucz_jednosci));
				}

			}

			else {
				throw new IllegalArgumentException(
						"niepoprawna liczba znakow, maks liczba 3 cyfrowa! Wpisales: " + liczba);
			}
		} catch (NumberFormatException e) {

			System.err.println("liczby ujemne niedozwolone!");
		}

		return;

	}

}
