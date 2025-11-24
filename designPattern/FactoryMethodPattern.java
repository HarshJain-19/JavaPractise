package designPattern;

public final class FactoryMethodPattern {
    private String name;
    private FactoryMethodPattern(String name) {
        this.name = name;
    }

    // Factory Method that return the new instance of any class
    public static FactoryMethodPattern createNewInstance(String name) {
        return new FactoryMethodPattern(name);
    }

    public void about() {
        System.out.println("Hello, I am Utility Pattern class.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
