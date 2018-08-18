package zad4_1;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class Glowny {

    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        try (Stream<String> stream = new BufferedReader(new FileReader("dane.txt")).lines()) {
            stream.filter(s -> s.contains("PL"))
                    .forEach(list::add);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Pattern p = Pattern.compile("\\d+");

        List<Integer> listPensja = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String element = list.get(i);
            Matcher m = p.matcher(element);
            m.find();
            int pensja = Integer.parseInt(m.group());
            listPensja.add(pensja);
        }


        System.out.println();


        System.out.println("suma pensji 2 najmniej zarabiających: " + listPensja.stream()
                .sorted()
                .peek(s -> System.out.println("podglad peek(): " + s))
                .limit(2)
                .mapToInt(Integer::intValue)
                .sum());

        System.out.println();

        System.out.println("suma pensji 2 najlepiej zarabiających: " + listPensja.stream()
                .sorted(Comparator.reverseOrder())
                .peek(s -> System.out.println("podglad peek(): " + s))
                .limit(2)
                .mapToInt(Integer::intValue)
				.sum());

	}
}
