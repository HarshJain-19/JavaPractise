package java8.ioStreams;

import java.io.*;
import java.util.function.*;

@FunctionalInterface
interface MyInterface {
    void sayHello(String name);
}

class MyClass implements MyInterface {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}

public class SerializeAndDeserialize1 {

    protected static void serialize(Serializable obj, String path) throws IOException {
        File outputFile = new File(path);
        if (!outputFile.exists() && outputFile.createNewFile())
            System.out.println("File created!");
        else
            System.out.println("Unable to create file!");
        try (
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(outputFile))
        ) {
            outputStream.writeObject(obj);
        }
    }

    protected static Object deserialize(String path) throws IOException, ClassNotFoundException {
        File inputFile = new File(path);
        try (
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(inputFile))
        ) {
            return inputStream.readObject();
        }
    }

    private static void serializeAndDeserializeFunction() throws Exception {
        final String path = "./testFiles/serializeAndDeserialize1-fn.txt";

        Function<Integer, String> fn = (Function<Integer, String> & Serializable) n -> "Hello " + n + " times";
        System.out.println("Run Original Function: " + fn.apply(5) + "\n");

        serialize((Serializable) fn, path);
        System.out.println("serialized function at: " + path);

        Function<Integer, String> deFn = (Function<Integer, String> & Serializable) deserialize(path);
        System.out.println("deserialize function from: " + path);

        System.out.println("Run deserialized function: " + deFn.apply(10));
    }

    private static void serializeAndDeserializeClass() throws Exception {
        final String path = "./testFiles/serializeAndDeserialize1-class.txt";

        serialize(MyClass.class, path);
        System.out.println("serialized class at: " + path);

        Class<?> DeClass = (Class<?>) deserialize(path);
        System.out.println("deserialize class from: " + path);

        MyInterface deObj = (MyInterface) DeClass.getDeclaredConstructor().newInstance();
        deObj.sayHello("World!");
    }

    public static void main(String[] args) throws Exception {
        serializeAndDeserializeFunction();
        System.out.println();
        serializeAndDeserializeClass();
    }
}
