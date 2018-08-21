package zad4_3;

import java.util.Map;

public class Glowny {
    public static void main(String[] args) {
 

    }





    // z użyciem metody containsKey
    public static void merge1(String klucz, Integer wartosc, Map<String, Integer> counts) throws NullPointerException {


        if (wartosc == null) {
            counts.remove(klucz);
            throw new NullPointerException();
        } else if (counts.containsKey(klucz)) {
            if (counts.get(klucz) == null) {
                counts.put(klucz, wartosc);
            } else {
                counts.put(klucz, counts.get(klucz) + wartosc);
            }
        } else {
            counts.put(klucz, wartosc);
        }
    }

    //z użyciem metody get oraz sprawdzania null-a
    public static void merge2(String klucz, Integer wartosc, Map<String, Integer> counts) throws NullPointerException {
        if (wartosc == null) {
            counts.remove(klucz);
            throw new NullPointerException();
        } else if (counts.get(klucz) == null) {
            counts.put(klucz, wartosc);
        } else {
            counts.put(klucz, counts.get(klucz) + wartosc);
        }


    }

    // z użyciem getOrDefault
    public static void merge3(String klucz, Integer wartosc, Map<String, Integer> counts) throws NullPointerException {
        if (wartosc == null) {
            counts.remove(klucz);
            throw new NullPointerException();
        } else if (counts.getOrDefault(klucz, wartosc) == wartosc) {
            counts.put(klucz, wartosc);
        } else if (counts.getOrDefault(klucz, wartosc) == null) {
            counts.put(klucz, wartosc);
        } else {
            counts.put(klucz, counts.get(klucz) + wartosc);
        }
    }

    // z użyciem putIfAbsent
    public static void merge4(String klucz, Integer wartosc, Map<String, Integer> counts) throws NullPointerException {
        if (wartosc == null) {
            counts.remove(klucz);
            throw new NullPointerException();
        } else if (counts.putIfAbsent(klucz, wartosc) == null) ;
        else {
            counts.put(klucz, counts.get(klucz) + wartosc);
        }

    }
}
