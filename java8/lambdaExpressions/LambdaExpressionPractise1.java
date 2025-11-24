package java8.lambdaExpressions;

@FunctionalInterface
interface MyFunctionInterface1 {
    //SAM (Single Abstract Method)
    void doSomething();

    default void defaultMethod() {
        System.out.println("this is a default method!");
    }

    static void staticMethod() {
        System.out.println("this is a static method!");
    }
}

class MyClass1 implements MyFunctionInterface1 {
    @Override
    public void doSomething() {
        System.out.println("called by implemented class");
    }
}

public class LambdaExpressionPractise1 {
    public static void main(String[] args) {
        //by implementation
        new MyClass1().doSomething();

        //by anonymous class
        MyFunctionInterface1 obj1 = new MyFunctionInterface1() {
            @Override
            public void doSomething() {
                System.out.println("called by anonymous class");
            }
        };
        obj1.doSomething();

        //by lambda expression
        MyFunctionInterface1 obj2 = () -> System.out.println("called by lambda expression");
        obj2.doSomething();

        obj2.defaultMethod();
        MyFunctionInterface1.staticMethod();
    }
}
