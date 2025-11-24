package problems.streams;

import java.util.*;
import java.util.stream.*;

//Ques. Sort the list of array such that first all odds come (in sorted) and then even come (in sorted)
public class SortingEvenAndOdd {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(9,5,7,1,8,3,2,4,6,10);

        List<Integer> result1 = numbers.stream()
                .sorted((a,b) -> {
                    if (a%2==0 && b%2!=0)
                        return 1;
                    else if (a%2!=0 && b%2==0)
                        return -1;
                    else
                        return Integer.compare(a,b);
//                        return a-b;
                })
                .collect(Collectors.toList());
        System.out.println(result1);

        List<Integer> result2 = numbers.stream()
                .sorted(Comparator.comparingInt((Integer x) -> x % 2)
                        .thenComparing(Integer::compare))
//                .sorted(Comparator.comparingInt(x -> (int) x % 2)
//                        .thenComparing((a,b) -> (int) a- (int) b))
                .collect(Collectors.toList());
        System.out.println(result2);
    }
}
