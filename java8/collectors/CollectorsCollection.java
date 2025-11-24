package java8.collectors;

import java.util.*;
import java.util.stream.*;

public class CollectorsCollection {
    public static void main(String[] args) {
        List<Integer> intList = IntStream.range(0,10)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(intList);

        List<Long> longList = LongStream.range(0,20)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(longList);

        List<Double> doubleList = LongStream.range(0,12)
                .asDoubleStream()
                .boxed()
                .collect(Collectors.toList());
        System.out.println(doubleList);

        double average = doubleList.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
        System.out.println(average);
    }
}
