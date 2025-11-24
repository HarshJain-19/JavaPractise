package collections;

import java.util.Comparator;
import java.util.TreeMap;

class Students {
    int rollno;
    String name;

    Students(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    public String toString() {
        return this.rollno + "_" + this.name;
    }
}

class SortByRollno implements Comparator<Students> {
    @Override
    public int compare(Students a, Students b) {
        return a.rollno - b.rollno;
    }
}

public class TreeMapPractise {
    public static void main(String[] args) {
        TreeMap<Students, Integer> tree_map = new TreeMap<Students, Integer>(new SortByRollno()); // O(1)

        tree_map.put(new Students(121, "bbbb"), 2); // O(log n)
        tree_map.put(new Students(151, "aaaa"), 3); // O(log n)
        tree_map.put(new Students(111, "cccc"), 1); // O(log n)

        System.out.println("TreeMap: " + tree_map); // O(n)
    }
}

