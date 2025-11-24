package java8.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintingStreams {
    public static void main(String[] args) {
        //1 - by making it list
        Stream<String> stream = Stream.of("Abc", "Bcd", "Cde", "Def", "Efg", "Fgh", "Ghi");

//        List<String> streamList = stream.collect(Collectors.collect(Collectors.toList()));
        List<String> streamList = stream.collect(Collectors.toList());
        System.out.println(streamList);


        //2 - by forEach method
        stream = Stream.of("Abc", "Bcd", "Cde", "Def", "Efg", "Fgh", "Ghi");

        stream.forEach(System.out::print);
        System.out.println();


        //3 - by peek method
        stream = Stream.of("Abc", "Bcd", "Cde", "Def", "Efg", "Fgh", "Ghi");

        stream.peek(System.out::print).forEach(x -> {});
    }
}
