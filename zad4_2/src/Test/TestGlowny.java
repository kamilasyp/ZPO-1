package Test;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import zad4_2.Glowny;

class TestGlowny {

	List<String> poprawna = Arrays.asList("AAA", "BBB", "CCC");

	@Test
	void testZamien() {
		List<String> lista = Arrays.asList("aaa", "bbb", "ccc");
		Glowny.zamien(lista);
		assertLinesMatch(poprawna, lista);
	}

	@Test
	void testZamien2() {
		List<String> lista = Arrays.asList("aaa", "bbb", "ccc");
		Glowny.zamien2(lista);
		assertLinesMatch(poprawna, lista);
	}

	@Test
	void testZamien3() {
		List<String> lista = Arrays.asList("aaa", "bbb", "ccc");
		Glowny.zamien3(lista);
		assertLinesMatch(poprawna, lista);
	}

}
