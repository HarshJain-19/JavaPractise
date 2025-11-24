package anonymous;

@FunctionalInterface
interface TestInterface {
    void show();
}

class Test {
    void show() {
        System.out.println("Hello from Test.show()");
    }
}

public class AnonymousClassPractise1 {
    public static void main(String[] args) {

        // anonymous class
        TestInterface testInterface1 = new TestInterface() {
            @Override
            public void show() {
                System.out.println("Hello from anonymous class of TestInterface");
            }
        };
        testInterface1.show();

        // lambda
        TestInterface testInterface2 = () -> System.out.println("Hello from lambda expression");
        testInterface2.show();

        Test test1 = new Test();
        test1.show();

        Test test2 = new Test() {
            @Override
            void show() {
                System.out.println("Hello from anonymous class test2 of Test");
            }
        };
        test2.show();

        Test test3 = new Test() {
            public void show() {
                System.out.println("Hello from anonymous class test3 of Test");
            }
        };
        test3.show();

    }
}

