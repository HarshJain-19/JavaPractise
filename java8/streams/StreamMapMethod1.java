package java8.streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamMapMethod1 {
    public static void main(String[] args) {
        List<String> strList = List.of("Ac", "Bcd", "Lodder", "pomter", "Local");
        System.out.println(strList.stream().map(String::length).collect(Collectors.toList()));

        List<List<Integer>> listList = List.of(List.of(1,2), List.of(3,4,5), List.of(6,7));
        System.out.println(listList.stream().flatMap(List::stream).collect(Collectors.toList()));
    }
}
