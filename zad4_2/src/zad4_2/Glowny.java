package zad4_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

public class Glowny {

	public static void main(String[] args) {

		List<String> lista = Arrays.asList("aaa", "bbb", "ccc");
		List<String> lista2 = new ArrayList<>(lista);
		List<String> lista3 = new ArrayList<>(lista);

		System.out.println("====================");
		System.out.println("metoda z iteratorem:");
		System.out.println("====================");
		wyswietl(lista);
		System.out.println();
		zamien(lista);
		wyswietl(lista);
		System.out.println();
		System.out.println("====================");
		System.out.println("metoda z petla:");
		System.out.println("====================");
		wyswietl(lista2);
		System.out.println();
		zamien2(lista2);
		wyswietl(lista2);
		System.out.println();
		System.out.println("====================");
		System.out.println("metoda z replaceAll:");
		System.out.println("====================");
		wyswietl(lista3);
		System.out.println();
		zamien3(lista3);
		wyswietl(lista3);

	}

	// z iteratorem
	public static void zamien(List<String> lista) {

		ListIterator<String> it = lista.listIterator();
		while (it.hasNext()) {
			int i = it.nextIndex();
			String element = it.next();
			lista.set(i, element.toUpperCase());
		}

	}

	// z pętlą używając indeksów na liście
	public static void zamien2(List<String> lista) {

		for (int i = 0; i < lista.size(); i++) {
			String element = lista.get(i);
			element = element.toUpperCase();
			lista.set(i, element);
		}

	}

	// metodą listową replaceAll
	public static void zamien3(List<String> lista) {
		for (int i = 0; i < lista.size(); i++) {
			UnaryOperator<String> unary = s -> s.toUpperCase();
			lista.replaceAll(unary);

		}
	}

	public static void wyswietl(List<String> lista) {
		lista.forEach(x -> System.out.println(x));
	}

}
