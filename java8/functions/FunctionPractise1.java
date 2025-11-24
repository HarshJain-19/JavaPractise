package java8.functions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionPractise1 {
    public static void main(String[] args) {
        Function<Double, Double> half = x -> x/2.0;
        Function<Double, Double> threeTimes = x -> x*3.0;

        System.out.println(half.andThen(threeTimes).apply(15.0));
        System.out.println(half.compose(threeTimes).apply(15.0));

        Function<Integer, Integer> iden = Function.identity();
        System.out.println(iden.apply(15));

        BiFunction<Double, Double, Double> multiply = (a,b) -> a*b;
        System.out.println(multiply.andThen(half).apply(10.0, 20.0));
    }
}
