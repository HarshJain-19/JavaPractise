package java8.streams;

import java.util.*;
import java.util.stream.*;

public class WaysToCreateStream1 {
    public static void main(String[] args) {
        // 1. Creating a Stream from an array of elements
        Stream<String> streamOfArray = Stream.of("apple", "banana", "cherry");

        // 2. Creating a Stream from a single element
        Stream<String> streamOfNullable = Stream.ofNullable("apple");

        // 3. Creating an empty Stream
        Stream<String> emptyStream = Stream.empty();

        // 4. Creating a Stream from an iterative function (infinite)
        Stream<Integer> streamIterate = Stream.iterate(1, x -> x+1).limit(5);

        // 5. Creating a Stream using a Supplier (infinite)
        Stream<Double> streamGenerate = Stream.generate(Math::random).limit(5);

        // 6. creating a stream using a array
        Integer[] integerArray = {1,2,3,4,5,6};
        Stream<Integer> arraysStream1 = Arrays.stream(integerArray);
        Stream<Integer> arraysStream2 = Stream.of(integerArray);

        // 7. from stream builder
        Stream.Builder<String> streamBuilder = Stream.builder();
        streamBuilder.add("a").add("b").add("c");
        Stream<String> streamFromBuilder = streamBuilder.build();

        // 8. from stream support
        List<Integer> list = List.of(1,2,3,4,5);
        Stream<Integer> streamFromSplIterator = StreamSupport.stream(list.spliterator(), false);

        // difference between Stream.of and StreamofNullable
//        Stream.of(null).forEach(System.out::println);        //gives error
        System.out.println("Stream.ofNullable: ");
        Stream.ofNullable(null).forEach(System.out::println);

        // Stream.ofNullable() also gives chaining options to you
    }
}
