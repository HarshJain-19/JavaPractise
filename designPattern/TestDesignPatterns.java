package designPattern;

public class TestDesignPatterns {
    public static void main(String[] args) {

        // Singleton Design Pattern
//        SingletonPattern singletonPattern = new SingletonPattern();

        SingletonPattern singletonPattern1 = SingletonPattern.getInstance();
        SingletonPattern singletonPattern2 = SingletonPattern.getInstance();

        singletonPattern1.about();
        System.out.println("SingletonPattern1 object reference id = " + singletonPattern1);
        System.out.println("SingletonPattern2 object reference id = " + singletonPattern2);


        // Utility Class
//        UtilityPattern utilityPattern = new UtilityPattern();
        UtilityPattern.about();
        System.out.println(UtilityPattern.greet("xyz"));


        // Factory Methods Class
//        FactoryMethodPattern factoryMethodPattern = new FactoryMethodPattern();
        FactoryMethodPattern factoryMethodPattern = FactoryMethodPattern.createNewInstance("xyz");
        factoryMethodPattern.about();
        System.out.println(factoryMethodPattern.getName());
    }
}
