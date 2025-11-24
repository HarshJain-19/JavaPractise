package java8.functions;

import java.util.function.*;

class Lol1<T> implements Predicate<T> {
    @Override
    public boolean test(T t) {
        return false;
    }

    @Override
    public Predicate<T> and(Predicate<? super T> other) {
        return Predicate.super.and(other);
    }

    @Override
    public Predicate<T> negate() {
        return Predicate.super.negate();
    }

    @Override
    public Predicate<T> or(Predicate<? super T> other) {
        return Predicate.super.or(other);
    }
}

class Lol2<T> implements Consumer<T> {
    @Override
    public void accept(T t) {

    }

    @Override
    public Consumer<T> andThen(Consumer<? super T> after) {
        return Consumer.super.andThen(after);
    }
}

class Lol3<T,U> implements Function<T,U> {
    @Override
    public U apply(T t) {
        return null;
    }

    @Override
    public <V> Function<T, V> andThen(Function<? super U, ? extends V> after) {
        return Function.super.andThen(after);
    }

    @Override
    public <V> Function<V, U> compose(Function<? super V, ? extends T> before) {
        return Function.super.compose(before);
    }
}

class Lol4<T> implements Supplier<T> {
    @Override
    public T get() {
        return null;
    }

}

public class FunctionalInterfacePractise1 {
    public static void main(String[] args) {

    }
}
