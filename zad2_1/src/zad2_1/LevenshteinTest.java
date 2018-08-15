package zad2_1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LevenshteinTest {

	@Test
	public void test1() {

		assertEquals(1.5, Levenshtein.levenshtein("kot", "kita"), 0);
	}

	@Test
	public void test2() {

		assertEquals(2, Levenshtein.levenshtein("drab", "dal"), 0);
	}

}
