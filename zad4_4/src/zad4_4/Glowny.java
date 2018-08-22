package zad4_4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Glowny {
	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		List<Integer> list2 = new LinkedList<>();
		list2.add(4);
		list2.add(5);
		list2.add(6);

		List<Integer> list11 = new ArrayList<>();
		list11.add(1);
		list11.add(2);
		list11.add(3);

		List<Integer> list22 = new LinkedList<>();
		list22.add(4);
		list22.add(5);
		list22.add(6);

		System.out.println("SWAP:");
		System.out.println();
		System.out.println("ArrayList: " + list1);
		System.out.println("LinkedList: " + list2);
		swap(list1, 0, 2);
		System.out.println("ArrayList: " + list1);
		swap(list2, 0, 2);
		System.out.println("LinkedList: " + list2);

		System.out.println();
		System.out.println("SWAP2:");
		System.out.println();
		System.out.println("ArrayList: " + list11);
		System.out.println("LinkedList: " + list22);

		try {
			swap2(list11, 0, 2);
			System.out.println("ArrayList: " + list11);
			System.out.println();
			swap2(list22, 0, 2);
			System.out.println("LinkedList: " + list22);
		} catch (WyjatekNotacja wyjatekNotacja) {
			wyjatekNotacja.printStackTrace();
		}

	}

	public static <T> void swap(List<T> list, int i, int j) {
		T elementI = list.get(i);
		T elementJ = list.get(j);
		list.set(i, elementJ);
		list.set(j, elementI);
	}

	public static <T> void swap2(List<T> list, int i, int j) throws WyjatekNotacja {

		if (list instanceof LinkedList) {
			throw new WyjatekNotacja();
		}

		T elementI = list.get(i);
		T elementJ = list.get(j);
		list.set(i, elementJ);
		list.set(j, elementI);
	}

	public static class WyjatekNotacja extends Exception {

		private static final long serialVersionUID = 1L;

		public WyjatekNotacja() {
			System.out.println("BRAK OBSŁUGI SWOBODNEGO DOSTĘPU!");
		}
	}
}
