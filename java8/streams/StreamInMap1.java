package java8.streams;

import java.util.*;
import java.util.stream.*;

public class StreamInMap1    {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");

        // stream in map
        map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey))
                .entrySet()
                .forEach(System.out::println);

        // only keys
        map.keySet()
                .stream()
                .forEach(System.out::print);
        System.out.println();

        // only values
        map.values()
                .stream()
                .forEach(System.out::print);
        System.out.println();
    }
}
