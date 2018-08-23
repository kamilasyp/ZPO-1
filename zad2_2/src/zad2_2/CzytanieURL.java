package zad2_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class CzytanieURL {

	public static ArrayList<String> odczytNazwisk() {
		// odczyt z URLa
		URL nazwiska = null;
		try {
//			nazwiska = new URL(
//					"https://gist.githubusercontent.com/jdudek/732279/raw/39e0ac7e7614857bf3759593d074131d605a71af/last.txt");
			nazwiska = new URL("https://raw.githubusercontent.com/mkolaczek/ZPO/master/nazwiska.txt");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(nazwiska.openStream(), "UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String nazwisko;

		ArrayList<String> listNazwiska = new ArrayList<String>();
		// dodanie nazwisk do listy
		try {
			while ((nazwisko = in.readLine()) != null) {
				listNazwiska.add(nazwisko);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listNazwiska;
	}

}
