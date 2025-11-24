package nestedClasses;

class Outer {
    void getValue() {
        int sum = 20;

        class Inner {
            private int divisor;
            int sum = 50;

            public Inner() {
                this.divisor = 4;
            }

            private int getDivisor() {
                return divisor;
            }

            private int getRemainder() {
                return sum % divisor;
            }

            private int getQuotient() {
                System.out.println("Inside inner class");
                return sum / divisor;
            }
        }

        Inner inner = new Inner();
        System.out.println("Divisor = "+ inner.getDivisor());
        System.out.println("Remainder = " + inner.getRemainder());
        System.out.println("Quotient = " + inner.getQuotient());
    }
}

public class localInnerClassPractise1 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.getValue();
    }
}
