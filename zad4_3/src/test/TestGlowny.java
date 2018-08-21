package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zad4_3.Glowny;

class TestGlowny {
	
	Map<String, Integer> counts;
	Map<String, Integer> counts1;
	Map<String, Integer> counts2;
	Map<String, Integer> counts3;
	Map<String, Integer> counts4;
	
	@BeforeEach
	void tworzenieMap()
	{
		counts = new HashMap<>();
		counts1 = new HashMap<>();
		counts2 = new HashMap<>();
		counts3 = new HashMap<>();
		counts4 = new HashMap<>();
	}
	

	@Test
	void testNullPointerException() {
        counts.put("word", 2);
        
        assertThrows(NullPointerException.class,() -> Glowny.merge1("word", null, counts));
        assertThrows(NullPointerException.class,() -> Glowny.merge2("word", null, counts));
        assertThrows(NullPointerException.class,() -> Glowny.merge3("word", null, counts));
        assertThrows(NullPointerException.class,() -> Glowny.merge4("word", null, counts));
        assertThrows(NullPointerException.class,() -> counts.merge("word", null, Integer::sum));
	}
	
	@Test
	void testWord2Word1() {
		
        counts.put("word", 2);
        counts1.put("word", 2);
        counts2.put("word", 2);
        counts3.put("word", 2);
        counts4.put("word", 2);
        
        counts.merge("word", 1, Integer::sum);
        Glowny.merge1("word", 1, counts1);
        Glowny.merge2("word", 1, counts2);
        Glowny.merge3("word", 1, counts3);
        Glowny.merge4("word", 1, counts4);
        
        assertEquals((Integer) 3, counts.get("word"));
        assertEquals((Integer) 3, counts1.get("word"));
        assertEquals((Integer) 3, counts2.get("word"));
        assertEquals((Integer) 3, counts3.get("word"));
        assertEquals((Integer) 3, counts4.get("word"));
   	
	}
	
	@Test
	void testWordNullWord1() {
		
        counts.put("word", null);
        counts1.put("word", null);
        counts2.put("word", null);
        counts3.put("word", null);
        counts4.put("word", null);
        
        counts.merge("word", 1, Integer::sum);
        Glowny.merge1("word", 1, counts1);
        Glowny.merge2("word", 1, counts2);
        Glowny.merge3("word", 1, counts3);
        Glowny.merge4("word", 1, counts4);
        
        assertEquals((Integer) 1, counts.get("word"));
        assertEquals((Integer) 1, counts1.get("word"));
        assertEquals((Integer) 1, counts2.get("word"));
        assertEquals((Integer) 1, counts3.get("word"));
        assertEquals((Integer) 1, counts4.get("word"));
   	
	}
	
	@Test
	void testWord2Null1() {
		
        counts.put("word", 2);
        counts1.put("word", 2);
        counts2.put("word", 2);
        counts3.put("word", 2);
        counts4.put("word", 2);
        
        counts.merge(null, 1, Integer::sum);
        Glowny.merge1(null, 1, counts1);
        Glowny.merge2(null, 1, counts2);
        Glowny.merge3(null, 1, counts3);
        Glowny.merge4(null, 1, counts4);
        
        assertEquals((Integer) 2, counts.get("word"));
        assertEquals((Integer) 2, counts1.get("word"));
        assertEquals((Integer) 2, counts2.get("word"));
        assertEquals((Integer) 2, counts3.get("word"));
        assertEquals((Integer) 2, counts4.get("word"));
   	
	}
	
	@Test
	void testNull2Word1() {

        counts.put(null, 2);
        counts1.put(null, 2);
        counts2.put(null, 2);
        counts3.put(null, 2);
        counts4.put(null, 2);
        
        counts.merge("word", 1, Integer::sum);
        Glowny.merge1("word", 1, counts1);
        Glowny.merge2("word", 1, counts2);
        Glowny.merge3("word", 1, counts3);
        Glowny.merge4("word", 1, counts4);
        
        assertEquals((Integer) 1, counts.get("word"));
        assertEquals((Integer) 1, counts1.get("word"));
        assertEquals((Integer) 1, counts2.get("word"));
        assertEquals((Integer) 1, counts3.get("word"));
        assertEquals((Integer) 1, counts4.get("word"));
   	
	}
	
	

}
