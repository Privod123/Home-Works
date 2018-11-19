package lessons11.zadachiSyntax.zadacha2;

/**
 * Created by Hello on 13.11.2018.
 * Задача 2 (синтаксис классов)
 Создать класс Cat.
 У кота должно быть имя (name, String),
 возраст (age, int),
 вес (weight, int),
 сила (strength, int).

 Реализовать метод boolean fight(Cat anotherCat):
 реализовать механизм драки котов в зависимости от их веса, возраста и силы.
 Зависимость придумать самостоятельно.
 Метод должен определять, выиграли ли мы (this) бой или нет,
 т.е. возвращать true, если выиграли и false - если нет.
 Должно выполняться условие:
 если cat1.fight(cat2) = true,
 то cat2.fight(cat1) = false

 Сам метод fight не должен выводить данные на экран.

 */
public class Zadacha2 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Tuzik",5,12,4);
        Cat cat2 = new Cat("Grelka",2,8,6);
        System.out.println("cat1.fight(cat2) = " + cat1.fight(cat2));
        System.out.println("cat2.fight(cat1) = " + cat2.fight(cat1));
    }
}
