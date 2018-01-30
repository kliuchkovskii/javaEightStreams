package com.javaeightstreams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsTest {
    private static List<Integer> randomList;
    public static void main(String[] args) {
        System.out.println("Filtering : ");
        List<String> list = Arrays.asList("First", "Second", "Third", "Fourth");
        List<String> filtered = list.stream().filter(s -> !(s.equals("Second")||s.equals("Fourth"))).collect(Collectors.toList());
        list.forEach(System.out::println);
        filtered.forEach(System.out::println);
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", " ", "", "jkl");
        int count = (int) strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);

        List<String> strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd", " ", "", "jkl");
        List<String> filteredStrings = strings2.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        filteredStrings.forEach(System.out::println);
        System.out.println("---------------------------------");

        System.out.println("For each : ");
        randomList = new ArrayList<>();
        Random rand = new Random();
        rand.ints().limit(10).forEach(StreamsTest::setRandomList);
        randomList.forEach(System.out::println);
        System.out.println("---------------------------------");

        System.out.println("Mapping : ");
        List<Integer> numbers = Arrays.asList(1,1,2,1,1,2);
        List<Integer> squaresList = numbers.stream().map( i -> i*i).collect(Collectors.toList());
        squaresList.forEach(System.out::print);
        System.out.println();
        List<Integer> numbers2 = Arrays.asList(1,1,2,1,1,2);
        List<Integer> squaresList2 = numbers2.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        squaresList2.forEach(System.out::print);
        System.out.println("\n---------------------------------");

        System.out.println("Sorting : ");
        List<Integer> intList = Arrays.asList(100,4,12,0,-4);
        intList.stream().sorted().forEach(System.out::println);

        List<String> stringList = Arrays.asList("bcd", "abc", "efg");
        stringList.stream().sorted().forEach(System.out::println);
        System.out.println("---------------------------------");

        System.out.println("Parallel stream : ");
        int countParallel = (int) strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(countParallel);
        System.out.println("---------------------------------");

        System.out.println("Collectors : ");
        List<String> filtered2 = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered2);

        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + mergedString);
        System.out.println("---------------------------------");

        System.out.println("Statistics : ");
        randomList = new ArrayList<>();
        rand.ints().limit(10).forEach(StreamsTest::setRandomList);
        IntSummaryStatistics stats = randomList.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println(randomList);
        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }

    private static void setRandomList(Object o){
        randomList.add((Integer) o);
    }
}
