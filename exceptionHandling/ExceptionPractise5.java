package exceptionHandling;

import java.io.*;

public class ExceptionPractise5 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("somefile.txt");
             FileWriter writer = new FileWriter("output.txt")) {
            reader.read();
        } catch (IOException e) {
            System.out.println("Main exception: " + e);
            // Print suppressed exceptions
            for (Throwable t : e.getSuppressed()) {
                System.out.println("Suppressed: " + t);
            }
        }
    }
}

