package Zad3_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ComparisonChain;

public class Glowny {

	public static void main(String[] args) {

		// zmieniajac dane na dluzsze pozmieniaj formatery ;)

		Student s1 = new Student("Jan", "Kowalski", "12.05.1989", 160);
		Student s2 = new Student("Jan", "Malinowski", "24.10.1983", 175);
		Student s3 = new Student("Jan", "Nowakowski", "12.05.1990", 180);
		Student s4 = new Student("Jan", "Baranowski", "24.10.1990", 174);
		Student s5 = new Student("Jan", "Nawałka", "12.05.1990", 160);
		Student s6 = new Student("Jan", "Bombrych", "24.10.1990", 175);

		List<Student> listaStudentow = new ArrayList<>();
		listaStudentow.add(s1);
		listaStudentow.add(s2);
		listaStudentow.add(s3);
		listaStudentow.add(s4);
		listaStudentow.add(s5);
		listaStudentow.add(s6);

		List<Student> listaStudentow2 = new ArrayList<>(listaStudentow);

		System.out.println("przed sortowaniem z JDK:");
		System.out.println("---------------------------");
		for (Student student : listaStudentow) {
			System.out.println(student);
		}

		// Sortowanie z JDK wg kryteriów:
		// 1. Decyduje ROK urodzenia,
		// 2. W obrębie tego samego roku alfabetycznie względem PIERWSZEJ litery
		// nazwiska
		// 3. W obrębie tej samej pierwszej litery nazwiska MALEJĄCO wg wzrostu.

		Collections.sort(listaStudentow, (Student o1, Student o2) -> {
			Integer rok1 = o1.pobierzRok();
			Integer rok2 = o2.pobierzRok();
			int porownanieRok = rok1.compareTo(rok2);
			if (porownanieRok != 0) {
				return porownanieRok;
			}

			String litera1 = o1.pobierzPierwszaLitereNazwiska();
			String litera2 = o2.pobierzPierwszaLitereNazwiska();
			int porownaniePierwszaLitera = litera1.compareTo(litera2);
			if (porownaniePierwszaLitera != 0) {
				return porownaniePierwszaLitera;
			}
			int porownanieWzrost = o2.getWzrost() - o1.getWzrost();
			return porownanieWzrost;
		});

		System.out.println();

		System.out.println("po sortowaniu z JDK:");
		System.out.println("---------------------------");
		for (Student student : listaStudentow) {
			System.out.println(student);
		}

		System.out.println();

		System.out.println("przed sortowaniem z Guava:");
		System.out.println("---------------------------");
		for (Student student : listaStudentow2) {
			System.out.println(student);
		}

		// Sortowanie z Guava wg kryteriów:
		// 1. Decyduje ROK urodzenia,
		// 2. W obrębie tego samego roku alfabetycznie względem PIERWSZEJ litery
		// nazwiska
		// 3. W obrębie tej samej pierwszej litery nazwiska MALEJĄCO wg wzrostu.

		Collections.sort(listaStudentow2, (Student o1, Student o2) -> {
			return ComparisonChain.start().compare(o1.pobierzRok(), o2.pobierzRok())
					.compare(o1.pobierzPierwszaLitereNazwiska(), o2.pobierzPierwszaLitereNazwiska())
					.compare(o2.getWzrost(), o1.getWzrost()).result();
		});

		System.out.println();
		System.out.println("po sortowaniu z Guava:");
		System.out.println("---------------------------");
		for (Student student : listaStudentow2) {
			System.out.println(student);
		}

	}

}
