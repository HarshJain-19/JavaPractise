package collections;

import java.util.ArrayList;

public class ArrayListPractise {
    public static void main(String[] args) {
        int i1 = 5;

        ArrayList<String> al = new ArrayList<>();
        al.add("hello");
        al.add(Integer.toString(i1));
        al.add(new ArrayListPractise().toString());

        System.out.println(al);

        // array list are heterogeneous of type
        ArrayList list = new ArrayList();
        list.add("Abc");
        list.add("Def");
        list.add(13);
        list.add(20);

        System.out.println(list);
    }
}
