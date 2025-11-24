package designPattern;

public final class UtilityPattern {
    private UtilityPattern() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static void about() {
        System.out.println("Hello, I am Utility Pattern class.");
    }

    public static String greet(String name) {
        return String.format("Hello %s, I am Utility Pattern class.", name);
    }
}
