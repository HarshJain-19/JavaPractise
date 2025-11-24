package java8.functions;

import java.util.function.Supplier;

public class SupplierPractise1 {
    public static void main(String[] args) {
//        Supplier<Double> randomValue = Math::random;
        //or
        Supplier<Double> randomValue = () -> Math.random();

        System.out.println(randomValue.get());
    }
}
