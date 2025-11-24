package java8.streams;

import java.util.*;
import java.util.stream.*;

public class AllMethodsOfStream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//  collect(Collector)

        // 1. Creating a stream from a collection (List)
        Stream<Integer> streamFromList = numbers.stream();
        System.out.println("stream from list: " + streamFromList);

        // 2. map(Function): Using `map` (Intermediate operation) to transform elements
        List<Integer> squaredList = streamFromList
                .map(n -> n * n)  // Squaring each number
                .collect(Collectors.toList());
        System.out.println("Squared numbers: " + squaredList);

        // 3. filter(Predicate): Using `filter` (Intermediate operation) to filter elements
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)  // Keeping only even numbers
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        // 4. distinct(): Using `distinct` (Intermediate operation) to remove duplicates
        List<Integer> duplicates = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> distinctNumbers = duplicates.stream()
                .distinct()  // Removing duplicates
                .collect(Collectors.toList());
        System.out.println("Distinct numbers: " + distinctNumbers);

        // 5. sorted(Comparator): Using `sorted` (Intermediate operation) to sort elements
        List<Integer> sortedList = numbers.stream()
//                .sorted()  // Default sorting (ascending order)
                .sorted(Comparator.reverseOrder())   //sorting(descending order)
                .collect(Collectors.toList());
        System.out.println("Sorted numbers in reverse: " + sortedList);

        // 6. limit(long): Using `limit` (Intermediate operation) to get a fixed number of elements
        List<Integer> limitedList = numbers.stream()
                .limit(5)  // Limiting to the first 5 elements
                .collect(Collectors.toList());
        System.out.println("Limited numbers: " + limitedList);

        // 7. skip(long): Using `skip` (Intermediate operation) to skip elements
        List<Integer> skippedList = numbers.stream()
                .skip(5)  // Skipping the first 5 elements
                .collect(Collectors.toList());
        System.out.println("Skipped numbers: " + skippedList);

        // 8. reduce(BinaryOperator): Using `reduce` (Terminal operation) to aggregate elements
        Optional<Integer> sum = numbers.stream()
//                .reduce((a, b) -> a + b);   // Summing up the elements
                .reduce(Integer::sum);
        sum.ifPresent(s -> System.out.println("Sum: " + s));

        // 9. forEach(Consumer): Using `forEach` (Terminal operation) to perform an action on each element
        System.out.print("Numbers: ");
        numbers.stream().forEach(n -> System.out.print(n + " "));
//        numbers.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 10. anyMatch|allMatch|noneMatch(Predicate): Using `anyMatch`, `allMatch`, `noneMatch` (Terminal operations) to test conditions
        boolean hasEven = numbers.stream().anyMatch(n -> n % 2 == 0);  // Checking if any number is even
        boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);  // Checking if all numbers are even
        boolean noneEven = numbers.stream().noneMatch(n -> n % 2 == 0);  // Checking if none are even
        System.out.println("Any even? " + hasEven);
        System.out.println("All even? " + allEven);
        System.out.println("None even? " + noneEven);

        // 11. count(): Using `count` (Terminal operation) to count elements
        long count = numbers.stream().count();  // Counting the number of elements
//        long count = numbers.size();
        System.out.println("Count: " + count);

        // 12. Using `max` and `min` (Terminal operations) to find the max and min elements
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);  // Finding max
        Optional<String> min = Stream.of("apple", "banana", "cherry", "date")
                .min(Comparator.comparingInt(String::length));
        max.ifPresent(m -> System.out.println("Max: " + m));
        min.ifPresent(m -> System.out.println("Min: " + m));

        // 13. flatMap(Function): Using `flatMap` (Intermediate operation) to flatten nested structures
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        List<Integer> flattenedList = nestedList.stream()
//                .flatMap(list -> list.stream())  // Flattening the nested lists
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened List: " + flattenedList);

        // 14. peek(Consumer): Using `peek` (Intermediate operation) to inspect elements (debugging purposes)
        List<Integer> peekedList = numbers.stream()
                .peek(n -> System.out.println("Processing: " + n))  // Inspect each element
                .map(n -> n * 2)  // Map to double the value
                .collect(Collectors.toList());
        System.out.println("Peeked List: " + peekedList);

        // 15. findFirst|findAny(): `FindFirst` & `FindAny`
        Optional<Integer> first = numbers.parallelStream().findFirst();
        Optional<Integer> any = numbers.parallelStream().findAny();

        first.ifPresent(x -> System.out.println("find first: " + x));
        any.ifPresent(x -> System.out.println("find any: " + x));

        // 16. `toArray`
        Integer[] arrayNumbers = numbers.stream()
                .toArray(Integer[]::new);
//        Integer[] arrayNumbers = numbers.toArray(Integer[]::new);
        System.out.println("Array from list: " + Arrays.toString(arrayNumbers));

        // 17. `join`
        String joined = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("-"));
        System.out.println("Joined numbers: " + joined);

        // 18. Iterator
        Iterator<Integer> iterator = numbers.stream().iterator();

        // 19. Converting stream to intStream
        String[] numbersList = {"1", "2", "3", "4", "5"};
        IntStream intStream = Arrays.stream(numbersList)
                .mapToInt(Integer::parseInt);
        System.out.println("sum: " + intStream.sum());

        intStream = Arrays.stream(numbersList)
                .mapToInt(Integer::parseInt);
        System.out.println("average: " + intStream.average());

        intStream = Arrays.stream(numbersList)
                .mapToInt(Integer::parseInt);
        System.out.println("max: " + intStream.max());

        intStream = Arrays.stream(numbersList)
                .mapToInt(Integer::parseInt);
        System.out.println("min: " + intStream.min());

        int[] intArray = Arrays.stream(numbersList)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("Array: " + Arrays.toString(intArray));

        // 20. Converting stream to streamObjects
        Stream<Integer> s = numbers.stream()
                .mapToInt(x -> x)
                .mapToObj(Integer::valueOf);
//                .boxed();

        // 21. takeWhile(predicate): `takeWhile`
        int[] takeWhileArray = Stream.of(1,2,3,4,5,6,7,8,9,1,2,3,4)
                .takeWhile(x -> x <= 5)
                .mapToInt(Integer::valueOf)
                .toArray();
        System.out.println("result of take-while: " + Arrays.toString(takeWhileArray));

        // 22. dropWhile(predicate): `dropWhile`
        int[] dropWhileArray = Stream.of(1,2,3,4,5,6,7,8,9,1,2,3,4)
                .dropWhile(x -> x <= 5)
                .mapToInt(Integer::valueOf)
                .toArray();
        System.out.println("result of drop-while: " + Arrays.toString(dropWhileArray));

        // 23. parallel & Sequential
        IntStream.rangeClosed(1,5).parallel().sequential().forEach(System.out::println);

        // 24. adding two streams
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5);
        Stream<Integer> stream2 = Stream.of(9,8,7,6);

        Stream<Integer> stream3 = Stream.concat(stream1, stream2);
    }
}
