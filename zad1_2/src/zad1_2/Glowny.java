package zad1_2;

/**
 * @author Marcin
 */

import java.math.*;
import java.util.*;

public class Glowny {
	/**
	 * Metoda sprawdzanie_numeru wczytuje z konsoli numer rachunku i sprawdza czy jest to polski numer rachunku
	 * oraz czy ilosc podanych cyfr jest poprawna tj 26.
	 * Metoda nie przyjmuje argumentow podczas wywolywania
	 */
	
	public static void sprawdzanie_numeru ()
	{
		String numer_PL = "2521";

		System.out.println("wprowadz numer rachunku:");

		Scanner odczyt = new Scanner(System.in);
		String numer_rachunku = odczyt.nextLine();

		int dlugosc = numer_rachunku.length();

		if (dlugosc == 26) {
			numer_rachunku = numer_rachunku + numer_PL;
			String wycinanie = numer_rachunku.substring(0, 2);
			String numer_koncowy = numer_rachunku.substring(2, 30) + wycinanie;

			BigInteger numer_kontrolny = new BigInteger(numer_koncowy);
			BigInteger dzielnik = new BigInteger("97");
			numer_kontrolny = numer_kontrolny.mod(dzielnik);

			int reszta = numer_kontrolny.intValue();

			if (reszta == 1)
				System.out.println("numer rachunku jest poprawny");
			else
				System.out.println("numer rachunku jest niepoprawny, nie jest to polski numer");
		} else
			System.out.println("numer rachunku jest niepoprawny. Liczba cyfr musi wynosic 26");
		odczyt.close();	
		return;
	}

	public static void main(String[] args) {
		
		sprawdzanie_numeru();
		
		return;
	}
}
