package java8.methodReference;

@FunctionalInterface
interface ConvertTOLower {
    String convertToLowerCase(String str);
}

public class MethodReferencingPractise1 {
    public static void main(String[] args) {
        //lambda expression
        ConvertTOLower convertTOLower1 = name -> name.toLowerCase();

        //method reference
        ConvertTOLower convertTOLower2 = String::toLowerCase;
    }
}
