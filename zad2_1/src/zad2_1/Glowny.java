package zad2_1;


import java.util.Scanner;

public class Glowny {


	public static void main(String[] args) {
		String slowo1, slowo2;

		Scanner odczyt = new Scanner(System.in);

		System.out.println("Podaj pierwsze slowo");
		slowo1 = odczyt.nextLine();

		System.out.println("Podaj drugie slowo");
		slowo2 = odczyt.nextLine();

		System.out.println("Odleglosc Levenshteina wynosi: " + Levenshtein.levenshtein(slowo1, slowo2));

		odczyt.close();
	}

}
