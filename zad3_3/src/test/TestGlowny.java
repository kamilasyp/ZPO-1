package test;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import zad3_3.Glowny;

class TestGlowny {

	String napis = "Ala ma kota";
	String napis2 = "abcd";
	String napisNull = null;
	int dlugosc = 3;
	int dlugosc2 = 2;
	int dlugoscZero = 0;

	List<String> poprawnie = Arrays.asList("Ala", " ma", " ko", "ta");
	List<String> poprawnie2 = Arrays.asList("ab", "cd");

	@Test
	void testPotnijNonNull() {

		List<String> wynik = Glowny.potnijNonNull(napis, dlugosc);
		List<String> wynik2 = Glowny.potnijNonNull(napis2, dlugosc2);

		assertLinesMatch(poprawnie, wynik);
		assertLinesMatch(poprawnie2, wynik2);

	}

	@Test
	void testPotnijSplitterGuava() {

		List<String> wynik = Glowny.potnijSplitterGuava(napis, dlugosc);
		List<String> wynik2 = Glowny.potnijSplitterGuava(napis2, dlugosc2);

		assertLinesMatch(poprawnie, wynik);
		assertLinesMatch(poprawnie2, wynik2);

	}

	@Test
	void testNullPointerException() {

		assertThrows(NullPointerException.class, () -> {
			Glowny.potnijNonNull(napisNull, dlugosc2);
		});
		
		assertThrows(NullPointerException.class, () -> {
			Glowny.potnijSplitterGuava(napisNull, dlugosc2);
		});
	}
	
	@Test
	void testIllegalArgumentException() {

		assertThrows(IllegalArgumentException.class, () -> {
			Glowny.potnijNonNull(napis, dlugoscZero);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			Glowny.potnijSplitterGuava(napis, dlugoscZero);
		});
	}

}
