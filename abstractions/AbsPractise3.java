package abstractions;

class Parent3 {
    static void staticMethod() {
        System.out.println("I am parent's static method");
    }
    void instanceMethod() {
        System.out.println("I am parent's instance method");
    }
}

class Child3 extends Parent3 {
    static void staticMethod() {
        System.out.println("I am child");
    }
     void instanceMethod() {
        System.out.println("I am child's instance method");
    }
}

public class AbsPractise3 {
    public static void main(String[] args) {
        Parent3 test = new Child3();

        //method hiding
        test.staticMethod();            //compile-time so gives parents

        //method overriding
        test.instanceMethod();          //run-time so gives childs
    }
}
