package java8.optionals;

import java.util.Optional;

public class OptionalPractise1 {
    public static void main(String[] args) {
        String[] strs = new String[10];

//        String upper = strs[5].toUpperCase();           // NullPointerException

        Optional<String> optionalStr = Optional.ofNullable(strs[5]);

        if (optionalStr.isPresent())
            System.out.println(optionalStr.get().toUpperCase());
        else {
            System.out.println("5 is not present");
        }

        Optional<String> optional1 = Optional.ofNullable(null);
        System.out.println(optional1);
        if (optional1.isPresent()) {
            System.out.println("value is present");
        }

        Optional<String> optional2 = Optional.of("Hello");
        System.out.println(optional2);

        System.out.println(Optional.empty());

        System.out.println(optional1.orElse("123"));

        System.out.println("\nHash Codes");
        System.out.println(Optional.ofNullable(1234).hashCode());
        System.out.println(Optional.ofNullable(97).hashCode());
        System.out.println(Optional.ofNullable("a").hashCode());
        System.out.println(Optional.ofNullable("string").hashCode());
        System.out.println(Optional.empty().hashCode());

        System.out.println(Optional.of(97).equals(Optional.of("a")));

        //filter in optionals
        Optional<Integer> optional3 = Optional.of(456);
        System.out.println(optional3.filter(x -> x%2==0));
        Optional<Integer> optional4 = Optional.of(455);
        System.out.println(optional4.filter(x -> x%2==0));

        //or that return another Optional class
        System.out.println(optional1.or(Optional::empty).or(() -> optional2));
    }
}
