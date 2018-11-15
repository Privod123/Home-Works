package lessons11.zadachiCollection.zadacha18;
import java.util.*;
/**
 * Created by Hello on 13.11.2018.
 * Задача 18
 Создать public классы Cat и Dog.
 Создать класс Pets со следующими методами:
 метод createCats должен возвращать множество с N котами.
 метод createDogs должен возвращать множество с M собаками.
 метод join должен возвращать объединенное множество всех животных - всех котов и собак.
 метод removeCats должен удалять из множества pets всех котов
 метод printPets  должен выводить на экран всех животных, которые в нем есть (каждое животное с новой строки)

 */
public class Zadacha18 {
    public static void main(String[] args) {
        Pets pets = new Pets();
        Set<Pets> pets1 = pets.createCats(3);
        Set<Pets> pets2 = pets.createDogs(2);
//        System.out.println(pets1);
//        System.out.println(pets2);
        Set<Pets> generalPets = pets.join(pets1,pets2);
        System.out.println(generalPets);
//        Set<Pets> newSetPets = pets.removeCats(generalPets,pets1);
//        System.out.println(pets.removeCats(generalPets,pets1));
       pets.printPets(generalPets);
    }
}
