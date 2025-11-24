package package2;
import package1.*;

class Class21 extends Class1 {
//    @Override
//    protected void display() {
//        System.out.println("Hello from package2");
//    }
    {
        System.out.println("I am default block");
    }
    static {
        System.out.println("I am Static block");
    }
    void show() {
        display();
    }
}

public class Class2 {
    public static void main(String[] args) {
        Class21 c1 = new Class21();
//        c1.display();
        c1.show();

        Class1 c2 = new Class21();
//        c2.display;                   //not working as display method is protected in package1.Class1
    }

}

//public class Class2 extends Class1 {
//    public static void main(String[] args) {
//        Class2 c1 = new Class2();
//        c1.display();                                     // here we can use this
//    }
//}
