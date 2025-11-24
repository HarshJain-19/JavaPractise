package exceptionHandling;

class MyRuntimeException1 extends RuntimeException {
    public MyRuntimeException1(String msg) {
        super(msg);
    }
}

public class RuntimeExceptionPractise1 {
    public void throwRuntimeException() throws MyRuntimeException1 {
        throw new MyRuntimeException1("This is a runtime exception");
    }

    public static void main(String[] args) {
//        new RuntimeExceptionPractise1().throwRuntimeException();

        try {
            new RuntimeExceptionPractise1().throwRuntimeException();
        } catch (RuntimeException rtEx) {
            System.out.println(rtEx.getMessage());
        }
    }
}
