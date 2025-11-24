package generics;

class GenericClass<T> {
    private T value;

    public GenericClass(T value) {
        this.value = value;
    }

    public void printValue() {
        System.out.println("Value: " + value);
    }
}

class NonGenericClass extends GenericClass<String> {

    public NonGenericClass(String value) {
        super(value);
    }

    public void showMessage() {
        System.out.println("This is a non-generic subclass.");
    }
}

public class GenericPractise2 {
    public static void main(String[] args) {
        NonGenericClass obj = new NonGenericClass("Hello, World!");
        obj.printValue();
        obj.showMessage();
    }
}

