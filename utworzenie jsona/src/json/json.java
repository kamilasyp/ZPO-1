package json;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class json {

	public static void main(String[] args) {

		// tworzenie mapy, wartociami jest lista
		Map<String, List<String>> hmapPolEng = new HashMap<String, List<String>>();

		List<String> arrayRobic = Arrays.asList("do", "make");
		hmapPolEng.put("robić", arrayRobic);

		List<String> arrayIsc = Arrays.asList("go", "walk");
		hmapPolEng.put("iść", arrayIsc);

		List<String> arrayPieniadze = Arrays.asList("cash", "money");
		hmapPolEng.put("pieniądze", arrayPieniadze);

		List<String> arrayDostac = Arrays.asList("get");
		hmapPolEng.put("dostać", arrayDostac);

		List<String> arraySamochod = Arrays.asList("car");
		hmapPolEng.put("samochód", arraySamochod);

		List<String> arrayKwiatek = Arrays.asList("flower");
		hmapPolEng.put("kwiatek", arrayKwiatek);

		List<String> arrayPies = Arrays.asList("dog");
		hmapPolEng.put("pies", arrayPies);

		List<String> arrayKot = Arrays.asList("cat");
		hmapPolEng.put("kot", arrayKot);

		List<String> arrayDom = Arrays.asList("house", "home");
		hmapPolEng.put("dom", arrayDom);

		List<String> arrayRodzina = Arrays.asList("family");
		hmapPolEng.put("rodzina", arrayRodzina);

		Gson gson = new Gson();

		// tworzenie tokenu, zeby zadbac o zgodnosc typow przy
		// serializacji/deserializacji
		Type hMapType = new TypeToken<HashMap<String, List<String>>>() {
		}.getType();
		// serializacja
		String json = gson.toJson(hmapPolEng, hMapType);

		Map<String, List<String>> hmapPolEng2 = new HashMap<String, List<String>>();

		// deserializacja
		hmapPolEng2 = gson.fromJson(json, hMapType);

		// sprawdzenie czy wszystko odbylo sie ok
		String klucze[] = { "robić", "iść", "pieniądze", "dostać", "samochód", "kwiatek", "pies", "kot", "dom",
				"rodzina" };

		for (int i = 0; i < klucze.length; i++) {
			for (String slowo : hmapPolEng2.get(klucze[i])) {
				System.out.println(slowo);
			}
		}

		// zapis do pliku
		FileWriter fileWriter = null;

		try {
			try {
				fileWriter = new FileWriter("PolEngTest.json");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fileWriter.write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
