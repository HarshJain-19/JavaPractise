package java8.collectors;

import java.util.*;
import java.util.stream.*;

public class SummingAndAveraging {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        int sum1 = list.stream().collect(Collectors.summingInt(Integer::intValue));
        int sum2 = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum1);

        double average1 = list.stream().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println(average1);
        OptionalDouble average2 = list.stream().mapToInt(x -> x).average();
        average2.ifPresentOrElse(System.out::println, () -> System.out.println("null"));
    }
}
