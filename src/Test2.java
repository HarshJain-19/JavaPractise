public class Test2 {
    public static void main(String[] args) {
//        MySingletonClass mySingletonClass = new MySingletonClass();

        MySingletonClass mySingletonClass = MySingletonClass.getInstance();
        mySingletonClass.about();

        System.out.println("is same: " + (mySingletonClass == MySingletonClass.getInstance()));
    }
}

final class MySingletonClass {
    private static MySingletonClass instance;
    private MySingletonClass() {}

    public static MySingletonClass getInstance() {
        if (null == instance)
            instance = new MySingletonClass();
        return instance;
    }

    public void about() {
        System.out.println("Hello, I am Singleton Pattern Class");
    }
}
