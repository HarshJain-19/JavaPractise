package abstractions;

class A {
    void a() {
        System.out.println("a");
    }
}

class B extends A {
    void b() {
        System.out.println("b");
    }

    @Override
    void a() {
        b();
    }
}

public class AbsPractise2 {
    public static void main(String[] args) {
        A obj = new B();
//        obj.b();
        obj.a();
    }
}
