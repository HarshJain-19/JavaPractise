package generics;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.List;

abstract class Animal {

    protected final String type;
    protected final String name;

    protected Animal(String type, String name) {
        this.type = type;
        this.name = name;
    }

    abstract String makeSound();
}

class Cat extends Animal implements Comparable<Cat> {
    public Cat(String type, String name) {
        super(type, name);
    }

    String getName() {
        return super.name;
    }

    @Override
    public String makeSound() {
        return "Meow";
    }

    @Override
    public int compareTo(Cat cat) {
        if (cat==null)
            throw new IllegalArgumentException("Cat argument cannot be null");
        return this.getName().length() - cat.getName().length();
    }
}

public class WildcardPractise3 {
    public static <T extends Animal & Comparable<T>> void order(List<T> list) {
        list.sort(Comparable::compareTo);
    }

    public static void main(String[] args) {
        List<Cat> catList = new ArrayList<>();
        WildcardPractise3.order(catList);
    }
}
