package com.Hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestImmutableMain {
    public static void main(String[] args) {
        List<String> namesList = new ArrayList<>();
        namesList.add("Puneet");
        namesList.add("Nitin");
        namesList.add("Hemant");

        System.out.println(namesList);

        List<String> unmodList = Collections.unmodifiableList(namesList);
        //   unmodList.add("AK");UnsupportedOperationException
      //  unmodList.set(0, "test");
        System.out.println(unmodList);
    }
}
