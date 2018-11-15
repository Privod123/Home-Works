package lessons11.zadachiCollection.zadacha17;

import java.util.*;
/**
 * Created by Hello on 13.11.2018.
 * Задача 17
 В условии указан минимум методов (остальные реализовать самостоятельно)
 Реализовать интерфейс RepkaItem в классе Person.
 В классе Person реализовать метод pull(Person person), который выводит фразу типа ‘<name> за <person>‘
 (Например, Бабка за Дедку или Дедка за Репку и тд )

 Результат использования:
 List<Person> repka = new ArrayList<Person>();
 plot.add(new Person("Репка", "Репку"));
 plot.add(new Person("Дедка", "Дедку"));
 plot.add(new Person("Бабка", "Бабку"));
 plot.add(new Person("Внучка", "Внучку"));
 и тд
 RepkaStory.print(repka);

 */
public class RepkaStory {
    public static void main(String[] args) {
        List<Person> repka = new ArrayList<>();
        repka.add(new Person("Репка", "Репку"));
        repka.add(new Person("Дедка","Дедку"));
        repka.add(new Person("Бабка","Бабку"));
        repka.add(new Person("Внучка","Внучку"));
        repka.add(new Person("Жучка","Жучку"));
        repka.add(new Person("Кошка","Кошку"));
        repka.add(new Person("Мышка","Мышку"));

        print(repka);

    }
    static void print(List<Person> list){
        for (int i = 0; i < list.size(); i++) {
            if ( i + 1 == list.size()) break;
            list.get(i + 1).pull(list.get(i));
        }
    }
}
