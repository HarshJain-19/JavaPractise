package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetPractise {
    public static void main(String[] args) {
        //hashSet
        HashSet<Integer> hs = new HashSet<>();

        hs.add(3);
        hs.add(-4);
        hs.add(2);
        hs.add(3);
        hs.add(null);
        hs.add(-3);

        System.out.println("hashSet: " + hs);
        //size
        System.out.println(hs.size());



        //linkedHashSet
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();

        lhs.add(3);
        lhs.add(-4);
        lhs.add(2);
        lhs.add(3);
        lhs.add(null);
        lhs.add(-3);

        System.out.println("linkedHashSet: " + lhs);



        //treeSet
        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(3);
        ts.add(-4);
        ts.add(2);
        ts.add(3);
//        ts.add(null);                         //nullPointerException
        ts.add(-3);

        System.out.println("treeSet: " + ts);
    }
}
