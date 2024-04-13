package com;

import com.model.Employee;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestJava8Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Puneet", "DEV", 50000, Arrays.asList(111, 222));
        Employee e2 = new Employee(1, "Arun", "QA", 20000, Arrays.asList(333, 444));
        Employee e3 = new Employee(1, "Jaideep", "DEV", 40000, Arrays.asList(555, 666));
        Employee e4 = new Employee(1, "Prerna", "DEV", 30000, Arrays.asList(777, 888));
        Employee e5 = new Employee(1, "Srilekha", "QA", 30000, Arrays.asList(999, 000));

        List<Employee> employeeList = Arrays.asList(e1, e2, e3, e4, e5);
        Employee maxSalEmp = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).get();
        System.out.println(maxSalEmp);

        //group by department
        Map<String, List<Employee>> empByDep = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println(empByDep);

        //show highest salary emp from each dep
        Map<String, Optional<Employee>> highestSalByDep = employeeList.stream().collect(
                Collectors.groupingBy(Employee::getDepartment,
                        Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary))))
        );

        System.out.println(highestSalByDep);

        ///

        List<String> namesList = employeeList.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(namesList);

        //
        List<Integer> phoneList = employeeList.stream()
                .flatMap(x -> x.getPhoneNumbers().stream()).collect(Collectors.toList());
        System.out.println(phoneList);

        List<String> parallelNames = employeeList.parallelStream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(parallelNames);


        //javaconceptt of the dat

        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
        Map<Boolean, List<Integer>> oddEvenSplit = listOfIntegers.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        oddEvenSplit.forEach((k, v) -> {
            if (k == true) {
                System.out.println("Even Numbers");
            }
            if (k == false) {
                System.out.println("Odd Numbers");
            }
            v.stream().forEach(x -> System.out.println(x));
        });

        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        List<String> distinctStringList = listOfStrings.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctStringList);

        //frequency
        String inputString = "Java Concept Of The Day";
        Map<Character, Long> characterLongMap = inputString.chars()
                .sorted()
                .mapToObj(c -> (char) c)
                .filter(x -> !Character.isWhitespace(x))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(characterLongMap);

        //reverse order

        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        List<Double> doubleList = decimalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(doubleList);

        //
        List<String> listOfStringsPrefixSuffix = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        String prefixSuffix = listOfStringsPrefixSuffix.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println(prefixSuffix);

        //max and min
        List<Integer> listOfIntegersMaxMin = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        Integer maxInt = listOfIntegersMaxMin.stream().max(Integer::compareTo).orElse(1);
        System.out.println(maxInt);

        //merge two sorted arrays
        int[] a = new int[]{4, 2, 7, 1};

        int[] b = new int[]{8, 3, 9, 5};

        int[] c = Arrays.stream(IntStream.concat(IntStream.of(a), IntStream.of(b)).toArray()).sorted().toArray();
        System.out.println(Arrays.toString(c));

        List<Integer> listOfIntegers3Max = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        List<Integer> max3 = listOfIntegers3Max.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        System.out.println(max3);

        //anagram

        String s1 = "RaceCar";
        String s2 = "CarRace";

        String s1Converted = s1.chars().sorted().mapToObj(ch1 -> String.valueOf((char) ch1)).collect(Collectors.joining());
        String s2Converted = s2.chars().sorted().mapToObj(ch1 -> String.valueOf((char) ch1)).collect(Collectors.joining());

        if(s1Converted.equals(s2Converted))
            System.out.println(true);

        //sum of all digits
        int i = 15623;
        Integer integerSum = Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println(integerSum);

        //increasing order of length

        List<String> listOfStringsOrder = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        List<String> orderedStringList = listOfStringsOrder.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        System.out.println(orderedStringList);

        //find common

        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);

        List<Integer> commonItems = list1.stream().filter(x -> list2.contains(x)).collect(Collectors.toList());
        System.out.println(commonItems);

        //reverse each word
        String strReverseEachWord = "Java Concept Of The Day";
        String reveredOrderString = Stream.of(strReverseEachWord.split(" "))
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
        System.out.println(reveredOrderString);

       //most repeated element
/*        List<String> listOfStringsMostRepeated = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
        Map<String, Long> stringLongMap = listOfStringsMostRepeated.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        stringLongMap.values().stream().max(Long::compareTo);*/


        List<String> listOfStringsMostRepeated = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
        Map<String, Long> stringLongMap = listOfStringsMostRepeated.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        stringLongMap.entrySet().stream().map(e -> e.getValue()).max(Long::compareTo);

        //palindroome
        String palin = "ROTATOR";
        boolean pflag = true;
        for(int p=0;p<palin.length()/2;p++) {
            if(palin.charAt(p) != palin.charAt(palin.length()-p-1)) {
                pflag = false;
            }
        }
        System.out.println(pflag);

      //duplicate chars in string
        String inputStringDup = "Java Concept Of The Day";
        String removedDupString = Stream.of(inputStringDup.split("")).map(String::toLowerCase).distinct().collect(Collectors.joining());
        System.out.println(removedDupString);

        Set<String> set = new HashSet<>();
        String removedDup = Stream.of(inputString.split(""))
                .map(String::toLowerCase)
                .filter(d -> !(set.add(d)))
                .filter(e -> !" ".equals(e))
                .collect(Collectors.joining(","));
        System.out.println(removedDup);

        String strStrip = "technologies";
        String stripStrPrint = Stream.of(strStrip.split("")).skip(1).limit(strStrip.length()-3).collect(Collectors.joining());
        System.out.println(stripStrPrint);


    }
}
