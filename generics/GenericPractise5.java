package generics;

class X<T> {}

class A {
    X a(X<String> q) {
        return null;
    }
}

class B extends A {
    @Override
    X<String> a(X q) {
        return null;
    }
}

// ?
//class C extends B {
//    @Override
//    X a(X<String> q) {
//        return super.a(q);
//    }
//}

public class GenericPractise5 {
    public static void main(String[] args) {

    }
}
