package java8.methodReference;

import java.util.Random;

class StringGenerator {
    private final String str;

    StringGenerator() {
        Random ran = new Random();

        this.str = ran.ints(97, 122+1)
                .limit(7)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public String getString() {
        return str;
    }
}

public class ArbitraryMethodReference1 {
    public static void main(String[] args) {
        String str = new StringGenerator().getString();
        System.out.println(str);
    }
}
