package java8.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamInList1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,4,2,4,4,6,7,8,2,4,0,1,6,9,7,5,3);

        List<Integer> evenList = list.stream().filter(x -> x%2==0).distinct().collect(Collectors.toList());
        List<Integer> oddList = list.stream().filter(x -> x%2!=0).distinct().collect(Collectors.toList());
        System.out.println(evenList);
        System.out.println(oddList);
    }
}
