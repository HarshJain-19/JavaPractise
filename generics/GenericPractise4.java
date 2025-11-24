package generics;

public class GenericPractise4<Integer> {
    Integer num;
    GenericPractise4(Integer num) {
        this.num = num;
    }

    public static void main(String[] args) {
//        GenericPractise4<String> obj1 = new GenericPractise4<>("Hello");                 //Exception
//        GenericPractise4<Integer> obj1 = new GenericPractise4<>(123);                     //Exception
//        GenericPractise4<?> obj1 = new GenericPractise4<>("Hello");
//        GenericPractise4<java.lang.Integer> obj2 = new GenericPractise4<>(123);
//        GenericPractise4<String> obj3 = new GenericPractise4<>("Hello");
    }
}
