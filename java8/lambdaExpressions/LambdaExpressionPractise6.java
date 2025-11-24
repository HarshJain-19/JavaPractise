package java8.lambdaExpressions;

import java.util.Objects;

@FunctionalInterface
interface Check<T> {
    boolean check(T x);
}

public class LambdaExpressionPractise6 {
    public static void main(String[] args) {
        Check<Integer> isEven = x -> (x&1)!=1;
        Check<Integer> isOdd = x -> (x&1)==1;

        if (isEven.check(21))
            System.out.println("21 is even");
        else if (isOdd.check(21)) {
            System.out.println("21 is odd");
        } else {
            System.out.println("what is 21");
        }

        Check<String> onlyAlpha = str -> (str!=null && !str.isEmpty() && str.chars().allMatch(Character::isLetter));

        if (onlyAlpha.check("Hello"))
            System.out.println("only alphabets");
        else
            System.out.println("no not all alphabets");
        
        Check<Object> isNull = Objects::nonNull;
    }
}
