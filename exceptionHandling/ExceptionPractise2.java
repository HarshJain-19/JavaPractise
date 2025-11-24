package exceptionHandling;

public class ExceptionPractise2 {
    public static void main (String[] args) {
        int a=5;
        int b=0;

        try {
            System.out.println(a/b);
        } catch (ArithmeticException e){
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println("A exception occurred!\t" + e.getMessage());
        } finally {
            System.out.println("Finally Called!");
        }
    }
    public void rethrownMethod() throws Exception {
        try {
            throw new Exception();
        } catch (Throwable t) {
            throw t;
        }
    }
}

