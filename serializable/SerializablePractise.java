package serializable;

import java.io.Serializable;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;

class User implements Serializable {
    private String username;
    private transient String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Username: " + username + ", Password: " + password;
    }
}

public class SerializablePractise {
    public static void main(String[] args) {
        User user = new User("john_doe", "secret123");

        //try-with-resource
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user file"));
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user file"));
        ) {
            oos.writeObject(user);

            User deserializedUser = (User) ois.readObject();
            System.out.println("Deserialized User: " + deserializedUser);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
