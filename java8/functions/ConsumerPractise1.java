package java8.functions;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

public class ConsumerPractise1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // Using a Consumer to print each element of the list
        Consumer<String> printName = name -> System.out.println(name);
        //or
//        Consumer<String> printName = System.out::println;
        names.forEach(printName);

        //consumer methods
        Consumer<String> consumer1 = str -> {
            str += "!!!";
            System.out.println(str);
        };

        printName.accept("I am Consumer function!");

        Consumer<String> consumer2 = str -> {
            System.out.println(str);
        };

        consumer1.andThen(consumer2).accept("Hello");


    }
}
