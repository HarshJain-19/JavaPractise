package collections;

import java.lang.Iterable;
import java.util.Iterator;
import java.util.ArrayList;

public class IterablePractise {
    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        arrList.add(4);
        arrList.add(15);
        arrList.add(26);

        Iterable<Integer> iter = arrList;
        System.out.println(iter);

        // enhanced for loop or for-each loop
        for(Integer i: iter) {
            System.out.println(i);
        }

        Iterator<Integer> it = iter.iterator();

        //iterator
        while (it.hasNext()) {
            System.out.println(it.next());
            it.remove();
        }
        System.out.println(iter);
    }
}
