package java8.streams;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilterMethod1 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Hello", "How", "are", "you", "?");

//        Stream<String> stream1 = stream.filter(x -> x.startsWith("H"));
//        stream1.forEach(System.out::println);

        System.out.println(stream.filter(x -> x.length()<=3).collect(Collectors.joining(" ")));

        String[] myArray = new String[] { "stream",   "is",  "a", "sequence", "of",  "elements", "like",     "list" };

        Stream<String> myStream = Stream.of(myArray);

        AtomicInteger i = new AtomicInteger(0);

        myStream.filter(x -> i.getAndIncrement() % 2 == 0).forEach(System.out::println);
    }
}
