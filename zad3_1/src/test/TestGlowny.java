package test;

import static org.junit.jupiter.api.Assertions.*;
import java.text.Collator;
import java.util.Locale;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import zad3_1.Glowny;

class TestGlowny {

	Locale locale = new Locale("pl", "PL");
	Collator collator = Collator.getInstance(locale);

	static void wyswietlTablice(String[] words) {
		for (String name : words) {
			System.out.println(name);
		}
	}

	@Test
	void testSortStrings() {

		String[] doSortowania = { "Łukasz", "Ścibor", "Stefania", "Bolek", "Agnieszka", "Zyta", "Órszula" };
		String[] poprawna = { "Agnieszka", "Bolek", "Łukasz", "Órszula", "Stefania", "Ścibor", "Zyta" };

		Glowny.sortStrings(collator, doSortowania);

		System.out.println("Wynik sortowania testSortStrings():");
		System.out.println();
		wyswietlTablice(doSortowania);
		System.out.println();

		assertArrayEquals(poprawna, doSortowania);
	}

	@Test
	void testFastSortStrings() {
		String[] doSortowania = { "Łukasz", "Ścibor", "Stefania", "Bolek", "Agnieszka", "Zyta", "Órszula" };
		String[] poprawna = { "Agnieszka", "Bolek", "Łukasz", "Órszula", "Stefania", "Ścibor", "Zyta" };

		Glowny.fastSortStrings(collator, doSortowania);

		System.out.println("Wynik sortowania testFastSortStrings():");
		System.out.println();
		wyswietlTablice(doSortowania);
		System.out.println();

		assertArrayEquals(poprawna, doSortowania);
	}

	@Test
	void testFastSortStrings2() {
		String[] doSortowania = { "Łukasz", "Ścibor", "Stefania", "Bolek", "Agnieszka", "Zyta", "Órszula" };
		String[] poprawna = { "Agnieszka", "Bolek", "Łukasz", "Órszula", "Stefania", "Ścibor", "Zyta" };

		Glowny.fastSortStrings2(collator, doSortowania);

		System.out.println("Wynik sortowania testFastSortStrings2():");
		System.out.println();
		wyswietlTablice(doSortowania);
		System.out.println();

		assertArrayEquals(poprawna, doSortowania);
	}

	static long sumTimeTestSortStringsTime = 0;
	static long sumTimeTestFastSortStringsTime = 0;
	static long sumTimeTestFastSortStringsTime2 = 0;

	@RepeatedTest(100000)
	void testSortStringsTime() {

		long startTime = System.nanoTime();

		String[] doSortowania = { "Łukasz", "Ścibor", "Stefania", "Bolek", "Agnieszka", "Zyta", "Órszula" };
		String[] poprawna = { "Agnieszka", "Bolek", "Łukasz", "Órszula", "Stefania", "Ścibor", "Zyta" };

		Glowny.sortStrings(collator, doSortowania);

		assertArrayEquals(poprawna, doSortowania);
		long endTime = System.nanoTime() - startTime;
		sumTimeTestSortStringsTime += endTime;
	}

	@RepeatedTest(100000)
	void testFastSortStringsTime() {
		long startTime = System.nanoTime();
		String[] doSortowania = { "Łukasz", "Ścibor", "Stefania", "Bolek", "Agnieszka", "Zyta", "Órszula" };
		String[] poprawna = { "Agnieszka", "Bolek", "Łukasz", "Órszula", "Stefania", "Ścibor", "Zyta" };

		Glowny.fastSortStrings(collator, doSortowania);
		assertArrayEquals(poprawna, doSortowania);
		long endTime = System.nanoTime() - startTime;
		sumTimeTestFastSortStringsTime += endTime;
	}

	@RepeatedTest(100000)
	void testFastSortStrings2Time() {
		long startTime = System.nanoTime();
		String[] doSortowania = { "Łukasz", "Ścibor", "Stefania", "Bolek", "Agnieszka", "Zyta", "Órszula" };
		String[] poprawna = { "Agnieszka", "Bolek", "Łukasz", "Órszula", "Stefania", "Ścibor", "Zyta" };
		Glowny.fastSortStrings2(collator, doSortowania);
		assertArrayEquals(poprawna, doSortowania);
		long endTime = System.nanoTime() - startTime;
		sumTimeTestFastSortStringsTime2 += endTime;
	}

	@AfterAll
	public static void wyswietlCzasyTestow() {
		System.out.println();
		System.out.println(String.format("Łączny czas w nanosekundach 100tyś testów testSortStrings(): %,d",
				sumTimeTestSortStringsTime));
		System.out.println(String.format("Łączny czas w nanosekundach 100tyś testów testFastSortStrings(): %,d",
				sumTimeTestFastSortStringsTime));
		System.out.println(String.format("Łączny czas w nanosekundach 100tyś testów testFastSortStrings2(): %,d",
				sumTimeTestFastSortStringsTime2));
	}
}
