package interfaces;

@FunctionalInterface
interface X {
    Iterable a(Iterable<String> b);
}

@FunctionalInterface
interface Y {
    Iterable<String> a(Iterable b);
}

@FunctionalInterface
interface Z extends X,Y {
}

public class InterfacePractise4 {
    public static void main(String[] args) {
        Z z = new Z() {
            @Override
            public Iterable<String> a(Iterable b) {
                return null;
            }
        };
    }
}
