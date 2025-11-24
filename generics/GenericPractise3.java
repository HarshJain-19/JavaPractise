package generics;

import java.io.Serializable;

class OverloadingErrors<T extends Serializable> {

    public void printElement(T t) {
        System.out.println("Signature is: printElement(T)");
    }

    /*
    public void printElement(Serializable o) {
        System.out.println("Signature is: printElement(Serializable)");
    }
    */
}

public class GenericPractise3 {
    public static void main(String[] args) {

    }
}
