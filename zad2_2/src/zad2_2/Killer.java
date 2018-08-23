package zad2_2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;

// klasa ktora zabija watek z wyscigiem po okreslonej liczbie zawodnikow

public class Killer implements Runnable {

	CountDownLatch licznik = null;
	ScheduledExecutorService watek;

	public Killer(CountDownLatch licznik, ScheduledExecutorService watek) {
		this.licznik = licznik;
		this.watek = watek;
	}

	public void run() {
		try {
			// oczekuje na uwolnienie zatrzasku
			licznik.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		this.watek.shutdownNow();
		System.out.println("****** KONIEC WYSCIGU ******");

	}
}
