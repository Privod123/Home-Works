package lessons11.zadachiCollection.zadacha18;

import java.util.HashSet;
import java.util.*;

/**
 * Created by Hello on 15.11.2018.
 */
public class Pets {

    Set createCats(int n){
        Set<Cat> cats = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            cats.add(new Cat(i));
        }
        return cats;
    }

    Set createDogs(int m){
        Set<Dog> dogs = new HashSet<>();
        for (int i = 1; i <= m; i++) {
            dogs.add(new Dog(i));
        }
        return dogs;
    }

     Set join(Set K,Set V) {
        Set<Pets> pets = new HashSet<>();
        pets.addAll(K);
        pets.addAll(V);
        return pets;
     }

    Set removeCats(Set K, Set V) {
        K.removeAll(V);
        return K;
    }

    void printPets(Set K) {
        Iterator iterator = K.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
