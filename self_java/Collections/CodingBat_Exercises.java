package CodingBat;

import java.util.*;

public class Exercises {

    public static void main(String[] args) {

        System.out.println(firstChar(new String[]{"salt", "tea", "soda", "toast"}));
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

    public static Map<String, Integer> wordCount(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        if (words.length == 0) {
            return map;
        }

        for (String word : words) {

            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }

    public Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for (String str : strings) {
            map.put(str.substring(0, 1), str.substring(str.length() - 1));
        }
        return map;
    }

//    public void wordAppend(String[] strings) {
//        Map<String, Integer> appendMap = new HashMap<>();
//        for(String string : strings) {
//            appendMap.put(string, appendMap.getOrDefault(string, 0) + 1);
//        }
//
//        appendMap.forEach((key, value) -> {
//            if (value > 1) System.out.println(key.repeat(value));
//        });
//    }

//    public String wordAppend(String[] strings) {
//        Map<String, Integer> appendMap = new HashMap<>();
//        StringBuilder output = new StringBuilder();
//        for(String string : strings) {
//            appendMap.put(string, appendMap.getOrDefault(string, 0) + 1);
//        }
//
//        appendMap.forEach((key, value) -> {
//            if (value > 1) output.append(String.join("", Collections.nCopies(value, key)));
//        });
//        return output.toString();
//    }

    public String wordAppend(String[] strings) {
        Map<String, Integer> appendMap = new HashMap<>();
        StringBuilder output = new StringBuilder();
        for(String string : strings) {
            appendMap.put(string, appendMap.getOrDefault(string, 0) + 1);
            if (appendMap.get(string) > 1 &&  appendMap.get(string) % 2 == 0) output.append(string);
        }

        return output.toString();
    }

    public List<Integer> doubling(List<Integer> nums) {
        nums.replaceAll(k -> (k*2));
        return nums;
    }

    public List<String> square(List<String> nums) {
        nums.replaceAll(k -> "y" + k + "y");
        return nums;
    }


}
