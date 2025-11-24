package java8.streams;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class StreamReduceMethod1 {
    public static void main(String[] args) {
        List<Integer> numList = List.of(2,3,4,5,6,7,8,9,1);

        List<Integer> oddList = numList.stream().reduce(new ArrayList<Integer>(), (a,b) -> {
            if (b%2!=0)
                a.add(b);
            return a;
        }, (a,b) -> {
            a.addAll(b);            //combiner function
            return a;
        });
//        System.out.println(oddList);

        ArrayDeque<Integer> reverseList = IntStream.rangeClosed(1,10)
                .boxed()
                .reduce(
                        new ArrayDeque<>(),
                        (acc, cur) -> {
                            acc.addFirst(cur);
                            return acc;
                        },
                        (a,b) -> {
                            a.addAll(b);
                            return a;
                        }
                );
//        System.out.println(reverseList);

        String reversedStr = IntStream.rangeClosed(1,10)
                .boxed()
                .reduce(
                        "",
                        (acc, cur) -> String.valueOf(cur) + acc,
                        (a,b) -> a+b
                );
//        System.out.println(reversedStr);

        int sum = Stream.of("1", "2", "3", "4", "5")
                .reduce(
                        0,
                        (a,b) -> {
                            return a + Integer.parseInt(b);
                        },
                        (a,b) -> {
                            System.out.println(a + " " + b);
                            return a+b;
                        }
                );
        System.out.println(sum);
    }
}
