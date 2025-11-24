package generics;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WildcardPractise2 {
//    public static <E> List<? extends E> mergeWildcard0(List<? extends E> listOne, List<? extends E> listTwo) {}

    public static <E> List<E> mergeWildcard(List<? extends E> listOne, List<? extends E> listTwo) {
        return Stream.concat(listOne.stream(), listTwo.stream())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Number> numbers1 = new ArrayList<>();
        numbers1.add(5);
        numbers1.add(10L);

        List<Number> numbers2 = new ArrayList<>();
        numbers2.add(15f);
        numbers2.add(20.0);

        List<Number> numberMerged = WildcardPractise2.mergeWildcard(numbers1, numbers2);
    }
}
