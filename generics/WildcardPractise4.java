package generics;

import java.util.*;

class NaturalNumber {
    private int i;

    public NaturalNumber(int i) {
        this.i = i;
    }
}

class EvenNumber extends NaturalNumber {
    public EvenNumber(int i) {
        super(i);
    }
}

public class WildcardPractise4 {
    public static void main(String[] args) {
        List<EvenNumber> le = new ArrayList<>();
        List<? extends NaturalNumber> ln = le;
//        List<? extends NaturalNumber> ln = new ArrayList<EvenNumber>();
        System.out.println(ln);
//        ln.add(new EvenNumber(35));
//        ln.add(new NaturalNumber(35));
    }
}
