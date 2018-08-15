package zad1_1;

import java.util.Scanner;

public class Glowny {

	int liczba = 0b1101_1011;
	static final String WZORZEC = "0123456789ABCDEF";

	public static String konwersja(int liczba, int podstawa_systemu) {
		String wynik = "";

		while (liczba > 0) {
			wynik = WZORZEC.charAt(liczba % podstawa_systemu) + wynik;
			liczba = liczba / podstawa_systemu;
		}
		return wynik;
	}

	public static void main(String[] args) {

		int liczba = 0b1101_1011;

		System.out.println("podaj w ktorym systemie (\"dziesiec\", \"trzy\" lub \"szesnascie\")");
		Scanner odczyt = new Scanner(System.in);
		String warunek = odczyt.nextLine();

		switch (warunek) {

		case "dziesiec": {
			System.out.println(liczba);
		}

			break;

		case "trzy": {
			System.out.println(konwersja(liczba, 3));
		}

			break;

		case "szesnascie": {
			System.out.println(konwersja(liczba, 16));
		}

			break;

		default:
			System.out.println("nieprawidlowy wybor");

		}

		odczyt.close();

		return;

	}

}
