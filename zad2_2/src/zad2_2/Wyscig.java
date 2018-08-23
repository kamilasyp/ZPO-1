package zad2_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;

import zad2_2.Log;

public class Wyscig implements Runnable {

	Log my_log = new Log("log.txt");

	CountDownLatch licznik = null;

	public Wyscig(CountDownLatch licznik) {
		this.licznik = licznik;
	}

	ArrayList<String> listNazwisko = CzytanieURL.odczytNazwisk();

	HashMap<Integer, String> czasNazwisko = new HashMap<Integer, String>();

	Queue<Integer> kolejkaCzasy = new PriorityQueue<>(15);

	int pierwszy = 380;
	int drugi = 390;
	int trzeci = 400;
	String nazwisko1, nazwisko2, nazwisko3;

	int iteratorWyswietlania = 0;

	int losowanieCzasu() {
		int czas;
		Random r = new Random();
		czas = (int) (r.nextGaussian() * 30 + 300);

		if (czas < 250)
			czas = 250;
		if (czas > 370)
			czas = 370;

		return czas;
	}

		String losowanieNazwiska() {
		Random random = new Random();
		int rozmiar = listNazwisko.size();
		int index = random.nextInt(rozmiar);
		String nazwisko = listNazwisko.get(index);
		listNazwisko.remove(index);
		return nazwisko;
	}

	@Override
	public void run() {

		String nazwisko = losowanieNazwiska();
		int czas = losowanieCzasu();

		kolejkaCzasy.add(czas);
		int najlepszyCzas = kolejkaCzasy.poll();

		if (czasNazwisko.isEmpty())
			czasNazwisko.put(czas, nazwisko);
		else {
			// dodaje do tego samego klucza(czasu) kolejne nazwisko, jesli czasy sie
			// powtarzaja
			if (czasNazwisko.containsKey(czas)) {
				String staraWartosc = czasNazwisko.get(czas);
				czasNazwisko.replace(czas, staraWartosc + ", " + nazwisko);
			} else
				czasNazwisko.put(czas, nazwisko);

		}

		if (najlepszyCzas < pierwszy) {
			trzeci = drugi;
			drugi = pierwszy;
			pierwszy = najlepszyCzas;
		} else if (najlepszyCzas < drugi && najlepszyCzas > pierwszy) {
			trzeci = drugi;
			drugi = najlepszyCzas;
		} else if (najlepszyCzas < trzeci && najlepszyCzas > drugi)
			trzeci = najlepszyCzas;

		// zapis logow
		my_log.logger.setLevel(Level.FINE);
		my_log.logger.fine("Zawodnik nr " + (iteratorWyswietlania + 1) + " " + nazwisko + ": " + czas + "s");

		System.out.println("******************************");
		System.out.println("Zawodnik nr " + (iteratorWyswietlania + 1) + " " + nazwisko + ": " + czas + "s");

		System.out.println("******************************");
		System.out.println();

		switch (iteratorWyswietlania) {

		case (0): {
			System.out.println("AKTUALNA KLASYFIKACJA:");
			System.out.println("1 -> " + pierwszy + "s " + czasNazwisko.get(pierwszy));
			System.out.println();
			break;
		}
		case (1): {
			System.out.println("AKTUALNA KLASYFIKACJA:");
			System.out.println("1 -> " + pierwszy + "s " + czasNazwisko.get(pierwszy));
			System.out.println("2 -> " + drugi + "s " + czasNazwisko.get(drugi));
			System.out.println();
			break;
		}
		default:
			System.out.println("AKTUALNA KLASYFIKACJA:");
			System.out.println("1 -> " + pierwszy + "s " + czasNazwisko.get(pierwszy));
			System.out.println("2 -> " + drugi + "s " + czasNazwisko.get(drugi));
			System.out.println("3 -> " + trzeci + "s " + czasNazwisko.get(trzeci));
			System.out.println();
		}
		iteratorWyswietlania += 1;

		// dekrementuje licznik, jak dojdzie do zera uwolni watek z Killerem
		this.licznik.countDown();
	}

}
