package java8.lambdaExpressions;

import java.util.*;

public class LambdaExpressionPractise3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("abc", "def", "bcd", "zdp", "kkp", "ggi", "igi"));
        //Comparable compareTo method
        list.sort((a,b) -> a.compareTo(b));
        //or
//        list.sort(String::compareTo);
        System.out.println(list);

        //Comparator compare method
        TreeSet<Integer> treeSet = new TreeSet<>((a,b) -> b-a);
        treeSet.addAll(List.of(2,5,7,1,4,7,8));
        System.out.println(treeSet);
    }
}
