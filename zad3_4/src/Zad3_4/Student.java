package Zad3_4;

import java.util.List;

import com.google.common.base.Splitter;

public class Student {

	private String imie;
	private String nazwisko;
	private String dataUrodzenia;
	private int wzrost;

// date podajemy w formacie dd.MM.yyyy
	public Student(String imie, String nazwisko, String dataUrodzenia, int wzrost) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.dataUrodzenia = dataUrodzenia;
		this.wzrost = wzrost;
	}

	public String getImie() {
		return this.imie;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public String getDataUrodzenia() {
		return this.dataUrodzenia;
	}

	public int getWzrost() {
		return this.wzrost;
	}

// wyłuskanie daty urodzenia dla formatu dd.MM.yyyy
	public int pobierzRok() {
		int rok = 0;

		List<String> dzienMiesiacRok = (List<String>) Splitter.on('.').splitToList(this.dataUrodzenia);
		rok = Integer.parseInt(dzienMiesiacRok.get(2));

		return rok;
	}

// wyłuskanie pierwszej litery nazwiska

	public String pobierzPierwszaLitereNazwiska() {

		String litera = this.nazwisko.substring(0, 1);

		return litera;
	}

//	 przesloniecie do wyswietlania inaczej bedzie hashkod	
	@Override
	public String toString() {
		return String.format("%3s  %-10s  %10s  %3s cm", imie, nazwisko, dataUrodzenia, wzrost);
	}
	

}
