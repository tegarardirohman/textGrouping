package com.enigmacamp;

import java.util.*;

public class Main {

    // text grouping with return MAP
    static Map<Character, Integer> textGrouping(String[] arr) {
        Map<Character, Integer> result = new HashMap<>();

        for (String data : arr) {
            for (int j = 0; j < data.length(); j++) {
                char ch = data.charAt(j);
                if (result.containsKey(ch)) {
                    result.put(ch, result.get(ch) + 1);
                } else {
                    result.put(ch, 1);
                }
            }
        }

        return result;
    }

    //sorting based on higher freq
    static String sorting(Map<Character, Integer> textGrouping) {
        // convert from map to list
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(textGrouping.entrySet());

        // bubble sort
        int n = entryList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Map.Entry<Character, Integer> e1 = entryList.get(j);
                Map.Entry<Character, Integer> e2 = entryList.get(j + 1);
                int valueCompare = Integer.compare(e2.getValue(), e1.getValue());
                if (valueCompare == 0) {
                    valueCompare = Character.compare(e1.getKey(), e2.getKey()); // sort based on abjad
                }
                if (valueCompare > 0) {
                    // swap element
                    Collections.swap(entryList, j, j + 1);
                }
            }
        }

        // Build a string
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entryList) {
            result.append(entry.getKey());
        }

        return result.toString();
    }


    public static void main(String[] args) {
        String[] input = {"Pendanaan", "Terproteksi", "Untuk", "Dampak", "Berarti"};

        // text grouping
        Map<Character, Integer> textGrouping = textGrouping(input);

        String sorted = sorting(textGrouping);

        System.out.println(sorted);


    }
}
