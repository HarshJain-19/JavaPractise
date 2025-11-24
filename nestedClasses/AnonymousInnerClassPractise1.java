package nestedClasses;

interface Age {
    int x = 21;
    void getAge();
}

public class AnonymousInnerClassPractise1 {
    public static void main(String[] args) {

        Age oj1 = new Age() {
            @Override
            public void getAge() {
                System.out.print("Age is " + x );
            }
        };

        oj1.getAge();
    }
}

