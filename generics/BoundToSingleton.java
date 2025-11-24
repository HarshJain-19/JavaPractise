package generics;

class NotASingletonClassException extends Exception {
    public NotASingletonClassException() {
        super("Not a Singleton class");
    }
}

class OnlySingletonClass<T> {
    OnlySingletonClass(Class<T> singletonClass) throws NotASingletonClassException {
        try {
            singletonClass.getDeclaredConstructor();
            throw new NotASingletonClassException();
        } catch (NotASingletonClassException e) {
            throw e;
        } catch (Exception e) {}
    }
}

class SingletonClass {
    private static SingletonClass instance;
    private SingletonClass() {}

    public static SingletonClass getInstance() {
        if (instance==null)
            instance = new SingletonClass();
        return instance;
    }

    void print(String str) {
        System.out.println(str);
    }
}

class NonSingletonClass {
    NonSingletonClass() {}

    void print(String str) {
        System.out.println(str);
    }
}

class BoundToSingleton {
    public static void main(String[] args) throws Exception {
//        OnlySingletonClass<NonSingletonClass> obj1 = new OnlySingletonClass<>(NonSingletonClass.class);
//        OnlySingletonClass<SingletonClass> obj2 = new OnlySingletonClass<>(SingletonClass.class);
    }
}
