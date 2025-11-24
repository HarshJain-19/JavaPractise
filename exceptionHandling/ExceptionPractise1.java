package exceptionHandling;

import java.io.*;

public class ExceptionPractise1 {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("test.txt");
        BufferedReader fileInput = new BufferedReader(file);

        for (int counter = 0; counter < 3; counter++)
            System.out.println(fileInput.readLine());

        fileInput.close();
    }
}
