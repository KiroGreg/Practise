package Blatt09_ComputerSciencePeople;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


//        System.out.println(firstChar(new String[]{"salt", "tea", "soda", "toast"}));

        List<Integer> liste = new ArrayList<Integer>();

        liste.add(63);
        liste.add(14);
        liste.add(18);

        liste.remove(2);

        liste.set(1, 73);
        liste.add(73);

        int a = liste.indexOf(73);
        int b = liste.lastIndexOf(73);

        int c = liste.indexOf(63);
        int d = liste.indexOf(14);

        liste.add(0, 40);
        System.out.println(liste.toString());
        


    }

    public static Map<String, String> firstChar(String[] strings) {
        Map<String, String> map = new HashMap<>();
        if (strings.length == 0) {
            return map;
        }

        for (String str : strings) {
            String firstEl = str.substring(0, 1);

            map.compute(firstEl, (key, value) -> (value == null) ? str : value + str);
        }
        return map;
    }

    public void erhoeheElementeUm(List<Integer> zahlen, int n)
    {
        zahlen.replaceAll(zahl -> zahl += n);
    }
}

