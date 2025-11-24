package problems.streams;

import java.util.*;
import java.util.stream.*;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Practise1 {
    public static void main(String[] args) {
        String[] strs = {"hello", "coke", "world", "penalty", "surrounding", "is"};

        //sorting by length of string
        System.out.println("sorting by length of strings: ");
        Stream.of(strs)
                .sorted(Comparator.comparingInt(String::length))
                .forEach(x -> System.out.print(x + ", "));
        System.out.println();

//        Ques.1 longest string in string arrays
        String longestString = Stream.of(strs)
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println("longest string: " + longestString);

//        Ques.2 Calculate the average age of a list of Person objects using Java streams:
        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );

        double averageAge = persons.stream()
                .collect(Collectors.averagingInt(person -> person.age));
        System.out.println("Average age: " + averageAge);
    }
}

