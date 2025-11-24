package serializable;

import java.io.*;

class TransientUser implements Serializable {
    private String username;
    private transient String password;

    public TransientUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Username: " + username + ", Password: " + password;
    }
}

public class TransientPractise {
    public static void main(String[] args) {
        TransientUser user = new TransientUser("john_doe", "secret123");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"))) {

            oos.writeObject(user);

            TransientUser deserializedUser = (TransientUser) ois.readObject();
            System.out.println("Deserialized User: " + deserializedUser);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
