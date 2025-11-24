package designPattern;

public final class SingletonPattern {
    private static SingletonPattern instance;
    private SingletonPattern() {}

    public static SingletonPattern getInstance() {
        if (null == instance)
            instance = new SingletonPattern();
        return instance;
    }

    public void about() {
        System.out.println("Hello, I am Singleton Pattern Class");
    }
}


