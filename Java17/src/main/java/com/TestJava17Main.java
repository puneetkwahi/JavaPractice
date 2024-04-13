package com;

import java.util.List;

public class TestJava17Main {
    public static void main(String[] args) {
        //unmodifible list
        List<String> myList = List.of("Puneey", "papa"); //immutable list
        //List<String> myList2 = (List<String>) Collections.unmodifiableList("Puneet", "Papa");
        myList.add("Mumm");
        System.out.println(myList);

        //path.get read/write

        //predicate.not

        //string - stripLeading, stripTrailing, isBlank
        // \n lines

        //type inferences ( we can use var)

        //switch expressions

        //"""
          //      """

        //records
    }
}
