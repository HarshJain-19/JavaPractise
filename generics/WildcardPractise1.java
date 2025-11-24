package generics;

import java.util.List;
import java.util.Arrays;

public class WildcardPractise1 {
    //
    static double extendedSum(List<? extends Number> list) {
        double sum=0;
        for (Number i: list) {
            sum += i.doubleValue();
        }
        return sum;
    }

    static int superedSum(List<? super Integer> list) {
        int sum=0;
        for (Object i: list) {
            if (i instanceof Number)
                sum += (Integer) i;
        }
        return sum;
    }

    static void printList(List<?> list) {
        System.out.println(list);
    }

    public static void main(String[] args) {
        List<Number> aList0 = Arrays.asList(1,2,3,4,5);
        System.out.println(extendedSum(aList0));

        List<Integer> aList1 = Arrays.asList(1,2,3,4,5);
        System.out.println(extendedSum(aList1));

        List<Double> aList2 = Arrays.asList(1.2,2.4,3.1,4.9,5.0);
        System.out.println(extendedSum(aList2));

        List<Number> aList3 = Arrays.asList(10,20,30);
        System.out.println(superedSum(aList3));

        printList(aList0);
    }
}
