package zad1_4;

import java.util.Scanner;

public class Glowny {
	public static void main(String[] args) {

		System.out.println("podaj dlugosc linijki:");
		Scanner wczytaj = new Scanner(System.in);
		int dlugosc = wczytaj.nextInt();
		wczytaj.close();
		int glebokosc = 5;

		for (int i = 0; i <= (16 * dlugosc); i++) {
			if (i % 16 == 0) {
				System.out.print(i / 16);
			} else {
				System.out.print(" ");
			}
		}

		System.out.println();

		for (int k = 0; k < glebokosc; k++) {
			for (int j = 0; j < dlugosc; j++) {
				for (int i = 0; i < 16; i++) {

					if (i % (int) Math.pow(2, glebokosc - k - 1) == 0) {
						System.out.print("|");
					} else {
						System.out.print(" ");
					}
				}

			}
			System.out.println("|");
		}
	}
}