package java8.streams;

import java.util.*;
import java.util.stream.*;

public class StreamInArrays1 {
    public static void main(String[] args) {
        String[] strs = {"a","b","c","d"};

        // by Arrays.stream()
        Arrays.stream(strs)
                .forEach(System.out::print);
        System.out.println();

        //by Stream.of()
        Stream.of(strs)
                .forEach(System.out::print);

        //by List.stream()
        Arrays.asList(strs).stream().forEach(System.out::print);
        System.out.println();

        int[] nums = {4,7,1,3,8,2};
        IntStream.of(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::print);
        System.out.println();
    }
}
