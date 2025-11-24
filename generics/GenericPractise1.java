package generics;

class Abc<T, U> {
    T obj1;
    U obj2;

    Abc(T obj1, U obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void print() {
        System.out.println(obj1);
        System.out.println(obj2);
    }

    static <X> void print(X x) {
        System.out.println(x);
    }
}

public class GenericPractise1 {
    public static void main(String[] args) {
        Abc<String, Integer> obj1 = new Abc<String, Integer>("GFG", 15);
        obj1.print();

        Abc.print("Hello World");

        Abc obj2 = new Abc(15, "Hello");
        obj2.print();

        obj2.obj1 = "ko";
        obj2.print();

        Abc[] abcArray = new Abc[5];
        abcArray[0] = obj1;
        abcArray[1] = obj2;
    }
}
