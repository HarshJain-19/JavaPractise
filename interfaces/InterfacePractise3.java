package interfaces;

interface Fooable {
    default int foo() {return 3;}
}

class A extends Object implements Fooable {
    @Override
    public int foo() {
        return Fooable.super.foo() + 1; //okay, returns 4
    }
}

public class InterfacePractise3 {
    public static void main(String[] args) {
        System.out.println(new A().foo());
    }
}
