package lessons11.zadachiSyntax;

/**
 * Created by Hello on 13.11.2018.
 * Задача 6 (синтаксис классов)
 Создать класс с методом getInstance(), который возвращает один и тот же экземпляр данного класса. Создание объектов извне запретить!

 */
class Instance{

    private static Instance instance;

    private Instance() {
    }

    public static synchronized Instance getInstance(){
        if (instance == null){
            return instance = new Instance();
        }else
            return instance;
    }
}

public class Zadacha6 {
    public static void main(String[] args) {
        Instance g = Instance.getInstance();
        System.out.println(g);
        Instance g1 = Instance.getInstance();
        System.out.println(g1);
    }
}
