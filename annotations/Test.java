package annotations;

class A {
    void sayHello() {
        System.out.println("Hello");
    }
}

class B extends A {
//    @Override
    @CustomOverride
    void sayHello() {
        super.sayHello();
    }
}

public class Test {
    @Author("Harsh Jain")
    public Test() {
    }

    @Todo(priority = Todo.Priority.MEDIUM, status = Todo.Status.STARTED)
    public static void main(String[] args) {

    }
}
