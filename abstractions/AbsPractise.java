package abstractions;

class Parent {
    private Parent() {
        System.out.println("parent");
    }
    Parent(String str) {
        System.out.println(str);
    }
}
abstract class Child extends Parent {
    Child() {
        super("Hello");
        System.out.println("child");
    }
}

public class AbsPractise {
    public static void main(String[] args) {
        new Child() {};
    }
}
