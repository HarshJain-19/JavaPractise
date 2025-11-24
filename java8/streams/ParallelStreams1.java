package java8.streams;

import java.util.*;
import java.util.stream.Collectors;

public class ParallelStreams1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        // stream
        list.stream().map(x -> x*2).forEach(System.out::print);
        System.out.println();

        // parallel stream
        list.parallelStream().map(x -> x*2).forEach(System.out::print);
        System.out.println();

        // parallel stream with ordered for Each
        list.parallelStream().map(x -> x*2).forEachOrdered(System.out::println);

        // thread-safety result
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = new ArrayList<>();

        numbers.parallelStream().forEach(result::add);  // ❌ Not thread-safe
        System.out.println("result: " + result);

        System.out.println("thread safe result: " + numbers.parallelStream().collect(Collectors.toList())); // ✔ Not thread-safe

    }
}
