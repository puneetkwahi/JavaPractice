package com.Hashmap;

import java.util.*;

public class TestHashmapMain {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        // Adding Key and Value pairs to HashMap
        map.put(44, "M");
        map.put(99, "I");
        map.put(22, "A");

        printMap(map);


        //sort by keys using treemap
        TreeMap<Integer, String> tMap = new TreeMap<>(map);
        printMap(tMap);

        List<Integer> sortedKeys = new ArrayList<>(map.keySet());
        Collections.sort(sortedKeys);
        for(Integer key : sortedKeys) {
            System.out.println(key + " --- " + map.get(key));
        }

        //sort hashmap by values
        Comparator comparator = new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        };

        ArrayList<Map.Entry<Integer, String>> entries = new ArrayList<>(map.entrySet());

        Collections.sort(entries, comparator);

        System.out.println("Sort by values");
        for(Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + " --- " + entry.getValue());
        }

    }

    static void printMap(Map<Integer, String> m) {
        for (Map.Entry<Integer, String> entry : m.entrySet()) {
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }

        System.out.println("===================");
    }


}
