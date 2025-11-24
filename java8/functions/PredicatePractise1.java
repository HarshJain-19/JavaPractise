package java8.functions;

import java.util.function.Predicate;

public class PredicatePractise1 {
    public static void main(String[] args) {
        Predicate<Integer> greaterThanTen = (i) -> i > 10;
        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;

        boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println(result);

        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        System.out.println(result2);

        boolean result3 = lowerThanTwenty.or(greaterThanTen).test(21);
        System.out.println(result3);

        // not static method
        System.out.println(Predicate.not(lowerThanTwenty).test(5));
    }
}

