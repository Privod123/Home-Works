package lesson17.singleton;

/**
 * Created by Hello on 03.12.2018.
 */
public class Singleton1 {

    private static Singleton1 instance;

    //private Singleton1() - приватный конструктор не позволит создание обьекта извне.
    private Singleton1() {
    }

    // создания обьекта по требованию
    public static Singleton1 getInstance(){
        if (instance == null){
            instance = new Singleton1();
        }
        return instance;
    }
}
