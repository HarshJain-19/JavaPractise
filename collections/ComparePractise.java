package collections;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Abc implements Comparable<Abc> {
    private Integer a, b;

    public Abc(int a, int b) {
        this.a = a;
        this.b = b;
    }

    //natural comparing
    @Override
    public int compareTo(Abc obj) {
        return this.a - obj.a;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public String toString() {
        return String.format("a = %d and b = %d", a, b);
    }

}

class CompareAbc implements Comparator<Abc> {
    private String by;

    public CompareAbc(String by) {
        this.by = by;
    }

    @Override
    public int compare(Abc obj1, Abc obj2) {
        if (by.equalsIgnoreCase("a"))
            return obj1.getA()-obj2.getA();
        else if (by.equalsIgnoreCase("b"))
            return obj1.getB()-obj2.getB();
        else
            return 0;
    }
}

public class ComparePractise {
    public static void main(String[] args) {
        List<Abc> abcList = new ArrayList<>();

        abcList.add(new Abc(3,6));
        abcList.add(new Abc(7,1));
        abcList.add(new Abc(5,7));
        abcList.add(new Abc(1,2));
        abcList.add(new Abc(6,4));
        abcList.add(new Abc(2,3));
        abcList.add(new Abc(4,5));

        System.out.println("normal without sorting");
        abcList.forEach(obj -> System.out.println(obj));

        System.out.println("\nafter natural sorting");
//        Collections.sort(abcList);
        //or
        abcList.sort(Comparable::compareTo);
        abcList.forEach(System.out::println);

        System.out.println("\nafter external sorting");
        Collections.sort(abcList, new CompareAbc("b"));
        abcList.forEach(System.out::println);

        System.out.println("\nafter Collections reverse sorting by comparable");
        Collections.sort(abcList, Collections.reverseOrder());
        abcList.forEach(System.out::println);

        System.out.println("\nafter Collections reverse sorting by comparator");
        Collections.sort(abcList, Collections.reverseOrder(new CompareAbc("b")));
        abcList.forEach(System.out::println);

        //using lambda expression
        abcList.sort((o1, o2) -> o1.getA()-o2.getA());
        abcList.forEach(element -> System.out.println(element));
    }
}
