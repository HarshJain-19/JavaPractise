package java8.lambdaExpressions;

@FunctionalInterface
interface Greet {
    String greet(String name);
}

public class LambdaExpressionPractise2 {
    public static String sayByeMethod(String name) {
        return "Bye " + name;
    }

    public static void main(String[] args) {
        Greet sayHello = name -> "Hello " + name;
        System.out.println(sayHello.greet("Sir"));

        Greet sayBye1 = name -> sayByeMethod(name);

        //or by method referencing
        Greet sayBye2 = LambdaExpressionPractise2::sayByeMethod;
    }
}
