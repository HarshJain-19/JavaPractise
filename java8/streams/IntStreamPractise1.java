package java8.streams;

import java.util.stream.IntStream;

public class IntStreamPractise1 {
    public static void main(String[] args) {
        IntStream.rangeClosed(0, 30)
                .filter(x -> x % 2 == 0)
                .mapToObj(String::valueOf)
                .forEach(System.out::println);
    }
}
