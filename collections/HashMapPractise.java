package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Iterator;

class Student {
    private int id;
    private String name;
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id+ " " + name;
    }
}

public class HashMapPractise {
    public static void main(String[] args) {
        HashMap<Student, String> studentMap = new HashMap<>();

        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");
        Student student3 = new Student(1, "Alice");
        Student student4 = student2;

        studentMap.put(student1, "A Grade");
        studentMap.put(student2, "B Grade");

        System.out.println("Grade of student1: " + studentMap.get(student1));
        System.out.println("Grade of student2: " + studentMap.get(student2));
        System.out.println("Grade of student3: " + studentMap.get(student3));
        System.out.println("Grade of student4: " + studentMap.get(student4));

        System.out.println(Objects.hashCode(student1));
        System.out.println(Objects.hashCode(student2));
        System.out.println(Objects.hashCode(student3));
        System.out.println(Objects.hashCode(student4));

        System.out.println(studentMap);

        //put and putiFAbsent
        Student student5 = new Student(3, "Joe");
        System.out.println(studentMap.put(student5, "C Grade"));
        System.out.println(studentMap.put(student5, "D Grade"));        //returns previous and replace the value
        System.out.println(studentMap.get(student5));

        System.out.println(studentMap.putIfAbsent(student5, "E Grade"));  //returns
        System.out.println(studentMap.get(student5));

        studentMap.put(null, null);
        System.out.println(studentMap.get(null));

        //entryset
        Set<Map.Entry<Student, String>> mapEntrySet = studentMap.entrySet();
        System.out.println(mapEntrySet);

        /*
        for(Map.Entry<Student, String> mapEntry: studentMap.entrySet()) {
            System.out.println(mapEntry.getKey() + ": " + mapEntry.getValue());
        }
         */
        //or
//        studentMap.entrySet().forEach(System.out::println);
//        studentMap.entrySet().forEach(entry -> System.out.println(entry));

        //forEach
//        studentMap.forEach((id, name) -> System.out.println(id+"-"+name));

        //stream
//        studentMap.entrySet().stream().forEach(entry -> System.out.println(entry.getValue()));

        //iterator
        Iterator<Map.Entry<Student, String>> iter = studentMap.entrySet().iterator();
        //we can use hashNext() and next() methods

        //keyset
        Set<Student> studentMapKeySet = studentMap.keySet();
        //or
        /*
        for(Student key: studentMap.keySet()) {
            System.out.println(studentMap.get(key));
        }
         */
    }
}
