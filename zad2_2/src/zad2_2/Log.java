package zad2_2;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {

	public Logger logger;
	FileHandler fh;

	public Log(String file_name) {
		File f = new File(file_name);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			// stworzenie uchwytu, false - nie bedzie dopisywal do istniejacego
			// pliku
			fh = new FileHandler(file_name, false);
			// getLogger tworzy lub pobiera rejestrator
			logger = Logger.getLogger("zadanie6");
			// dodanie uchwytu
			logger.addHandler(fh);
			// zapis w prostym formacie
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
