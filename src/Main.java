import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

class Student {
    int id;
    String name;
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean equals(Student obj) {
        return id==obj.id && name.equals(obj.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

public class Main {
    public static void main(String[] args) {
//        HashMap<Student, String> studentMap = new HashMap<>();

//        Student student1 = new Student(1, "Alice");
//        Student student2 = new Student(2, "Bob");
//        Student student3 = new Student(1, "Alice");
//        Student student4 = student2;

//        studentMap.put(student2, "A Grade");
//        student2.id=1;
//        student2.name="Alice";
//        studentMap.put(student3, "B Grade");

//        System.out.println("Grade of student1: " + studentMap.get(student1));
//        System.out.println("Grade of student2: " + studentMap.get(student2));
//        System.out.println("Grade of student3: " + studentMap.get(student3));
//        System.out.println("Grade of student4: " + studentMap.get(student4));

        //put and putiFAbsent
//        Student student5 = new Student(3, "Joe");
//        System.out.println(studentMap.put(student5, "C Grade"));
//        System.out.println(studentMap.put(student5, "D Grade"));        //returns previous and replace th value
//        System.out.println(studentMap.get(student5));
//
//        System.out.println(studentMap.putIfAbsent(student5, "E Grade"));
//        System.out.println(studentMap.get(student5));
//
//        studentMap.put(null, null);
//        System.out.println(studentMap.get(null));


    }
}
