package lesson17.singleton;

/**
 * Created by Hello on 03.12.2018.
 */
public class Singleton2 {
    private static final Singleton2 INSTANCE = new Singleton2();

    private Singleton2(){}

    // создание обьекта при инициализации класса
    public static Singleton2 getInstance(){
        return INSTANCE;
    }
}
