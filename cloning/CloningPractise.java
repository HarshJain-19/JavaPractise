package cloning;

import java.lang.Cloneable;

class JustReference {
    int a;
    JustReference() {
        this.a=0;
    }
    JustReference(int a) {
        this.a=a;
    }
}

class Test implements Cloneable {
    int x,y;
    JustReference jstRef;

    Test(int x, int y, JustReference jref) {
        this.x=x;
        this.y=y;
        this.jstRef=jref;
    }

    //Shallow cloning
    @Override
    public Test clone() throws CloneNotSupportedException {
        return (Test) super.clone();
    }

    //deep cloning
    public Test deepClone() throws CloneNotSupportedException {
        Test t = (Test) super.clone();
        t.jstRef = new JustReference();
        return t;
    }
}

public class CloningPractise {
    public static void main(String[] args) throws CloneNotSupportedException {
        Test t1 = new Test(4,5, new JustReference(100));

        //referencing
        Test t2 = t1;
        t2.x=11;
        System.out.println(t1.x);               //11
        System.out.println(t2.x);               //11

        //shallow cloning
        Test t3 = t1.clone();
        t3.x=12;
        System.out.println(t1.x);               //11
        System.out.println(t3.x);               //12
        t3.jstRef.a=200;
        System.out.println(t1.jstRef.a);        //200
        System.out.println(t3.jstRef.a);        //200

        //deep cloning
        Test t4 = t1.deepClone();
        t4.x=13;
        System.out.println(t1.x);               //11
        System.out.println(t4.x);               //13
        t4.jstRef.a=300;
        System.out.println(t1.jstRef.a);        //200
        System.out.println(t4.jstRef.a);        //200

    }
}
