package java8.lambdaExpressions;

import java.util.concurrent.atomic.AtomicInteger;

@FunctionalInterface
interface MyFunctionalInterface1 {
    void print();
}

public class LambdaExpressionPractise4 {
    public static void main(String[] args) {
        String str = "Hello";                       //effectively final i.e, not changed after declared
//        str="lol";

        MyFunctionalInterface1 obj = () -> {
//            String str = "Hello1";                //error
//            str = "lol";                          //error
            System.out.println(str);
        };
//        str= "ho";


        // can use atomic integer
        AtomicInteger aInt = new AtomicInteger(10);

        MyFunctionalInterface1 obj1 = () -> {
            aInt.getAndIncrement();
            System.out.println(aInt);
        };
        obj1.print();
    }
}
