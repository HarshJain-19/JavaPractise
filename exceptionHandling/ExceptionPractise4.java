package exceptionHandling;

public class ExceptionPractise4 {
    //Swallowing exception by return in finally
    static void swallowingMethod1() {
        try {
            throw new Exception("A Simple Exception");
        } finally {
            System.out.println("swallowing method1 Finally executed");
            return;
        }
    }

    //Swallowing exception by throw in finally
    static void swallowingMethod2() throws Exception {
        try {
            System.out.println("try executed!");
            throw new Exception("This is exception by try block");
        } catch (Exception e) {
            System.out.println("catch executed!");
            throw new Exception("This is exception by catch block");
        } finally {
            System.out.println("finally executed!");
            throw new Exception("This is exception by finally block");
        }
    }


    public static void main(String[] args) {
        swallowingMethod1();

        try {
            swallowingMethod2();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
