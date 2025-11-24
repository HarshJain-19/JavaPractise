package serializable;

import java.io.*;

public class ExternalizablePractise implements Externalizable {
    String name;
    int id, age;

    public ExternalizablePractise() {
        System.out.println("no-argument constructor");
    }

    public ExternalizablePractise(int id, String name, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = (String) in.readObject();
        this.age = in.readInt();
    }

    @Override
    public String toString() {
        return String.format("id = %d, name = %s & age = %d", id, name, age);
    }

    public static void main(String[] args) throws Exception {
        ExternalizablePractise ex1 = new ExternalizablePractise(1, "Joe", 20);

        //output-stream
        FileOutputStream fos = new FileOutputStream("ex-prac.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ex1);

        //input-stream
        FileInputStream fis = new FileInputStream("ex-prac.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ExternalizablePractise ex2 = (ExternalizablePractise) ois.readObject();

        System.out.println(ex2);
    }
}
