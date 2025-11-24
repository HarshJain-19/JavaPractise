package interfaces;

interface Abc {
    static void abc1() {
        System.out.println("abc1");
    }
    default void abc2() {
        System.out.println("abc2");
    }
    void good();
}

abstract class Pqr implements Abc {
//    @Override
//    public void good() {};

    void displayAbc2() {
        abc2();
    }
}

class Def extends Pqr implements Abc {
    @Override
    public void good() {};
}

public class InterfacePractise2 {
    public static void main(String[] args) {
//        Def.abc1();
//        Def.abc2();

        Abc.abc1();
//        Abc.abc2();

        new Def().displayAbc2();

        new Abc() { public void good() {}}.abc2();
    }
}

