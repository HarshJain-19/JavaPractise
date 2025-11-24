package java8.collectors;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.concurrent.*;

public class MethodsOfCollectors {
    public static void main(String[] args) {

        // 1: toList
        IntStream.range(1,10)
                .boxed()
                .collect(Collectors.toList());
//                .toList();

        // 2: toSet
        Set<Integer> setFromStream = Stream.of(1, 2, 3, 3, 4, 5)
                .collect(Collectors.toSet());

        // 3: toMap
        Map<Integer, String> mapFromStream = Stream.of("red", "blue", "green", "yellow")
                .collect(Collectors.toMap(String::length, Function.identity()));
        System.out.println("Map from stream: " + mapFromStream);

        // 4: joining
        String joinedString = Stream.of("red", "blue", "green", "yellow")
//                .collect(Collectors.joining(". "));
                .collect(Collectors.joining(", ", "{", "}"));
        System.out.println("Joined stream: " + joinedString);

        // 5: grouping by
        Map<Integer, List<String>> groupedString = Stream.of("red", "blue", "green", "yellow", "purple", "grey", "black")
                        .collect(Collectors.groupingBy(String::length));
        System.out.println("grouping stream: " + groupedString);

        Map<Integer, Long> groupedString1 = Stream.of("red", "blue", "green", "yellow", "purple", "grey", "black")
                        .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println("grouping stream with count: " + groupedString1);

        Map<Integer, String> groupedString2 = Stream.of("red", "blue", "green", "yellow", "purple", "grey", "black")
                        .collect(Collectors.groupingBy(
                                String::length,
                                Collectors.mapping(
                                        word -> word.substring(0,1),
                                        Collectors.joining("|")
                                ))
                        );
        System.out.println("grouping stream with first letter: " + groupedString2);

        // 6: Partitioning by
        Map<Boolean, List<Integer>> partitionedStream = Stream.of(1,2,3,4,5,6,7,8,9)
                .collect(Collectors.partitioningBy(x -> x>5));
        System.out.println("Patitioned of stream: " + partitionedStream);

        // 7: counting
        Long count = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.counting());
//                .count();

        // 8: Summarizing (int, long, double)
        IntSummaryStatistics intSummary = Stream.of(1,2,3,4,5,6,7,8,9)
                .collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println("summary of stream(1-9): " + intSummary);

        // 9: reducing
        int sum = IntStream.rangeClosed(1,5)
                .boxed()
                .collect(Collectors.reducing(0, Integer::sum));
        System.out.println("sum of 1-5: " + sum);

        // 10: mapping
        List<String> listFromStream = Stream.of("red", "blue", "green", "yellow")
                .collect(Collectors.mapping(String::toUpperCase, Collectors.toList()));
//                .map(String::toUpperCase).collect(Collectors.toList());

        // 11: flat mapping
        List<String> listOfCharFromStream = Stream.of("red", "blue", "green", "yellow")
                .collect(Collectors.flatMapping(x -> Stream.of(x.split("")), Collectors.toList()));
        List<String> listOfCharFromStream0 = Stream.of("red", "blue", "green", "yellow")
                .flatMap(x -> Stream.of(x.split("")))
                .collect(Collectors.toList());
        System.out.println("Characters from stream using collectors: " + listOfCharFromStream);
        System.out.println("Characters from stream without using collectors: " + listOfCharFromStream0);


        // 12: concurrent grouping
        ConcurrentMap<Integer, List<String>> groupedByLengthConcurrent = Stream.of("apple", "banana", "avocado", "cherry", "blueberry")
                .collect(Collectors.groupingByConcurrent(String::length));
        System.out.println("grouping by concurrent map: " + groupedByLengthConcurrent);

        // 14. averaging (int, double, long)
        double average = Stream.of(1,2,3,4,5)
                .collect(Collectors.averagingInt(Integer::intValue));
        System.out.println("average: " + average);

        // 15: collectingAndThen
        List<String> sortedList = Stream.of("apple", "banana", "avocado", "cherry", "blueberry")
                .collect(Collectors.collectingAndThen(
                        Collectors.mapping(String::toUpperCase, Collectors.toList()),
                        list -> {
                            list.sort(Comparator.naturalOrder());
                            return list;
                        }
                ));
        System.out.println("Sorted stream List by collecting and then: " + sortedList);

        // 16: minBy and maxBy
        int maxInt = IntStream.rangeClosed(1,10)
                .boxed()
                .collect(Collectors.maxBy(Integer::compareTo))
//                .max(Integer::compareTo)
                .orElse(0);

        // 17: toMap
        Map<Integer, String> wordMap = Stream.of("apple", "banana", "avocado")
                .collect(Collectors.toMap(String::length, word -> word));
        System.out.println("word map: " + wordMap);

        Map<Integer, String> wordMap1 = Stream.of("apple", "banana", "cherry", "avocado")
                .collect(Collectors.toMap(String::length,
                        UnaryOperator.identity(),
                        BinaryOperator.maxBy(String::compareTo)
                ));
        System.out.println("word map with replacement by max lexical order: " + wordMap1);

        Map<Integer, String> wordMap2 = Stream.of("apple", "banana", "cherry", "avocado")
                .collect(Collectors.toMap(
                        String::length,
                        UnaryOperator.identity(),
                         (existing, replacement) -> replacement,
                        TreeMap::new // Use TreeMap to sort by key
                ));
        System.out.println("word map with tree map: " + wordMap2);

        // toCollection
        List<String> listFromStream1 = Stream.of("abc","def","ghi")
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
