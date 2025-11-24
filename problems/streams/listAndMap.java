package problems.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class listAndMap {
    public static void main(String[] args) {

        //Ques.1 Convert list(string) to map(string, length)
        List<String> list = List.of("Red", "Green", "Blue", "Orange", "Pink", "Black", "Yellow");
        Map<String, Integer> map = list.stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(map);

        //Ques.2 Convert map to String
        String str = map.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining("|"));
        System.out.println(str);
    }
}
